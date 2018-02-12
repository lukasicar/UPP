import { Component, OnInit, Input } from '@angular/core';
import { RegisterService } from './register.service';
import { Category } from './register.category';
import { MockUser } from './../home/home.mockuser';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

    categories: Category[]=[];
    mu: MockUser=new MockUser();
    @Input() taskId: string;
    
    
    constructor(private  registerService: RegisterService) { }

      ngOnInit() {
        //this.getCategories();
      }
    
    register(){
        this.registerService.register(this.mu,this.taskId).subscribe(x=>window.location.reload());
    }
/*
    getCategories(){
        this.registerService.getCategories().subscribe(s => this.categories.push(s));
    }*/
}
