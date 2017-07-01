import { Component, AfterViewInit } from '@angular/core';
import { AbstractControl } from '@angular/forms'
import {HomeService} from "./home.service";

@Component({
  selector: 'knol-home',
  templateUrl: '../app/home/home.component.html',
  providers:[HomeService]
})
export class HomeComponent implements AfterViewInit{

  arr:any[];

  ngAfterViewInit() {
    console.log("ng after");
    var materialMenuScript = document.createElement('script');
    materialMenuScript.type = 'text/javascript';
    materialMenuScript.src = './assets/js/jquery.flexslider.js';
    materialMenuScript.id = 'menuScript';
    document.body.appendChild(materialMenuScript);

    var custom = document.createElement('script');
    custom.type = 'text/javascript';
    custom.src = './assets/js/custom.js';
    custom.id = 'customScript';
    document.body.appendChild(custom);
  }

  constructor(homeService: HomeService){
    this.arr = homeService.techniques();
  }

}
