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
                    用户管理
                </a>
                <i class="fa fa-angle-right"></i>
            </li>
            <li>
                <a href="javascript:;">
                    UserInfo
                </a>
            </li>
        </ul>

        <!-- 查询用表单-->
        <form class="form-horizontal" id="userInfoForm"  role="form" action="rest/urpManage/userquery"  method="post" >
            <input id="indexPage" name="indexPage" value="${indexPage}" type="hidden" />
            <input id="pageSize" name="pageSize" value="${pageSize}"  type="hidden" />
            <div class="form-group">
                <div class="table-row-cell">
                    <label for="username" class="col-sm-1 control-label">名称：</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" value="${username}" name="username" id="username" placeholder="请输入名称">
                    </div>
                    <label for="userAge" class="col-sm-1 control-label">年龄：</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="userAge" id="userAge" placeholder="请输入年龄">
                    </div>
                </div>
                <button id="fat-btn" class="btn btn-primary" data-loading-text="Loading..."
                        type="button" onclick="submitForm()" > 查询
                </button>
            </div>

        </form>

        <!-- END PAGE TITLE & BREADCRUMB-->
        <table id="tale_data" class="table table-bordered">
            <caption>用户信息列表</caption>

                    <thead>
                        <tr>
                            <th>用户名</th>
                            <th>创建时间</th>
                            <th>最后登录时间</th>

                        </tr>
                    </thead>


            <tbody>
                <c:if test="${!empty page}" >
                    <c:forEach items="${page.result}" var="item" varStatus="status" >
                        <tr>
                            <td>${item.userName}</td>
                            <td>${item.createTime}</td>
                            <td>${endLoginTime}</td>
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
        var linkId = "userInfoLink";
        var formId = "userInfoForm";
        submitForm(linkId,formId);
    }


    $(function(){
        $('form').bootstrapValidator({
            message:'This value is not valid',
            feedbackIcons:{
                valid:'glyphicon glyphicon-ok',
                invalid:'glyphicon glyphicon-remove',
                validating:'glyphicon glyphicon-refresh'
            },
            fields:{
                username:{
                    message:'用户名验证失败',
                    validators:{
                        notEmpty:{
                            message:'用户名不能为空!',
                        }
                    }
                },
                age:{
                    message:'用户年龄验证失败',
                    validators:{
                        notEmpty:{
                            message:'用户年龄不能为空!',
                        }
                    }
                }

            }

        });
    });


</script>
