var View = function (eventBus) {
    var eventBus = eventBus;
    var innerHTML = '<div id="view" class ="container"></div>';
    document.body.innerHTML = innerHTML;

    $("#view").html(
        '<div class = "container">' +
        '<h2>Input text</h2>' +
        '<div class="col-md-5" id="inputText">' +
        '<textarea class = "form-control" rows="10" placeholder = "Enter wiki-like formatted text" id="wikiText"></textarea>' +
        '</br><button id="toHTML" class = "btn btn-primary">To HTML</button></div></div>' +
        '<div class = "container">' +
        '<h2>Result</h2>' +
        '<div class="col-md-5">' +
        '<textarea class = "form-control" rows="10" id="HTMLText"></textarea>' +
        '</br></div></div>'
    );

    $("#toHTML").click(function () {
        eventBus.postMessage("FORMAT_ATTEMPT", $("#wikiText").val());
        console.log($("#wikiText").val());
    });

    var renderResultArea = function (responseDTO) {
        console.log(responseDTO.text);
        $("#HTMLText").val("<html><body>" + responseDTO.text + "</body></html>");
    };

    eventBus.registerConsumer("FORMAT_SUCCESSFUL", function (data) {
        renderResultArea(data)
    });
};