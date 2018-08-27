<%@ page isELIgnored="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%--<script>
    $(function() {
        $( "#datetimepicker" ).datepicker({
            changeMonth: true,
            changeYear: true
        });
    });
</script>--%>
<section id="content">
    <section class="vbox">
        <section class="scrollable padder">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="<%=request.getContextPath()%>/index.html"><i class="fa fa-home"></i>&nbsp;Home</a></li>
                <li><a href="<%=request.getContextPath()%>/system/config/view.html">Config</a></li> <li><a href="javascript:void(0)">Cấu hình tham số sao lưu khởi tạo</a></li>
            </ul>
            <div class="m-b-md">
                <h3 class="m-b-none">Cấu hình tham số sao lưu khởi tạo </h3>
            </div>

            <section class="panel panel-default">
                <header class="panel-heading"><i class="fa fa-caret-square-o-right"></i>Thông tin cấu hình lưu trữ dữ liệu sao lưu khởi tạo ""</header>
                <div class="panel-body" style="overflow: scroll;min-height: 500px;">
                    <s:form method="post"  action="init-edit-save" cssClass="form-horizontal" theme="simple" cssStyle="">


                        <div class="form-group">
                            <label class="col-sm-2 control-label label-bam-trai" style="line-height: 30px">Thư mục lưu trữ </label>
                            <div class="col-sm-10">
                                <div class="input-group m-b" style="width: 100%">
                                        <span class="input-group-addon">
                                            <i class="fa fa-folder" aria-hidden="true"></i>
                                        </span>
                                    <s:textfield name="cfBackup.pathBackUp" maxlength="150" cssStyle="width:100%;"
                                                 cssClass="form-control"/>
                                </div>
                                    <%--<s:fielderror cssStyle="color: red" fieldName="item.title"/>--%>
                            </div>
                        </div>
                        <%--<div class="form-group">
                            <label class="col-md-2 control-label label-bam-trai">Trạng thái sao lưu</label>
                            <div class="col-md-9">
                                <label id="label-red"class="radio-inline prevent-type truong-radio-padding">
                                    <input type="radio" name="checkBackup" value="true" id="radio-red" <s:property value="%{cfBackup.checkBackup == true?'checked':''}"/>  ><span id="span-yellow" class="">Đang hoạt động</span>
                                </label>
                                <label id = "label-yellow" class="radio-inline truong-radio-padding ">
                                    <input type="radio" name="checkBackup" value="false" id="radio-yellow" <s:property value="%{cfBackup.checkBackup != true?'checked':''}"/> ><span id="span-red" class="">Ngừng hoạt động</span>
                                </label>
                            </div>
                        </div>--%>
                        <div class="form-group">
                            <label class="col-md-2 control-label label-bam-trai">Thời gian sao lưu</label>
                            <div class="col-md-2">
                                <div class="input-group m-b" style="width: 100%">
                                        <span class="input-group-addon">
                                            <i class="fa fa-clock-o" aria-hidden="true"></i>
                                        </span>
                                    <s:textfield name="cfBackup.backupTime" maxlength="150" cssStyle="width:100%;"
                                                 cssClass="form-control" id="single-input"/>
                                </div>

                            </div>

                        </div>


                        <div class="form-group">
                            <label class="col-md-2 control-label label-bam-trai">Email</label>
                            <div class="col-md-10">
                                <div class="input-group m-b" style="width: 100%">
                                        <span class="input-group-addon">
                                            <i class="fa fa-envelope" aria-hidden="true"></i>
                                        </span>
                                    <s:textfield name="cfBackup.email" maxlength="150" cssStyle="width:100%;"
                                                 cssClass="form-control" />
                                        <%--<input type="text" class="form-control" id="tokenfield" name="email" value="${cfBackup.email}">--%>
                                </div>
                            </div>

                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label  label-bam-trai">Lịch sao lưu</label>
                            <div class="col-md-6 control-label label-bam-trai truong-font-chu">
                                <input type="checkbox" class="selectAll truong-check-fix">
                                Tất cả các ngày trong tuần
                                <ul style="list-style:none">
                                    <li><input class="truong-check-fix truong-check-fixmg cb01" type="checkbox" value="true" name="cfBackup.mon" <s:property value="%{cfBackup.mon == true?'checked':''}"/> >Thứ 2</li>
                                    <li><input class="truong-check-fix truong-check-fixmg cb01" type="checkbox" value="true" name="cfBackup.tue" <s:property value="%{cfBackup.tue == true?'checked':''}"/> >Thứ 3</li>
                                    <li><input class="truong-check-fix truong-check-fixmg cb01" type="checkbox" value="true" name="cfBackup.wed" <s:property value="%{cfBackup.wed == true?'checked':''}"/> >Thứ 4</li>
                                    <li><input class="truong-check-fix truong-check-fixmg cb01" type="checkbox" value="true" name="cfBackup.thu" <s:property value="%{cfBackup.thu == true?'checked':''}"/> >Thứ 5</li>
                                    <li><input class="truong-check-fix truong-check-fixmg cb01" type="checkbox" value="true" name="cfBackup.fri" <s:property value="%{cfBackup.fri == true?'checked':''}"/> >Thứ 6</li>
                                    <li><input class="truong-check-fix truong-check-fixmg cb01" type="checkbox" value="true" name="cfBackup.sat" <s:property value="%{cfBackup.sat == true?'checked':''}"/> >Thứ 7</li>
                                    <li><input class="truong-check-fix truong-check-fixmg cb01" type="checkbox" value="true" name="cfBackup.sun" <s:property value="%{cfBackup.sun == true?'checked':''}"/> >Chủ nhật</li>
                                </ul>
                            </div>
                        </div>


                        <div class="line line-dashed line-lg pull-in"></div>




                        <div class="line line-dashed line-lg pull-in" style="clear:both ;margin-bottom: 50px"></div>
                        <div class="form-group">
                            <div class="col-md-12" style="text-align: center">
                                <a href="<%=request.getContextPath()%>/system/config/list.html" class="btn btn-default">Hủy bỏ</a>
                                <button type="submit" data-loading-text="Cập nhập"  class="btn btn-primary">Cập nhập</button>
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
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/clockpicker.min.css"  type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/jquery-clockpicker.min.css"  type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css" type="text/css"/>
<script src="<%=request.getContextPath()%>/assets/js/jquery-clockpicker.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/js/eternicode-bootstrap-datepicker/css/datepicker.css" type="text/css"/>
<script src="<%=request.getContextPath()%>/assets/js/eternicode-bootstrap-datepicker/js/bootstrap-datepicker.js"></script>

<script>


</script>

<script>
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
<script>

    $('input:radio').click(function(){
        if($('#radio-red:checked').length > 0){
            $('#label-red').addClass('truong-bgcolor-red');
            $('#span-yellow').addClass('truong-text-coloryl');
            $('#label-yellow').removeClass('truong-bgcolor-yellow');
            $('#span-red').removeClass('truong-text-colorred');
        }

        else{
            $('#label-yellow').addClass('truong-bgcolor-yellow');
            $('#span-red').addClass('truong-text-colorred');
            $('#label-red').removeClass('truong-bgcolor-red');
            $('#span-yellow').removeClass('truong-text-coloryl');
        }
    });
    $(document).ready(function () {
        if($('#radio-red:checked').length > 0){
            $('#label-red').addClass('truong-bgcolor-red');
            $('#span-yellow').addClass('truong-text-coloryl');
            $('#label-yellow').removeClass('truong-bgcolor-yellow');
            $('#span-red').removeClass('truong-text-colorred');
        }

        else{
            $('#label-yellow').addClass('truong-bgcolor-yellow');
            $('#span-red').addClass('truong-text-colorred');
            $('#label-red').removeClass('truong-bgcolor-red');
            $('#span-yellow').removeClass('truong-text-coloryl');
        }
    });

</script>
<script type="text/javascript">

    $('.clockpicker').clockpicker()
        .find('input').change(function(){
        console.log(this.value);
    });
    $('#single-input').clockpicker({
        placement: 'bottom',
        align: 'right',
        autoclose: true,
        'default': '20:48'
    });
    $('.clockpicker-with-callbacks').clockpicker({
        donetext: 'Done',
        init: function() {
            console.log("colorpicker initiated");
        },
        beforeShow: function() {
            console.log("before show");
        },
        afterShow: function() {
            console.log("after show");
        },
        beforeHide: function() {
            console.log("before hide");
        },
        afterHide: function() {
            console.log("after hide");
        },
        beforeHourSelect: function() {
            console.log("before hour selected");
        },
        afterHourSelect: function() {
            console.log("after hour selected");
        },
        beforeDone: function() {
            console.log("before done");
        },
        afterDone: function() {
            console.log("after done");
        }
    })
        .find('input').change(function(){
        console.log(this.value);
    });
    if (/Mobile/.test(navigator.userAgent)) {
        $('input').prop('readOnly', true);
    }
</script>
<script>
    /*$('.selectAll').click(function(){
     $('input:checkbox').not(this).prop('checked', this.checked);
     });*/

    function checkedValue(element, bool) {
        if (bool) {
            return element.each(function() {
                $(this).prop('checked', true);
            });
        } else {
            return element.each(function() {
                $(this).prop('checked', false);
            });
        }
    }
    $('.selectAll').change(function() {
        var $self = $(this);

        if ($self.is(':checked')) {
            checkedValue($('.cb01'), true);
        } else {
            checkedValue($('.cb01'), false);
        }
    });

    // Checked parent checkbox when all child checkbox checked
    $('.cb01').change(function() {
        var flag = true;

        if (!$('.cb01').is(':checked')) {
            console.log(!$('.cb01').is(':checked'));
            $('.selectAll').prop('checked', false);
        }

        $('.cb01').each(function() {
            var $self = $(this);
            if (!$self.is(':checked')) {
                flag = false;
                return;
            }
        });

        $('.selectAll').prop('checked', flag);
    });
    $(window).on('load',function () {
        var flag = true;

        if (!$('.cb01').is(':checked')) {
            console.log(!$('.cb01').is(':checked'));
            $('.selectAll').prop('checked', false);
        }

        $('.cb01').each(function() {
            var $self = $(this);
            if (!$self.is(':checked')) {
                flag = false;
                return;
            }
        });
        $('.selectAll').prop('checked', flag);
    });
</script>

