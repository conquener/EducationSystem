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
        <form class="form-horizontal" content="multipart/form-data"  id="userInfoModifyForm" role="form" action="rest/urpManage/modifyUserInfo"  method="post" >
            <div class="form-group">
                <div class="table-row-cell">
                    <label for="username" class="col-sm-1 control-label">用户名：</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" value="${userInfo.userName}"
                               name="username" id="username" placeholder="请输入名称">
                    </div>
                </div>
             </div>
            <div class="form-group">
                <div class="table-row-cell">
                    <label for="userPwd" class="col-sm-1 control-label">用户密码：</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" value="${userInfo.userPwd}" name="userPwd" id="userPwd" placeholder="请输入年龄">
                    </div>
                </div>
            </div>
            <div class="form-group">

                <div class="table-row-cell">
                    <label for="userInfoFile" class="col-sm-1 control-label">用户档案：</label>
                    <div class="col-sm-4">
                        <input type="file" name="userInfoFile" id="userInfoFile"  data-min-file-count="1" multiple class="file-loading" />
                    </div>
                </div>
            </div>


            <div class="form-group">
                    <button id="fat-btn" class="btn btn-primary" data-loading-text="Loading..."
                            type="button" onclick="submitOf()" > 查询
                    </button>
            </div>

        </form>

    </div>
</div>
<script language="JavaScript" type="text/javascript">
    var userInfoFile = $("#userInfoFile");

    //初始化上传控件
    userInfoFile.fileinput({
        uploadUrl: "rest/urpManage/uploadUserInfoFile",
        uploadAsync: true,
        maxFileCount: 5,//表示允许同时上传的最大文件个数
        //minFileCount: 0, 最小
        showBrowse: false,
        browseOnZoneClick: true,
        language: 'zh', //设置语言
        //allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀  此处做ftp上传测试 ,不使用
        showUpload: true, //是否显示上传按钮
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        //dropZoneEnabled: false,//是否显示拖拽区域
        //minImageWidth: 50, //图片的最小宽度
        //minImageHeight: 50,//图片的最小高度
        //maxImageWidth: 1000,//图片的最大宽度
        //maxImageHeight: 1000,//图片的最大高度
        //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
        enctype: 'multipart/form-data',
        validateInitialCount:true,
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}!"
    });

    //导入文件上传完成之后的事件
    userInfoFile.on("fileuploaded", function (event, data, previewId, index) {
        var data = data.response.lstOrderImport;
        debugger
        if (data == undefined) {
            toastr.error('文件格式类型不正确');
            return;
        }

    });
    //导入文件上传中的事件
    userInfoFile.on("fileupload", function (event, data, previewId, index) {
        var data = data.response.lstOrderImport;
        debugger
        if (data == undefined) {
            toastr.error('文件格式类型不正确');
            return;
        }

    });

    //提交事件
    function submitOf(){
        debugger;
        var linkId = "userInfoModify";
        var formId = "userInfoModifyForm";
        submitForm(formId,linkId);
    }


</script>
