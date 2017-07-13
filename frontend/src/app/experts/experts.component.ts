import {Component, OnInit} from '@angular/core';
import {selector} from "rxjs/operator/publish";
import {ExpertsService} from "./experts.service";

@Component({
  moduleId: module.id,
  selector: 'experts',
  templateUrl : 'experts.component.html',
  providers:[ExpertsService]
})

export class ExpertsComponent implements OnInit{
  expertsArray:any[];

  constructor(private expertService: ExpertsService){

  }
  ngOnInit() {
    this.expertService.experts().subscribe(
        res => {
          this.expertsArray = res;
        },
        error => {
          alert(error);
        }
     );
  }
}