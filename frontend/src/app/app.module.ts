import { NgModule }      from '@angular/core';
import {Routes, RouterModule} from '@angular/router'
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { SharedModule }  from './shared/shared.module';
import {HomeModule} from './home/home.module';
import {ExpertsModule} from './experts/experts.module';
import {routing} from "./app.routes";
/*import {HomeComponent} from "./home/home.component";*/


@NgModule({
  imports:      [ BrowserModule, routing, HomeModule, RouterModule, ExpertsModule, SharedModule ],
  declarations: [ AppComponent],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
