<%@ page isELIgnored="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<section id="content">
    <div class="row m-n">
        <div class="col-sm-4 col-sm-offset-4">
            <div class="text-center m-b-lg">
                <h1 class="h text-white animated fadeInDownBig">404</h1>
            </div>
            <article class="media ">
                <div class="pull-left">
                    <span class="pull-left thumb-sm"><img src="<%=request.getContextPath()%>/assets/images/icon/cry.png" class="img-circle" style="opacity: 0.5"></span>
                </div>
                <div class="media-body">
                    <a href="javascript:void(0)" class="h4 text-warning">DỮ LIỆU BẠN TÌM KIẾM KHÔNG TỒN TẠI</a>
                    <small class="block m-t-xs">Hãy bấm vào link bên dưới để trở lại trang chủ</small>
                </div>
            </article>
            <div class="list-group m-b-sm bg-white m-b-lg" style="margin-top:10px;">
                <a href="<%=request.getContextPath()%>/index.html" class="list-group-item ">
                    <i class="fa fa-chevron-right icon-muted"></i>
                    <i class="fa fa-fw fa-home icon-muted"></i> <span class="text-info">Trở về trang chủ</span>
                </a>

            </div>
        </div>
    </div>
</section>
