import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map';
@Injectable()
export class RegisterFirmService {

    private apiUrl = `${environment.BACKEND_URL}`;
    
    constructor(private http: Http) { }

    getCategories(){
        return this.http.get(this.apiUrl+"/categories").map(res=>res.json);    
    }
}
