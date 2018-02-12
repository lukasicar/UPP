import { Component, OnInit, Input } from '@angular/core';
import { RegisterFirmService } from './register-firm.service';
import { Category } from './../register/register.category';
import { MockUser } from './../home/home.mockuser';

@Component({
  selector: 'app-register-firm',
  templateUrl: './register-firm.component.html',
  styleUrls: ['./register-firm.component.css']
})
export class RegisterFirmComponent implements OnInit {
    
    categories: Category[]=[];
    @Input() taskId: string;
    mu: MockUser=new MockUser();
    categoryName:string;
    
    constructor(private registerFirmService: RegisterFirmService) { }

    ngOnInit() {
        this.getCategories();
      }
    
    register(mu:MockUser){
        alert(this.mu.udaljenost);
        //this.registerFirmService.register(this.mu,this.taskId).subscribe(x=>window.location.reload());
    }

    getCategories(){
        this.registerFirmService.getCategories().subscribe(s => this.categories.push(s));
    }
}
