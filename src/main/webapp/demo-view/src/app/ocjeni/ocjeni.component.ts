import { Component, OnInit, Input } from '@angular/core';
import { OcjeniService } from './ocjeni.service';
@Component({
  selector: 'app-ocjeni',
  templateUrl: './ocjeni.component.html',
  styleUrls: ['./ocjeni.component.css']
})
export class OcjeniComponent implements OnInit {

    @Input() taskId: string;
    polje:string="";
    upit:string="";
    odg:string="";
    
    constructor(private ocjeniService: OcjeniService) { }

    ngOnInit() {
        //this.ocjeniService.getOdg(this.taskId).subscribe(x=>this.odg=x);
        this.ocjeniService.getOdg(this.taskId).subscribe(x=>{this.upit=x;alert(x););
    }
    
    complete(){
        if(this.polje==""){
            alert("unesite nesto");
            return;
        }
        this.ocjeniService.complete(this.polje,this.taskId).subscribe(x=>{if(x=="ok"){window.location.reload();}else
        {alert(x);return;}});
    }

}
