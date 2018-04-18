<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/22
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN PAGE HEADER-->
<div class="row">
    <div class="col-md-12">
        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
        <h3 class="page-title" id="index-page-title">UserInfo</h3>
        <ul class="page-breadcrumb breadcrumb">
            <li>
                <i class="fa fa-home"></i>
                <a href="javascript:;">
                    角色管理
                </a>
                <i class="fa fa-angle-right"></i>
            </li>
            <li>
                <a href="javascript:;">
                    RoleInfo
                </a>
            </li>
        </ul>

        <!-- 查询用表单-->
        <form class="form-horizontal" id="roleInfoForm"  role="form" action="rest/urpManage/roleInfo"  method="post" >
            <input id="indexPage" name="indexPage" value="${indexPage}" type="hidden" />
            <input id="pageSize" name="pageSize" value="${pageSize}"  type="hidden" />
            <div class="form-group">
                <div class="table-row-cell">
                    <label for="roleName" class="col-sm-1 control-label">名称：</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" value="${roleName}" name="roleName" id="roleName" placeholder="请输入名称">
                    </div>

                </div>
                <button id="fat-btn" class="btn btn-primary" data-loading-text="Loading..."
                        type="button" onclick="submitOf()" > 查询
                </button>
            </div>

        </form>

        <!-- END PAGE TITLE & BREADCRUMB-->
        <table id="tale_data" class="table table-bordered">
            <caption>角色信息列表</caption>
            <thead>
            <tr>
                <th>角色名</th>
                <th>角色描述</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${!empty page}" >
                <c:forEach items="${page.result}" var="item" varStatus="status" >
                    <tr>
                        <td>${item.roleName}</td>
                        <td>${item.roleDesc}</td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
        <%@include file="../include/pageIndex.jsp"%>
    </div>
</div>
<script language="JavaScript" type="text/javascript">
    function submitOf(){
        var linkId = "roleInfoLink";
        var formId = "roleInfoForm";
        submitForm(linkId,formId);
    }

</script>
