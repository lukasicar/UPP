import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Http, Response } from "@angular/http";
import { TenderResponse } from './../tender-response/tender-response';
import 'rxjs/add/operator/map';



@Injectable()
export class RazmatranjeService {

    private apiUrl = `${environment.BACKEND_URL}`;
    
    constructor(private http: Http) { }
    
    zadovoljan(taskId:string,tr:TenderResponse){
        return this.http.post(this.apiUrl+"/task/zadovoljan/"+taskId,tr).map(res=>res.text());
    }

    getPonude(taskId:string){
        return this.http.get(this.apiUrl+"/task/getPonude/"+taskId).map(res=>res.json());
    }
    
    no(taskId:string){
        return this.http.get(this.apiUrl+"/task/no/"+taskId).map(res=>res.text());
    }
    
    info(taskId:string,tr:TenderResponse){
        return this.http.post(this.apiUrl+"/task/info/"+taskId,tr).map(res=>res.text());
    }
}
