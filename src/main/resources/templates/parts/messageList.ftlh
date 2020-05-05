<#include "security.ftlh">

<div class="card-in-line my-3">
    <div class="row">
        <#list messages as message>
            <div class="col-md-4">
                <div class="card myShadow" style="box-shadow: 0 6px 10px 0 #612127;">
                    <#if isAdmin>
                        <div class="clear-message-div" style="text-align: right">
                            <a class="clear-message" href="/user-messages/clear/${message.id}">
                                <i class="material-icons">clear</i>
                            </a>
                        </div>
                    </#if>
                    <div class="card-image">
                        <div class="view overlay">
                            <#if message.file??>
                            <#--<a href="/api/file/${message.file.id}"><b>${message.file.name}</b></a>-->
                            <#-- <a href="/api/file/${message.file.id}">-->
                                <img src="/api/file/${message.file.id}" alt="" class="card-img-top">
                            <#--</a>-->
                            <#else>
                                <img src="/static/image/No_image.png" alt="" class="card-img-top">
                            </#if>
                        </div>
                    </div>
                    <div class="card-body">
                        <a href="/messages/${message.id}/like" class="activator waves-effect waves-light mr-4">
                            <#if message.meLiked>
                            <i class="material-icons">thumb_up_alt</i><span
                                    style="vertical-align: text-bottom"> ${message.likes}</span></a>
                        <#else>
                            <i class="material-icons-outlined">thumb_up_alt</i><span
                                style="vertical-align: text-bottom"> ${message.likes}</span></a>
                        </#if>
                        <!-- Title -->
                        <h6 style="font-weight: 400; max-width: 200px;" class="card-title">#${message.tag}</h6>
                        <hr>
                        <!-- Text -->
                        <p class="card-text" style="overflow: auto;height: 100px;">${message.text}</p>
                        <!-- Link -->

                        <a href="/review/${message.id}" class="black-text d-flex justify-content-end">
                            <h6 style="font-weight: 400;">Read more
                                <i class="material-icons" style="vertical-align: middle">keyboard_arrow_right</i></h6>
                        </a>
                    </div>
                    <#--<div class="card-body"
                         id="card-message-body">
                        <div style="text-align: left">
                            <span>${message.text}</span> <br>
                            <p style="margin-bottom: 0">#${message.tag}</p>
                        </div>
                    </div>-->
                    <div class="card-footer text-muted container" style="overflow: auto">
                        <a href="/user/private-cabinet" style="text-decoration: none;">
                            <#if message.author.file??>
                                <img src="/api/file/${message.author.file.id}" class="round">
                            <#else>
                                <img src="/static/image/ava.png" class="round">
                            </#if>
                        </a>
                        <a href="/user-messages/${message.author.id}"
                           class="author-name-a"
                           style="margin: 5px;font-size: 14px;padding-top: 5px">${message.authorName}</a>
                        <#if message.author.id == currentUserId>
                            <a href="/user-messages/${message.author.id}?message=${message.id}"
                               class="btn btn-light" id="edit-btn" style="font-size: 14px">Edit</a>
                        </#if>
                    </div>
                </div>
            </div>
        <#else>
            No message
        </#list>
    </div>
</div>
