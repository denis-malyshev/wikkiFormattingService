var Controller = function (eventbus) {
    var eventBus = eventbus;

    var isEmptyMessage = function (message) {
        return (!/\S/.test(message));
    };

    eventBus.registerConsumer("FORMAT_ATTEMPT", function (text) {
        if (!isEmptyMessage(text)) {
            eventBus.postMessage("MODEL_UPDATE", text);
        }
    });
};