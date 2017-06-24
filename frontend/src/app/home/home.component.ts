import { Component, AfterViewInit } from '@angular/core';
import { AbstractControl } from '@angular/forms'
@Component({
  selector: 'knol-home',
  templateUrl: './app/home/home.component.html',
  styleUrls: ['./app/home/home.component.css']
})
export class HomeComponent implements AfterViewInit{

  arr: any[] = [
    {id: 1, imgUrl: 'https://www.scala-lang.org/resources/img/smooth-spiral.png', title: 'Scala'},
    {id: 2, imgUrl: 'https://d3an9kf42ylj3p.cloudfront.net/uploads/2015/06/spark-logo.png?x23053', title: 'spark'},
    {id: 3, imgUrl: 'https://angular.io/assets/images/logos/angular/angular.png', title: 'Angular'},
    {id: 4, imgUrl: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRuLMuNbMmZjvu39H_8O-CgZmTDdO-0kYyFeSXizJR2jcR7BMP3AuLYURc', title: 'spark'},
    {id: 5, imgUrl: 'https://www.seeklogo.net/wp-content/uploads/2011/06/java-logo-vector.png', title: 'Scala'},
    
  ];
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
}
