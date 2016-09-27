<#macro formInput entity title="" id=""  errorKey="" needValide=false value="">
<div class="sub-title">${title}</div>
<div>
    <input type="text" class="form-control" name="${id}" id="${id}" value="${value}">
    <#if needValide>
        <#if entity?? >
            <@spring.bind "${errorKey}" />
            <span style="color: red;"> <@spring.showErrors "<br>"/></span>
        </#if>
    </#if>
</div>
</#macro>