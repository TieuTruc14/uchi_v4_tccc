<%@ page isELIgnored="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/chosen2/chosen.css" />
<section id="content">
    <section class="vbox">
        <section class="scrollable padder">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="<%=request.getContextPath()%>/index.html"><i class="fa fa-home"></i>&nbsp;Home</a></li>
                <li><a href="#">User</a></li>
                <li><a href="javascript:void(0)">Thêm nhóm quyền</a></li>
            </ul>
            <div class="m-b-md">
                <h3 class="m-b-none">Thêm mới nhóm quyền</h3>
            </div>

            <section class="panel panel-default">
                <header class="panel-heading"><i class="fa fa-caret-square-o-right"></i>Thêm nhóm quyền</header>
                <div class="panel-body" style="min-height: 600px;">
                    <s:form method="post" action="add-save" theme="simple"  enctype="multipart/form-data" cssClass="" cssStyle="" validate="true">
                        <div class="form-group">
                            <label class="col-sm-2 control-label" style="line-height: 30px">Mã nhóm</label>
                            <div class="col-sm-10">
                                <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-barcode" aria-hidden="true"></i>
                                        </span>
                                    <s:textfield name="item.id" maxlength="100" cssStyle="width:100%;"
                                                 placeholder="Mã" cssClass="form-control"/>

                                </div>
                                <s:fielderror cssStyle="color: red" fieldName="item.id"/>
                            </div>
                        </div>
                        <div class="line line-dashed line-lg pull-in"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" style="line-height: 30px">Tên nhóm</label>
                            <div class="col-sm-10">
                                <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-users" aria-hidden="true" style="font-size: 10px"></i>
                                        </span>
                                    <s:textfield name="item.name" placeholder="Tên"  cssStyle="width:100%;"
                                                 cssClass="form-control"/>
                                </div>
                                <s:fielderror cssStyle="color: red" fieldName="item.name"/>
                            </div>
                        </div>
                        <div class="line line-dashed line-lg pull-in"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" style="line-height: 30px">Mô tả</label>
                            <div class="col-sm-10">
                                <div class="input-group m-b">
                                        <span class="input-group-addon">
                                            <i class="fa fa-pencil" style="font-size: 10px" aria-hidden="true"></i>
                                        </span>
                                    <s:textfield name="item.description" placeholder="Mô tả" cssStyle="width:100%;" cssClass="form-control"/>
                                </div>
                            </div>
                        </div>

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


