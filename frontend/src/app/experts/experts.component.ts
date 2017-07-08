import {Component} from '@angular/core';
import {selector} from "rxjs/operator/publish";
import {ExpertsService} from "./experts.service";
@Component({
  moduleId: module.id,
  selector: 'experts',
  templateUrl : 'experts.component.html',
  providers:[ExpertsService]
})
export class ExpertsComponent{
  expertsArray:any[];

  constructor(expertService: ExpertsService){
    this.arr = expertService.experts();
  }
}