var HomeService = (function () {
    function HomeService() {
    }
    HomeService.prototype.techniques = function () {
        return [
            {
                id: 0,
                imgUrl: 'https://www.scala-lang.org/resources/img/smooth-spiral.png',
                title: 'Scala'
            },
            {
                id: 1,
                imgUrl: 'http://www.alluxio.org/images/brands/spark.png',
                title: 'spark'
            },
            {
                id: 2,
                imgUrl: 'https://angular.io/assets/images/logos/angular/angular.png',
                title: 'Angular'
            },
            {
                id: 3,
                imgUrl: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRuLMuNbMmZjvu39H_8O-CgZmTDdO-0kYyFeSXizJR2jcR7BMP3AuLYURc',
                title: 'Lagom'
            },
            {
                id: 4,
                imgUrl: 'https://www.seeklogo.net/wp-content/uploads/2011/06/java-logo-vector.png',
                title: 'Scala'
            }
        ];
    };
    return HomeService;
}());
export { HomeService };
//# sourceMappingURL=home.service.js.map