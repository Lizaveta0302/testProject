<#include "security.ftlh">

<div class="card-columns">
    <#list messages as message>
        <div class="card my-3" style="width: 13rem">
            <div class="m-2" style="height: 13rem; text-align: center">
                <#if message.file??>
                <#--<a href="/api/file/${message.file.id}"><b>${message.file.name}</b></a>-->
                    <a href="/api/file/${message.file.id}">
                        <img src="/api/file/${message.file.id}" alt="" class="card-img-top"
                             style="max-height: 12rem; max-width: 12rem">
                    </a>
                </#if>
            </div>
            <div class="card-body" style="height: 5rem">
                <div class="m-2">
                    <span class="card-text">${message.text}</span> <br>
                    <i class="card-subtitle">#${message.tag}</i>
                </div>
            </div>
            <div class="card-footer text-muted" style="height: 4rem">
                <a href="/user-messages/${message.author.id}">${message.authorName}</a>
                <#if message.author.id == currentUserId>
                    <a href="/user-messages/${message.author.id}?message=${message.id}" class="btn btn-light">Edit</a>
                </#if>
            </div>
        </div>
    <#else>
        No message
    </#list>
</div>