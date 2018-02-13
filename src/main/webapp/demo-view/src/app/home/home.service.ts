import { Injectable } from '@angular/core';
import { Http, Response, Headers } from "@angular/http";
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

    login(username:string,password:string){
        var headers = new Headers();
        headers.append('username', username);
        headers.append('password', password);
        return this.http.get(this.apiUrl+"/login",{headers: headers}).map(res=>res.text());
    }
    
    getTasks(){
        return this.http.get(this.apiUrl+"/register/getTasks").map(res=>res.json());
    }
}
