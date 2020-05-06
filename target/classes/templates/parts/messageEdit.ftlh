<a style="margin-left: 30px" class="btn btn-light" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
   aria-controls="collapseExample">
   Добавить отзыв
    <i class="material-icons-outlined" style="vertical-align: middle">create</i>
</a>
<div class="collapse <#if message??>show</#if>" id="collapseExample" style="margin-left: 30px">
    <div class="form-group mt-3">
        <form method="post" action="/main" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                       value="<#if message??>${message.text}</#if>" name="text" placeholder="Введите сообщение"/>
                <#if textError??>
                    <div class="invalid-feedback">
                        ${textError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control ${(tagError??)?string('is-invalid', '')}"
                       value="<#if message??>${message.tag}</#if>" name="tag" placeholder="Тэг">
                <#if tagError??>
                    <div class="invalid-feedback">
                        ${tagError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <label class="custom-file-label" for="uploadfile">Фотография</label>
                    <input type="file" class="custom-file-input" name="uploadfile" id="uploadfile"
                           placeholder="Upload image">
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="hidden" name="id" value="<#if message??>${message.id}</#if>"/>
            <div class="form-group">
                <button type="submit" class="btn btn-light">Сохранить отзыв</button>
            </div>
        </form>
    </div>
</div>