import { Component, OnInit, Input } from '@angular/core';
import { TenderResponse } from './tender-response';
import { TenderResponseService } from './tender-response.service';


@Component({
  selector: 'app-tender-response',
  templateUrl: './tender-response.component.html',
  styleUrls: ['./tender-response.component.css']
})
export class TenderResponseComponent implements OnInit {

    @Input() taskId: string;
    tr:TenderResposse=new TenderResponse();
    
    constructor(private tenderResponseService: TenderResponseService) { }

    ngOnInit() {
    }
    
    complete(){
        this.tr.firmId=localStorage.getItem('username');
        this.tenderResponseService.complete(this.tr,taskId).subscribe(x=>window.location.reload());
    }

}
