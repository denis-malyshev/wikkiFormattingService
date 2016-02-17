var Model = function (eventBus) {
    var update = function (modelData) {
        var requestData = JSON.stringify(new RequestDTO(modelData));

        $.ajax({
            type: "POST",
            url: RestEndPoints.TO_HTML,
            data: requestData,
            contentType: "application/json",
            dataType: "json"
        }).done(function (responseData) {
            eventBus.postMessage(Event.MODEL_UPDATED, responseData.text);
        });
    };

    eventBus.registerConsumer(Event.MODEL_UPDATE, function (modelData) {
        update(modelData);
    });
};