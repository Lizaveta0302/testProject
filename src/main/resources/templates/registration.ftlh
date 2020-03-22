<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    Add new user
    <br>
<#if message??>
    <i>${message}</i>
<#else>

</#if>
    <@l.login "/registration" />
</@c.page>