<#import "parts/common.ftlh" as c>

<@c.page>

    <div class="review-title">
        <h4 style="text-align: center; font-weight: 300">Отзыв пользователя
            <a href="/user-messages/${message.author.id}">${message.authorName}</a>
        </h4>
    </div>
    <div class="container my-3 mx-3">
        <div class="row my-3">
            <div style="margin: auto; width: 400px;">
                <#if message.file??>
                    <img src="/api/file/${message.file.id}" alt="">
                <#else>
                    <img src="/static/image/No_image.png" alt="">
                </#if>
            </div>
        </div>
        <div class="row row-cols-2 my-4 mb-5 ml-5">
            <div class="col">
                <div>
                    <span style="font-weight: 500">#${message.tag}</span>
                    <p>${message.text}</p>
                </div>
            </div>
            <div class="col">
                <div class="review-col-right">
                    <h6>Отзывы этого пользователя:</h6>
                    <a href="/user-messages/${message.author.id}"
                       class="author-name-a">${message.authorName}</a>

                    <h6>Похожие отзывы по тегу #${message.tag}:</h6>
                    <ul>
                        <#list messageList as mes>
                            <li>
                                <a href="/review/${mes.id}">Отзыв от ${mes.authorName}
                                    <span>  ${mes.likes}
                                        <i class="material-icons-outlined" style="vertical-align: text-bottom">thumb_up_alt</i>
                                    </span>
                                </a>
                            </li>
                        </#list>
                    </ul>
                </div>
            </div>
        </div>

    </div>

</@c.page>