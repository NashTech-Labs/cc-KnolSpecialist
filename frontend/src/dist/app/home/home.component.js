"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var HomeComponent = (function () {
    function HomeComponent() {
        this.arr = [
            { id: 1, imgUrl: 'https://www.scala-lang.org/resources/img/smooth-spiral.png', title: 'Scala' },
            { id: 2, imgUrl: 'https://d3an9kf42ylj3p.cloudfront.net/uploads/2015/06/spark-logo.png?x23053', title: 'spark' },
            { id: 3, imgUrl: 'https://angular.io/assets/images/logos/angular/angular.png', title: 'Angular' },
            { id: 4, imgUrl: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRuLMuNbMmZjvu39H_8O-CgZmTDdO-0kYyFeSXizJR2jcR7BMP3AuLYURc', title: 'spark' },
            { id: 5, imgUrl: 'https://www.seeklogo.net/wp-content/uploads/2011/06/java-logo-vector.png', title: 'Scala' },
            { id: 6, imgUrl: 'https://d3an9kf42ylj3p.cloudfront.net/uploads/2015/06/spark-logo.png?x23053', title: 'spark' },
            { id: 7, imgUrl: 'https://www.scala-lang.org/resources/img/smooth-spiral.png', title: 'Scala' },
            { id: 8, imgUrl: 'https://d3an9kf42ylj3p.cloudfront.net/uploads/2015/06/spark-logo.png?x23053', title: 'spark' },
            { id: 9, imgUrl: 'https://www.scala-lang.org/resources/img/smooth-spiral.png', title: 'Scala' }
        ];
    }
    HomeComponent.prototype.ngAfterViewInit = function () {
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
    };
    return HomeComponent;
}());
HomeComponent = __decorate([
    core_1.Component({
        selector: 'knol-home',
        templateUrl: './app/home/home.component.html',
        styleUrls: ['./app/home/home.component.css']
    })
], HomeComponent);
exports.HomeComponent = HomeComponent;
//# sourceMappingURL=home.component.js.map