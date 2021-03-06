<#macro select id datas value="" key="" text="" headKey="" headValue="" >
<select id="${id}" name="${id}" class="form-control">
    <#if headKey!="">
        <option <#if value=="">selected</#if> value="${headKey!""}">${headValue!""}</option>
    </#if>
    <#list datas as data>
        <#if key!="">
            <#if value == data[key]?string>
                <option value="${data[key]!""}" selected>${data[text!""]}</option>
            <#else>
                <option value="${data[key]!""}">${data[text]!""}</option>
            </#if>
        <#else>
            <#if value == data>
                <option value="${data!""}" selected>${data!""}</option>
            <#else>
                <option value="${data!""}">${data!""}</option>
            </#if>
        </#if>
    </#list>
</select>
</#macro>