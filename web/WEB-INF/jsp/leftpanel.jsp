<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ page isELIgnored="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%--<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>--%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%!
    public boolean isActive(String navPath) {
        String namespace = ServletActionContext.getActionMapping().getNamespace();///contract
        String action = ServletActionContext.getActionMapping().getName();//add
        String activeUri = namespace + "/" + action + ".html";///contract/add.html
        if (activeUri.startsWith(navPath)) {
            return true;
        }

        return false;
    }
%>
<%--<aside class="bg-light lter b-r aside-md hidden-print" id="nav">--%>
<aside class="bg-dark lter aside-md hidden-print hidden-xs" id="nav">
    <section class="vbox">
        <header class="header bg-primary lter text-center clearfix">
            <div class="btn-group">
                <button type="button" class="btn btn-sm btn-dark btn-icon"><i class="fa fa-envelope"></i></button>
                <div class="btn-group hidden-nav-xs">
                    <a href="#" class="btn btn-sm btn-primary " >Phản hồi </a>
                </div>
            </div>
        </header>
        <section class="w-f scrollable">
            <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0" data-size="5px" data-color="#333333">
                <nav class="nav-primary hidden-xs">
                    <ul class="nav">
                        <li class=""><a href="#">
                            <i class="fa fa-search icon">
                                <b class="bg-danger"></b>
                            </i><span>Tra cứu</span></a>
                        </li>
                        <li class=""><a href="#" class=""> <i class="fa fa-paste icon"> <b class="bg-warning"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>Quản lý hợp đồng</span> </a>

                            <ul class="nav lt">
                                <li class=""><a href="<%=request.getContextPath()%>/contract/add.html" class=""> <i class="fa fa-angle-right"></i> <span>Hợp đồng công chứng</span> </a></li>
                                <li class=""><a href="#" class=""> <i class="fa fa-angle-right"></i> <span>Hợp đồng online</span> </a></li>
                                <li class="<%= isActive("/contract/add") ? "active" : "" %>"><a href="<%=request.getContextPath()%>/contract/add.html" class=""> <i class="fa fa-angle-right"></i> <span>Soạn hợp đồng</span> </a></li>
                                <li class=""><a href="#" class=""> <i class="fa fa-angle-right"></i> <span>Hợp đồng chưa đồng bộ</span> </a></li>
                            </ul>
                        </li>
                        <li class=""><a href="#" class=""> <i class="fa fa-file-text icon"> <b class="bg-success"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>Báo cáo thống kê</span> </a>
                            <ul class="nav lt">
                                <li class=""><a href="<%=request.getContextPath()%>/system/user/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Nhóm hợp đồng</span> </a></li>
                                <li class=""><a href="<%=request.getContextPath()%>/system/grant/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Công chứng viên</span> </a></li>
                                <li class=""><a href="<%=request.getContextPath()%>/system/contract-history/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Ngân hàng</span> </a></li>
                                <li class=""><a href="<%=request.getContextPath()%>/system/system-history/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Thống kê tổng hợp</span> </a></li>
                                <li class=""><a href="<%=request.getContextPath()%>/system/config/list.html" class=""> <i class="fa fa-angle-right"></i> <span>In sổ hợp đồng công chứng</span> </a></li>
                                <li class=""><a href="<%=request.getContextPath()%>/system/backup/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Theo thông tu 04</span> </a></li>
                            </ul>
                        </li>
                        <li class=""><a href="#" class=""> <i class="fa fa-cogs icon"> <b class="bg-primary"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>Quản trị hệ thống</span> </a>
                            <ul class="nav lt">
                                <li class=""><a href="<%=request.getContextPath()%>/system/user/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Danh sách người dùng</span> </a></li>
                                <li class=""><a href="<%=request.getContextPath()%>/system/grant/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Nhóm quyền</span> </a></li>
                                <li class=""><a href="<%=request.getContextPath()%>/category/contracthistory/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Lịch sử hợp đồng</span> </a></li>
                                <li class=""><a href="<%=request.getContextPath()%>/system/system-history/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Lịch sử hệ thống</span> </a></li>
                                <li class=""><a href="<%=request.getContextPath()%>/system/config/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Cấu hình sao lưu</span> </a></li>
                                <li class=""><a href="<%=request.getContextPath()%>/system/backup/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Sao lưu dữ liệu từ STP</span> </a></li>
                            </ul>
                        </li>
                        <li class=""><a href="#" class=""> <i class="fa fa-th-list icon"> <b class="bg-primary dker"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>Danh mục</span> </a>
                            <ul class="nav lt">
                                <li class=""><a href="<%=request.getContextPath()%>/category/bank/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Ngân hàng</span> </a></li>
                                <li class=""><a href="<%=request.getContextPath()%>/category/contract-kind/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Loại hợp đồng</span> </a></li>
                                <li class=""><a href="<%=request.getContextPath()%>/category/contract-template/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Mẫu hợp đồng</span> </a></li>
                                <li class=""><a href="<%=request.getContextPath()%>/category/privy-template/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Mẫu đương sự</span> </a></li>
                                <li class=""><a href="<%=request.getContextPath()%>/category/property-template/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Mẫu tài sản</span> </a></li>
                                <li class=""><a href="<%=request.getContextPath()%>/category/manual/list.html" class=""> <i class="fa fa-angle-right"></i> <span>Tài liệu hướng dẫn</span> </a></li>
                            </ul>
                        </li>
                        <li class=""><a href="<%=request.getContextPath()%>/category/announcement/list.html">
                            <i class="fa fa-volume-up icon">
                                <b class="bg-info"></b>
                            </i><span>Thông báo</span></a>
                        </li>
                        <li class=""><a href="#">
                            <i class="fa fa-phone icon">
                                <b class="bg-info dker"></b>
                            </i><span>Liên hệ</span></a>
                        </li>

                    </ul>
                </nav>
            </div>
        </section>
        <footer class="footer lt hidden-xs b-light">
            <a href="#nav" data-toggle="class:nav-xs" class="pull-right btn btn-sm btn-default btn-icon "> <i class="fa fa-angle-left text"></i><i class="fa fa-angle-right text-active"></i> </a>
        </footer>
    </section>
</aside>