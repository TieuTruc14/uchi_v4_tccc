<%@ page isELIgnored="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<section id="content">
    <section class="vbox">
        <section class="scrollable padder">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="<%=request.getContextPath()%>/index.html"><i class="fa fa-home"></i>&nbsp;Home</a></li>
                <li><a href="<%=request.getContextPath()%>/category/bank/list.html">Bank</a></li>
                <li><a href="javascript:void(0)">Thông tin ngân hàng</a></li>
            </ul>
            <div class="m-b-md">
                <h3 class="m-b-none">Thông tin ngân hàng </h3>
            </div>

            <section class="panel panel-default">
                <header class="panel-heading"><i class="fa fa-caret-square-o-right"></i> Thông tin ngân hàng
                    "<s:property value="item.title"/>"
                </header>
                <div class="panel-body">
                    <s:hidden name="item.id"/>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="line-height: 30px">Tên ngân hàng</label>
                        <div class="col-sm-10">
                            <div class="input-group m-b" style="width: 100%">
                                <span class="input-group-addon">
                                    <i class="fa fa-book" ></i>
                                </span>
                                <s:textfield name="item.name" maxlength="200" cssStyle="width:100%;"
                                             placeholder="Họ và tên" cssClass="form-control" disabled="true"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="line-height: 30px">Mã Ngân hàng</label>
                        <div class="col-sm-10">
                            <div class="input-group m-b" style="width: 100%">
                                <span class="input-group-addon">
                                    <i class="fa fa-tag" aria-hidden="true"></i>
                                </span>
                                <s:textfield name="item.code" maxlength="200" cssStyle="width:100%;"
                                             placeholder="Họ và tên" cssClass="form-control" disabled="true"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="line-height:30px ">Trạng thái hoạt động</label>
                        <%--<select name="item.disable" >
                            <option value="0" <s:property value='%{item.disable ==0?"selected":""}'/> >Ngưng hoạt động</option>
                            <option value="1" <s:property value='%{item.disable ==1?"selected":""}'/> > Đang hoạt động</option>
                        </select>--%>
                        <div class="col-sm-10">
                            <input type="radio" name="item.disable" class="truong-radio-vertical" <s:property value="%{item.disable==0?'checked':''}"/> disabled ><span class="truong-color-red">Đang hoạt động</span>
                            <input type="radio" name="item.disable" class="truong-radio-vertical-right" <s:property value="%{item.disable==1?'checked':''}"/> disabled >Ngưng hoạt đông
                        </div>


                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>



                    <div class="line line-dashed line-lg pull-in" style="clear:both ;margin-bottom: 50px"></div>
                    <div class="form-group">
                        <div class="col-sm-12" style="text-align: center">
                            <%--<a href="<%=request.getContextPath()%>/category/manual/edit.html?id=<s:property value="item.id"/> "
                               class="btn btn-primary">Chỉnh sửa</a>--%>
                            <a href="<%=request.getContextPath()%>/category/bank/list.html" class="btn btn-default">Quay lại
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
<link rel="stylesheet" href="/assets/css/style.css" type="text/css"/>
<script src="/assets/js/eternicode-bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script>
    $(document).ready(function () {
        var contentHtml= $('#contentCk').text();

        $('#editor').html(contentHtml);
    });
</script>
<script>


    $(document).ready(function () {
        var checkSex = <s:property value="item.sex"/>;
        if (checkSex == 'false') {
            $("#nam").selected(true);
            $('#nam').prop("checked", true);
        } else if (checkSex == 'true') {
            $("#nu").selected(true);
            $('#nu').prop("checked", true);
        }
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
<script src="<%=request.getContextPath()%>/assets/note/js/wysiwyg/jquery.hotkeys.js"></script>
<script src="<%=request.getContextPath()%>/assets/note/js/wysiwyg/bootstrap-wysiwyg.js"></script>
<script src="<%=request.getContextPath()%>/assets/note/js/wysiwyg/demo.js"></script>