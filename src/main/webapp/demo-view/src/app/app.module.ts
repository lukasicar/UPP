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

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    HomeComponent,
    RegisterFirmComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    FormsModule
  ],
  providers: [RegisterService,HomeService,RegisterFirmService],
  bootstrap: [AppComponent]
})
export class AppModule { }
