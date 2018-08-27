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
                <header class="panel-heading"><i class="fa fa-caret-square-o-right"></i>Thông tin cấu hình lưu trữ dữ liệu sao lưu "<s:property value="message"/>"</header>
                <div class="panel-body">
                    <s:form method="post" id="form-submit" action="restore.html" theme="simple"  cssClass="form-horizontal" cssStyle="" >
                        <table class="table border-table">
                            <th class=" border-table truong-background-clpink">Cảnh báo: Việc phục hồi dữ liệu sẽ làm mất toàn bộ dữ liệu cũ.
                                Hãy chắc chắn rằng hành động này là cần thiết. Bạn sẽ phải chịu toàn bộ trách nhiệm của mình khi thực hiện hành
                                động này.</th>
                        </table>
                        <div class="form-group">
                            <div class="col-md-10 truong-font-chu">
                                <input type="checkbox" class="truong-check-fix"> Tôi đồng ý phúc hồi toàn bộ dữ liệu
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label label-bam-trai">Thư mục lưu trữ</label>
                            <div class="col-md-6">
                                <s:textfield name="cfBackup.fileRestore" cssClass="form-control" value="E:/backup/backupbackup_09-08-2017.sql" />
                                <%--<input type="text" class="form-control" name="fileRestore" value="E:/backup/backupbackup_09-08-2017.sql">--%>
                            </div>
                            <div class="col-md-2">
                                <input type="submit" class="btn btn-primary" value="Phục hồi dữ liệu">
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
