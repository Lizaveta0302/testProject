<#include "security.ftlh">

<div class="card-in-line my-3">
    <div class="row">
        <#list messages as message>
            <div class="col-md-3" style="margin-bottom: 50px">
                <div class="card myShadow" style="box-shadow: 0 6px 10px 0 #612127; height: 380px">
                    <div class="card-image" style="margin: auto">
                        <#if message.file??>
                        <#--<a href="/api/file/${message.file.id}"><b>${message.file.name}</b></a>-->
                            <a href="/api/file/${message.file.id}">
                                <img src="/api/file/${message.file.id}" alt="" class="rounded">
                            </a>
                        <#else>
                            <img src="/static/image/No_image.png" alt="" class="rounded">
                        </#if>
                    </div>
                    <div class="card-body"
                         style=" display: flex; align-items: flex-end;
                         padding: 15px; padding-left: 30px">
                        <div style="text-align: left">
                            <span>${message.text}</span> <br>
                            <p style="margin-bottom: 0">#${message.tag}</p>
                        </div>
                    </div>
                    <div class="card-footer text-muted" style="height: 4rem">

                        <a href="/user/private-cabinet" style="text-decoration: none">
                            <#if message.author.file??>
                                <img src="/api/file/${message.author.file.id}" class="round">
                            <#else>
                                <img src="/static/image/ava.png" class="round">
                            </#if>
                        </a>

                        <a href="/user-messages/${message.author.id}" class="author-name-a">${message.authorName}</a>
                        <#if message.author.id == currentUserId>
                            <a href="/user-messages/${message.author.id}?message=${message.id}"
                               class="btn btn-light" id="edit-btn">Edit</a>
                        </#if>
                    </div>
                </div>
            </div>
        <#else>
            No message
        </#list>
    </div>
</div>