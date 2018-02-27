import { Component, OnInit, Input } from '@angular/core';
import { TenderResponse } from './tender-response';
import { TenderResponseService } from './tender-response.service';
import { RazmatranjeService } from './../razmatranje/razmatranje.service';


@Component({
  selector: 'app-tender-response',
  templateUrl: './tender-response.component.html',
  styleUrls: ['./tender-response.component.css']
})
export class TenderResponseComponent implements OnInit {

    @Input() taskId: string;
    tr:TenderResponse=new TenderResponse();
    redniBr:number=0;
    
    constructor(private tenderResponseService: TenderResponseService,private razmatranjeService: RazmatranjeService) { }

    ngOnInit() {
        var name=localStorage.getItem('username');
        this.razmatranjeService.getPonude(this.taskId).subscribe(x=>{for(var i in x){if(x[i].firmId==name){this.redniBr=+i+1;}}});
        
    }
    
    complete(){
        if(this.validation()){
            this.tr.firmId=localStorage.getItem('username');
            if(this.tr.datum!=null)
                this.tr.datum+=":00";
            this.tenderResponseService.complete(this.tr,this.taskId).subscribe(x=>window.location.reload());
        }
    }
    
    complete1(){
        this.tr.firmId=localStorage.getItem('username');
        //this.tr.datum+=":00";
        this.tenderResponseService.complete1(this.tr,this.taskId).subscribe(x=>window.location.reload());
        
    }
    
    validation(){
        if(this.tr.pristanak==true){
            if(this.tr.cijena==null){
            alert("Unesite cijenu usluge");
                return false;
            }else if(typeof this.tr.datum=='undefined'){
                alert("Odredite rok izvrsetka usluge");
                return false;
            }
        }else{
            this.tr.datum=null;            
        }
        return true;
    }

}
