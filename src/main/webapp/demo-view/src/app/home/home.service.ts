import { Injectable } from '@angular/core';
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map'
import { MockUser } from './home.mockuser';
import { environment } from '../../environments/environment';

@Injectable()
export class HomeService {

    private apiUrl = `${environment.BACKEND_URL}`;
    
    constructor(private http: Http) { }
    
    startProcess(){
        return this.http.get(this.apiUrl+"/register/startProcess").map(res=>res.text());    
    }

    login(){
        
        return this.http.get(this.apiUrl+"/login").map(res=>res.text());
    }
    
    getTasks(){
        return this.http.get(this.apiUrl+"/register/getTasks").map(res=>res.json());
    }
}
