<#-- 自定义的分页指令。
属性说明：
   pageNo      当前页号(int类型)
   pageSize    每页要显示的记录数(int类型)
   toURL       点击分页标签时要跳转到的目标URL(string类型)
   pageCount   总页码数(int类型)
   method      查询方法的类型（GET/POST）
   recordCount 总记录数(int类型)
 使用方式：
  <#if recordCount??>
    <#import "/pager.ftl" as p>
    <@p.pager pageNo=1 pageSize=10 recordCount=13 pageCount=2 toURL="xxxxx/queryXXX" method="get"/>
  </#if>
 -->

<#macro pager pageNo pageSize recordCount pageCount toURL method>
<#-- 定义局部变量pageCount保存总页数 -->
    <#if recordCount==0><#return/></#if>
<#-- 页号越界处理 -->
    <#if (pageNo > pageCount)>
        <#assign pageNo=pageCount>
    </#if>
    <#if (pageNo < 1)>
        <#assign pageNo=1>
    </#if>
<#-- 输出分页表单 -->
<div class=" pull-right" style="margin-right: 2%">
    <form method="${method}" action="" name="qPagerForm">

        <ul class="pagination">
        <#-- 把请求中的所有参数当作隐藏表单域(无法解决一个参数对应多个值的情况) -->
            <#list RequestParameters?keys as key>
                <#if (key!="page" && RequestParameters[key]??)>
                    <input type="hidden" name="${key}" value="${RequestParameters[key]}"/>
                </#if>
            </#list>
            <input type="hidden" name="page" value="${pageNo}"/>
        <#-- 上一页处理 -->
            <#if (pageNo == 1)>
                <li>
                    <a class="disabled">&laquo;&nbsp;上一页</a>
                </li>
            <#else>
                <li>
                    <a href="javascript:void(0)" onclick="turnOverPage(${pageNo - 1})">&laquo;&nbsp;上一页</a>
                </li>
            </#if>
        <#-- 如果前面页数过多,显示... -->
            <#assign start=1>
            <#if (pageNo > 4)>
                <#assign start=(pageNo - 1)>
                <li>
                    <a href="javascript:void(0)" onclick="turnOverPage(1)">1</a>
                </li>
                <li>
                    <a href="javascript:void(0)" onclick="turnOverPage(2)">2</a>
                    &hellip;
                </li>
            </#if>
        <#-- 显示当前页号和它附近的页号 -->
            <#assign end=(pageNo + 1)>
            <#if (end > pageCount)>
                <#assign end=pageCount>
            </#if>
            <#list start..end as i>
                <#if (pageNo==i)>
                    <li>
                        <a class="current">${i}</a>
                    </li>
                <#else>
                    <li>
                        <a href="javascript:void(0)" onclick="turnOverPage(${i})">${i}</a>
                    </li>
                </#if>
            </#list>
        <#-- 如果后面页数过多,显示... -->
            <#if (end < pageCount - 2)>
                <li>
                    <a>&hellip;</a>
                </li>
            </#if>
            <#if (end < pageCount - 1)>
                <li>
                    <a href="javascript:void(0)" onclick="turnOverPage(${pageCount - 1})">${pageCount-1}</a>
                </li>
            </#if>
            <#if (end < pageCount)>
                <li>
                    <a href="javascript:void(0)" onclick="turnOverPage(${pageCount})">${pageCount}</a>
                </li>
            </#if>
        <#-- 下一页处理 -->
            <#if (pageNo == pageCount)>
                <li>
                    <a class="disabled">下一页&nbsp;&raquo;</a>
                </li>
            <#else>
                <li>
                    <a href="javascript:void(0)" onclick="turnOverPage(${pageNo + 1})">下一页&nbsp;&raquo;</a>
                </li>
            </#if>

        </ul>
        <#--<span>共${recordCount}条记录，</span>-->
        <#--<span>当前第<b>${pageNo}/${pageCount}</b>页</span>-->
    </form>
    <script language="javascript">
        function turnOverPage(no) {
            var qForm = document.qPagerForm;
            if (no >${pageCount}) {
                no =${pageCount};
            }
            if (no < 1) {
                no = 1;
            }
            qForm.page.value = no;
            qForm.action = "${toURL}";
            qForm.submit();
        }
    </script>
</div>
</#macro>