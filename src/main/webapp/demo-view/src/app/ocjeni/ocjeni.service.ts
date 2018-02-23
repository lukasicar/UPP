import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map';

@Injectable()
export class OcjeniService {

    private apiUrl = `${environment.BACKEND_URL}`;
    
    constructor(private http: Http) { }
    
    complete(polje:string,taskId:string){
        return this.http.post(this.apiUrl+"/task/ocjeni/"+taskId,polje).map(res=>res.text());
    }
    
    getOdg(taskId:string){
        return this.http.get(this.apiUrl+"/task/getOdg/"+taskId).map(res=>res.text());
    }
    
    getUpit(taskId:string){
        return this.http.get(this.apiUrl+"/task/getUpit/"+taskId).map(res=>res.text());
    }
    

}
