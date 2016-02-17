var Model = function (eventbus) {
    var eventBus = eventbus;

    var update = function (text) {
        var data = JSON.stringify(new RequestDTO(text));
        console.log(data);

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/wf_service/to_html",
            data: data,
            contentType: "application/json",
            dataType: "json"
        }).done(function (data) {
            eventBus.postMessage("MODEL_UPDATED", data);
            console.log(data);
        });
    };

    eventBus.registerConsumer("MODEL_UPDATE", function (text) {
        update(text);
    });
};