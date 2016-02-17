$(function () {
    (new launch(new EventBus()));
});
var launch = function (eventBus) {
    new Model(eventBus);
    new View(eventBus);
    new Controller(eventBus);
};

