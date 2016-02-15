var WikiFormattingService = function (eventBus) {
    var eventBus = eventBus;

    var format = function (text) {
        var data = JSON.stringify(new RequestDTO(text));
        console.log(data);

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/to_html",
            data: data,
            contentType: "application/json",
            dataType: "json"
        }).done(function (data) {
            eventBus.postMessage("FORMAT_SUCCESSFUL", data);
            console.log(data);
        });
    };

    eventBus.registerConsumer("FORMAT_ATTEMPT", function (text) {
        format(text);
    });
};