<#import "parts/common.ftlh" as c>
<#import "parts/new_login.ftlh" as l>

<@c.page>
<#if message??>
    <i>${message}</i>
<#else>

</#if>
    <@l.login "/registration" true />
</@c.page>