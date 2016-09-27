<#macro formCommonButton>
    <#import "formCancleButton.ftl" as formCancleButton>
    <#import "formAddButton.ftl" as formAddButton>
<div class="pull-right" style="margin-top: 2%">
    <@formAddButton.formAddButton/>
    <@formCancleButton.formCancleButton/>
</div>
</#macro>