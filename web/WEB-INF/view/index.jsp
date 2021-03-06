<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->
    <head>
        <base href="<%=basePath%>">
        <meta charset="utf-8" />
        <title>Education System</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
        <meta content="" name="description" />
        <meta content="" name="author" />
        <meta name="MobileOptimized" content="320">

        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="${basePath}/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->

        <!-- BEGIN THEME STYLES -->
        <link href="${basePath}/assets/css/style-metronic.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/assets/css/style.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/assets/css/style-responsive.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/assets/css/plugins.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/assets/css/pages/tasks.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="${basePath}/assets/css/custom.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/assets/plugins/bootstrap-fileInput/css/fileinput.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/assets/plugins/bootstrap-fileInput/themes/explorer-fa/theme.css" media="all" rel="stylesheet" type="text/css"/>
        <link href="${basePath}/assets/plugins/bootstrapValidator/bootstrapValidator.css"/>
        <!-- END THEME STYLES -->

        <link rel="shortcut icon" href="${basePath}/app/img/favicon.ico" />

        <style>
            #userinfo_bg {
                background-image: url(${basePath}/assets/img/bg/user_info_repeat_bg.jpg);
                background-color: #ecf5fb;
                background-position: left top;
                background-repeat: repeat;
                padding: 15px;
            }
        </style>
    </head>
    <!-- END HEAD -->

    <!-- BEGIN BODY -->
    <body class="page-header-fixed">
        <!-- BEGIN HEADER -->
        <div class="header navbar navbar-inverse navbar-fixed-top">
            <!-- BEGIN TOP NAVIGATION BAR -->
            <div class="header-inner">
                <!-- BEGIN LOGO -->
                <a class="navbar-brand" href="javascript:;">
                    <img src="assets/img/logo.png" alt="logo" class="img-responsive" />
                </a>
                <!-- END LOGO -->
                <!-- BEGIN RESPONSIVE MENU TOGGLER -->
                <a href="javascript:;" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <img
                    src="assets/img/menu-toggler.png" alt="" />
                </a>
                <!-- END RESPONSIVE MENU TOGGLER -->
                <!-- BEGIN TOP NAVIGATION MENU -->
                <ul class="nav navbar-nav pull-right">
                    <li class="dropdown user">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                            <img alt="头像" src="assets/img/avatar1_small.jpg"/>
                            <span class="username"> ${userInfo.userName } </span>
                            <i class="fa fa-angle-down"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="javascript:;" id="trigger_fullscreen">
                                    <i class="fa fa-move"></i> 全屏
                                </a>
                            </li>
                            <li>
                                <a href="extra_lock.html">
                                    <i class="fa fa-lock"></i> 锁屏
                                </a>
                            </li>
                            <li>
                                <a href="rest/user/loginOut">
                                    <i class="fa fa-key"></i> 退出
                                </a>
                            </li>
                        </ul>
                    </li>
                    <!-- END USER LOGIN DROPDOWN -->
                </ul>
                <!-- END TOP NAVIGATION MENU -->
            </div>
            <!-- END TOP NAVIGATION BAR -->
        </div>
        <!-- END HEADER -->
        <div class="clearfix"></div>
        <!-- BEGIN CONTAINER -->
        <div class="page-container">
            <!-- BEGIN SIDEBAR -->
            <div class="page-sidebar-wrapper">
                <div class="page-sidebar navbar-collapse collapse">
                    <!-- BEGIN SIDEBAR MENU -->
                    <ul class="page-sidebar-menu" id="page-sidebar-menu">
                        <li class="sidebar-toggler-wrapper">
                            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                            <div class="sidebar-toggler hidden-phone"></div>
                            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                        </li>

                        <li class="start active">
                            <a href="rest/page/dashboard" id="btn-dashboard">
                                <i class="fa fa-home"></i><span class="title"> 首页 </span><span
                                class="selected"> </span>
                            </a>
                        </li>

                        <li class="">
                            <a href="javascript:;">
                                <i class="fa fa-gears"></i><span class="title"> 系统管理 </span><span
                                class="arrow "> </span>
                            </a>
                            <ul class="sub-menu">
                                <shiro:hasAnyRoles name="Super_User,Admin,IT">
                                    <li>
                                        <a id="userInfoLink" href="rest/urpManage/userquery">
                                            用户管理
                                        </a>
                                    </li>
                                </shiro:hasAnyRoles>
                                <shiro:hasAnyRoles name="Super_User,Admin,IT">
                                    <li>
                                        <a id="roleInfoLink" href="rest/urpManage/roleInfo">
                                            角色管理
                                        </a>
                                    </li>
                                </shiro:hasAnyRoles>
                                <shiro:hasAnyRoles name="Super_User,Admin,IT">
                                    <li>
                                        <a href="rest/page/groupInfo">
                                            Group管理
                                        </a>
                                    </li>
                                </shiro:hasAnyRoles>
                                <shiro:hasAnyRoles name="Super_User,Admin">
                                    <li>
                                        <a href="rest/page/permissionInfo">
                                            权限管理
                                        </a>
                                    </li>
                                </shiro:hasAnyRoles>
                            </ul>
                        </li>

                        <li class="">
                            <a href="javascript:;">
                                <i class="fa fa-user"></i><span class="title"> 个人中心 </span><span
                                class="arrow "> </span>
                            </a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="rest/page/gotoModifyUserInfo">
                                        信息修改
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        密码修改
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <!-- END SIDEBAR MENU -->
                </div>
            </div>
            <!-- END SIDEBAR -->
            <!-- BEGIN CONTENT -->
            <div class="page-content-wrapper" >
                <div class="page-content" id="userinfo_bg">
                    <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
                    <div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog" >
                            <div class="modal-content" >
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                                    <h4 class="modal-title">Modal title</h4>
                                </div>
                                <div class="modal-body">
                                    Widget settings form goes here
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn blue">
                                        Save changes
                                    </button>
                                    <button type="button" class="btn default" data-dismiss="modal">
                                        Close
                                    </button>
                                </div>
                            </div>
                            <!-- /.modal-content -->
                        </div>
                        <!-- /.modal-dialog -->
                    </div>
                    <!-- /.modal -->
                    <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
                    <!-- BEGIN STYLE CUSTOMIZER -->
                    <div class="theme-panel hidden-xs hidden-sm">
                        <div class="toggler"></div>
                        <div class="toggler-close"></div>
                        <div class="theme-options">
                            <div class="theme-option theme-colors clearfix">
                                <span> 主题颜色 </span>
                                <ul>
                                    <li class="color-black current color-default" data-style="default"></li>
                                    <li class="color-blue" data-style="blue"></li>
                                    <li class="color-brown" data-style="brown"></li>
                                    <li class="color-purple" data-style="purple"></li>
                                    <li class="color-grey" data-style="grey"></li>
                                    <li class="color-white color-light" data-style="light"></li>
                                </ul>
                            </div>
                            <div class="theme-option">
                                <span> 布局 </span>
                                <select class="layout-option form-control input-small">
                                    <option value="fluid">顺序</option>
                                    <option value="boxed">盒状</option>
                                </select>
                            </div>
                            <div class="theme-option">
                                <span> 标题 </span>
                                <select class="header-option form-control input-small">
                                    <option value="fixed">固定</option>
                                    <option value="default">默认</option>
                                </select>
                            </div>
                            <div class="theme-option">
                                <span> 工具栏 </span>
                                <select class="sidebar-option form-control input-small">
                                    <option value="fixed">固定</option>
                                    <option value="default">默认</option>
                                </select>
                            </div>
                            <div class="theme-option">
                                <span> 工具栏位置 </span>
                                <select class="sidebar-pos-option form-control input-small">
                                    <option value="left">左边</option>
                                    <option value="right">右边</option>
                                </select>
                            </div>
                            <div class="theme-option">
                                <span> 页脚 </span>
                                <select class="footer-option form-control input-small">
                                    <option value="fixed">固定</option>
                                    <option value="default">默认</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <!-- BEGIN DASHBOARD STATS -->
                    <div id="main-content"></div>

                    <!-- END PORTLET-->
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END CONTAINER -->
        <!-- BEGIN FOOTER -->
        <div class="footer">
            <div class="footer-inner">
                2017&copy; Education System.
            </div>
            <div class="footer-tools">
                <span class="go-top"><i class="fa fa-angle-up"></i></span>
            </div>
        </div>
        <!--[if lt IE 9]>
        <script src="${basePath}/assets/plugins/respond.min.js"></script>
        <script src="${basePath}/assets/plugins/excanvas.min.js"></script>
        <![endif]-->

        <script src="${basePath}/assets/plugins/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="${basePath}/assets/plugins/jquery-migrate-1.4.1.min.js" type="text/javascript"></script>
        <script src="${basePath}/assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
        <script src="${basePath}/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${basePath}/assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js"
                type="text/javascript"></script>
        <script src="${basePath}/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="${basePath}/assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="${basePath}/assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
        <script src="${basePath}/assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>

        <script src="${basePath}/assets/plugins/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="${basePath}/assets/plugins/select2/select2.min.js"></script>

        <script src="${basePath}/assets/scripts/app.js" type="text/javascript"></script>
        <script type="text/javascript" src="${basePath}/app/js/index.js"></script>



        <script src="${basePath}/assets/plugins/bootstrap-fileInput/js/fileinput.js"/>
        <script src="${basePath}/assets/plugins/bootstrap-fileInput/js/plugins/sortable.js" type="text/javascript"></script>
        <script src="${basePath}/assets/plugins/bootstrap-fileInput/js/locales/fr.js" type="text/javascript"></script>
        <script src="${basePath}/assets/plugins/bootstrap-fileInput/js/locales/es.js" type="text/javascript"></script>
        <script src="${basePath}/assets/plugins/bootstrap-fileInput/themes/explorer-fa/theme.js" type="text/javascript"></script>
        <script src="${basePath}/assets/plugins/bootstrap-fileInput/themes/fa/theme.js" type="text/javascript"></script>

        <script src="assets/plugins/bootstrapValidator/bootstrapValidator.js" />
        <script type="text/javascript">
            function submitForm(formId,linkId){
                debugger;
                var  form = $('#'+formId);

                var href ;
                if(form.attr('action').indexOf('?')>0){
                    href= form.attr('action').substring(0,form.attr('action').indexOf('?'));
                }else{
                    href= form.attr('action');
                }
                form.attr('action',href+'?'+form.serialize());
                form.submit();
            }
        </script>


        <!-- <script data-main="app/js/main" src="app/lib/requirejs/require.js"></script> -->
    </body>
</html>