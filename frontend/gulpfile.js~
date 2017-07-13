var gulp = require('gulp');
var uglify = require('gulp-uglify');
//var ngBuild = require('gulp-ng-build');

gulp.task('minify', function () {
   gulp.src('js/app.js')
      .pipe(uglify())
      .pipe(gulp.dest('dist'))
});

var minifyCss = require('gulp-minify-css');

module.exports = function() {
    return gulp.src('css/*.css')
               .pipe(minifyCss())
               .pipe(gulp.dest('dist'));
 };


 
//gulp.task('default', ngBuild, function(){
  // console.log('build done with success'); 
//});
