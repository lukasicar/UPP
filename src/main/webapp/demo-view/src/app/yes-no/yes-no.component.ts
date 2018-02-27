import { Component, OnInit, Input } from '@angular/core';
import { Category } from './../register/register.category';
import { MockUser } from './../home/home.mockuser';
import { YesNoService } from './yes-no.service';
import { OcjeniService } from './../ocjeni/ocjeni.service';

@Component({
  selector: 'app-yes-no',
  templateUrl: './yes-no.component.html',
  styleUrls: ['./yes-no.component.css']
})
export class YesNoComponent implements OnInit {
    
    choice: string="";
    @Input() taskId: string;
    odg: string="";
    
    constructor(private yesNoService: YesNoService,private ocjeniService: OcjeniService) { }
    
    ngOnInit() {
        this.ocjeniService.getOdg(this.taskId).subscribe(x=>this.odg=x);
    }
    
    complete(){
        if(this.choice==""){
            alert("odaberite nesto");
        }else
            this.yesNoService.complete(this.choice,this.taskId).subscribe(x=>window.location.reload());
    }

}
