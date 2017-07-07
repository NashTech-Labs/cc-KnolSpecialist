import { Routes, RouterModule }   from '@angular/router';
import {ExpertsComponent} from "./experts.component";

const routes: Routes = [
  {
    path: 'experts',
    component: ExpertsComponent
  }
];
export const expertsRouting = RouterModule.forChild(routes);