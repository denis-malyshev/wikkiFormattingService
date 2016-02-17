var View = function (eventBus) {
    var viewId = "view";
    var inputAreaId = "inputText";
    var resultAreaId = "resultText";
    var formatBtnId = "format";

    var viewSelector = "#" + viewId;
    var inputAreaSelector = "#" + inputAreaId;
    var resultAreaSelector = "#" + resultAreaId;
    var formatBtnSelector = "#" + formatBtnId;

    var innerHTML = '<div id="' + viewId + '" class ="container"></div>';

    var inputContainer = '<div class = "container">' +
        '<h2>Input text:</h2>' +
        '<div class="col-md-5">' +
        '<textarea class = "form-control" rows="10" placeholder = "Enter wiki-like formatted text" id="' + inputAreaId + '"></textarea>' +
        '</br><button id="' + formatBtnId + '" class = "btn btn-primary">To HTML</button></div></div>';

    var resultContainer = '<div class = "container">' +
        '<h2>Result:</h2>' +
        '<div class="col-md-5">' +
        '<div id="' + resultAreaId + '"></div>' +
        '</br></div></div>';

    $('body').html(innerHTML);

    $(viewSelector).html(inputContainer + resultContainer);

    $(formatBtnSelector).click(function () {
        eventBus.postMessage("FORMAT_ATTEMPT", $(inputAreaSelector).val());
    });

    var renderResultArea = function (modelData) {
        $(resultAreaSelector).html(modelData);
    };

    eventBus.registerConsumer("MODEL_UPDATED", function (modelData) {
        renderResultArea(modelData)
    });
};