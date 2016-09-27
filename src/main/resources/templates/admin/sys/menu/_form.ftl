<#import "../../component/form/hiddenInput.ftl" as hiddenInput>
<#import "../../component/form/formInput.ftl" as formInput>
<#import "../../component/form/formCommonButton.ftl" as formCommonButton>
<@hiddenInput.hiddenInput id="${_csrf.parameterName}" value="${_csrf.token}"/>
<@formInput.formInput entity=sysMenu title="菜单名称" id="name"  errorKey="sysMenu.name" needValide=true value=""/>
<@formInput.formInput entity=sysMenu title="菜单地址" id="urls"  errorKey="sysMenu.urls"  needValide=true value=""/>
<@formInput.formInput entity="" title="菜单图标" id="icons"  errorKey=""  needValide=false value=""/>
<@formCommonButton.formCommonButton/>