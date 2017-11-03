<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="pagination">
    <c:if test="${!empty page}" >
        <c:choose>
            <c:when test="${page.totalPages == 1}">
                <li class="previous disabled"><a>&larr;上一页</a></li>
            </c:when>
            <c:otherwise>
                <li class="previous"><a href="javascript:jumpPage('${indexPage-1}','${pageSize}');">&larr;上一页</a></li>
            </c:otherwise>
        </c:choose>
        <!-- 跳转到第一页 如果只有一页，那么就不能跳动-->
        <c:choose>
            <c:when test="${page.totalPages == 1}" >
                <li class="disabled"><a>&laquo;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="javascript:jumpPage(1,'${pageSize}');">&laquo;</a></li>
            </c:otherwise>
        </c:choose>

        <c:forEach begin="1" end="${page.totalPages}" varStatus="status">
            <c:choose>
                <c:when test="${page.pageNo == status.index}">
                    <li class="active"><a>${status.index}</a></li>
                </c:when>
                <c:otherwise>
                    <li ><a href="javascript:jumpPage('${status.index}','${pageSize}');">${status.index}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <!-- 跳转到最后一页 如果只有一页，那么就不能跳动-->
        <c:choose>
            <c:when test="${page.totalPages == 1}" >
                <li class="disabled"><a>&raquo;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="javascript:jumpPage('${page.totalPages}','${pageSize}');">&raquo;</a></li>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${page.totalPages == indexPage}">
                <li class="next disabled"><a>下一页&rarr;</a></li>
            </c:when>
            <c:otherwise>
                <li class="next"><a href="javascript:jumpPage('${indexPage+1}','${pageSize}');">下一页&rarr;</a></li>
            </c:otherwise>
        </c:choose>
        <div class="btn-group">
            <button type="button" class="btn btn-primary" >页面大小</button>
            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                <span class="caret"/>
            </button>
            <ul class="dropdown-menu" role="menu">
                <li><a href="javascript:jumpPage(1,5);">5</a> </li>
                <li><a href="javascript:jumpPage(1,10);">10</a> </li>
                <li><a href="javascript:jumpPage(1,15);">15</a> </li>
                <li><a href="javascript:jumpPage(1,20);">20</a> </li>
            </ul>
        </div>
    </c:if>
</ul>
<script type="text/javascript">
    function jumpPage(indexPage,pageSize){
        $("#indexPage").val(indexPage);
        $("#pageSize").val(pageSize);
        submitOf();
    }

</script>
