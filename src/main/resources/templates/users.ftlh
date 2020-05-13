<#import "parts/common.ftlh" as c>

<@c.page>
    <body>
    <div class="container">
        <div id="search">
            <h3>Users</h3>
            <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample"
                    aria-expanded="false" aria-controls="collapseExample">
                Add user
            </button>
            <div class="collapse" id="collapseExample">
                <form style="border: dimgrey 2px solid; padding: 10px; margin: 5px" method="post" action="/save">
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="validationServer01">Surname</label>
                            <input id="surnameA" name="surname" type="text" class="form-control" placeholder="Surname"
                                   value=""
                                   required>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationServer02">Name</label>
                            <input id="nameA" name="name" type="text" class="form-control" placeholder="Name" value=""
                                   required>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationServer02">Patronymic</label>
                            <input id="patronymicA" name="patronymic" type="text" class="form-control"
                                   placeholder="Patronymic"
                                   value="" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-4">
                            <label for="validationServer03">PhoneNum</label>
                            <input id="phoneA" name="phone" type="tel" class="form-control" placeholder="Phone" required>
                        </div>
                        <div class="col-4">
                            <label for="validationServer04">Mail</label>
                            <input id="mailA" name="mail" type="email" class="form-control" placeholder="Mail" required>
                        </div>
                    </div>
                    <button id="save" class="btn btn-primary" type="submit">Add</button>
                </form>
            </div>
            <div>

                <div class="form-row">
                    <div class="col-md-4 mb-3">
                        <form class="form-inline">
                            <input id="surname" class="form-control mr-sm-2" type="text"
                                   placeholder="Search by surname"  aria-label="Search" name="searchField">
                            <button id="surnameBtn" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </div>
                    <div class="col-md-4 mb-3">
                        <form class="form-inline">
                        <input id="name" class="form-control mr-sm-2" type="text" placeholder="Search by name"
                               aria-label="Search" name="searchField">
                        <button id="nameBtn" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </div>
                    <div class="col-md-4 mb-3">
                        <form class="form-inline">
                        <input id="patronymic" class="form-control mr-sm-2" type="text" placeholder="Search by patronymic"
                               aria-label="Search" name="searchField">
                        <button id="patronymicBtn" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </div>
                    <div class="col-md-4 mb-3">
                        <form class="form-inline">
                        <input id="phone" class="form-control mr-sm-2" type="tel" placeholder="Search by phoneNum"
                               aria-label="Search" name="searchField">
                        <button id="phoneBtn" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </div>
                    <div class="col-md-4 mb-3">
                        <form class="form-inline">
                        <input id="mail" class="form-control mr-sm-2" type="email" placeholder="Search by mail"
                               aria-label="Search" name="searchField">
                        <button id="mailBtn" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </div>
                    <div class="col-md-4 mb-3">
                        <form class="form-inline">
                        <input id="all" class="form-control mr-sm-2" type="text" placeholder="Search by any field"
                               aria-label="Search" name="searchField">
                        <button id="queryBtn" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </div>
                </div>
                <table class="table table-hover" id="table">
                    <thead class="thead-dark">
                    <tr>
                        <th data-field="surname" scope="col">
                            <form method="get" action="/users">
                                <input name="param" hidden value="surname">
                                <button class="btn btn-info" type="submit" id="surnameSort">
                                    Surname
                                </button>
                            </form>
                        </th>
                        <th data-field="name" scope="col">
                            <form method="get" action="/users">
                                <input name="param" hidden value="name">
                                <button class="btn btn-info" type="submit" id="nameSort">
                                    Name
                                </button>
                            </form>
                        </th>
                        <th data-field="patronymic" scope="col">
                            <form method="get" action="/users">
                                <input name="param" hidden value="patronymic">
                                <button class="btn btn-info" type="submit" id="patronymicSort">
                                    Patronymic
                                </button>
                            </form>
                        </th>
                        <th data-field="phone" scope="col">PhoneNum</th>
                        <th data-field="mail" scope="col">Mail</th>
                        <th data-field="action1" scope="col"></th>
                        <th data-field="action2" scope="col"></th>
                    </tr>
                    </thead>
                    <#list userList as user>
                        <tr>
                            <td>${user.surname}</td>
                            <td>${user.name}</td>
                            <td>${user.patronymic}</td>
                            <td>${user.phone}</td>
                            <td>${user.mail}</td>
                            <td>
                                <button class="btn btn-outline-success my-2 my-sm-0" type="button" id="${user.id}"
                                        name="mainEdit"
                                        data-toggle="modal"
                                        data-target="#modalCenter${user.id}">
                                    Edit
                                </button>
                                <div class="modal fade" id="modalCenter${user.id}" tabindex="-1" role="dialog"
                                     aria-labelledby="modalCenterTitle" aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-centered" role="document"
                                         style="max-width: 1000px">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="modalCenterTitle">Edit user</h5>
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <form action="/update" method="post"
                                                  style="border: dimgrey 2px solid; padding: 10px; margin: 5px">
                                                <div class="modal-body">

                                                    <div class="form-row">
                                                        <input hidden name="id" value="${user.id}">
                                                        <div class="col-md-4 mb-3">
                                                            <label for="validationServer01">Surname</label>
                                                            <input name="surname" type="text" class="form-control"
                                                                   placeholder="Surname" value="${user.surname}"
                                                                   required>
                                                        </div>
                                                        <div class="col-md-4 mb-3">
                                                            <label for="validationServer02">Name</label>
                                                            <input name="name" type="text" class="form-control"
                                                                   placeholder="Name" value="${user.name}" required>
                                                        </div>
                                                        <div class="col-md-4 mb-3">
                                                            <label for="validationServer02">Patronymic</label>
                                                            <input name="patronymic" type="text"
                                                                   class="form-control" placeholder="Patronymic"
                                                                   value="${user.patronymic}" required>
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="col-4">
                                                            <label for="validationServer03">PhoneNum</label>
                                                            <input name="phone" type="tel" class="form-control"
                                                                   placeholder="Phone" value="${user.phone}" required>
                                                        </div>
                                                        <div class="col-4">
                                                            <label for="validationServer04">Mail</label>
                                                            <input name="mail" type="email" class="form-control"
                                                                   placeholder="Mail" value="${user.mail}" required>
                                                        </div>
                                                    </div>

                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary"
                                                                data-dismiss="modal">Cancel
                                                        </button>
                                                        <button id="${user.id}" type="submit" class="btn btn-primary"
                                                                name="edit">
                                                            Update user
                                                        </button>
                                                    </div>

                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <button class="btn btn-danger" type="button" id="${user.id}" name="delete">
                                    Delete
                                </button>
                            </td>
                        </tr>
                    </#list>
                </table>
            </div>
        </div>

    </div>
    </body>
    <style scoped>
        @import url("https://fonts.googleapis.com/css?family=Roboto:400,300,600,400italic");

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            -webkit-font-smoothing: antialiased;
            -moz-font-smoothing: antialiased;
            -o-font-smoothing: antialiased;
            font-smoothing: antialiased;
            text-rendering: optimizeLegibility;
        }

        body {
            font-family: "Roboto", Helvetica, Arial, sans-serif;
            font-weight: 100;
            font-size: 14px;
            line-height: 50px;
            color: #777;
            background: url("http://atkufa.ru/uploads/wallpapers/47118-atsume-neko-wallpaper.jpg");
        }

        .container {
            max-width: 1400px;
            width: 100%;
            margin: 0 auto;
            position: relative;
        }

        #search input[type="text"],
        #search input[type="email"],
        #search input[type="tel"],
        #search textarea,
        #search button[type="submit"] {
            max-width: 200px;
            min-width: 100px;
            font: 400 12px/16px "Roboto", Helvetica, Arial, sans-serif;
        }

        #search {
            background: #F9F9F9;
            padding: 10px;
            margin: 10px 0;
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
        }

        #search h3 {
            alignment: center;
            display: block;
            font-size: 30px;
            font-weight: 300;
            margin-bottom: 10px;
        }

        #search h4 {
            margin: 5px 0 15px;
            display: block;
            font-size: 13px;
            font-weight: 400;
        }

        #search input[type="text"],
        #search input[type="email"],
        #search input[type="tel"],
        #search input[type="text"]:hover,
        #search input[type="email"]:hover,
        #search input[type="tel"]:hover,
        #search textarea:hover {
            -webkit-transition: border-color 0.3s ease-in-out;
            -moz-transition: border-color 0.3s ease-in-out;
            transition: border-color 0.3s ease-in-out;
            border: 1px solid #aaa;
        }

        #search textarea {
            height: 100px;
            max-width: 100%;
            resize: none;
        }


        #search input:focus,
        #search textarea:focus {
            outline: 0;
            border: 1px solid #aaa;
        }

        ::-webkit-input-placeholder {
            color: #888;
        }

        :-moz-placeholder {
            color: #888;
        }

        ::-moz-placeholder {
            color: #888;
        }

        :-ms-input-placeholder {
            color: #888;
        }

    </style>

    <script>
        connect();
        let indexOfUpdatingUser = 0;


        $('#nameBtn').on('click', function () {
            alert('clicked');
            let text = document.getElementById("text_name").value;
            $.post('/search', {param: "name", reqString: text, cutoff_frequency: 0.01}, function (data) {
            });
        });
        $('#surnameBtn').on('click', function () {
            alert('clicked');
            let text = document.getElementById("text_surname").value;
            $.post('/search', {param: "surname", reqString: text, cutoff_frequency: 0.01}, function (data) {
            });

        });
        $('#patronymicBtn').on('click', function () {
            alert('clicked');
            let text = document.getElementById("text_patronymic").value;
            $.post('/search', {param: "patronymic", reqString: text, cutoff_frequency: 0.01}, function (data) {
            });

        });

        $('#phoneBtn').on('click', function () {
            alert('clicked');
            let text = document.getElementById("text_phone").value;
            $.post('/search', {param: "phone", reqString: text, cutoff_frequency: 0.01}, function (data) {

            });

        });

        $('#mailBtn').on('click', function () {
            alert('clicked');
            let text = document.getElementById("text_mail").value;
            $.post('/search', {param: "mail", reqString: text, cutoff_frequency: 0.01}, function (data) {

            });
            // 
        });
        $('button[name="delete"]').on('click', function () {
            alert('clicked');
            alert($(this).attr('id'));
            let userId = $(this).attr('id');
            $.post('/delete', {id: userId}, function (data) {
            });

        });

        $('input[name="searchField"]').autocomplete({
            minChars: 1,
            maxHeight: 400,
            width: 300,
            zIndex: 9999,
            deferRequestBy: 0,
            onSelect: function (data, value) {
            },
            source: autocompleteArray2,
        });
    </script>
</@c.page>