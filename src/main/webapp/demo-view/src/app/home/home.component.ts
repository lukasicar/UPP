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
    s: string="d";

    constructor(private homeService: HomeService) { }
    
    ngOnInit() {
        this.getAvailableTasks();
    }
    
    
    startProcess(){
        this.homeService.startProcess().subscribe(x=>this.getAvailableTasks());
    }
    
    login(){
        
        this.homeService.login().subscribe(x=>console.log("ee"));
        
    }
    
    getAvailableTasks(){
        this.homeService.getTasks().subscribe(x=>this.tasks=x);
    }
    
    beeba(id: string){
        alert(id);
        this.s=id;
    }
}
