<#include "security.ftlh">
<#import "new_login.ftlh" as l>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Majorca</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/hikes">Походы <span class="sr-only">(current)</span></a>
            </li>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/main">Отзывы<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user-messages/${currentUserId}">Мои отзывы<span
                                class="sr-only">(current)</span></a>
                </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">Список пользователей<span class="sr-only">(current)</span></a>
                </li>
            </#if>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/user/profile">Профиль<span class="sr-only">(current)</span></a>
                </li>
            </#if>
        </ul>
        <div class="navbar-text mr-3">
            ${name}
        </div>
        <#if user??>
            <div>
                <div class="navbar-text mr-3 avatar">
                    <#if user.file??>
                        <a href="/user/private-cabinet"> <img src="/api/file/${user.file.id}" alt="Личный кабинет"
                                                              class="round"></a>
                    <#else>
                        <a href="/user/private-cabinet"> <img src="/static/image/ava.png" alt="Личный кабинет"
                                                              class="round"></a>
                    </#if>
                </div>
            </div>
        </#if>
        <@l.logout/>
    </div>
</nav>