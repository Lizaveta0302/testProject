<#import "parts/common.ftlh" as c>

<@c.page>
    <div style="text-align: center">
        <h3>${userChannel.username}</h3>
        <br>
        <h5 style="font-weight: 400">${type}</h5>
        <br>
        <ul class="list-group" style="width: 400px;margin: auto">
            <#list users as user>
                <li class="list-group-item">
                    <a style="color:#000;" href="/user-messages/${user.id}">${user.getUsername()}</a>
                </li>
            </#list>
        </ul>
    </div>
</@c.page>