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
        
        if(this.validation())
           this.registerService.register(this.mu,this.taskId).subscribe(x=>window.location.reload());
    }
/*
    getCategories(){
        this.registerService.getCategories().subscribe(s => this.categories.push(s));
    }*/
    
    validation(){
        if(this.mu.ime==null||this.mu.ime.trim().length==0){
            alert("Unesite ime");
            return false;
        }else if(this.mu.mail==null||this.mu.mail.trim().length==0){
            alert("Unesite mail");
            return false;
        }else if(!this.mu.mail.includes("@")){
            alert("Nema @ u mejlu");
            return false;
        }
        else if(this.mu.username==null||this.mu.username.trim().length==0){
            alert("Unesite username");
            return false;
        }
        else if(this.mu.address==null||this.mu.address.trim().length==0){
            alert("Unesite adresu");
            return false;
        }else if(this.mu.password==null||this.mu.password.trim().length==0){
            alert("Unesite password");
            return false;
        }else if(this.mu.mjesto==null||this.mu.mjesto.trim().length==0){
            alert("Unesite mjesto");
            return false;
        }else if(this.mu.postanskiBroj==null){
            alert("Unesite postanski broj");
            return false;
        }else if(typeof this.mu.type =='undefined'){
            alert("Unesite tip korisnika");
            return false;
        }
        return true;
    }
}
