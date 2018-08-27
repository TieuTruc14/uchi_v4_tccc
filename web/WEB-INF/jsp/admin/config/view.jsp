<%@ page isELIgnored="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%--<script src="<%=request.getContextPath()%>/assets/ckeditor/ckeditor.js"></script>--%>

<section id="content">
    <section class="vbox">
        <section class="scrollable padder">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="<%=request.getContextPath()%>/index.html"><i class="fa fa-home"></i>&nbsp;Home</a></li>
                <li><a href="#">Config</a></li> <li><a href="javascript:void(0)">Cấu hình tham số sao lưu</a></li>
            </ul>
            <div class="m-b-md">
                <h3 class="m-b-none">Cấu hình tham số sao lưu </h3>
            </div>
            <s:if test="actionErrors.contains('action.error.permission')">
                <div class="alert"> <i class="fa fa-info-sign"></i>
                    <code><s:property value="getTitleText('fms.failed.authority')"/></code>
                </div>
            </s:if>
            <section class="panel panel-default">
                <header class="panel-heading"><i class="fa fa-caret-square-o-right"></i>Thông tin cấu hình lưu trữ dữ liệu sao lưu"<s:property value="${message}"/> "</header>
                <div class="panel-body">
                    <s:form method="post" id="form-submit" action="add-save" theme="simple"  cssClass="form-horizontal" cssStyle="" >
                        <table class="table " >
                            <tr class="border-table">
                                <th class="border-table col-md-3 ann-title" >Thư mục lưu trữ dữ liệu sao lưu</th>
                                <td class="border-table"><s:property value="cfBackup.pathBackUp"/> </td>
                            </tr>
                            <tr class="border-table">
                                <th class="border-table col-md-3 ann-title">Lịch sao lưu</th>
                                <td class="border-table">
                                        <s:property value="%{cfBackup.mon ==true?'- Thứ 2 ':''}"/>
                                    <s:property value="%{cfBackup.tue ==true?'- Thứ 3 ':''}"/>
                                    <s:property value="%{cfBackup.wed ==true?'- Thứ 4 ':''}"/>
                                    <s:property value="%{cfBackup.thu ==true?'- Thứ 5 ':''}"/>
                                    <s:property value="%{cfBackup.fri ==true?'- Thứ 6 ':''}"/>
                                    <s:property value="%{cfBackup.sat ==true?'- Thứ 7 ':''}"/>
                                    <s:property value="%{cfBackup.sun ==true?'- Chủ nhật ':''}"/>

                                </td>
                            </tr>
                            <tr class="border-table">
                                <th class="border-table col-md-3 ann-title">Thời gian sao lưu</th>
                                <td class="border-table"> <s:property value="cfBackup.backupTime"/> </td>
                            </tr>
                            <tr class="border-table">
                                <th class="border-table col-md-3 ann-title">Danh sách gửi mail</th>
                                <td class="border-table"><s:property value="cfBackup.email"/> </td>
                            </tr>
                        </table>
                        <div class="form-group">
                            <div class="col-md-4">
                                <div class="row">
                                    <label class="col-md-5 control-label label-bam-trai">Trạng thái sao lưu</label>


                                    <label class="control-label  truong-text-radior col-md-6"><span class="truong-text-coloryl">Cho phép sao lưu dữ liệu</span></label>
                                </div>
                            </div>
                        </div>






                        <div class="line line-dashed line-lg pull-in"></div>
                        <div class="form-group">
                            <div class="col-sm-12" style="text-align: center">
                                <a href="<%=request.getContextPath()%>/system/config/edit.html" class="btn btn-primary">Chỉnh sửa</a>
                                <%--<a href="<%=request.getContextPath()%>/system/config/back-up-now.html" class="btn btn-primary">Sao lưu dữ liệu đột xuất</a>--%>
                                <a data-toggle="modal" data-target="#myModal" class="btn btn-primary btn-stp" >Sao lưu dữ liệu đột xuất </a>
                                <!-- Modal -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header" style="background-color: #2ca9e0">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <h4 class="modal-title" id="myModalLabel" style="color: white" >Sao lưu dữ liệu đột xuất </h4>
                                            </div>
                                            <div class="modal-body">
                                                Việc làm này có thể tốn nhiều thời gian và tốn dung lượng bộ nhớ. Bạn có chắc chắn sao lưu dữ liệu hay không ?
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default btn-stp-default" data-dismiss="modal">Đóng</button>
                                                <a href="<%=request.getContextPath()%>/system/config/back-up-now.html" class="btn btn-primary btn-stp" >Sao lưu ngay</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <a href="<%=request.getContextPath()%>/system/config/restore-view.html" class="btn btn-primary">Phục hồi dữ liệu</a>
                                <a href="<%=request.getContextPath()%>/system/config/list-sql.html" class="btn btn-primary">Xem danh sách</a>

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
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/js/eternicode-bootstrap-datepicker/css/datepicker.css" type="text/css"/>
<script src="<%=request.getContextPath()%>/assets/js/eternicode-bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<%--<script type="text/javascript">
    CKEDITOR.replace( 'contentCk' , {

        height: '300px',
        resize_enabled : true
    } );

</script>  --%>
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




<%--<%=request.getContextPath()%>/assets/ckeditor/ckeditor.js--%>
