<#macro formSelector entity data title="" id=""  errorKey="" needValide=false value="" formKey="" formText=""
formHeadKey="" formHeadValue="">

<#import "../select.ftl" as item>
<div class="sub-title">${title}</div>
<div>
    <@item.select value="${value}" id="${id}" datas=data key="${formKey}"
    text="${formText}" headKey="${formHeadKey}" headValue="${formHeadValue}"/>
    <#if needValide>
        <#if entity?? >
            <@spring.bind "${errorKey}" />
            <span style="color: red;"> <@spring.showErrors "<br>"/></span>
        </#if>
    </#if>
</div>
</#macro>