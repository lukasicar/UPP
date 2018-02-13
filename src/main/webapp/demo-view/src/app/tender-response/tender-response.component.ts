import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-tender-response',
  templateUrl: './tender-response.component.html',
  styleUrls: ['./tender-response.component.css']
})
export class TenderResponseComponent implements OnInit {

    @Input() taskId: string;
    
    constructor() { }

    ngOnInit() {
    }

}
