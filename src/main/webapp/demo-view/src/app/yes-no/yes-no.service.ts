import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map';
import { MockUser } from './../home/home.mockuser';

@Injectable()
export class YesNoService {
    
    private apiUrl = `${environment.BACKEND_URL}`;
    
    constructor(private http: Http) { }
    
    complete(choice:string,taskId:string){
        return this.http.post(this.apiUrl+"/task/odabir1/"+taskId,choice).map(res=>res.text());
    }

}
