<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6" style="margin-left: 30px;">
            <form method="get" action="/main" class="form-inline">
                <input type="text" class="form-control" name="filter" value="${filter?ifExists}"
                       placeholder="Поиск по тегу"/>
                <button type="submit" class="btn btn-light ml-2">Найти</button>
            </form>
        </div>
    </div>
    <div style="font-size: 44px;text-align:center;margin-bottom:-20px;color: #2c2c2c">
        <h2 style="font-weight: 300;">Отзывы пользователей</h2>
    </div>
<#--<#include "parts/messageEdit.ftlh" />-->
    <#include "parts/messageList.ftlh" />

</@c.page>
