<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>

    <div class="review-title">
        <h4 style="text-align: center; font-weight: 300">Инструкторы походов</h4>
    </div>
    <div class="container my-3 mx-lg-5">
        <ul class="spr-list">
            <#list users as user>
                <#if user.supervisor?? && user.file??>
                    <li class="d-flex flex-row ml-5 spr-li">
                        <div class="p-2 spr-ava">
                            <a href="/api/file/${user.file.id}">
                                <img src="/api/file/${user.file.id}" class="round-pc"
                                     style="border-radius: 2px;width: 120px; height: 120px">
                            </a>
                        </div>
                        <div class="p-2 align-self-center spr-body">
                            <a <#if user??>href="/user-messages/${user.id}" <#else> href="#"</#if> style="color: black">
                                <b style="font-weight: 500">
                                    ${user.supervisor.last_name} ${user.supervisor.name}
                                    <br>
                                </b>
                            </a>
                            ${user.supervisor.city}<br>
                            <i>${user.supervisor.phone}</i><br>
                           <#-- <#list hikesCount as hc>-->
                                <span>
                                Запланировано походов: <#--${hc}-->
                            </span>
                           <#-- </#list>-->
                        </div>
                    </li>
                <#elseif user.supervisor??>
                    <li class="d-flex flex-row ml-5 spr-li">
                        <div class="p-2 spr-ava">
                            <a href="#">
                                <img src="/static/image/ava.png" alt="" class="round-pc"
                                     style="border: none;border-radius: 2px;width: 120px; height: 120px">
                            </a>
                        </div>
                        <div class="p-2 align-self-center spr-body">
                            <a href="/user-messages/${user.id}" style="color: black">
                                <b style="font-weight: 500">${user.supervisor.last_name} ${user.supervisor.name}<br></b></a>
                            ${user.supervisor.city}<br>
                            <i>${user.supervisor.phone}</i><br>
                        </div>
                    </li>
                </#if>
            </#list>
        </ul>
    </div>

</@c.page>