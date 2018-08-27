<%@ page isELIgnored="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<section id="content">
    <section class="vbox">
        <section class="scrollable padder">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="<%=request.getContextPath()%>/index.html"><i class="fa fa-home"></i>&nbsp;Home</a></li>
                <li><a href="<%=request.getContextPath()%>/system/user/list.html">User</a></li> <li><a href="javascript:void(0)">Change password</a></li>
            </ul>
            <div class="m-b-md">
                <h3 class="m-b-none">Đổi mật khẩu</h3>
            </div>
            <s:if test="hasActionMessages()">
                    <h3 style="color: #00b2de"><s:actionmessage/></h3>
            </s:if>
            <section class="panel panel-default">
                <header class="panel-heading"><i class="fa fa-caret-square-o-right"></i> Đổi mật khẩu</header>
                <div class="panel-body">
                    <s:form method="post" action="change-pass" theme="simple" cssStyle="" validate="true">
                        <s:hidden name="id" />
                        <s:hidden name="item.id" />
                        <s:hidden name="item.username" />
                        <%--<code><s:property value="item.username" /></code>--%>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Mật khẩu cũ</label>
                            <div class="col-sm-10">
                                <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-lock"></i>
                                        </span>
                                    <s:textfield name="item.password" maxlength="25" placeholder="Mật khẩu cũ" cssClass="form-control" />
                                </div>
                                <s:fielderror cssStyle="color: red" fieldName="password"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Mật khẩu mới</label>
                            <div class="col-sm-10">
                                <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-lock"></i>
                                        </span>
                                    <s:textfield name="newPassword" maxlength="25" placeholder="Mật khẩu mới" cssClass="form-control" />
                                </div>
                                <s:fielderror cssStyle="color: red" fieldName="newPassword"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Xác nhận mật khẩu mới</label>
                            <div class="col-sm-10">
                                <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-lock"></i>
                                        </span>
                                    <s:textfield name="reNewPassword" maxlength="25" placeholder="Xác nhận mật khẩu mới" cssClass="form-control" />
                                </div>
                                <s:fielderror cssStyle="color: red" fieldName="reNewPassword"/>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 50px;">
                            <div class="col-sm-4 col-sm-offset-5">
                                <a href="<%=request.getContextPath()%>/system/user/list.html" class="btn btn-default">Hủy bỏ</a>
                                <button type="submit" data-loading-text="..." class="btn btn-primary">Cập nhập</button>
                            </div>
                        </div>
                    </s:form>
                </div>
            </section>
        </section>
        <%--<footer class="footer bg-white b-t b-light"><p>This is a footer</p></footer>--%>
    </section>
    <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen" data-target="#nav"></a>
</section>