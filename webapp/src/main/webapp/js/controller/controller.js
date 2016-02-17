var Controller = function (eventBus) {
    var isEmptyData = function (modelData) {
        return (!/\S/.test(modelData));
    };

    eventBus.registerConsumer(Event.FORMAT_ATTEMPT, function (modelData) {
        if (!isEmptyData(modelData)) {
            eventBus.postMessage(Event.MODEL_UPDATE, modelData);
        }
    });
};