<#import "../../component/form/hiddenInput.ftl" as hiddenInput>
<#import "../../component/form/formInput.ftl" as formInput>
<#import "../../component/form/formSelector.ftl" as formSelector>
<#import "../../component/form/formCommonButton.ftl" as formCommonButton>
<@hiddenInput.hiddenInput id="${_csrf.parameterName}" value="${_csrf.token}"/>

<@formSelector.formSelector entity=sysMenu data=parentMenus title="上级菜单"
  id="pid"  errorKey="sysMenu.pid" needValide=false value="${(entity.pid)!''}" formKey="id" formText="name"
formHeadKey=" " formHeadValue="无"/>
<@formInput.formInput entity=sysMenu title="菜单名称" id="name"  errorKey="sysMenu.name" needValide=true value="${(entity.name)!''}"/>
<@formInput.formInput entity=sysMenu title="菜单地址" id="urls"  errorKey="sysMenu.urls"  needValide=true value="${(entity.urls)!''}"/>
<@formInput.formInput entity="" title="菜单图标" id="icons"  errorKey=""  needValide=false value="${(entity.icons)!''}"/>
<@formCommonButton.formCommonButton/>

<script>
    $(document).ready(function () {
        $("select").select2();
    });
</script>