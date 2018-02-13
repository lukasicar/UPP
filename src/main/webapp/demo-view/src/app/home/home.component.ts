import { Component, OnInit } from '@angular/core';
import { MockUser } from './home.mockuser';
import { HomeService } from './home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
      
    tasks: string[];
    taskId: string="";
    taskName: string="";
    username: string;
    password: string;

    constructor(private homeService: HomeService) { }
    
    ngOnInit() {
        this.getAvailableTasks();
        if(localStorage.getItem('username')!=null){
            window.location.href="http://localhost:4200/home1";
        };
    }
    
    
    startProcess(){
        this.homeService.startProcess().subscribe(x=>this.getAvailableTasks());
    }
    
    login(){
        
        this.homeService.login(this.username,this.password).subscribe(x=>{alert(x);if(x=="ok"){localStorage.setItem('username',this.username);
        window.location.href="http://localhost:4200/home1"}});
        
    }
    
    getAvailableTasks(){
        this.homeService.getTasks().subscribe(x=>this.tasks=x);
    }
    
    beeba(taskName: string,id: string){
        alert(id);
        this.taskId=id;
        this.taskName=taskName;
    }
}
