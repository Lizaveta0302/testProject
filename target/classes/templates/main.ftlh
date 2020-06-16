<#import "parts/common.ftlh" as c>
<#import "parts/old_login.ftlh" as l>

<@c.page>
    <div class="jumbotron">
        <p class="lead">Здесь каждый найдет занятие по душе. Познавательные походы, тренировки, только лучшие,
            высококвалифицированные руководители!</p>
        <hr class="my-4">
        <p>Присоединяйся и стань частью нашей большой и дружной команды!</p>
        <p class="lead">
            <a class="btn btn-info" href="/info" role="button">Узнать больше</a>
        </p>
    </div>
    <br>
    <hr style="margin-bottom: 3%">
    <div class="form-row">
        <div class="form-group col-md-6" style="margin-left: 30px;">
            <form method="get" action="/main" class="form-inline">
                <input type="text" class="form-control" name="filter" value="${filter?ifExists}"
                       placeholder="Поиск по тегу"/>
                <button type="submit" class="btn btn-light ml-2">Найти
                    <span class="material-icons" style="vertical-align: text-top">search</span></button>
            </form>
        </div>
    </div>
    <div style="font-size: 44px;text-align:center;margin-bottom:-20px;color: #2c2c2c">
        <h2 style="font-weight: 300;">Отзывы пользователей</h2>
    </div>

    <#include "parts/messageList.ftlh">

</@c.page>
