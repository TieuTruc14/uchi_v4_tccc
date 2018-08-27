<%@ page isELIgnored="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/chosen2/chosen.css" />
<section id="content">
    <section class="vbox">
        <section class="scrollable padder">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="<%=request.getContextPath()%>/index.html"><i class="fa fa-home"></i>&nbsp;Home</a></li>
                <li><a href="#">User</a></li>
                <li><a href="javascript:void(0)">Thêm tài khoản</a></li>
            </ul>
            <div class="m-b-md">
                <h3 class="m-b-none">Thêm mới tài khoản </h3>
            </div>
            <s:if test="actionErrors.contains('action.error.permission')">
                <div class="alert"><i class="fa fa-info-sign"></i>
                    <code><s:property value="getTitleText('fms.failed.authority')"/></code>
                </div>
            </s:if>
            <section class="panel panel-default">
                <header class="panel-heading"><i class="fa fa-caret-square-o-right"></i>Thêm tài khoản</header>
                <div class="panel-body" style="min-height: 600px;">
                    <s:form method="post" action="add-save" theme="simple"  enctype="multipart/form-data" cssClass="" cssStyle="" validate="true">
                        <div class="form-group">
                            <label class="col-sm-2 control-label" style="line-height: 30px">Họ tên <span style="color: red">*</span></label>
                            <div class="col-sm-10">
                                <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-user" aria-hidden="true"></i>
                                        </span>
                                    <s:textfield name="item.name" maxlength="100" cssStyle="width:100%;"
                                                 placeholder="Họ và tên" cssClass="form-control"/>

                                </div>
                                <s:fielderror cssStyle="color: red" fieldName="item.name"/>
                            </div>
                        </div>
                        <div class="line line-dashed line-lg pull-in"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" style="line-height: 30px">Tài khoản <span style="color: red">*</span></label>
                            <div class="col-sm-10">
                                <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-users" aria-hidden="true" style="font-size: 10px"></i>
                                        </span>
                                    <s:textfield name="item.username" placeholder="Tài khoản" maxlength="100" cssStyle="width:100%;"
                                                 cssClass="form-control"/>
                                </div>
                                <s:fielderror cssStyle="color: red" fieldName="item.username"/>
                            </div>
                        </div>
                        <div class="line line-dashed line-lg pull-in"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" style="line-height: 30px">Email <span style="color: red">*</span></label>
                            <div class="col-sm-10">
                                <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-envelope" style="font-size: 11px" aria-hidden="true"></i>
                                        </span>
                                    <s:textfield name="item.email" placeholder="Email" cssStyle="width:100%;" cssClass="form-control"/>
                                </div>
                                <s:fielderror cssStyle="color: red" fieldName="item.email"/>
                            </div>
                        </div>
                        <div class="line line-dashed line-lg pull-in"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Mật khẩu <span style="color: red">*</span></label>
                            <div class="col-sm-10">
                                <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-lock"></i>
                                        </span>
                                    <s:password name="item.password" type="password" maxlength="50" cssStyle="width:100%;" placeholder="Mật khẩu" cssClass="form-control" />
                                </div>
                                <s:fielderror cssStyle="color: red" fieldName="item.password"/>
                            </div>
                        </div>
                        <div class="line line-dashed line-lg pull-in"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Xác nhận mật khẩu <span style="color: red">*</span></label>
                            <div class="col-sm-10">
                                <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-lock"></i>
                                        </span>
                                    <s:password name="confirmPassword" maxlength="50" cssStyle="width:100%;" placeholder="Xác nhận mật khẩu" cssClass="form-control" />
                                </div>
                                <s:fielderror cssStyle="color: red" fieldName="confirmPassword"/>
                            </div>
                        </div>
                        <div class="line line-dashed line-lg pull-in"></div>
                        <div class="form-group pull-in ">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-4 control-label" style="line-height: 30px">Số điện
                                        thoại</label>
                                    <div class="col-sm-8">
                                        <div class="input-group m-b" style="padding-left: 5px">
                                        <span class="input-group-addon">
                                            <i class="fa fa-phone"></i>
                                        </span>
                                            <s:textfield name="item.phone" maxlength="15" cssStyle="width:100%;"
                                                         placeholder="Số điện thoại" cssClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-4 control-label" style="line-height: 30px">Địa chỉ</label>
                                    <div class="col-sm-8">
                                        <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-home"></i>
                                        </span>
                                            <s:textfield name="item.address" maxlength="255" cssStyle="width:100%;"
                                                         placeholder="Địa chỉ" cssClass="form-control"/>
                                        </div>
                                        <s:fielderror cssStyle="color: red" fieldName="item.phone"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="line line-dashed line-lg pull-in"></div>
                        <div class="form-group pull-in">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-4 control-label" style="line-height: 30px">Ngày sinh</label>
                                    <div class="col-sm-8">
                                        <div class="input-group m-b" style="padding-left: 5px">
                                        <span class="input-group-addon">
                                            <i class="fa fa-birthday-cake" style="font-size: 10px"></i>
                                        </span>
                                            <s:textfield name="item.birthday" placeholder="Ngày sinh" id="datetimepicker" maxlength="15" cssStyle="width:100%;"
                                                         cssClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-4 control-label" style="line-height: 30px">Chức vụ</label>
                                    <div class="col-sm-8">
                                        <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-birthday-cake" style="font-size: 10px"></i>
                                        </span>
                                            <select data-placeholder="Chức vụ" name="position" id="test" class="form-control" multiple>
                                                <option value = "01">Quản lí</option>
                                                <option value = "02">Công chứng viên</option>
                                                <option value = "03">Chuyên viên soạn thảo</option>
                                                <option value = "04">Văn thư, thủ quỹ</option>
                                                <option value = "99">Khác</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="l" style="clear: both"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" style="line-height: 30px">Số chứng minh</label>
                            <div class="col-sm-10">
                                <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-user" aria-hidden="true"></i>
                                        </span>
                                    <s:textfield name="item.passport" maxlength="100" cssStyle="width:100%;"
                                                 placeholder="Số chứng minh nhân dân" cssClass="form-control"/>
                                </div>
                                <s:fielderror cssStyle="color: red" fieldName="item.passport"/>
                            </div>
                        </div>
                        <div class="line line-dashed line-lg pull-in"></div>
                        <div class="form-group pull-in" style="clear: both">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-4 control-label" style="line-height: 30px">Trạng thái hoạt động</label>
                                    <div class="col-sm-8">
                                        <div class="input-group m-b">
                                                <s:radio list="#{'true':'Hoạt động','false':'Ngừng hoạt động'}" name="item.disable" value="true"></s:radio>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-4 control-label" style="line-height: 30px">Giới tính</label>
                                    <div class="col-sm-8">
                                        <div class="input-group m-b">
                                                <s:radio list="#{'true':'Nam','false':'Nữ'}" name="item.sex" value="true"></s:radio>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="line line-dashed line-lg pull-in" style="clear:both ;margin-bottom: 50px"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-5">
                                <a href="<%=request.getContextPath()%>/system/user/list.html" class="btn btn-default">Hủy bỏ</a>
                                <button type="submit" data-loading-text="Thêm mới" class="btn btn-primary">Thêm mới</button>
                            </div>
                        </div>
                    </s:form>

                </div>
            </section>
        </section>
        <footer class="footer bg-white b-t b-light"><p>This is a footer</p></footer>
    </section>
    <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen" data-target="#nav"></a>
</section>

<link rel="stylesheet" href="/assets/js/eternicode-bootstrap-datepicker/css/datepicker.css" type="text/css"/>
<script src="/assets/js/eternicode-bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script src="<%=request.getContextPath()%>/assets/chosen2/chosen.jquery.js"></script>
<script>
    $(function() {
        $('#test').chosen({
            disable_search_threshold: 10,
            no_results_text: "Không tìm kiếm được kết quả: ",
            width: "100%"
        });
        $('#test').trigger('chosen:updated');

    });
    $(document).ready(function () {
        $('.input-daterange').datepicker({
            format: "dd/mm/yyyy",
            startDate: "2012/01/01",
            endDate: "",
            todayBtn: "linked",
            calendarWeeks: false,
            autoclose: true,
            todayHighlight: true
        });
    });
</script>