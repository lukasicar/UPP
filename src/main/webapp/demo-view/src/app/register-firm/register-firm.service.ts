import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map';
import { MockUser } from './../home/home.mockuser';

@Injectable()
export class RegisterFirmService {

    private apiUrl = `${environment.BACKEND_URL}`;
    
    constructor(private http: Http) { }

    getCategories(){
        return this.http.get(this.apiUrl+"/categories").map(res=>res.json());    
    }
    
    register(mu: MockUser,taskId:string){
        return this.http.post(this.apiUrl+"/register/registracijaKorisnika/"+taskId,mu).map(res=>res.text());
    }
}
