<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="person-information-section">
        <div class="private-cabinet-top">

        </div>
        <div class="private-cabinet-bottom">
            <div class="between-top-bottom">
                <div class="ava-foto">
                    <#if user.file??>
                        <a href="/api/file/${user.file.id}">
                            <img src="/api/file/${user.file.id}" class="round-pc">
                        </a>
                    <#else>
                        <img src="/static/image/ava.png" alt="" class="round-pc"
                             style="border: none">
                    </#if>
                </div>
                <div class="edit-profile-btn">
                    <form action="/user/profile" method="get">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button class="btn btn-light" id="mybtn" type="submit">Edit profile</button>
                    </form>
                </div>
            </div>
            <div class="name-person-under-foto">
                <h3 class="name-person"><b>${user.username}</b></h3>
                <p class="count-messages">${countMessages} Messages</p>
            </div>
            <div class="followers">
                <div class="follower-block">
                    <a class="follower" href="/user/subscribers/${user.id}/list"><b>${followers}</b> Followers</a>
                </div>
                <div class="follower-block">
                    <a class="follower" href="/user/subscriptions/${user.id}/list"><b>${following}</b> Following</a>
                </div>
            </div>
        </div>
    </div>

</@c.page>