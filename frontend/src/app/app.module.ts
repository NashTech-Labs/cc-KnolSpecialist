import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { HeaderComponent }  from './shared/header/header.component';
import {HomeComponent} from "./home/home.component";

@NgModule({
  imports:      [ BrowserModule ],
  declarations: [ AppComponent, HeaderComponent, HomeComponent],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
