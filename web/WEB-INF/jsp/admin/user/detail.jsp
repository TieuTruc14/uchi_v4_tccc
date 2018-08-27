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
                <li><a href="<%=request.getContextPath()%>/system/user/list.html">User</a></li>
                <li><a href="javascript:void(0)">Thông tin tài khoản</a></li>
            </ul>
            <div class="m-b-md">
                <h3 class="m-b-none">Thông tin tài khoản </h3>
            </div>

            <section class="panel panel-default">
                <header class="panel-heading"><i class="fa fa-caret-square-o-right"></i> Thông tin tài khoản
                    "<s:property value="item.username"/>"
                </header>
                <div class="panel-body" style="min-height: 550px">
                    <s:hidden name="item.id"/>
                    <input type="hidden" id="SelectedUserPosition" value="<s:property value="item.position"/>"/>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="line-height: 30px">Họ tên</label>
                        <div class="col-sm-10">
                            <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-user" aria-hidden="true"></i>
                                        </span>
                                <s:textfield name="item.name" maxlength="100" cssStyle="width:100%;"
                                             placeholder="Họ và tên" cssClass="form-control" disabled="true"/>
                            </div>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="line-height: 30px">Tài khoản</label>
                        <div class="col-sm-10">
                            <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-users" aria-hidden="true" style="font-size: 10px"></i>
                                        </span>
                                <s:textfield name="item.username" maxlength="100" cssStyle="width:100%;"
                                             cssClass="form-control" disabled="true"/>
                            </div>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="line-height: 30px">Email</label>
                        <div class="col-sm-10">
                            <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-envelope" style="font-size: 11px" aria-hidden="true"></i>
                                        </span>
                                <s:textfield name="item.email" cssStyle="width:100%;" cssClass="form-control"
                                             disabled="true"/>
                            </div>
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
                                                     placeholder="Số điện thoại" cssClass="form-control"
                                                     disabled="true"/>
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
                                        <s:textfield name="item.address" maxlength="15" cssStyle="width:100%;"
                                                     placeholder="Địa chỉ" cssClass="form-control" disabled="true"/>
                                    </div>
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
                                                     cssClass="form-control" disabled="true"/>
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
                                        <%--<input id="SelectedUserRole" value="3,5,7"/>

                                        <select id="UserRole" multiple style="width: 200px">
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                            <option>6</option>
                                            <option>7</option>
                                        </select>--%>
                                        <select data-placeholder="Chức vụ" name="position" id="test" class="test form-control" multiple disabled>
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
                                             placeholder="Số chứng minh nhân dân" cssClass="form-control" disabled="true"/>
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
                                        <s:if test="%{item.disable == true}">
                                            <s:radio list="#{'true':'Hoạt động','false':'Ngừng hoạt động'}" name="item.disable" value="true" disabled="true"/>
                                        </s:if>
                                        <s:else>
                                            <s:radio list="#{'true':'Hoạt động','false':'Ngừng hoạt động'}" name="item.disable" value="false" disabled="true"/>
                                        </s:else>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="col-sm-4 control-label" style="line-height: 30px">Giới tính</label>
                                <div class="col-sm-8">
                                    <div class="input-group m-b">
                                        <s:if test="%{item.sex == true}">
                                            <s:radio list="#{'true':'Nam','false':'Nữ'}" name="item.sex" value="true" disabled="true"/>
                                        </s:if>
                                        <s:else>
                                            <s:radio list="#{'true':'Nam','false':'Nữ'}" name="item.sex" value="false" disabled="true"/>
                                        </s:else>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group">

                        <div class="col-sm-12" style="text-align: center">
                            <a href="<%=request.getContextPath()%>/system/user/edit.html?id=<s:property value="item.id"/> "
                               class="btn btn-primary">Chỉnh sửa</a>
                            <a href="<%=request.getContextPath()%>/system/user/list.html" class="btn btn-default">Quay lại
                                danh
                                sách</a>
                        </div>
                    </div>
                </div>
            </section>
        </section>
        <%--<footer class="footer bg-white b-t b-light"><p>This is a footer</p></footer>--%>
    </section>
    <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen" data-target="#nav"></a>
</section>

<link rel="stylesheet" href="/assets/js/eternicode-bootstrap-datepicker/css/datepicker.css" type="text/css"/>
<script src="/assets/js/eternicode-bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script src="<%=request.getContextPath()%>/assets/chosen2/chosen.jquery.js"></script>
<script>
    $(function(){
        $('#test').chosen();
    })
    $(document).ready(function () {
        var selectedUserPosition = $('#SelectedUserPosition').val();
        var str_array = selectedUserPosition.split(',');
        for (var i = 0; i < str_array.length; i++) {
            str_array[i] = str_array[i].replace(/^\s*/, "").replace(/\s*$/, "");
        }
        $("#test").val(str_array).trigger("chosen:updated");
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

    $(function(){
        $('#UserRole').chosen();
    })

    $(document).ready(function () {
        var selectedUserRole = document.getElementById('SelectedUserRole').value;

        var str_array = selectedUserRole.split(',');

        for (var i = 0; i < str_array.length; i++) {
            str_array[i] = str_array[i].replace(/^\s*/, "").replace(/\s*$/, "");
        }

        $("#UserRole").val(str_array).trigger("chosen:updated");
    });
</script>