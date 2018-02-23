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
    
    constructor(private razmatranjeService: RazmatranjeService) { }

    ngOnInit() {
        this.getPonude();
    }
    
    complete(){
        //this.tr.firmId=localStorage.getItem('username');
        //this.tenderResponseService.complete(this.tr,this.taskId).subscribe(x=>window.location.reload());
    }
    
    getPonude(){
        this.razmatranjeService.getPonude(this.taskId).subscribe(x=>this.ponude=x);
    }
    
    no(){
        this.razmatranjeService.no(this.taskId).subscribe(x=>window.location.reload());
    }

}
