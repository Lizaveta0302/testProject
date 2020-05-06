<#import "parts/common.ftlh" as c>

<@c.page>
    Редактирование пользователя
    <form action="/user" method="post">
        <input class="form-control" style="width: 200px;margin-bottom: 15px;margin-top: 10px" type="text" name="username" value="${user.username}">
        <#list roles as role>
            <div>
                <label>
                    <input type="checkbox" name="${role}"
                            ${user.roles?seq_contains(role)?string("checked","")}>${role}
                </label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button class="btn btn-light" type="submit">Сохранить</button>
    </form>
</@c.page>
