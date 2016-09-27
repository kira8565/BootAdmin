<#macro searchInput id label>
<div class="form-group">
    <label for="${id}">${label}</label>
    <input type="text" id="${id}" class="form-control" name="${id}" value="${RequestParameters[id]!''}">
</div>
</#macro>