"use strict";
var ExpertsService = (function () {
    function ExpertsService() {
    }
    ExpertsService.prototype.experts = function () {
        return [
            {
                id: 1,
                name: 'Pranjut',
                percentage: '98'
            },
            {
                id: 2,
                name: 'Anuj',
                percentage: '98'
            },
            {
                id: 3,
                name: 'Ashu',
                percentage: '98'
            },
        ];
    };
    return ExpertsService;
}());
exports.ExpertsService = ExpertsService;
//# sourceMappingURL=experts.service.js.map