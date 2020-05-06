<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Majorca</title>
        <link rel="stylesheet" href="/static/style.css">
        <link rel="icon" href="/static/image/icon.png">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+Sharp"
              rel="stylesheet">

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- ускоренное отображение -->
        <#--<script src="https://cdnjs.cloudflare.com/ajax/libs/turbolinks/5.2.0/turbolinks.js"></script>-->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <#--<script src="https://www.google.com/recaptcha/api.js"></script>-->
        <#--<style>
            .turbolinks-progress-bar{
                height: 2px;
                background-color: navy;
            }
        </style>-->
    </head>

    <body>

    <#include "navbar.ftlh">
    <#if home??>
        <div class="container-fluid mx-0" style="padding: 0"><#nested ></div>
    <#else>
        <div class="container mt-5">
            <#nested>
        </div>
    </#if>

    <#include "footer.ftlh" />


    </body>
    </html>
</#macro>