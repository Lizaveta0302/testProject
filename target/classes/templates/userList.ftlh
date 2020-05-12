<#import "parts/common.ftlh" as c>

<@c.page>
    <h4 style="font-weight: 300;padding-bottom: 30px"> Список пользователей </h4>
    <div style="margin-bottom: 90px; width: 450px;">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">Имя</th>
                <th scope="col">Инструктор</th>
                <th scope="col">Роль</th>
                <th scope="col">Изменить</th>
                <th scope="col">Удалить</th>
            </tr>
            </thead>
            <tbody>
            <#list  users as user>
                <tr class="table-light">
                    <td>${user.username} <#if user.supervisor??>(${user.supervisor.last_name} ${user.supervisor.name})</#if></td>
                    <td><#if user.supervisor??><i class="material-icons-outlined"
                                                  style="margin-top: 2px">done</i><#else><i
                                class="material-icons-outlined"
                                style="margin-top: 2px">indeterminate_check_box</i> </#if></td>
                    <td><#list user.roles as role>${role}<#sep>, </#list></td>
                    <td><a style="color: black" href="/user/${user.id}"><i class="material-icons-outlined"
                                                                           style="margin-top: 2px">create</i></a></td>
                    <td><a style="color: black" href="/user/delete/${user.id}"><i class="material-icons-outlined"
                                                                                  style="margin-top: 2px">delete</i></a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>
