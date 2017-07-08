(function () {
    'use strict';
    var gulp = require('gulp');
    var del = require('del');

    var paths = {
        htmlPages: ['src/app/**/**/*.html'],
        cssPages: 'src/app/**/**/*.css'
    };
    /**
     * @clean all environment
     */
    gulp.task('clean-all', function (done) {
        del('./src/dist/', done);
    });
    gulp.task('copy-html', function () {
        return gulp.src(paths.htmlPages)
            .pipe(gulp.dest('src/dist/app'));
    });

    gulp.task('copy-css', function () {
        return gulp.src(paths.cssPages)
            .pipe(gulp.dest('src/dist/app'));
    });

    var gulp = require('gulp'); //Add dependency to package.json if not added
    var replace = require('gulp-replace'); //Add dependency to package.json if not added

    gulp.task('tweak-minJs', function () {
        gulp.src(['./src/dist/prod/bundle.min.js'])
            .pipe(replace('moduleId:module.id,', ''))
            .pipe(gulp.dest('./src/dist/prod/app/'));
    });
    gulp.task('copy-rootfiles-prod', function () {
        return gulp.src(['./src/assets/**/*'])
            .pipe(gulp.dest('./src/dist/prod/assets'));
    });
})();
