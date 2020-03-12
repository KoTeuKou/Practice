let stompClient = null;
let autocompleteArray = [{id: 0, surname: "surname", name: "name", patronymic: "patronymic"}];
let autocompleteArray2 = [];
function connect() {
    let socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/autocomplete', function (autocomplete) {
            console.log(autocomplete.body);
            autocompleteArray = JSON.parse(autocomplete.body);
            $.each(autocompleteArray, function(i, item) {
                autocompleteArray2.push({
                    value: item.surname + ' ' + item.name + ' ' + item.patronymic, data: item.id
                })
            });
            console.log(autocompleteArray2)
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
    $("#text_query").on('input', function () {
        stompClient.send("/app/autocomplete", {}, $("#text_query").val());
    });
});