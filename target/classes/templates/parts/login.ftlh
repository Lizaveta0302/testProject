<#include "security.ftlh">
<#macro login path isRegisterForm>
    <div class="row">
        <div class="col-lg-4 col-md-6 col-sm-8 ml-auto mr-auto mb-5">
            <form class="form" action="${path}" method="post"  <#if isRegisterForm>enctype="multipart/form-data"</#if>>
                <div class="card card-login card-hidden">
                    <div class="card-header card-header-primary text-center">
                        <h4 class="card-title"><#if isRegisterForm>Регистрация<#else>Вход</#if></h4>
                    </div>
                    <div class="card-body">
                        <p class="card-description text-center" style="color: #999;">Заполните форму</p>
                        <span class="bmd-form-group">
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="material-icons">face</i>
                      </span>
                    </div>
                    <input type="text" name="username"
                           class="form-control ${(usernameError??)?string('is-invalid', '')}"
                           value="<#if user??>${user.username}</#if>"
                           placeholder="User name">
                       <#if usernameError??>
                           <div class="invalid-feedback">
                                ${usernameError}
                           </div>
                       </#if>
                  </div>
                </span>

                        <span class="bmd-form-group">
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="material-icons">lock_outline</i>
                      </span>
                    </div>
                    <input type="password" name="password"
                           class="form-control ${(passwordError??)?string('is-invalid', '')}"
                           value="<#if user??>${user.password}</#if>"
                           placeholder="Password">
                       <#if passwordError??>
                           <div class="invalid-feedback">
                                ${passwordError}
                           </div>
                       </#if>
                  </div>
                </span>
                        <#if isRegisterForm>
                            <span class="bmd-form-group">
                              <div class="input-group">
                                <div class="input-group-prepend">
                                  <span class="input-group-text">
                                    <i class="material-icons">lock_outline</i>
                                  </span>
                                </div>
                                <input type="password" name="password2"
                                       class="form-control ${(password2Error??)?string('is-invalid', '')}"
                                       value="<#if user??>${user.password}</#if>"
                                       placeholder="Retype password">
                                   <#if password2Error??>
                                       <div class="invalid-feedback">
                                            ${password2Error}
                                       </div>
                                   </#if>
                              </div>
                        </span>
                            <div class="form-group" style="margin-top: 25px">
                                <div class="custom-file">
                                    <label class="custom-file-label" for="uploadfile">Фотография</label>
                                    <input type="file" class="custom-file-input" name="uploadfile" id="uploadfile"
                                           placeholder="Upload image">
                                </div>
                            </div>
                        </#if>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <div class="add-new-ref mb-1">
                        <#if !isRegisterForm><a href="/registration">
                            <span class="material-icons" style="vertical-align: text-bottom; margin-right: 5px">person_add</span>
                            Добавить нового пользователя
                        </a></#if>
                    </div>
                    <div class="card-footer justify-content-center">
                        <button type="submit"
                                class="btn btn-rose btn-link btn-lg"><#if isRegisterForm>Создать<#else>Войти</#if></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-light" type="submit"><#if user??>Выйти<#else>Войти</#if></button>
    </form>
</#macro>