import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map';
import { MockUser } from './../home/home.mockuser';
import { TenderRequest } from './tender-request';

@Injectable()
export class TenderRequestService {

    private apiUrl = `${environment.BACKEND_URL}`;
    
    constructor(private http: Http) { }
    
    complete(tr:TenderRequest,taskId:string){
        return this.http.post(this.apiUrl+"/task/tenderRequest/"+taskId,tr).map(res=>res.text());
    }

}
