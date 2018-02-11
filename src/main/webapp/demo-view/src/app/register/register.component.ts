import { Component, OnInit } from '@angular/core';
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
    
    constructor(private  registerService: RegisterService) { }

      ngOnInit() {
        //this.getCategories();
      }
/*
    getCategories(){
        this.registerService.getCategories().subscribe(s => this.categories.push(s));
    }*/
}
