<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/18
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN PAGE HEADER-->
<div class="row">
    <div class="col-md-12">
        <!-- BEGIN PAGE TITLE & BREADCRUMB-->
        <h3 class="page-title" id="index-page-title">PermissionInfo</h3>
        <ul class="page-breadcrumb breadcrumb">
            <li>
                <i class="fa fa-home"></i>
                <a href="javascript:;">
                    用户个人信息管理
                </a>
                <i class="fa fa-angle-right"></i>
            </li>
            <li>
                <a href="javascript:;">
                    ModifyUserInfo
                </a>
            </li>
        </ul>
        <!-- END PAGE TITLE & BREADCRUMB-->
        <!-- 查询用表单-->
        <form class="form-horizontal" id="userInfoModifyForm"  role="form" action="rest/urpManage/modifyUserInfo"  method="post" >
            <div class="form-group">
                <div class="table-row-cell">
                    <label for="username" class="col-sm-1 control-label">用户名：</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" value="${userInfo.userName}" name="username" id="username" placeholder="请输入名称">
                    </div>

                    <label for="userInfoFile" class="col-sm-1 control-label">用户档案：</label>
                    <div class="col-sm-3">
                        <input id="userInfoFile" name="persionDocu" value="${userInfo.persionDocu}" type="file" multiple class="fileupload">
                    </div>

                </div>
                <div>
                    <label for="userPwd" class="col-sm-1 control-label">用户密码：</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" value="${userInfo.userPwd}" name="userPwd" id="userPwd" placeholder="请输入年龄">
                    </div>

                </div>

                <button id="fat-btn" class="btn btn-primary" data-loading-text="Loading..."
                        type="button" onclick="submitOf()" > 查询
                </button>
            </div>
        </form>

    </div>
</div>
<script language="JavaScript" type="text/javascript">
   /* $("#userInfoFile").fileupload({
        uploadUrl: "rest/urpManage/uploadUserInfoFile",
        uploadAsync: true,
        maxFileCount: 5,
        showBrowse: false,
        browseOnZoneClick: true
    });*/

    function submitOf(){
        debugger;
        var linkId = "userInfoLink";
        var formId = "userInfoModifyForm";
        submitForm(linkId,formId);
    }


</script>
