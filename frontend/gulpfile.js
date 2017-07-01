(function () {
    'use strict';
    var gulp = require('gulp');
    var Q = require('q');
    var tsc = require('gulp-typescript');
    var tsConfig = tsc.createProject('tsconfig.json');
    var browserify = require('gulp-browserify');
    var source = require('vinyl-source-stream');
    var tsify = require('tsify');
    var embedTemplates = require('gulp-angular-embed-templates');
    var concat = require('gulp-concat');
    var jsminify = require('gulp-minify');
    var embedSass = require('gulp-angular2-embed-sass');
    var nodemon = require('nodemon');
    var tslint = require('gulp-tslint');
    var imagemin = require('gulp-imagemin');
    var del = require('del');
    var plumber = require('gulp-plumber');
    var runSequence = require('run-sequence');
    var sourceMaps = require('gulp-sourcemaps');
    var replace = require('gulp-replace');
    var uglifycss = require('gulp-uglifycss');
    var inject = require('gulp-inject');
    var gzip = require('gulp-gzip');
    var paths = {
        htmlPages: ['app/**/**/*.html'],
        cssPages: 'app/**/**/*.css',
        copySystemConfig: './systemjs.config.extras.js',
        copySystemExtrasConfig: './systemjs.config.js',
        copyBsconfig: './bs-config.json',
        copyPackageJSON: 'package.json',
        copyBowerJSON: 'bower.json',
        copyBabelrc: '.babelrc',
        copytypings: 'typings.json',
        vendorScript: 'assets/js/',
        forbiddenPage: 'forbidden.html'
    };

    /**
     * @clean Development environment
     */
    gulp.task('clean', function (done) {
        del(['dist/dev', 'dist/temp'], done);

    });

    /**
     * @clean all environment
     */
    gulp.task('clean-all', function (done) {
        del('dist/', done);
    });

    /**
     * Clean all the js files from app folder
     */
    gulp.task('clean-junkjs', function (done) {
        del(['app/**/*.js', 'app/**/*.js.map'], done);
    });

    /**
     * @Prepare the environment ie., copy the sourcecode along with html and css into a `temp` directory for the safety.
     */
    gulp.task('prep-env', function () {
        return gulp
            .src(['app/**/*.ts', 'app/**/*.html', 'app/**/*.css'])
            .pipe(gulp.dest('dist/temp/src/app'));
    });

    /**
     * @Compile the sourcecode typescript i.e., `ts` files and copy them in `dist/dev` environment
     */
    gulp.task('ts-compile', function () {
        return gulp
            .src('dist/temp/src/app/**/*.ts')
            .pipe(sourceMaps.init())
            .pipe(tsc(tsConfig))
            .pipe(sourceMaps.write('.'))
            .pipe(gulp.dest('dist/dev/src/app'));
    });

    gulp.task('copy-html', function () {
        return gulp.src(paths.htmlPages)
            .pipe(gulp.dest('dist/dev/src/app'));
    });

    gulp.task('copy-css', function () {
        return gulp.src(paths.cssPages)
            .pipe(gulp.dest('dist/app'));
    });

    gulp.task('default', ['copy-html', 'copy-css', 'watch']);

    gulp.task('watch', function(){
        gulp.watch(paths.htmlPages, ['copy-html']);
        gulp.watch(paths.cssPages, ['copy-css']);
    });

    var systemjsBuilder = require('systemjs-builder');

    gulp.task('tsc', function () {

        return gulp.src(['app/**/*.ts', 'typings/index.d.ts'])
            .pipe(tsc({
                "target": "es5",
                "module": "commonjs",
                "moduleResolution": "node",
                "sourceMap": true,
                "emitDecoratorMetadata": true,
                "experimentalDecorators": true,
                "removeComments": true,
                "noImplicitAny": false,
                "suppressImplicitAnyIndexErrors": true
            }))
            .js.pipe(gulp.dest('dist'));
    });
    gulp.task('bundle-config', function() {
        return gulp.src('app/configs/systemjs.config.js')
            .pipe(gulp.dest('dist/configs'));
    });
    gulp.task('bundle-app', ['bundle-config', 'tsc'], function() {

        var builder = new systemjsBuilder('', 'app/configs/systemjs.config.js');
        return builder
            .bundle('[dist/**/*]', 'production/app.bundle.min.js', {
                minify: true,
                mangle: true
            })
            .then(function() {
                console.log('Build complete');
            })
            .catch(function(err) {
                console.log('Build error');
                console.log(err);
            });

    });

    gulp.task('bundle-dependencies', ['bundle-config', 'tsc'], function() {

        var builder = new systemjsBuilder('', 'app/configs/systemjs.config.js');
        return builder
            .bundle('dist/**/* - [dist/**/*.js]', 'production/dependencies.bundle.min.js', {
                minify: true,
                mangle: true
            })
            .then(function() {
                console.log('Build complete');
            })
            .catch(function(err) {
                console.log('Build error');
                console.log(err);
            });

    });

    gulp.task('production', ['bundle-app', 'bundle-dependencies'], function(){});

})();
