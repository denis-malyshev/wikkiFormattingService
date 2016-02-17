var Controller = function (eventBus) {
    var isEmptyData = function (modelData) {
        return (!/\S/.test(modelData));
    };

    eventBus.registerConsumer("FORMAT_ATTEMPT", function (modelData) {
        if (!isEmptyData(modelData)) {
            eventBus.postMessage("MODEL_UPDATE", modelData);
        }
    });
};