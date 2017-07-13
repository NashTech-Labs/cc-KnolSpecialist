import { Component } from '@angular/core';

import {
  Router, Event as RouterEvent,
  NavigationStart,
  NavigationEnd,
  NavigationCancel,
  NavigationError
} from '@angular/router';

@Component({
  moduleId: module.id,
  selector: 'my-app',
  template: `<knol-header></knol-header><router-outlet></router-outlet>`
})
export class AppComponent  {   }
