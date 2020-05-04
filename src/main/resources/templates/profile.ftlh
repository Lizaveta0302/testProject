<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="content">
        <h3 style="text-align: center; padding-bottom: 20px">${username}</h3>
        ${message?ifExists}
        <form method="post" enctype="multipart/form-data">

            <#--<div class="form-group row">
                <label class="col-sm-2 col-form-label">User Name :</label>
                <div class="col-sm-6">
                    <input type="text" name="username" class="form-control" placeholder="User name"/>
                </div>
            </div>-->
            <div class="form-group row justify-content-center">
                <label class="col-sm-2 col-form-label">Password:</label>
                <div class="col-sm-4">
                    <input type="password" name="password" class="form-control" placeholder="Password"/>
                </div>
            </div>
            <div class="form-group row  justify-content-center">
                <div class="col-sm-6">
                    <div class="custom-file">
                        <label class="custom-file-label" for="uploadfile">Choose image</label>
                        <input type="file" class="custom-file-input" name="uploadfile" id="uploadfile"
                               placeholder="Upload image">
                    </div>
                </div>
            </div>
            <#--<div class="form-group row">
                <label class="col-sm-2 col-form-label">Email:</label>
                <div class="col-sm-6">
                    <input type="email" name="email" class="form-control" placeholder="${email!''}"/>
                </div>
            </div>-->
            <div class="form-group row justify-content-center">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button class="btn btn-light" style="margin: auto" type="submit">Save</button>
            </div>
        </form>
    </div>
</@c.page>