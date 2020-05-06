<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Majorca</title>
    <link rel="stylesheet" href="/static/style.css">
    <link rel="icon" href="/static/image/icon.png">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css"
          href="https://cdn.datatables.net/buttons/1.6.1/css/buttons.bootstrap4.min.css">

     <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">

    <!-- Значки удаления и редактирования -->
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" type="text/css" rel="stylesheet">


    <script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" language="javascript"
            src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" language="javascript"
            src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.min.js"></script>
    <script type="text/javascript" language="javascript"
            src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.flash.min.js"></script>
    <script type="text/javascript" language="javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script type="text/javascript" language="javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
    <script type="text/javascript" language="javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
    <script type="text/javascript" language="javascript"
            src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.html5.min.js"></script>
    <script type="text/javascript" language="javascript"
            src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.print.min.js"></script>

    <script type="text/javascript" src="static/tableHike.js"></script>

    <style>
        table.dataTable thead .sorting {
            background-image: none;
        }

        table.dataTable thead .sorting_asc {
            background-image: none;
        }

        table.dataTable thead .sorting_desc {
            background-image: none;
        }
    </style>
    <!-- end Hike table js-->
</head>
<body>

<#include "parts/navbar.ftlh">

<div class="container mt-5">
    <h1 class="page_title" style="margin-top: 30px; text-align: center;font-weight: 300">Проводимые походы</h1>
    <hr style="width: 35%;margin-bottom: 30px;">
    <table id="example" class="display nowrap table table-hover table-sm" style="width:100%">
        <thead>
        <tr>
            <th scope="col">Название</th>
            <th scope="col">Тип похода</th>
            <th scope="col">Дней</th>
            <th scope="col">Кол-во привалов</th>
            <th scope="col">Дата</th>
            <#--<th th:if="${#request.userPrincipal != null}" scope="col">Удалить</th>-->
        </tr>
        </thead>
        <tbody>
        <#list messages as message>
            <tr class="table-light">
                <th scope="row">${message.tag}</th>
                <td>${message.authorName}</td>
                <td>${message.author.username}</td>
                <td>${message.authorName}</td>
                <td>${message.tag}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>

<hr style="margin-bottom: 10%">
</div>

<#include "parts/footer.ftlh" />


</body>
</html>