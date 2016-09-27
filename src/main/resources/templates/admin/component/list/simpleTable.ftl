<#macro simpleTable tableHeaderMaps datas dataAttributes _number _size _totalRecord _totalPages>
<table class="datatable table table-striped table-bordered table-hover" cellspacing="0" width="100%">
    <thead>
    <tr>
        <#list tableHeaderMaps as obj>
            <th style="${obj.headerStyle!""}">${obj.headerName!""}</th>
        </#list>
        <th style="width: 15%;">操作</th>
    </tr>
    </thead>
    <tbody>
        <#list list as obj>
        <tr>
            <#list dataAttributes as attr>
                <td>${obj[attr]!''}</td>
            </#list>
            <td>
                <a href="edit?id=${obj.id}" class="btn btn-info ">编辑</a>
                <a href="delete?id=${obj.id}" class="btn btn-danger ">删除</a>
            </td>
        </tr>
        </#list>
    </tbody>
</table>
<div id="pager">
    <#import "pager.ftl" as p>
                <@p.pager pageNo=_number pageSize=_size recordCount=_totalRecord pageCount=_totalPages toURL="?" method="get"/>
</div>
</#macro>