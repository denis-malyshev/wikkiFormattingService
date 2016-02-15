var EventBus = function () {
    this.consumers = [];
};
EventBus.prototype.registerConsumer = function (type, consumer) {
    this.consumers.push({
        type: type,
        callback: consumer
    });
    console.log(new Date().toLocaleTimeString() + ": added consumer " + type);
};
EventBus.prototype.postMessage = function (type, message) {
    for (var i = 0; i < this.consumers.length; i++) {
        if (this.consumers[i].type == type) {
            var callback = this.consumers[i].callback;
            var myCallback = function () {
                callback(message);
            };
            setTimeout(myCallback, 100);
            console.log(new Date().toLocaleTimeString() + ": message posted to " + type);
        }
    }
};
