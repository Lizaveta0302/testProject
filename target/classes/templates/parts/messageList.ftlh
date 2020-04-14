<#include "security.ftlh">

<div class="card-in-line my-3">
    <div class="row">
        <#list messages as message>
            <div class="col-md-3" style="margin-bottom: 50px">
                <div class="card" style="box-shadow: 0 6px 10px 0 #612127; height: 380px">
                    <div class="card-image" style="margin: auto">
                        <#if message.file??>
                        <#--<a href="/api/file/${message.file.id}"><b>${message.file.name}</b></a>-->
                            <a href="/api/file/${message.file.id}">
                                <img src="/api/file/${message.file.id}" alt="" class="rounded">
                            </a>
                        </#if>
                        <#if !message.file??>
                            <img src="/static/image/No_image.png" alt="" class="rounded">
                        </#if>
                    </div>
                    <div class="card-body" style=" display: flex; align-items: flex-end;">
                        <div style="text-align: left">
                            <span>${message.text}</span> <br>
                            <p class="description">#${message.tag}</p>
                        </div>
                    </div>
                    <div class="card-footer text-muted" style="height: 4rem">
                        <a href="/user-messages/${message.author.id}">${message.authorName}</a>
                        <#if message.author.id == currentUserId>
                            <a href="/user-messages/${message.author.id}?message=${message.id}"
                               class="btn btn-light">Edit</a>
                        </#if>
                    </div>
                </div>
            </div>
        <#else>
            No message
        </#list>
    </div>
</div>