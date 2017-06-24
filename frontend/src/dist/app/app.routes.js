"use strict";
var router_1 = require("@angular/router");
var home_component_1 = require("./home/home.component");
var routes = [
    {
        path: 'home',
        component: home_component_1.HomeComponent,
    },
    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    }
];
exports.routing = router_1.RouterModule.forRoot(routes);
//# sourceMappingURL=app.routes.js.map