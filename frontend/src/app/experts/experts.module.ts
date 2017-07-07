import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ExpertsComponent} from "./experts.component";
import {expertsRouting} from "./experts.routes";

@NgModule({
  imports: [CommonModule, expertsRouting],
  declarations : [ExpertsComponent]
})

export class ExpertsModule{

}