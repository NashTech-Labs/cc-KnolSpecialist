import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { SharedModule }  from './shared/shared.module';
import {HomeModule} from './home/home.module';
/*import {HomeComponent} from "./home/home.component";*/


@NgModule({
  imports:      [ BrowserModule, HomeModule, SharedModule ],
  declarations: [ AppComponent],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
