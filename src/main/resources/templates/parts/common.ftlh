<#macro page>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ElasticSearch</title>
    <link rel="stylesheet" href="/static/style.css">
    <link rel="shortcut icon" href="https://pbs.twimg.com/media/EIJka-yWwAAJj3J.jpg" type="image/jpg">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<#include "navbar.ftlh">
<div class="container mt-5" >
<#nested>
</div>
</body>

</html>
</#macro>