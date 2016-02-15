$(function () {
    (new launch(new EventBus()));
});
var launch = function (eventBus) {
    new WikiFormattingService(eventBus);
    new View(eventBus);
};

