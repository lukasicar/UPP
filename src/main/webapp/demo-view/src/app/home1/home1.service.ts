import { Injectable } from '@angular/core';
import { Http, Response, Headers } from "@angular/http";
import 'rxjs/add/operator/map'
import { environment } from '../../environments/environment';

@Injectable()
export class Home1Service {

    private apiUrl = `${environment.BACKEND_URL}`;
    
    constructor(private http: Http) { }

    getTasks(){
        var headers = new Headers();
        headers.append('username', localStorage.getItem('username'));
        return this.http.get(this.apiUrl+"/register/getTasks",{headers: headers}).map(res=>res.json());
    }
}
