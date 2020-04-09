<#include "security.ftlh">

<div class="card-columns">
    <#list messages as message>
        <div class="card my-3" style="width: 18rem;">
            <div class="m-2">
                <#if message.file??>
                <#--<a href="/api/file/${message.file.id}"><b>${message.file.name}</b></a>-->
                    <a href="/api/file/${message.file.id}"><img src="/api/file/${message.file.id}" class="card-img-top"></a>
                </#if>
            </div>
            <div class="m-2">
                <span>${message.text}</span> <br>
                <i>#${message.tag}</i>
            </div>
            <div class="card-footer text-muted">
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