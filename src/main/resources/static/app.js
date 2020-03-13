let stompClient = null;
let autocompleteArray = [];
let autocompleteArray2 = [];
let requestParam = "";
function connect() {
    let socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/autocomplete', function (autocomplete) {
            console.log(autocomplete.body);
            autocompleteArray = JSON.parse(autocomplete.body);
            autocompleteArray2.length = 0;
            console.log(requestParam);
            $.each(autocompleteArray, function(i, item) {
                switch (requestParam) {
                    case "all":
                        autocompleteArray2.push({
                            value: item.surname + ' ' + item.name + ' ' + item.patronymic, data: item.id
                        });
                        break;
                    case "surname":
                        autocompleteArray2.push({
                            value: item.surname, data: item.id
                        });
                        break;
                    case "name":
                        autocompleteArray2.push({
                            value: item.name, data: item.id
                        });
                        break;
                    case "patronymic":
                        autocompleteArray2.push({
                            value: item.patronymic, data: item.id
                        });
                        break;
                    case "mail":
                        autocompleteArray2.push({
                            value: item.mail, data: item.id
                        });
                        break;
                    case "phone":
                        autocompleteArray2.push({
                            value: item.phone, data: item.id
                        });
                        break;
                }

            });
            console.log(autocompleteArray2)
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
    $('input[name="searchField"]').on('input', function () {
        let id = $(this).attr('id');
        let text = $('#' + id).val();
        if (text === "") return;
        requestParam = id;
        stompClient.send("/app/autocomplete", {}, id + "`" + text);
    });
});