import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { RegisterService } from './register/register.service';
import { HttpModule } from '@angular/http';
import { HomeService } from './home/home.service';
import { RegisterFirmComponent } from './register-firm/register-firm.component';
import { RegisterFirmService } from './register-firm/register-firm.service';
import { Home1Component } from './home1/home1.component';
import { TenderRequestComponent } from './tender-request/tender-request.component';
import { TenderResponseComponent } from './tender-response/tender-response.component';
import { Home1Service } from './home1/home1.service';
import { TenderRequestService } from './tender-request/tender-request.service';
import { TenderResponseService } from './tender-response/tender-response.service';
import { YesNoComponent } from './yes-no/yes-no.component';
import { YesNoService } from './yes-no/yes-no.service';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    HomeComponent,
    RegisterFirmComponent,
    Home1Component,
    TenderRequestComponent,
    TenderResponseComponent,
    YesNoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    FormsModule
  ],
  providers: [RegisterService,HomeService,RegisterFirmService,Home1Service,TenderRequestService,TenderResponseService,
  YesNoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
