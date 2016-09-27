<#include "../../layout/layout.ftl">
<#setting url_escaping_charset='utf-8'>
<#import "/spring.ftl" as spring />
<#import "../../component/formHead.ftl" as formHead>
<@layout>
<div class="row">
    <div class="col-xs-12">
        <div class="card">
            <@formHead.formHead title="新增菜单"/>
            <div class="card-body">
                <form action="addEntity" method="post">
                    <#include "_form.ftl"/>
                </form>
            </div>
        </div>
    </div>
</div>
</@layout>