import {NgModule} from '@angular/core';
import {HomeComponent} from './home.component';
import {CommonModule} from '@angular/common';
import {HomeService} from "./home.service";
import {homeRouting} from "./home.routes";

@NgModule({
  imports: [CommonModule, homeRouting],
  declarations: [HomeComponent],
  providers: [HomeService],
  exports: [HomeComponent]
})
export class HomeModule {

}
