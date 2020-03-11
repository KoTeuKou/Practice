let stompClient = null;
let autocompleteArray = null;

function connect() {
    let socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/autocomplete', function (autocomplete) {
            console.log(autocomplete.body);
            autocompleteArray = JSON.parse(autocomplete.body);

            //TODO: Add autocomplete view
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }

    console.log("Disconnected");
}

$(function () {  // Find by name input field, look for info in console
    $("#text_name").on('input', function () {
        stompClient.send("/app/autocomplete", {}, $("#text_name").val());
    });
});