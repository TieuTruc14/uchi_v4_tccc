<%@ page isELIgnored="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<script type="text/javascript">
    $("#uchi-status").show();
    setTimeout(function () {
        $("#uchi-status").hide();
    }, 4000);
</script>

<section id="content">
    <section class="vbox">
        <section class="scrollable padder">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="<%=request.getContextPath()%>/index.html"><i class="fa fa-home"></i>&nbsp;Home</a></li>
                <li><a href="#">User</a></li>
                <li><a href="javascript:void(0)">List</a></li>
            </ul>
            <div class="m-b-md"><h3 class="m-b-none" id="uchi-status" style="color: #009900">
                <s:property value="message"/></h3>
            </div>

            <section class="panel panel-default">
                <header class="panel-heading"><i class="fa fa-caret-square-o-right"></i> Dữ liệu

                </header>
                <div class="text-sm wrapper bg-light lt">
                    <s:form cssClass="form-inline padder" role="form" theme="simple">
                        <div class="form-group"><s:textfield name="filterUserName" placeholder="Username"
                                                             cssClass="input-sm form-control"/></div>
                        <button type="submit" class="btn btn-default btn-sm" formaction="list.html">Tìm kiếm</button>
                        <a class="btn btn-sm btn-primary pull-right" href="<%=request.getContextPath()%>/system/grant/add.html"><i
                                class="fa fa-plus"></i> Thêm mới</a>
                    </s:form>
                </div>
                <div class="table-responsive table-overflow-x-fix">
                    <table id="tblGroup" class="table table-striped table-bordered m-b-none text-sm">
                        <thead>
                        <tr>
                            <th class="box-shadow-inner small_col text-center">#</th>
                            <th class="box-shadow-inner small_col text-center">Mã</th>
                            <th class="box-shadow-inner small_col text-center">Tên nhóm quyền</th>
                            <th class="box-shadow-inner small_col text-center">Mô tả</th>
                            <th class="box-shadow-inner small_col text-center hidden-xs">Người tạo</th>
                            <th class="box-shadow-inner small_col text-center hidden-xs">Thời gian tạo</th>
                            <th class="box-shadow-inner small_col text-center hidden-xs">Người cập nhập</th>
                            <th class="box-shadow-inner small_col text-center hidden-xs">Thời gian cập nhập</th>
                            <th class="box-shadow-inner small_col text-center">Hoạt động</th>
                        </tr>
                        </thead>
                        <tbody>

                        <s:iterator var="item" value="page.items" status="stat">
                            <tr>
                                <td class="align-center"><s:property value="#stat.count"/></td>
                                <td class="align-center"><a
                                        href="<%=request.getContextPath()%>/system/grant/detail.html?id=<s:property value="#item.id" />"><s:property
                                        value="#item.id"/></a></td>
                                <td class="align-center"><s:property value="#item.name"/></td>
                                <td class="align-center"><s:property value="#item.description"/></td>
                                <td class="hidden-xs align-center"><s:property value="#item.userCreated.name"/></td>
                                <td class="hidden-xs align-center"><s:date  name="#item.dateCreated" format="dd/MM/yyyy HH:mm:ss"/></td>
                                <td class="hidden-xs align-center"><s:property value="#item.userUpdated.name"/></td>
                                <td class="hidden-xs align-center"><s:date  name="#item.dateUpdated" format="dd/MM/yyyy HH:mm:ss"/></td>
                                <td class="align-center">
                                    <div class="btn-group">
                                        <button class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown"><i
                                                class="fa fa-random"></i></button>
                                        <ul class="dropdown-menu pull-right">
                                            <li> <a href="<%=request.getContextPath()%>/system/grant/edit.html?id=<s:property value="#item.id" />">
                                                <i class="fa fa-pencil-square-o"></i>Sửa</a></li>
                                            <li> <a href="<%=request.getContextPath()%>/system/grant/grant-group.html?id=<s:property value="#item.id" />">
                                                <i class="fa fa-pencil-square-o"></i>Phân quyền cho nhóm</a></li>
                                        </ul>
                                    </div>
                                </td>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>
                </div>
                <footer class="panel-footer">
                    <div class="row">
                        <div class="col-sm-4 hidden-xs"></div>
                        <div class="col-sm-4 text-center">
                            <small class="text-muted inline m-t-sm m-b-sm"></small>
                        </div>
                        <div class="col-sm-12 text-right text-center-xs">
                            <ul class="pagination pagination-sm m-t-none m-b-none">
                                <s:if test="%{page.pageNumber > 1}">
                                    <li>
                                        <a href="<%=request.getContextPath()%>/system/user/list.html?page.pageNumber=<s:property value="%{page.pageNumber}" />&filterUserName=<s:property value="filterUserName"/>">«</a>
                                    </li>
                                </s:if>
                                <s:iterator var="item" value="page.pageList" status="stat">
                                    <s:if test="%{page.pageNumber==#item}">
                                        <li><a style="color: #aa1111"
                                               href="<%=request.getContextPath()%>/system/user/list.html?page.pageNumber=<s:property value="#item" />&filterUserName=<s:property value="filterUserName"/>"><s:property
                                                value="#item"/></a></li>
                                    </s:if>
                                    <s:else>
                                        <li>
                                            <a href="<%=request.getContextPath()%>/system/user/list.html?page.pageNumber=<s:property value="#item" />&filterUserName=<s:property value="filterUserName"/>"><s:property
                                                    value="#item"/></a></li>
                                    </s:else>
                                </s:iterator>
                                <s:if test="%{page.pageNumber < page.getPageCount()}">
                                    <li>
                                        <a href="<%=request.getContextPath()%>/system/user/list.html?page.pageNumber=<s:property value="%{page.pageNumber + 2 }" />&&filterUserName=<s:property value="filterUserName"/>">»</a>
                                    </li>
                                </s:if>
                            </ul>
                        </div>
                    </div>
                </footer>
            </section>
        </section>
        <%--<footer class="footer bg-white b-t b-light"></footer>--%>
    </section>
    <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen" data-target="#nav"></a>
</section>

<link href="<%=request.getContextPath()%>/assets/bootstrap-select/bootstrap-select.min.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/assets/bootstrap-select/bootstrap-select.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tblGroup').dataTable({
            "bFilter": false,
            "bPaginate": false,
            "bAutoWidth": false,
            "sPaginationType": "full_numbers"
        });
    });
</script>
