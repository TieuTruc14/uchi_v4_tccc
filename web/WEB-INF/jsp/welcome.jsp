<%@ page isELIgnored="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script>
    var BASIC_AUTHENTICATION = "<s:property value="BasicAuthenticationInterceptor" />";
    console.log(BASIC_AUTHENTICATION);
</script>
<section id="content" style="width: 100%!important;">
    <section class="vbox">
        <section class="scrollable padder">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in"> <li><a href="<%=request.getContextPath()%>/index"><i class="fa fa-home"></i>&nbsp;Home</a></li> </ul>
            <%--<div class="m-b-md"> <h3 class="m-b-none"><sec:authentication property="principal.username" /></h3> </div>--%>
            <p>Thao tác nội dung menu bên trái</p>

        </section>
    </section>
    <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen" data-target="#nav"></a>
</section>

