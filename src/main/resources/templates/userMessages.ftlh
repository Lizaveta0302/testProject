<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <#if !isCurrentUser>
        <#if isSubscriber>
            <a href="/user/unsubscribe/${userChannel.id}" class="btn btn-info">Unsubscribe</a>
        <#else>
            <a href="/user/subscribe/${userChannel.id}" class="btn btn-info">Subscribe</a>
        </#if>
    </#if>
    <#if isCurrentUser>

    </#if>
    <h3 style="text-align: center; font-weight: 400">${userChannel.username}</h3>
    <div class="container my-3">
        <div class="row">
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Subscriptions</div>
                        <h3 class="card-text">
                            <a href="/user/subscriptions/${userChannel.id}/list">${subscriptionsCount}</a>
                        </h3>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Subscribers</div>
                        <h3 class="card-text">
                            <a href="/user/subscribers/${userChannel.id}/list">${subscribersCount}</a>
                        </h3>
                    </div>
                </div>
            </div>
        </div>
        <#if isAdmin && userChannel.isAdmin()>
            <div class="row">
                <div class="col" style="margin-left: 5px">

                    <!-- Кнопка пуска модальное окно -->
                    <button type="button" class="btn btn-light" data-toggle="modal" data-target="#myModal">
                        Добавить руководителя
                    </button>

                    <!-- Модальное окно -->
                    <div style="margin-bottom: 150px;" class="modal fade" id="myModal" tabindex="-1" role="dialog"
                         aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form action="/addSupervisor" method="post">
                                        <fieldset>
                                            <legend>Добавление руководителя</legend>
                                            <div class="form-group">
                                                <label for="name_supervisor">Имя</label>
                                                <input type="text" class="form-control" name="name"
                                                       id="name" aria-describedby="emailHelp"
                                                       placeholder="Введите имя">
                                            </div>
                                            <div class="form-group">
                                                <label for="last_name">Фамилия</label>
                                                <input type="text" class="form-control" name="last_name" id="last_name"
                                                       placeholder="Введите фамилию">
                                            </div>
                                            <div class="form-group">
                                                <label for="patronymic">Отчество</label>
                                                <input type="text" class="form-control" name="patronymic"
                                                       id="patronymic" placeholder="Введите отчество">
                                            </div>
                                            <div class="form-group">
                                                <label for="salary">Телефон</label>
                                                <input type="text" class="form-control" name="phone" id="phone"
                                                       placeholder="Введите телефон">
                                            </div>
                                            <div class="form-group">
                                                <label for="salary">Город</label>
                                                <input type="text" class="form-control" name="city" id="city"
                                                       placeholder="Введите город">
                                            </div>


                                            <div class="form-group">
                                                <input type="text" name="username"
                                                       class="form-control"
                                                       placeholder="User name">
                                            </div>
                                            <div class="form-group">
                                                <input type="password" name="password"
                                                       class="form-control"
                                                       placeholder="Password">
                                            </div>


                                            <input type="hidden" value="${_csrf.token}" name="_csrf">
                                            <button type="submit" class="btn btn-primary">Добавить</button>
                                        </fieldset>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col" style="margin-left: 5px">
                    <!-- Кнопка пуска модальное окно -->
                    <button type="button" class="btn btn-light" data-toggle="modal" data-target="#myModal1">
                        Добавить поход
                    </button>

                    <!-- Модальное окно -->
                    <div style="margin-bottom: 150px;" class="modal fade" id="myModal1" tabindex="-1" role="dialog"
                         aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form action="/addHike" method="post">
                                        <fieldset>
                                            <legend>Добавление поход</legend>
                                            <div class="form-group">
                                                <label for="name">Название</label>
                                                <input type="text" class="form-control" name="name"
                                                       id="name" aria-describedby="emailHelp"
                                                       placeholder="Введите название">
                                            </div>
                                            <div class="form-group">
                                                <label for="type_hike">Тип похода</label>
                                                <input type="text" class="form-control" name="type_hike" id="type_hike"
                                                       placeholder="Введите тип похода">
                                            </div>
                                            <div class="form-group">
                                                <label for="seats">Количество мест</label>
                                                <input type="number" class="form-control" name="seats"
                                                       id="seats" placeholder="Введите количество мест">
                                            </div>
                                            <div class="form-group">
                                                <label for="price">Цена</label>
                                                <input type="number" class="form-control" name="price" id="price"
                                                       placeholder="Введите Цену">
                                            </div>
                                            <div class="form-group">
                                                <label for="description">Описание</label>
                                                <input type="text" class="form-control" name="description"
                                                       id="description"
                                                       placeholder="Введите описание">
                                            </div>
                                            <input type="hidden" value="${_csrf.token}" name="_csrf">
                                            <button type="submit" class="btn btn-primary">Добавить</button>
                                        </fieldset>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </#if>
    </div>
    <#if isCurrentUser>
        <#include "parts/messageEdit.ftlh" />
    </#if>
    <#include "parts/messageList.ftlh" />
</@c.page>