var Model = function (eventbus) {
    var eventBus = eventbus;

    var update = function (modelData) {
        var requestData = JSON.stringify(new RequestDTO(modelData));

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/wf_service/to_html",
            data: requestData,
            contentType: "application/json",
            dataType: "json"
        }).done(function (responseData) {
            eventBus.postMessage("MODEL_UPDATED", responseData.text);
        });
    };

    eventBus.registerConsumer("MODEL_UPDATE", function (modelData) {
        update(modelData);
    });
};