<#include "../../layout/layout.ftl">
<#setting url_escaping_charset='utf-8'>
<#import "/spring.ftl" as spring />
<@layout>
<div class="row">
    <div class="col-xs-12">
        <div class="card">
            <div class="card-header">
                <div class="card-title">
                    <div class="title">新增菜单</div>
                </div>
            </div>
            <div class="card-body">
                <form action="addEntity" method="post">

                    <#include "_form.ftl"/>
                </form>
            </div>
        </div>
    </div>
</div>
</@layout>