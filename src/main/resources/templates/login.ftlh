<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <#if message??>
        <i>${message}</i>
    <#else>
    </#if>
    <@l.login "/login" false/>
</@c.page>