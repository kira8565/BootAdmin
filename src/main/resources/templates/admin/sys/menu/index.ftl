<#include "../../layout/layout.ftl">
<#setting url_escaping_charset='utf-8'>
<@layout>
<div class="row">
    <div class="col-xs-12">
        <div class="card">
            <div class="card-header">
                <div class="card-title">
                    <div class="title">菜单管理</div>
                </div>

            </div>
            <div class="card-body">
                <form class="form-inline">
                    <div class="form-group">
                        <label for="exampleInputName2">菜单名称</label>
                        <input type="text" class="form-control" name="name" value="${RequestParameters['name']!''}">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
                <hr/>
                <table class="datatable table table-striped table-bordered table-hover" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th>菜单名称</th>
                        <th>菜单图标</th>
                        <th>菜单地址</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list list as obj>
                        <tr>
                            <td>${obj.name!''}</td>
                            <td>${obj.icons!''}</td>
                            <td>${obj.urls!''}</td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
            <div id="pager">
                <#import "../../layout/pager.ftl" as p>
                <@p.pager pageNo=_number pageSize=_size recordCount=_totalRecord pageCount=_totalPages toURL="?" method="get"/>
            </div>
        </div>
    </div>
</div>
</@layout>