<%@ page isELIgnored="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en" class="bg-dark">
<head>
    <meta charset="utf-8"/>
    <title>Công chứng Uchi-login</title>
    <meta name="description" content="app, uchi, v4, cong chung, off screen nav"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/assets/images/osp.ico"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/note/css/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/note/css/animate.css" type="text/css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/note/css/font-awesome.min.css" type="text/css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/note/css/font.css" type="text/css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/note/css/app.css" type="text/css"/>
    <!--[if lt IE 9]>
    <script src="<%=request.getContextPath()%>/assets/note/js/ie/html5shiv.js"></script>
    <script src="<%=request.getContextPath()%>/assets/note/js/ie/respond.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/note/js/ie/excanvas.js"></script>
    <![endif]-->
</head>
<body class="">
<style>
    .navbar-brand img {
        max-height: 50px;
    }
</style>
<section id="content" class="m-t-lg wrapper-md animated fadeInUp">
    <div class="container aside-xxl">
        <%--<a class="navbar-brand block" href="index.html"><img src="#" class="img-rounded"></a>--%>
        <section class="panel panel-default bg-white m-t-lg">
            <header class="panel-heading text-center">
                <strong>Đăng Nhập</strong>
            </header>
            <form action="<s:url value='/j_spring_security_check'/>" class="panel-body wrapper-lg" method="post"
                  class="form-group ">
                <div class="form-group">
                    <label class="control-label">Tài khoản</label>
                    <input id="username" name="username" placeholder="username" class="form-control input-lg">
                </div>
                <div class="form-group">
                    <label class="control-label">Mật khẩu</label>
                    <input type="password" id="password" name="password" placeholder="password"
                           class="form-control input-lg">
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" id="rememberme" name="remember-me"> Ghi nhớ mật khẩu
                    </label>
                    <%--<input type="hidden" name="${_csrf.parameterName}"--%>
                    <%--value="${_csrf.token}" />--%>
                </div>
                <a href="#" class="pull-right m-t-xs" data-toggle="modal" data-target="#myModal"
                   style="color: #717171;">
                    <small>Quên mật khẩu?</small>
                </a>
                <button type="submit" class="btn btn-primary">Đăng nhập</button>
                <div class="line line-dashed"></div>
                <p class="text-primary">HỖ TRỢ KỸ THUẬT</p>
                <p class="text-muted">
                    <small>Di động:0977 258 852 (Mr. Phạm Mạnh)</small>
                </p>
            </form>
        </section>
    </div>
</section>
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <section class="panel panel-default">
            <header class="panel-heading font-bold">Tìm lại mật khẩu</header>
            <div class="panel-body">
                <form class="bs-example form-horizontal">
                    <div class="form-group">
                        <label class="col-lg-2 control-label">Tài khoản</label>
                        <div class="col-lg-10">
                            <input type="text" id="account" class="form-control" placeholder="Tài khoản">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-2 control-label">Email</label>
                        <div class="col-lg-10">
                            <input type="email" id="email" class="form-control" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-8 col-lg-4">
                            <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">Đóng</button>
                            <button onclick="sendPass()" class="btn btn-sm btn-primary">Gửi lại mật khẩu</button>
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </div>
</div>
<!-- footer -->
<footer id="footer">
    <div class="text-center padder">
        <p>
            <small>Hệ thống công chứng &copy; 2017</small>
        </p>
    </div>
</footer>
<!-- / footer -->
<script src="<%=request.getContextPath()%>/assets/note/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="<%=request.getContextPath()%>/assets/note/js/bootstrap.js"></script>
<!-- App -->
<script src="<%=request.getContextPath()%>/assets/note/js/app.js"></script>
<script src="<%=request.getContextPath()%>/assets/note/js/slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/note/js/app.plugin.js"></script>
<script>
    function sendPass() {
        var url = location.protocol + '//' + location.host + '/send-pass.html';
        var account = $('#account').val();
        var email = $('#email').val();
        alert(account + "," + email + "," +url);
        $.ajax({
            type: "post",
            url: url,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: {
                account: account,
                email: email
            },
            success: function (response) {

            },
            error: function (e) {
                console.log("ERROR: ", e);
            },
            done: function (e) {
                console.log("DONE");
            }
        });
    }

    function beforeSubmit() {
        var username=$('#username').val();
        var password=$('#password').val();

    }
</script>
</body>
</html>