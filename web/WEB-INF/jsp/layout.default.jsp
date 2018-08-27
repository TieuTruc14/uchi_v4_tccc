<%@ page isELIgnored="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
    <meta charset="utf-8"/>
    <title><tiles:insertAttribute name="title"/></title>
    <link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/assets/images/osp.ico" />
    <meta name="description" content="uchi,tccc, cong chung"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/note/css/bootstrap.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/note/css/animate.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/note/css/font-awesome.min.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/note/css/font.css" type="text/css" cache="false"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/note/js/datatables/datatables.css" type="text/css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/note/css/app.css" type="text/css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/note/css/style.css" type="text/css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/js/select2/select2.css" type="text/css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/note/js/select2/theme.css" type="text/css"/>

    <%--<[if lt IE 9]>--%>
    <script src="<%=request.getContextPath()%>/assets/note/js/ie/html5shiv.js" cache="false"></script>
    <script src="<%=request.getContextPath()%>/assets/note/js/ie/respond.min.js" cache="false"></script>
    <script src="<%=request.getContextPath()%>/assets/note/js/ie/excanvas.js" cache="false"></script>
    <%--<[endif]>--%>
    <script src="<%=request.getContextPath()%>/assets/js/jquery-3.1.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/note/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/note/js/bootstrap.js"></script>
    <script src="<%=request.getContextPath()%>/assets/note/js/app.js"></script>
    <script src="<%=request.getContextPath()%>/assets/note/js/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/note/js/datatables/jquery.dataTables.min.js"></script>
    <%--<script src="<%=request.getContextPath()%>/assets/note/js/app.plugin.js"></script>--%>
    <script src="<%=request.getContextPath()%>/assets/js/jquery.spin.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/select2/select2.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/js/eternicode-bootstrap-datepicker/css/datepicker.css" type="text/css"/>
    <script src="<%=request.getContextPath()%>/assets/js/eternicode-bootstrap-datepicker/js/bootstrap-datepicker.js"></script>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/project/contract/editor.css" />
    <script src="<%=request.getContextPath()%>/assets/project/angularjs/angular.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/project/angularjs/angular-sanitize.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/project/contract/contract.js"></script>
    <%--<script src="<s:url value="/assets/js/jquery.spin.js"/> "></script>--%>
    <script>
        var preUrl='<%=request.getContextPath()%>';
    </script>
</head>
<body>
<section class="vbox">
    <tiles:insertAttribute name="header" />
    <section>
        <section class="hbox stretch">
            <tiles:insertAttribute name="leftpanel" />
            <tiles:insertAttribute name="page" />
        </section>
    </section>
</section>


<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
        (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

    ga('create', 'UA-49035491-1', 'uchi.vn');
    ga('send', 'pageview');

//    $(".select2").select2();

    $(".select2").select2({
        /*placeholder: '---Chọn---',*/
        allowClear: true,
        width: '100%'
    });
    $('.input-daterange').datepicker({
        format: "dd/mm/yyyy",
        startDate: "01/01/2012",
        endDate: endDateofDatepicker,
        todayBtn: "linked",
        calendarWeeks: false,
        autoclose: true,
        todayHighlight: true
    });

</script>

</body></html>
