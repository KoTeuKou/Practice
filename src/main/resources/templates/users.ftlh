<#import "parts/common.ftlh" as c>

<@c.page>
    <body>
    <div class="container">
        <div id="search">
            <h3>Ну шо, elasticsearch?</h3>
            <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample"
                    aria-expanded="false" aria-controls="collapseExample">
                Добавление пользователя
            </button>
            <div class="collapse" id="collapseExample">
                <form style="border: dimgrey 2px solid; padding: 10px; margin: 5px">
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="validationServer01">Фамилия</label>
                            <input id="surnameAdding" type="text" class="form-control" placeholder="Surname" value=""
                                   required>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationServer02">Имя</label>
                            <input id="nameAdding" type="text" class="form-control" placeholder="Name" value=""
                                   required>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationServer02">Отчество</label>
                            <input id="patronymicAdding" type="text" class="form-control" placeholder="Patronymic"
                                   value="" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-4">
                            <label for="validationServer03">Телефон</label>
                            <input id="phoneAdding" type="tel" class="form-control" placeholder="Phone" required>
                        </div>
                        <div class="col-4">
                            <label for="validationServer04">Mail</label>
                            <input id="mailAdding" type="email" class="form-control" placeholder="Mail" required>
                        </div>
                    </div>
                    <button id="save" class="btn btn-primary" type="submit">Добавить</button>
                </form>
            </div>
            <div>
                <div class="form-row">
                    <div class="col-md-4 mb-3">
                        <input id="text_name" class="form-control mr-sm-2" type="text" placeholder="Поиск по имени"
                               aria-label="Search">
                        <button id="name" class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
                    </div>
                    <div class="col-md-4 mb-3">
                        <input id="text_phone" class="form-control mr-sm-2" type="tel" placeholder="Поиск по телефону"
                               aria-label="Search">
                        <button id="phone" class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
                    </div>
                    <div class="col-md-4 mb-3">
                        <input id="text_mail" class="form-control mr-sm-2" type="email" placeholder="Поиск по mail"
                               aria-label="Search">
                        <button id="mail" class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
                    </div>
                </div>
                <table class="table table-hover" id="table">
                    <thead class="thead-dark">
                    <tr>
                        <th data-field="id" scope="col">№</th>
                        <th data-field="surname" scope="col">Фамилия</th>
                        <th data-field="name" scope="col">Имя</th>
                        <th data-field="patronymic" scope="col">Отчество</th>
                        <th data-field="phone" scope="col">Телефон</th>
                        <th data-field="mail" scope="col">mail</th>
                        <th data-field="action1" scope="col">Edit</th>
                        <th data-field="action2" scope="col">Delete</th>
                    </tr>
                    </thead>
                    <#list userList as user>
                        <tr>
                            <td>${user_index}</td>
                            <td>${user.surname}</td>
                            <td>${user.name}</td>
                            <td>${user.patronymic}</td>
                            <td>${user.mail}</td>
                            <td>${user.phone}</td>
                            <td>
                                <button class="btn btn-outline-success my-2 my-sm-0" type="button" id="${user_index}"
                                        name="mainEdit" data-toggle="modal"
                                        data-target="#modalCenter">
                                    Edit
                                </button>
                                <div class="modal fade" id="modalCenter" tabindex="-1" role="dialog"
                                     aria-labelledby="modalCenterTitle" aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-centered" role="document"
                                         style="max-width: 1000px">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="modalCenterTitle">Редактирование
                                                    пользователя</h5>
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <form style="border: dimgrey 2px solid; padding: 10px; margin: 5px">
                                                    <div class="form-row">
                                                        <div class="col-md-4 mb-3">
                                                            <label for="validationServer01">Фамилия</label>
                                                            <input id="surnameUpdating" type="text" class="form-control"
                                                                   placeholder="Surname" value="" required>
                                                        </div>
                                                        <div class="col-md-4 mb-3">
                                                            <label for="validationServer02">Имя</label>
                                                            <input id="nameUpdating" type="text" class="form-control"
                                                                   placeholder="Name" value="" required>
                                                        </div>
                                                        <div class="col-md-4 mb-3">
                                                            <label for="validationServer02">Отчество</label>
                                                            <input id="PatronymicUpdating" type="text"
                                                                   class="form-control" placeholder="Patronymic"
                                                                   value="" required>
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="col-4">
                                                            <label for="validationServer03">Телефон</label>
                                                            <input id="phoneUpdating" type="tel" class="form-control"
                                                                   placeholder="Phone" required>
                                                        </div>
                                                        <div class="col-4">
                                                            <label for="validationServer04">Mail</label>
                                                            <input id="mailUpdating" type="email" class="form-control"
                                                                   placeholder="Mail" required>
                                                        </div>
                                                    </div>

                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary"
                                                                data-dismiss="modal">Отменить
                                                        </button>
                                                        <button type="submit" class="btn btn-primary" name="edit">
                                                            Обновить данные
                                                        </button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <button class="btn btn-danger" type="button" id="${user_index}" name="delete">
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
            background: url("https://www.tokkoro.com/picsup/2941209-nyan-cat-simple-simple-background-minimalism-sky___landscape-nature-wallpapers.jpg");
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
            max-width: 300px;
            min-width: 200px;
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

        #search button[type="submit"] {
            cursor: pointer;
            width: 100%;
            border: none;
            background: #4CAF50;
            color: #FFF;
            margin: 0 0 5px;
            padding: 10px;
            font-size: 15px;
        }

        #search button[type="submit"]:hover {
            background: #43A047;
            -webkit-transition: background 0.3s ease-in-out;
            -moz-transition: background 0.3s ease-in-out;
            transition: background-color 0.3s ease-in-out;
        }

        #search button[type="submit"]:active {
            box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.5);
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
        $('#table').bootstrapTable({});
        $(document).ready(function () {
            let users = [];
            for (let el in userList) {
                alert(el);
                users.push({id: el.index, name: el.full_name, phone: el.phone, mail: el.mail})
            }
            $('#table').bootstrapTable("load", users);
        });
        $('#name').on('click', function () {
            alert('clicked');
            let text = document.getElementById("text_name").value;
            let users = [];
            $.post('/search', {param: "name", reqString: text, cutoff_frequency: 0.01}, function (data) {
                alert(data);
                for (let el in data) {
                    data.push({id: el.index, name: el.full_name, phone: el.phone, mail: el.mail})
                }
            });

            $('#table').bootstrapTable("load", users);
        });

        $('#phone').on('click', function () {
            alert('clicked');
            let text = document.getElementById("text_phone").value;
            let users = [];
            $.post('/search', {param: "name", reqString: text, cutoff_frequency: 0.01}, function (data) {

            });
            $('#table').bootstrapTable("load", users);
        });

        $('#mail').on('click', function () {
            alert('clicked');
            let text = document.getElementById("text_mail").value;
            let users = [];
            $.post('/search', {param: "name", reqString: text, cutoff_frequency: 0.01}, function (data) {

            });
            $('#table').bootstrapTable("load", users);
        });
        $('#save').on('click', function () {
            alert('clicked');
            let surname = document.getElementById("surnameAdding").value;
            let name = document.getElementById("nameAdding").value;
            let patronymic = document.getElementById("patronymicAdding").value;
            let phone = document.getElementById("phoneAdding").value;
            let mail = document.getElementById("mailAdding").value;
            let user = surname + ' ' + name + ' ' + patronymic + ';' +
                phone + ';' + mail;

            $.post('/save', {userString: user}, function (data) {
                alert(data)
            });
        });
        $('button[name="mainEdit"]').on('click', function () {
            alert('clicked');
            indexOfUpdatingUser = $(this).attr('id');
        });
        $('button[name="edit"]').on('click', function () {
            alert('clicked');
            alert(indexOfUpdatingUser);
            let surname = document.getElementById("surnameUpdating").value;
            let name = document.getElementById("nameUpdating").value;
            let patronymic = document.getElementById("patronymicUpdating").value;
            let phone = document.getElementById("phoneUpdating").value;
            let mail = document.getElementById("mailUpdating").value;
            let user = surname + ' ' + name + ' ' + patronymic + ';' +
                phone + ';' + mail;
            let userId = $(this).attr('id');
            $.post('/update', {id: userId, userString: user}, function (data) {
                alert(data)
            });
        });
        $('button[name="delete"]').on('click', function () {
            alert('clicked');
            alert($(this).attr('id'));
            let userId = $(this).attr('id');
            $.post('/delete', {id: userId}, function (data) {
                alert(data)
            });
        });
    </script>
</@c.page>