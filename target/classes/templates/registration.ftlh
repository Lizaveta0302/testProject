<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div class="mb-1">Add new user</div>
<#if message??>
    <i>${message}</i>
<#else>

</#if>
    <@l.login "/registration" true />
</@c.page>