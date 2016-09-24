<#macro layout>
<!DOCTYPE html>
<html>

<head>
    <title>Flat Admin V.2 - Free Bootstrap Admin Templates</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>
    <!-- CSS Libs -->
    <link rel="stylesheet" type="text/css" href="/lib/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/lib/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/lib/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="/lib/css/bootstrap-switch.min.css">
    <link rel="stylesheet" type="text/css" href="/lib/css/checkbox3.min.css">
    <link rel="stylesheet" type="text/css" href="/lib/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="/lib/css/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/lib/css/select2.min.css">
    <!-- CSS App -->
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/themes/flat-blue.css">

    <!-- Javascript Libs -->
    <script type="text/javascript" src="/lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="/lib/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/lib/js/Chart.min.js"></script>
    <script type="text/javascript" src="/lib/js/bootstrap-switch.min.js"></script>

    <script type="text/javascript" src="/lib/js/jquery.matchHeight-min.js"></script>
    <script type="text/javascript" src="/lib/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="/lib/js/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript" src="/lib/js/select2.full.min.js"></script>
    <script type="text/javascript" src="/lib/js/ace/ace.js"></script>
    <script type="text/javascript" src="/lib/js/ace/mode-html.js"></script>
    <script type="text/javascript" src="/lib/js/ace/theme-github.js"></script>
    <!-- Javascript -->
</head>


<script>
    function initList(dataSet,columns) {
        var selected = [];
        var table = $('#tb').dataTable({
            "data":dataSet,
            "columns": columns,
            "aoColumnDefs": [//设置列的属性，此处设置第一列不排序
                {"class": "tn", "targets": [0]},
                {
                    "targets": -1,
                    "class": "but_xq",
                    "data": null,
                    "bSortable": false,
                    "defaultContent": "<p><a id=\"edit\" href=\"#\">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a id=\"del\"  href=\"#\">删除</a></p>"
                }
            ],
            "aaSorting": [[0, "desc"]], //给列表排序 ，第一个参数表示数组 (由0开始)。1 表示Browser列。第二个参数为 desc或是asc
            "oLanguage": {//插件的汉化
                "sLengthMenu": "每页显示 _MENU_ 条记录",
                "sZeroRecords": "抱歉， 没有找到",
                "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                "sInfoEmpty": "没有数据",
                "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "前一页",
                    "sNext": "后一页",
                    "sLast": "尾页"
                },
                "sZeroRecords": "没有检索到数据",
                "sProcessing": "<img src='' />",
                "sSearch": "搜索"
            },
            "rowCallback": function (row, data) {//添加单击事件，改变行的样式
                if ($.inArray(data.DT_RowId, selected) !== -1) {
                    $(row).addClass('selected');
                }
            },
            "lengthMenu": [[5, 10, 25, 50, -1], [5, 10, 25, 50, "全部"]]
        });

        $("#tb tr").slice(1).each(function (g) {
            var p = this;
            $(this).children().slice(1).click(function () {
                $($(p).children()[0]).children().each(function () {
                    if (this.type == "checkbox") {
                        if (!this.checked) {
                            this.checked = true;
                        } else {
                            this.checked = false;
                        }
                    }
                });
            });
        });


        /**
         * 修改
         */
        $('a#edit').on('click', 'a#edit', function () {
            var data = $('#tb').DataTable().row($(this).parents('tr')).data();
            alert("查看修改：" + data[1] + "," + data[2]);
        });

        /**
         * 删除
         */
        $('a#del').click(function () {
            var data = $('#tb').DataTable().row($(this).parents('tr')).data();
            alert("删除：" + data[1] + "," + data[2]);
        });
    }

</script>


<body class="flat-blue">
<div class="app-container">
    <div class="row content-container">
        <nav class="navbar navbar-default navbar-fixed-top navbar-top">
            <div class="container-fluid">
                <div class="navbar-header">
                <#--<button type="button" class="navbar-expand-toggle">-->
                        <#--<i class="fa fa-bars icon"></i>-->
                    <#--</button>-->
                    <#--<ol class="breadcrumb navbar-breadcrumb">-->
                        <#--<li>Table</li>-->
                        <#--<li class="active">Static Table</li>-->
                    <#--</ol>-->
                    <#--<button type="button" class="navbar-right-expand-toggle pull-right visible-xs">-->
                        <#--<i class="fa fa-th icon"></i>-->
                    <#--</button>-->
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <button type="button" class="navbar-right-expand-toggle pull-right visible-xs">
                        <i class="fa fa-times icon"></i>
                    </button>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-expanded="false"><i class="fa fa-comments-o"></i></a>
                        <ul class="dropdown-menu animated fadeInDown">
                            <li class="message">
                                <a href="/admin/logout">登出</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="side-menu sidebar-inverse">
            <nav class="navbar navbar-default" role="navigation">
                <div class="side-menu-container">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">
                            <div class="icon fa fa-paper-plane"></div>
                            <div class="title">BootAdmin</div>
                        </a>
                        <button type="button" class="navbar-expand-toggle pull-right visible-xs">
                            <i class="fa fa-times icon"></i>
                        </button>
                    </div>
                    <ul class="nav navbar-nav">
                        <#list _menus as obj>
                            <#if obj.level ==0>
                                <li>
                                    <a href="${obj.urls!''}">
                                        <span class="${obj.icons!''}"></span><span
                                            class="title">${obj.name!''}</span>
                                    </a>
                                </li>
                            </#if>
                        </#list>
                        <#list _menus as obj>
                            <#if obj.level ==1>
                                <li class="panel panel-default dropdown">
                                    <a data-toggle="collapse" href="#dropdown-element">
                                        <span class="${obj.icons!''}"></span><span class="title">${obj.name}</span>
                                    </a>
                                    <div id="dropdown-element" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <ul class="nav navbar-nav">
                                                <#list _menus as subMenu>
                                                    <#if (subMenu.pid)?? && subMenu.pid == obj.id>
                                                        <li><a href="${subMenu.urls!''}">${subMenu.name!''}</a></li>
                                                    </#if>
                                                </#list>
                                            </ul>
                                        </div>
                                    </div>
                                </li>
                            </#if>
                        </#list>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="container-fluid">
            <div class="side-body">
                <#nested "content" />
            </div>
        </div>
    </div>
    <footer class="app-footer">
        <div class="wrapper">
            <span class="pull-right">2.1 <a href="#"><i class="fa fa-long-arrow-up"></i></a></span> © 2015 Copyright.
        </div>
    </footer>

</body>

</html>

</#macro>