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
                    <!--form action="/user/profile" method="get">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button class="btn btn-light" id="mybtn" type="submit">Edit profile</button>
                    </form-->
                    <!-- Кнопка пуска модальное окно -->
                    <button type="button" class="btn btn-light" id="mybtn" data-toggle="modal" data-target="#editModal"
                            style="margin-bottom: 4%;">
                        Редактировать профиль
                    </button>
                </div>
                <!-- Модальное окно -->
                <div style="margin-bottom: 150px;" class="modal fade" id="editModal" tabindex="-1" role="dialog"
                     aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form method="post" action="/user/profile" enctype="multipart/form-data">
                                    <fieldset>
                                        <legend style="margin-bottom: 25px;text-align: center">Редактирование</legend>
                                        <div class="form-group row justify-content-center">
                                            <label class="col-sm-2 col-form-label">Пароль:</label>
                                            <div class="col-sm-6">
                                                <input type="password" name="password" class="form-control"
                                                       placeholder="Пароль"/>
                                            </div>
                                        </div>
                                        <div class="form-group row  justify-content-center">
                                            <div class="col-sm-8">
                                                <div class="custom-file">
                                                    <label class="custom-file-label" for="uploadfile">Фотография</label>
                                                    <input type="file" class="custom-file-input" name="uploadfile"
                                                           id="uploadfile"
                                                           placeholder="Upload image">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group row justify-content-center">
                                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                            <button class="btn btn-light" style="margin: auto" type="submit">Сохранить
                                            </button>
                                        </div>
                                    </fieldset>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                            </div>
                        </div>
                    </div>
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