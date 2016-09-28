<#macro message>
    <#if t_error_message??>
    <p class="alert alert-danger alert-dismissable">
    ${t_error_message}
    </p>
    </#if>

    <#if t_success_massage??>
    <p class="alert alert-success alert-dismissable">
    ${t_success_massage}
    </p>
    </#if>
</#macro>