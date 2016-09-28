<#include "../../layout/layout.ftl">
<#setting url_escaping_charset='utf-8'>
<#import "/spring.ftl" as spring />
<#import "../../component/formHead.ftl" as formHead>
<#import "../../component/form/hiddenInput.ftl" as hiddenInput>
<@layout>
<div class="row">
    <div class="col-xs-12">
        <div class="card">
            <@formHead.formHead title="编辑菜单"/>
            <div class="card-body">
                <form action="editEntity" method="post">
                    <@hiddenInput.hiddenInput id="id" value="${(entity.id)!''}" />
                    <#include "_form.ftl"/>
                </form>
            </div>
        </div>
    </div>
</div>
</@layout>