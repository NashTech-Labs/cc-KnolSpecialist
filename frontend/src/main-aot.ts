/// <reference path="../node_modules/@types/node/index.d.ts" />
import { platformBrowser }    from '@angular/platform-browser';
import { AppModuleNgFactory } from './dist/aot/app/app.module.ngfactory';

platformBrowser().bootstrapModuleFactory(AppModuleNgFactory);