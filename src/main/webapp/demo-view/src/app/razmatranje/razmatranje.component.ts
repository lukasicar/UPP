import { Component, OnInit, Input } from '@angular/core';
import { RazmatranjeService } from './razmatranje.service';
import { TenderResponse } from './../tender-response/tender-response';

@Component({
  selector: 'app-razmatranje',
  templateUrl: './razmatranje.component.html',
  styleUrls: ['./razmatranje.component.css']
})
export class RazmatranjeComponent implements OnInit {

    @Input() taskId: string;
    ponude:TenderResponse[]=[];
    odabranaPonuda:TenderResponse=new TenderResponse();
    
    constructor(private razmatranjeService: RazmatranjeService) { }

    ngOnInit() {
        this.getPonude();
    }
    
    zadovoljan(){
        if(typeof this.odabranaPonuda.firmId == 'undefined'){
            alert("Odaberite firmu");
            return;
        }
        this.razmatranjeService.zadovoljan(this.taskId,this.odabranaPonuda).subscribe(x=>window.location.reload());
    }
    
    getPonude(){
        this.razmatranjeService.getPonude(this.taskId).subscribe(x=>{for (var i in x){x[i].datum=new Date(x[i].datum);}this.ponude=x;});
    }
    
    no(){
        this.razmatranjeService.no(this.taskId).subscribe(x=>window.location.reload());
    }
    
    a(ponuda:any){
        if(ponuda.selected==true){
            this.odabranaPonuda=ponuda;
        }else{
            this.odabranaPonuda=new TenderResponse();
        }
        this.ponude.every(function(item:any) {
            if(item.selected==true&&item.firmId!=ponuda.firmId){
                item.selected=false;
            }
            return true;
      })

    }
    
    info(){
        if(typeof this.odabranaPonuda.firmId == 'undefined'){
            alert("Odaberite firmu");
            return;
        }
        this.razmatranjeService.info(this.taskId,this.odabranaPonuda).subscribe(x=>window.location.reload());
    }

}
