import { Component, OnInit } from '@angular/core';
import { Home1Service } from './home1.service';

@Component({
  selector: 'app-home1',
  templateUrl: './home1.component.html',
  styleUrls: ['./home1.component.css']
})
export class Home1Component implements OnInit {

    username:string;
    tasks: string[];
    taskId: string="";
    taskName: string="";
    
    constructor(private home1Service: Home1Service) { }

    ngOnInit() {
        if(localStorage.getItem('username')==null){
            window.location.href="http://localhost:4200";
        };
        this.username=localStorage.getItem('username');
    }
    
    logout(){
        localStorage.removeItem('username');
        window.location.href="http://localhost:4200";
    }
    
    beeba(taskName: string,id: string){
        alert(id);
        this.taskId=id;
        this.taskName=taskName;
    }
    
    getAvailableTasks(){
        this.home1Service.getTasks().subscribe(x=>this.tasks=x);
    }
}
