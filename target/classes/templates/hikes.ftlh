<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Majorca</title>
    <link rel="stylesheet" href="/static/style.css">
    <link rel="icon" href="/static/image/icon.png">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+Sharp"
          rel="stylesheet">

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
<#include "parts/security.ftlh">

<div class="container mt-5">
    <h1 class="page_title" style="margin-top: 30px; text-align: center;font-weight: 300">Проводимые походы</h1>
    <hr style="width: 35%;margin-bottom: 30px;">
    <table id="example" class="display nowrap table table-hover table-sm" style="width:100%">
        <thead>
        <tr>
            <th scope="col">Название</th>
            <th scope="col">Тип похода</th>
            <th scope="col">Описание</th>
            <th scope="col">Мест</th>
            <th scope="col">Цена</th>
            <!--th scope="col">Подробнее</th-->
            <#if isAdmin>
                <th scope="col">Удалить</th>
                <th scope="col">Забронировать</th>
            <#elseif user??>
                <th scope="col">Забронировать</th>
            </#if>
            <#--<th th:if="${#request.userPrincipal != null}" scope="col">Удалить</th>-->
        </tr>
        </thead>
        <tbody>
        <#list hikes as hike>
            <tr class="table-light">
                <th scope="row">${hike.name}</th>
                <td>${hike.typeHike.types}</td>
                <td>${hike.description}</td>
                <td>${hike.seats}</td>
                <td>${hike.price}</td>
                <!--td><a href="http://rtss.by/images/reports/2019shipunov.pdf">Подробнее</a></td-->
                <#if isAdmin>
                    <td style="text-align: center"><a href="/hike/clear/${hike.hike_id}"><i
                                    class="fa  fa-fw fa-trash"
                                    style="font-size:20px;color: black"></i></a>
                    </td>
                    <td style="text-align: center">
                        <a href="/hike/reservation/${hike.hike_id}">
                            <button class="btn btn-light">Бронь</button>
                        </a>
                    </td>
                <#elseif user??>
                    <td style="text-align: center">
                        <#-- <#list reserves as r>
                             <#if r.hike_id??>
                                 <a href="/hike/cancelReservation/${hike.hike_id}">
                                     <button class="btn btn-light">Отмена</button>
                                 </a>
                             <#else>-->
                        <a href="/hike/reservation/${hike.hike_id}">
                            <button class="btn btn-light">Бронь</button>
                        </a>
                    </td>
                </#if>
            </tr>
        </#list>
        </tbody>
    </table>
</div>

<hr>
<br>
<div class="team">
    <div class="container">
        <h1 class="text-center" style="font-weight: 400">Наши походы</h1>
        <div class="row">
            <#list hikes as hk>
                <div class="col-lg-3 col-md-3 col-sm-12 item">
                    <img align="center" src="" alt="Hike!" class="img-fluid">
                    <div class="des">
                        <p>${hk.typeHike.types}</p>
                    </div>
                    <span class="text-muted">${hk.description} ${hk.price} руб.</span>
                </div>
            </#list>
        </div>
    </div>
</div>
<hr style="margin-bottom: 10%">
</div>

<#include "parts/footer.ftlh" />

<script>
    var imgs = document.getElementsByClassName('img-fluid');

    for (var i = 0; i < imgs.length; i++) {
        var num = Math.floor(Math.random() * 10 + 1);
        imgs[i].src = '/static/image/hike' + num + '.jpg';
        imgs[i].alt = imgs[i].src;
    }
</script>
</body>
</html>