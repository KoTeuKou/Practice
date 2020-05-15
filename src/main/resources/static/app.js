let stompClient = null;
let autocompleteArray = [];
let autocompleteArray2 = [];
let requestParam = "";
function connect() {
    let socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/autocomplete', function (autocomplete) {
            autocompleteArray = JSON.parse(autocomplete.body);
            autocompleteArray2.length = 0;
            $.each(autocompleteArray, function(i, item) {
                switch (requestParam) {
                    case "SURNAME":
                        autocompleteArray2.push({
                            value: item.surname, data: item.id
                        });
                        break;
                    case "NAME":
                        autocompleteArray2.push({
                            value: item.name, data: item.id
                        });
                        break;
                    case "PATRONYMIC":
                        autocompleteArray2.push({
                            value: item.patronymic, data: item.id
                        });
                        break;
                    case "MAIL":
                        autocompleteArray2.push({
                            value: item.mail, data: item.id
                        });
                        break;
                    case "PHONE":
                        autocompleteArray2.push({
                            value: item.phone, data: item.id
                        });
                        break;
                }
            });
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }

    console.log("Disconnected");
}

$(function () {
    $('input[name*="SearchField"]').on('input', function () {
        let id = $(this).attr('id');
        let text = $('#' + id).val();
        if (text === "") return;
        requestParam = id;
        stompClient.send("/app/autocomplete", {}, id + "`" + text);
    });
});