import { Category } from './../register/register.category';
export class TenderRequest{
    category:Category;
    opisPosla:string;
    procjenaVrijednosti:number;
    rokZaPrimanjePonuda:Date;
    maksimalniBrojPonuda:number;
    rokZaIzvrsavanjeUsluge:Date;
}