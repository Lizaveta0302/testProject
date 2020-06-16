<#import "parts/common.ftlh" as c>

<@c.page>
    <div style="text-align: center">
        <h3>${userChannel.username}</h3>
        <br>
        <h5 style="font-weight: 400">Забронированные походы:</h5>
        <br>
        <ul class="list-group" style="width: 400px;margin: auto">
            <#list reservations as reserve>
                <li class="list-group-item">
                    <a style="color:#000;" href="/hikes">${reserve.name}</a>
                    <a href="/hike/cancelReservation/${reserve.hike_id}">
                        <button class="btn btn-light">Отменить бронь</button>
                    </a>
                </li>
            </#list>
        </ul>
    </div>
</@c.page>