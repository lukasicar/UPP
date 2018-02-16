import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map';
import { TenderResponse } from './tender-response';

@Injectable()
export class TenderResponseService {

    private apiUrl = `${environment.BACKEND_URL}`;
    
    constructor(private http: Http) { }
    
    complete(tr:TenderResponse,taskId:string){
        return this.http.post(this.apiUrl+"/task/tenderResponse/"+taskId,tr).map(res=>res.text());
    }

}
