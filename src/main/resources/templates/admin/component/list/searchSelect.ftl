<#macro searchSelect id label data value formKey formText formHeadKey formHeadValue>
<div class="form-group">
    <label for="${id}">${label}</label>
    <#import "../select.ftl" as item>
    <@item.select value="${value}" id="${id}" datas=data key="${formKey}" text="${formText}" headKey="${formHeadKey}" headValue="${formHeadValue}"/>
</div>
</#macro>