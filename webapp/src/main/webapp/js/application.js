$(function () {
    (new Application(new EventBus()).launch());
});
var Application = function (eventBus) {
    this.eventBus = eventBus;
};
Application.prototype.launch = function () {
    new Model(this.eventBus);
    new View(this.eventBus);
    new Controller(this.eventBus);
};

