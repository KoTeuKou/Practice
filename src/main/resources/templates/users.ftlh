<#import "parts/common.ftlh" as c>

<@c.page>
    <body>
    <div class="container">
        <div id="search" action="main.ftlh" method="post">
            <h3>Ну шо, elasticsearch?</h3>
            <div class="form">
                <div class="row">
                    <div class="btn-group col-sm">
                        <input name="name" class="form-control mr-sm-2" type="text" placeholder="Поиск по имени" aria-label="Search">
                        <button  class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
                    </div>
                    <div class="btn-group col-sm">
                        <input name="email" class="form-control mr-sm-2" type="tel" placeholder="Поиск по телефону" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
                    </div>
                    <div class="btn-group col-sm">
                        <input name="phone" class="form-control mr-sm-2" type="email" placeholder="Поиск по mail" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
                    </div>
                </div>
                <table class="table table-hover">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">№</th>
                        <th scope="col">ФИО</th>
                        <th scope="col">Телефон</th>
                        <th scope="col">mail</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list users as user>
                        <tr>
                            <td>${user_index}</td>
                            <td>${user.full_name}</td>
                            <td>${user.phone}</td>
                            <td>${user.mail}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
            </form>
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
</@c.page>