import { Component, OnInit, Input } from '@angular/core';
import { Category } from './../register/register.category';
import { MockUser } from './../home/home.mockuser';
import { TenderRequest } from './tender-request';
import { TenderRequestService } from './tender-request.service';
import { RegisterFirmService } from './../register-firm/register-firm.service';

@Component({
  selector: 'app-tender-request',
  templateUrl: './tender-request.component.html',
  styleUrls: ['./tender-request.component.css']
})
export class TenderRequestComponent implements OnInit {

    categories: Category[]=[];
    @Input() taskId: string;
    tr: TenderRequest=new TenderRequest();
    
    //mu: MockUser=new MockUser();
    //categoryName:string;
    //o: Category;

    constructor(private tenderRequestService: TenderRequestService,private registerFirmService: RegisterFirmService) { }

    ngOnInit() {
        this.getCategories();
      }
    
    complete(){
        if(this.validation()){
            this.tr.rokZaPrimanjePonuda+=":00";
            this.tr.rokZaIzvrsavanjeUsluge+=":00";
            this.tenderRequestService.complete(this.tr,this.taskId).subscribe(x=>window.location.reload());
        }
        
    }

    getCategories(){
        this.registerFirmService.getCategories().subscribe(s => {this.categories=s;});
    }
    
    validation(){
        if(typeof this.tr.category =='undefined'){
            alert("Unesite kategoriju posla");
            return false;
        }else if(this.tr.opisPosla==null||this.tr.opisPosla.trim().length==0){
            alert("Unesite opis posla");
            return false;
        }else if(this.tr.procjenaVrijednosti==null){
            alert("Unesite procjenu vrijednosti");
            return false;
        }else if(typeof this.tr.rokZaPrimanjePonuda=='undefined'){
            alert("Odredite rok za primanje ponuda");
            return false;
        }else if(this.tr.maksimalniBrojPonuda==null){
            alert("Unesite maksimalni broj ponuda");
            return false;
        }else if(typeof this.tr.rokZaIzvrsavanjeUsluge=='undefined'){
            alert("Odredite rok za izvrsavanje usluge");
            return false;
        }
        return true;
    }
    

}
