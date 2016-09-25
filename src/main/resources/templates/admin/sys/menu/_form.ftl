<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<div class="sub-title">菜单名称</div>
<div>
    <input type="text" class="form-control" name="name">
<#if sysMenu??>
    <@spring.bind "sysMenu.name" />
    <span style="color: red;"> <@spring.showErrors "<br>"/></span>
</#if>
</div>
<div class="sub-title">菜单地址</div>
<div>
    <input type="text" class="form-control" name="urls">
<#if sysMenu??>
    <@spring.bind "sysMenu.urls" />
    <span style="color: red;"> <@spring.showErrors "<br>"/></span>
</#if>
</div>
<div class="sub-title">菜单图标</div>
<div>
    <input type="text" class="form-control" name="icons">
</div>
<div class="pull-right" style="margin-top: 2%">
    <button type="submit" class="btn btn-success">提交</button>
    <a href="javascript:void(0)"
       onclick="javascript:window.history.go(-1)"
       class="btn btn-default">取消</a>
</div>