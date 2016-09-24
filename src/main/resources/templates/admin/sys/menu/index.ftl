<#include "../../layout/layout.ftl">

<@layout>
<div class="page-title">
    <span class="title">Table</span>
    <div class="description">A bootstrap table for display list of data.</div>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="card">
            <div class="card-header">
                <div class="card-title">
                    <div class="title">菜单管理</div>
                </div>
            </div>
            <div class="card-body">
                <table id="tb" class="datatable table table-striped" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script>
    var columns = [
        {"title": "菜单名称", "class": "center"},
        {"title": "菜单图标", "class": "center"},
        {"title": "菜单地址", "class": "center"},
    ];

    $(document).ready(function () {
        $.post('listData', {
            '${_csrf.parameterName}': '${_csrf.token}'
        }, function (e) {
            var list = eval(e);
            var dataset = [];
            for (var i = 0; i < list.length; i++) {
                var arr = ['1','2','3']
                dataset.push(arr);
            }
            initList(dataset, columns);
        })

    });

</script>
</@layout>