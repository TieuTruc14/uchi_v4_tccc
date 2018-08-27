<%@ page isELIgnored="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script src="<%=request.getContextPath()%>/assets/js/checkbox.js"></script>
<!-- fuelux -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/note/js/fuelux/fuelux.css" type="text/css" />
<script src="<%=request.getContextPath()%>/assets/note/js/fuelux/fuelux.js"></script>
<section id="content">
    <section class="vbox">
        <section class="scrollable padder">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="<%=request.getContextPath()%>/index.html"><i class="fa fa-home"></i>&nbsp;Home</a></li>
                <li><a href="#">User</a></li>
                <li><a href="javascript:void(0)">Phần quyền</a></li>
            </ul>
            <div class="m-b-md">
                <h3 class="m-b-none">Phần quyền nhóm: "<s:property value="group.name"/>"</h3>
            </div>

            <section class="panel panel-default">
                <header class="panel-heading"><i class="fa fa-caret-square-o-right"></i>Phần quyền nhóm: "<s:property value="group.name"/>" </header>
                <div class="panel-body" style="min-height: 600px;">
                    <s:form method="post" action="grant-group-save" theme="simple"  enctype="multipart/form-data" cssClass="" cssStyle="" validate="true">
                        <s:textfield name="id" hidden="true" />
                        <%--<div class="checkbox">--%>
                            <%--<label class="checkbox-custom">--%>
                                <%--<input type="checkbox" name="grantCheckAll" >--%>
                                <%--<i class="fa fa-fw fa-square-o"></i>--%>
                                <%--TẤT CẢ QUYỀN--%>
                            <%--</label>--%>
                        <%--</div>--%>

                        <input type="checkbox" id="grantCheckAll" > <span class="text-primary">TẤT CẢ QUYỀN</span>
                        <section class="panel panel-default" style="margin-top:20px;">
                            <header class="panel-heading bg-light">
                                <ul class="nav nav-tabs nav-justified">
                                    <li class="active"><a href="#system" data-toggle="tab"><strong>QUẢN TRỊ HỆ THỐNG</strong></a></li>
                                    <li><a href="#function" data-toggle="tab"><strong>CHỨC NĂNG</strong></a></li>
                                    <li><a href="#report" data-toggle="tab" ><strong>BÁO CÁO</strong></a></li>
                                    <li><a href="#category" data-toggle="tab" ><strong>DANH MỤC</strong></a></li>
                                </ul>
                            </header>
                            <div class="panel-body"  style="padding:0px">
                                <div class="tab-content">
                                    <div class="tab-pane active" id="system">

                                        <div class="table-responsive table-overflow-x-fix">
                                            <table id="tblGroup" class="table table-striped table-bordered m-b-none text-sm">
                                                <thead>
                                                <tr>
                                                    <th class="box-shadow-inner small_col text-center"><input type="checkbox" id="checkbox_1" ></th>
                                                    <th class="box-shadow-inner small_col text-center">Chức năng</th>
                                                    <th class="box-shadow-inner small_col text-center">Xem</th>
                                                    <th class="box-shadow-inner small_col text-center hidden-xs">Thêm</th>
                                                    <th class="box-shadow-inner small_col text-center hidden-xs">Sửa</th>
                                                    <th class="box-shadow-inner small_col text-center hidden-xs">Xóa</th>
                                                </tr>
                                                </thead>
                                                <tbody>

                                                <s:iterator var="item" value="page.systems" status="stat">
                                                    <tr>
                                                        <td class="align-center text-center"><input type="checkbox" name="listSystem" value="<s:property value='#item.id'/>ALL" onchange="checkAllInRow(this)"></td>
                                                        <td class="align-center text-center"><s:property value="#item.name"/></td>

                                                        <td class="align-center text-center">
                                                            <s:if test="#item.xem">
                                                                <input type="checkbox" name="listSystem" value="<s:property value='#item.id'/>VIEW" onchange="checkChiren(this)" />
                                                            </s:if><s:else>
                                                                <i class="fa fa-times-circle" aria-hidden="true"></i>
                                                            </s:else>
                                                        </td>
                                                        <td class="align-center text-center">
                                                            <s:if test="#item.them">
                                                                <input type="checkbox" name="listSystem" value="<s:property value='#item.id'/>ADD" onchange="checkChiren(this)" />
                                                            </s:if><s:else>
                                                               <i class="fa fa-times-circle" aria-hidden="true"></i>
                                                            </s:else>
                                                        </td>
                                                        <td class="align-center text-center">
                                                            <s:if test="#item.sua">
                                                                <input type="checkbox" name="listSystem" value="<s:property value='#item.id'/>EDIT" onchange="checkChiren(this)" />
                                                            </s:if><s:else>
                                                               <i class="fa fa-times-circle" aria-hidden="true"></i>
                                                            </s:else>
                                                        </td>

                                                        <td class="align-center text-center">
                                                            <s:if test="#item.xoa">
                                                                <input type="checkbox" name="listSystem" value="<s:property value='#item.id'/>DELETE" onchange="checkChiren(this)" />
                                                            </s:if><s:else>
                                                                <i class="fa fa-times-circle" aria-hidden="true"></i>
                                                            </s:else>
                                                        </td>

                                                    </tr>
                                                </s:iterator>
                                                </tbody>
                                            </table>
                                        </div>

                                    </div>
                                    <div class="tab-pane" id="function">
                                        <div class="table-responsive table-overflow-x-fix">
                                            <table id="tblFunction" class="table table-striped table-bordered m-b-none text-sm">
                                                <thead>
                                                <tr>
                                                    <th class="box-shadow-inner small_col text-center"><input type="checkbox" id="checkbox_2" ></th>
                                                    <th class="box-shadow-inner small_col text-center">Chức năng</th>
                                                    <th class="box-shadow-inner small_col text-center">Xem</th>
                                                    <th class="box-shadow-inner small_col text-center hidden-xs">Thêm</th>
                                                    <th class="box-shadow-inner small_col text-center hidden-xs">Sửa</th>
                                                    <th class="box-shadow-inner small_col text-center hidden-xs">Xóa</th>
                                                </tr>
                                                </thead>
                                                <tbody>

                                                <s:iterator var="item" value="page.functions" status="stat">
                                                    <tr>
                                                        <td class="align-center text-center">
                                                            <input type="checkbox" name="listFunction" value="<s:property value='#item.id'/>ALL" onchange="checkAllInRow(this)">
                                                        </td>
                                                        <td class="align-center text-center"><s:property value="#item.name"/></td>

                                                        <td class="align-center text-center">
                                                            <s:if test="#item.xem">
                                                                <input type="checkbox" name="listFunction" value="<s:property value='#item.id'/>VIEW" onchange="checkChiren(this)" />
                                                            </s:if><s:else>
                                                            <i class="fa fa-times-circle" aria-hidden="true"></i>
                                                        </s:else>
                                                        </td>
                                                        <td class="align-center text-center">
                                                            <s:if test="#item.them">
                                                                <input type="checkbox" name="listFunction" value="<s:property value='#item.id'/>ADD" onchange="checkChiren(this)" />
                                                            </s:if><s:else>
                                                            <i class="fa fa-times-circle" aria-hidden="true"></i>
                                                        </s:else>
                                                        </td>
                                                        <td class="align-center text-center">
                                                            <s:if test="#item.sua">
                                                                <input type="checkbox" name="listFunction" value="<s:property value='#item.id'/>EDIT" onchange="checkChiren(this)" />
                                                            </s:if><s:else>
                                                            <i class="fa fa-times-circle" aria-hidden="true"></i>
                                                        </s:else>
                                                        </td>

                                                        <td class="align-center text-center">
                                                            <s:if test="#item.xoa">
                                                                <input type="checkbox" name="listFunction" value="<s:property value='#item.id'/>DELETE" onchange="checkChiren(this)" />
                                                            </s:if><s:else>
                                                            <i class="fa fa-times-circle" aria-hidden="true"></i>
                                                        </s:else>
                                                        </td>

                                                    </tr>
                                                </s:iterator>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="report">
                                        <div class="table-responsive table-overflow-x-fix">
                                            <table id="tblReport" class="table table-striped table-bordered m-b-none text-sm">
                                                <thead>
                                                <tr>
                                                    <th class="box-shadow-inner small_col text-center"><input type="checkbox" id="checkbox_3" ></th>
                                                    <th class="box-shadow-inner small_col text-center">Chức năng</th>
                                                    <th class="box-shadow-inner small_col text-center">Xem</th>
                                                </tr>
                                                </thead>
                                                <tbody>

                                                <s:iterator var="item" value="page.reports" status="stat">
                                                    <tr>
                                                        <td class="align-center text-center"><input type="checkbox" name="listReport" value="<s:property value='#item.id'/>ALL" onchange="checkAllInRow(this)"></td>
                                                        <td class="align-center text-center"><s:property value="#item.name"/></td>

                                                        <td class="align-center text-center">
                                                            <s:if test="#item.xem">
                                                                <input type="checkbox" name="listReport" value="<s:property value='#item.id'/>VIEW" onchange="checkChiren(this)" />
                                                            </s:if><s:else>
                                                            <i class="fa fa-times-circle" aria-hidden="true"></i>
                                                        </s:else>
                                                        </td>

                                                    </tr>
                                                </s:iterator>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>

                                    <div class="tab-pane" id="category">

                                        <div class="table-responsive table-overflow-x-fix">
                                            <table id="tblCategory" class="table table-striped table-bordered m-b-none text-sm">
                                                <thead>
                                                <tr>
                                                    <th class="box-shadow-inner small_col text-center"><input type="checkbox" id="checkbox_4" ></th>
                                                    <th class="box-shadow-inner small_col text-center">Chức năng</th>
                                                    <th class="box-shadow-inner small_col text-center">Xem</th>
                                                    <th class="box-shadow-inner small_col text-center hidden-xs">Thêm</th>
                                                    <th class="box-shadow-inner small_col text-center hidden-xs">Sửa</th>
                                                    <th class="box-shadow-inner small_col text-center hidden-xs">Xóa</th>
                                                </tr>
                                                </thead>
                                                <tbody>

                                                <s:iterator var="item" value="page.categories" status="stat">
                                                    <tr>
                                                        <td class="align-center text-center"><input type="checkbox" name="listCategory" value="<s:property value='#item.id'/>ALL" onchange="checkAllInRow(this)"></td>
                                                        <td class="align-center text-center"><s:property value="#item.name"/></td>

                                                        <td class="align-center text-center">
                                                            <s:if test="#item.xem">
                                                                <input type="checkbox" name="listCategory" value="<s:property value='#item.id'/>VIEW" onchange="checkChiren(this)" />
                                                            </s:if><s:else>
                                                            <i class="fa fa-times-circle" aria-hidden="true"></i>
                                                        </s:else>
                                                        </td>
                                                        <td class="align-center text-center">
                                                            <s:if test="#item.them">
                                                                <input type="checkbox" name="listCategory" value="<s:property value='#item.id'/>ADD" onchange="checkChiren(this)" />
                                                            </s:if><s:else>
                                                            <i class="fa fa-times-circle" aria-hidden="true"></i>
                                                        </s:else>
                                                        </td>
                                                        <td class="align-center text-center">
                                                            <s:if test="#item.sua">
                                                                <input type="checkbox" name="listCategory" value="<s:property value='#item.id'/>EDIT" onchange="checkChiren(this)" />
                                                            </s:if><s:else>
                                                            <i class="fa fa-times-circle" aria-hidden="true"></i>
                                                        </s:else>
                                                        </td>

                                                        <td class="align-center text-center">
                                                            <s:if test="#item.xoa">
                                                                <input type="checkbox" name="listCategory" value="<s:property value='#item.id'/>DELETE" onchange="checkChiren(this)" />
                                                            </s:if><s:else>
                                                            <i class="fa fa-times-circle" aria-hidden="true"></i>
                                                        </s:else>
                                                        </td>

                                                    </tr>
                                                </s:iterator>
                                                </tbody>
                                            </table>
                                        </div>

                                    </div>

                                </div>
                            </div>
                        </section>



                        <div class="line line-dashed line-lg pull-in" style="clear:both ;margin-bottom: 50px"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-5">

                                <button type="submit" data-loading-text="..." class="btn btn-primary">Cập nhập</button>
                                <a href="<%=request.getContextPath()%>/system/grant/list.html" class="btn btn-default">Hủy bỏ</a>
                            </div>
                        </div>
                    </s:form>

                </div>
            </section>
        </section>

    </section>
    <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen" data-target="#nav"></a>
</section>
<script>
    $(document).ready(function () {
        /*Quy uoc cha con cho checkbox*/
        $('#grantCheckAll').checkboxes({
            itemChild: 'list'
        });
        $('#checkbox_1').checkboxes({
            itemChild: 'listSystem'
        });
        $('#checkbox_2').checkboxes({
            itemChild: 'listFunction'
        });
        $('#checkbox_3').checkboxes({
            itemChild: 'listReport'
        });
        $('#checkbox_4').checkboxes({
            itemChild: 'listCategory'
        });

        /*load quyen*/
        var systems = "<s:property value="page.listSystem"/>".split(",");
        var functions = "<s:property value="page.listFunction"/>".split(",");
        var reports = "<s:property value="page.listReport"/>".split(",");
        var categories = "<s:property value="page.listCategory"/>".split(",");
        $("input[name='listSystem']").each(function() {
            for(var i=0; i<systems.length;i++){
                if(systems[i] == this.value) {
                    $(this).prop('checked', true);
                }
            }
        });
        $("input[name='listFunction']").each(function() {
            for(var i=0; i<functions.length;i++){
                if(functions[i] == this.value) {
                    $(this).prop('checked', true);
                }
            }
        });
        $("input[name='listReport']").each(function() {
            for(var i=0; i<reports.length;i++){
                if(reports[i] == this.value) {
                    $(this).prop('checked', true);
                }
            }
        });
        $("input[name='listCategory']").each(function() {
            for(var i=0; i<categories.length;i++){
                if(categories[i] == this.value) {
                    $(this).prop('checked', true);
                }
            }
        });

        //kiem tra cac checkbox trong bang dc check toan bo chua.
        function checkValuecb_1(){
            var result=true;
            $("input[name='listSystem']").each(function() {
                if(!$(this).is(':checked')){
                    result=false;
                    return result;
                }

            });
            return result;
        }
        function checkValuecb_2(){
            var result=true;
            $("input[name='listFunction']").each(function() {
                if(!$(this).is(':checked')){
                    result=false;
                    return result;
                }

            });
            return result;
        }
        function checkValuecb_3(){
            var result=true;
            $("input[name='listReport']").each(function() {
                if(!$(this).is(':checked')){
                    result=false;
                    return result;
                }

            });
            return result;
        }
        function checkValuecb_4(){
            var result=true;
            $("input[name='listCategory']").each(function() {
                if(!$(this).is(':checked')){
                    result=false;
                    return result;
                }

            });
            return result;
        }
        var checkcb1=checkValuecb_1();
        var checkcb2=checkValuecb_2();
        var checkcb3=checkValuecb_3();
        var checkcb4=checkValuecb_4();
        if(checkcb1){
            $('#checkbox_1').prop('checked', true);
        }
        if(checkcb2){
            $('#checkbox_2').prop('checked', true);
        }
        if(checkcb3){
            $('#checkbox_3').prop('checked', true);
        }
        if(checkcb4){
            $('#checkbox_4').prop('checked', true);
        }
        if(checkcb1 && checkcb2 && checkcb3 && checkcb4){
            $('#grantCheckAll').prop('checked', true);
        }

        //WHEN change value of checkbox group
        $("#checkbox_1").change(function() {
            if(this.checked) {
                if($('#checkbox_1').is(':checked') && $('#checkbox_2').is(':checked') && $('#checkbox_3').is(':checked') && $('#checkbox_4').is(':checked')){
                    $('#grantCheckAll').prop('checked',true);
                }
            }else{
                $('#grantCheckAll').prop('checked',false);
            }
        });
        $("#checkbox_2").change(function() {
            if(this.checked) {
                if($('#checkbox_1').is(':checked') && $('#checkbox_2').is(':checked') && $('#checkbox_3').is(':checked') && $('#checkbox_4').is(':checked')){
                    $('#grantCheckAll').prop('checked',true);
                }
            }else{
                $('#grantCheckAll').prop('checked',false);
            }
        });
        $("#checkbox_3").change(function() {
            if(this.checked) {
                if($('#checkbox_1').is(':checked') && $('#checkbox_2').is(':checked') && $('#checkbox_3').is(':checked') && $('#checkbox_4').is(':checked')){
                    $('#grantCheckAll').prop('checked',true);
                }
            }else{
                $('#grantCheckAll').prop('checked',false);
            }
        });
        $("#checkbox_4").change(function() {
            if(this.checked) {
                if($('#checkbox_1').is(':checked') && $('#checkbox_2').is(':checked') && $('#checkbox_3').is(':checked') && $('#checkbox_4').is(':checked')){
                    $('#grantCheckAll').prop('checked',true);
                }
            }else{
                $('#grantCheckAll').prop('checked',false);
            }
        });

        /*Change grantCheckAll*/
        $("#grantCheckAll").change(function() {
            if(this.checked) {
                $('#checkbox_1').prop('checked', true);
                $('#checkbox_2').prop('checked', true);
                $('#checkbox_3').prop('checked', true);
                $('#checkbox_4').prop('checked', true);
            }else{
                $('#checkbox_1').prop('checked', false);
                $('#checkbox_2').prop('checked', false);
                $('#checkbox_3').prop('checked', false);
                $('#checkbox_4').prop('checked', false);
            }
        });
    });

    function checkAllInRow(e){
        if($(e).is(':checked')) $(e).parent().parent().find("input:checkbox").each(function() {
            $(this).prop('checked', true);
        });
        else $(e).parent().parent().find("input:checkbox").each(function() {
            $(this).prop('checked', false);
        });
    }

    function checkChiren(e) {
        if($(e).is(':checked')){
            var check=checkAllValue();
            if(check){
                $(e).parent().parent().find("input:checkbox").each(function(i) {
                    if(i==0){
                        $(this).prop('checked', true);
                    }
                });
            }
        }
        else{
            $(e).parent().parent().find("input:checkbox").each(function(i) {
                if(i==0){
                    $(this).prop('checked', false);
                }
            });
        }

        function checkAllValue() {
            var result=true;
            $(e).parent().parent().find("input[type='checkbox']").each(function(i) {
                //ko tinh doi tuong dau tien: item_ALL
                if(!$(this).is(':checked')){
                    if(i>0){
                        result= false;
                    }
                }
            });
            return result;
        }
    }

</script>