<#include "../../layout/layout.ftl">
<#setting url_escaping_charset='utf-8'>
<#import "../../component/formHead.ftl" as formHead>
<#import "../../component/list/searchInput.ftl" as searchInput>
<#import "../../component/list/searchSelect.ftl" as searchSelect>
<#import "../../component/list/searchButton.ftl" as searchButton>
<#import "../../component/list/addButton.ftl" as addButton>
<#import "../../component/list/simpleTable.ftl" as simpleTable>
<@layout>
<div class="row">
    <div class="col-xs-12">
        <div class="card">
            <@formHead.formHead title="菜单管理"/>
            <div class="card-body">
                <form class="form-inline">

                    <@searchSelect.searchSelect id="pid"
                    label="上级菜单" data=parentMenus
                    value="${RequestParameters['pid']!''}"
                    formKey="id" formText="name" formHeadKey=" " formHeadValue="全部"/>

                    <@searchInput.searchInput id="name" label="菜单名称"/>

                    <@searchButton.searchButton/>
                    <@addButton.addButton/>
                </form>
                <hr/>

                <#assign  tableHeaderMaps=[
                {"headerName":"菜单名称"},
                {"headerName":"菜单图标"},
                {"headerName":"菜单地址"}]/>

                <#assign  dataAttributes=["name","icons","urls"]/>

                <@simpleTable.simpleTable tableHeaderMaps=tableHeaderMaps datas=list
                dataAttributes=dataAttributes _number=_number _size=_size _totalRecord=_totalRecord
                _totalPages=_totalPages/>

            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $("select").select2();
    });
</script>
</@layout>