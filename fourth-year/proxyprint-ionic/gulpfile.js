var gulp = require('gulp');
var gutil = require('gulp-util');
var bower = require('bower');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var sass = require('gulp-sass');
var cleanCSS = require('gulp-clean-css');
var sourcemaps = require('gulp-sourcemaps');
var ngAnnotate = require('gulp-ng-annotate');
var rename = require('gulp-rename');
var sh = require('shelljs');

var paths = {
  css: [
    'www/css/**/*.css'
  ],
  javascript: [
    'www/lib/jquery/dist/jquery.min.js',
    'www/lib/ionic/js/ionic.bundle.js',
    'www/lib/ngCordova/dist/ng-cordova.js',
    'www/lib/angular-cookies/angular-cookies.min.js',
    'www/js/app/**/*.js'
  ]
};

gulp.task('default', ['sass']);

gulp.task('build-js', function() {
  return gulp.src(paths.javascript)
    .pipe(sourcemaps.init())
    .pipe(ngAnnotate())
    .pipe(concat('app.js'))
    .pipe(uglify())
    .pipe(sourcemaps.write())
    .pipe(gulp.dest('www/assets/js'));
});

gulp.task('build-css', function(done) {
  gulp.src('www/stylesheets/**/*.scss')
    .pipe(sass())
    .on('error', sass.logError)
    .pipe(concat('app.css'))
    .pipe(gulp.dest('www/assets/css/'))
    .pipe(cleanCSS())
    .pipe(gulp.dest('www/assets/css/'))
    .on('end', done);
});

gulp.task('watch', function() {
  gulp.watch(paths.css, ['build-css']);
  gulp.watch(paths.javascript, ['build-js']);
});

gulp.task('install', ['git-check'], function() {
  return bower.commands.install()
    .on('log', function(data) {
      gutil.log('bower', gutil.colors.cyan(data.id), data.message);
    });
});

gulp.task('git-check', function(done) {
  if (!sh.which('git')) {
    console.log(
      '  ' + gutil.colors.red('Git is not installed.'),
      '\n  Git, the version control system, is required to download Ionic.',
      '\n  Download git here:', gutil.colors.cyan('http://git-scm.com/downloads') + '.',
      '\n  Once git is installed, run \'' + gutil.colors.cyan('gulp install') + '\' again.'
    );
    process.exit(1);
  }
  done();
});

gulp.task('build', ['build-js', 'build-css']);
