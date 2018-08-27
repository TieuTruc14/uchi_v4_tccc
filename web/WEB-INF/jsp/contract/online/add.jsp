<%@ page isELIgnored="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/note/js/fuelux/fuelux.css" type="text/css" />

<script src="<%=request.getContextPath()%>/assets/project/contract/directives/dynamic.js"></script>
<script src="<%=request.getContextPath()%>/assets/project/contract/directives/editspan.js"></script>
<script src="<%=request.getContextPath()%>/assets/project/contract/directives/fileUpload.js"></script>
<script src="<%=request.getContextPath()%>/assets/project/contract/directives/format-currency.js"></script>


<script src="<%=request.getContextPath()%>/assets/project/contract/factory/contract-factory.js"></script>
<script src="<%=request.getContextPath()%>/assets/project/contract/factory/contractKind-factory.js"></script>
<script src="<%=request.getContextPath()%>/assets/project/contract/factory/contractTemplate-factory.js"></script>
<script src="<%=request.getContextPath()%>/assets/project/contract/factory/user-factory.js"></script>
<script src="<%=request.getContextPath()%>/assets/project/contract/factory/bank-factory.js"></script>
<script src="<%=request.getContextPath()%>/assets/project/contract/online/add.js?v=1.1"></script>

<section id="content">
    <section class="vbox" ng-app="contract" ng-controller="contractCtrl">
    <%--<section class="vbox">--%>
        <section class="scrollable padder">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="<%=request.getContextPath()%>/index.html"><i class="fa fa-home"></i>&nbsp;Home</a></li>
                <li><a href="#">Hợp đồng</a></li>
                <li><a href="javascript:void(0)">Thêm hợp đồng online</a></li>
            </ul>
            <div class="m-b-md">
                <h3 class="m-b-none">Thêm hợp đồng online </h3>
            </div>
            <section class="panel panel-default wizard">
                <div class="clearfix wizard-steps">
                    <ul class="steps">
                        <li data-target="#step1" class="active"><span class="badge badge-info">1</span>Thông tin hợp đồng</li>
                        <li data-target="#step2"><span class="badge">2</span>Nội dung hợp đồng</li>
                        <li data-target="#step3"><span class="badge">3</span>Phí công chứng</li>
                        <li data-target="#step4"><span class="badge">4</span>Thông tin khác</li>
                    </ul>
                    <div class="actions">
                        <button type="button" class="btn btn-default btn-sm btn-prev" disabled="disabled" id="btnBack" style="display: none;">Quay lại</button>
                        <button type="button" class="btn btn-default btn-sm btn-next" data-last="Lưu" id="btnNext" style="display: none;">Tiếp tục</button>
                        <a href="javascript:void(0)" class="btn btn-info btn-sm" onclick="clickNextStep2()" id="nextStep1">Tiếp tục</a>
                        <a href="javascript:void(0)" class="btn btn-default btn-sm" onclick="clickBackStep1()" id="backStep2" style="display: none;">Quay lại</a>
                        <a href="javascript:void(0)" class="btn btn-info btn-sm" onclick="clickNextStep3()" id="nextStep2" style="display: none;">Tiếp tục</a>
                        <a href="javascript:void(0)" class="btn btn-default btn-sm" onclick="clickBackStep2()" id="backStep3" style="display: none;">Quay lại</a>
                        <a href="javascript:void(0)" class="btn btn-info btn-sm" onclick="clickNextStep4()" id="nextStep3" style="display: none;">Tiếp tục</a>
                        <a href="javascript:void(0)" class="btn btn-default btn-sm" onclick="clickBackStep3()" id="backStep4" style="display: none;">Quay lại</a>
                        <%--<a href="javascript:void(0)" class="btn btn-info btn-sm" ng-click="addContract()" id="finish" style="display: none;">Hoàn tất</a>--%>
                        <a href="javascript:void(0)" class="btn btn-info btn-sm" onclick="submit()"  id="finish" style="display: none;">Hoàn tất</a>
                    </div>
                </div>
                <div class="step-content panel-body" style="height:auto">
                    <s:form method="post" action="add-save" id="formContract" theme="simple"  enctype="multipart/form-data" cssClass="form-horizontal" cssStyle="" validate="true">
                        <div class="step-pane active" id="step1">
                            <div class="form-group">
                                <label class="col-sm-3 control-label" style="line-height: 30px">Nhóm hợp đồng <code>*</code></label>
                                <div class="col-sm-9">
                                    <div class="input-group m-b">
                                            <span class="input-group-addon">
                                                <i class="fa fa-user" aria-hidden="true"></i>
                                            </span>
                                        <select class="selectpicker select2 span2" style="width:100%;max-width:350px;" ng-model="contractKind" ng-change="changeContractKind(contractKind)">
                                            <option value="">--Chọn--</option>
                                            <option  ng-repeat="item in contractKinds" value="{{item.id}}">{{item.name}}</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="line line-dashed line-lg pull-in"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label" style="line-height: 30px;">Tên hợp đồng <code>*</code></label>
                                <div class="col-sm-9">
                                    <div class="input-group m-b">
                                            <span class="input-group-addon">
                                                <i class="fa fa-user" aria-hidden="true"></i>
                                            </span>
                                        <select name="item.contractTemplate" class="selectpicker select2 span2" style="width:100%;max-width:350px" ng-model="item.contractTemplate" ng-change="changeContractTemplate(item.contractTemplate)">
                                            <option value="">--Chọn--</option>
                                            <option  ng-repeat="item in contractTemplates" value="{{item.id}}">{{item.name}}</option>
                                        </select>

                                    </div>

                                </div>
                            </div>
                            <div class="line line-dashed line-lg pull-in"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label" style="line-height: 30px">Số hợp đồng <code>*</code></label>
                                <div class="col-sm-9">
                                    <div class="input-group m-b">
                                            <span class="input-group-addon">
                                                <i class="fa fa-user" aria-hidden="true"></i>
                                            </span>
                                        <s:textfield name="item.contractNumber"  ng-model="item.contractNumber" maxlength="100"  cssStyle="width:100%;max-width: 350px;"
                                                     placeholder="Số hợp đồng" cssClass="form-control"/>

                                    </div>

                                </div>
                            </div>
                            <div class="line line-dashed line-lg pull-in"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label" style="line-height: 30px">Ngày thụ lý<code>*</code></label>
                                <div class="col-sm-3">
                                    <div class="input-group m-b input-daterange">
                                            <span class="input-group-addon">
                                                <i class="fa fa-user" aria-hidden="true"></i>
                                            </span>
                                        <s:textfield name="item.receivedDate" ng-model="item.receivedDate" maxlength="100" cssStyle="width:100%;"
                                                     placeholder="Ngày thụ lý" cssClass="form-control"/>

                                    </div>

                                </div>
                                <label class="col-sm-3 control-label" style="line-height: 30px">Ngày công chứng<code>*</code></label>
                                <div class="col-sm-3">
                                    <div class="input-group m-b input-daterange">
                                            <span class="input-group-addon ">
                                                <i class="fa fa-user" aria-hidden="true"></i>
                                            </span>
                                        <s:textfield name="item.notaryDate" ng-model="item.notaryDate" maxlength="100" cssStyle="width:100%;"
                                                     placeholder="Ngày công chứng" cssClass="form-control"/>

                                    </div>

                                </div>
                            </div>
                            <div class="line line-dashed line-lg pull-in"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label" style="line-height: 30px">Chuyên viên soạn thảo<code>*</code></label>
                                <div class="col-sm-3">
                                    <div class="input-group m-b">
                                            <span class="input-group-addon">
                                                <i class="fa fa-user" aria-hidden="true"></i>
                                            </span>
                                        <select name="item.drafter" class="selectpicker select2 span2" style="width:100%;max-width:350px" ng-model="item.drafter" >
                                            <option value="">--Chọn--</option>
                                            <option  ng-repeat="item in drafters" value="{{item.id}}">{{item.name}}</option>
                                        </select>
                                    </div>
                                    <%--<s:fielderror cssStyle="color: red" fieldName="item.name"/>--%>
                                </div>
                                <label class="col-sm-3 control-label" style="line-height: 30px">Công chứng viên<code>*</code></label>
                                <div class="col-sm-3">
                                    <div class="input-group m-b">
                                            <span class="input-group-addon">
                                                <i class="fa fa-user" aria-hidden="true"></i>
                                            </span>
                                        <select name="item.notary" class="selectpicker select2 span2" style="width:100%;max-width:350px" ng-model="item.notary" >
                                            <option value="">--Chọn--</option>
                                            <option  ng-repeat="item in notarys" value="{{item.id}}">{{item.name}}</option>
                                        </select>
                                    </div>

                                </div>
                            </div>
                            <div class="line line-dashed line-lg pull-in"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label" style="line-height: 30px">Giá trị hợp đồng <code>*</code></label>
                                <div class="col-sm-9">
                                    <div class="input-group m-b">
                                            <span class="input-group-addon">
                                                <i class="fa fa-user" aeditor.cssria-hidden="true"></i>
                                            </span>
                                        <s:textfield  name="item.contractValue" ng-model="item.contractValue" maxlength="100" cssStyle="width:100%;"
                                                     placeholder="Giá trị hợp đồng" cssClass="form-control"/>

                                    </div>

                                </div>
                            </div>

                            <div class="line line-dashed line-lg pull-in"></div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label" style="line-height: 30px">Tóm tắt nội dung</label>
                                <div class="col-sm-9">
                                    <div class="input-group m-b">
                                            <span class="input-group-addon">
                                                <i class="fa fa-user" aria-hidden="true"></i>
                                            </span>
                                        <s:textarea name="item.summary" ng-model="item.summary" maxlength="100" cssStyle="width:100%;"
                                                    placeholder="Tóm tắt nội dung" cssClass="form-control"/>

                                    </div>

                                </div>
                            </div>

                        </div>
                        <div class="step-pane" id="step2">
                            <div class="btn-toolbar m-b-sm btn-editor" data-role="editor-toolbar"
                                 data-target="#editor"  style="margin:auto;width:800px;">
                                <div style="margin:auto;text-align: center;width:790px;">
                                    <div class="btn-group"><a class="btn btn-default btn-sm" data-edit="bold" title="Bold (Ctrl/Cmd+B)">
                                        <i class="fa fa-bold"></i></a>
                                        <a class="btn btn-default btn-sm" data-edit="italic" title="Italic (Ctrl/Cmd+I)"><i class="fa fa-italic"></i></a>
                                        <a class="btn btn-default btn-sm" data-edit="strikethrough" title="Strikethrough"> <i class="fa fa-strikethrough"></i></a>
                                        <a class="btn btn-default btn-sm" data-edit="underline" title="Underline (Ctrl/Cmd+U)"> <i class="fa fa-underline"></i></a>
                                    </div>
                                    <div class="btn-group">
                                        <a class="btn btn-default btn-sm"  data-edit="insertunorderedlist" title="Bullet list">
                                            <i class="fa fa-list-ul"></i></a>
                                        <a class="btn btn-default btn-sm" data-edit="insertorderedlist" title="Number list">
                                            <i class="fa fa-list-ol"></i></a>
                                        <a class="btn btn-default btn-sm" data-edit="outdent" title="Reduce indent (Shift+Tab)">
                                            <i class="fa fa-dedent"></i></a>
                                        <a class="btn btn-default btn-sm" data-edit="indent" title="Indent (Tab)">
                                            <i class="fa fa-indent"></i></a>
                                    </div>
                                    <div class="btn-group">
                                        <a class="btn btn-default btn-sm" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)">
                                            <i class="fa fa-align-left"></i>
                                        </a>
                                        <a class="btn btn-default btn-sm" data-edit="justifycenter"
                                           title="Center (Ctrl/Cmd+E)"><i
                                                class="fa fa-align-center"></i>
                                        </a>
                                        <a class="btn btn-default btn-sm" data-edit="justifyright"
                                           title="Align Right (Ctrl/Cmd+R)"><i
                                                class="fa fa-align-right"></i>
                                        </a>
                                        <a class="btn btn-default btn-sm" data-edit="justifyfull"
                                           title="Justify (Ctrl/Cmd+J)"><i class="fa fa-align-justify"></i>
                                        </a>
                                    </div>
                                    <div class="btn-group"><a class="btn btn-default btn-sm"
                                                              data-edit="undo" title="Undo (Ctrl/Cmd+Z)"><i
                                            class="fa fa-undo"></i></a> <a class="btn btn-default btn-sm"
                                                                           data-edit="redo"
                                                                           title="Redo (Ctrl/Cmd+Y)"><i
                                            class="fa fa-repeat"></i></a></div>

                                    <div class="btn-group ">
                                        <a ng-click="viewAsDoc()" style="margin:0px 0px;" class="btn btn-sm btn-info">Xem online</a>
                                        <a ng-click="downloadWord()"style="margin:0px 2px;" class="btn btn-sm btn-info">Xuất file word</a>
                                        <div class="btn-group" style="margin-top:0px;">
                                            <button class="btn btn-primary btn-sm dropdown-toggle " data-toggle="dropdown"><i class="fa fa-plus"></i>đương sự-tài sản<span class="caret"></span></button>
                                            <ul class="dropdown-menu">
                                                <li><a data-toggle="modal"  data-target="#addPrivysDialog" ><i class="fa fa-plus"></i>Đương sự</a></li>
                                                <li><a data-toggle="modal"  data-target="#addPropertyDialog"><i class="fa fa-plus"></i>Tài sản</a></li>
                                            </ul>
                                        </div>
                                    </div>

                                    <br><br>
                                    <div class="form-group">
                                        <div id="textboxofp"></div>
                                    </div>

                                </div>
                                <div id="editor"   class="form-control" style="margin:auto;font-size:14pt!important;width: 742px!important;height:842px;overflow:scroll;font-family: 'Times New Roman';padding:20px 20px!important;">
                                    <div dynamic="item.content" id="contentHtml"></div>
                                </div>
                            </div>
                            <s:textfield type="hidden" name="item.content" id="contractContent" />
                            <textarea hidden="true" name="contentText" id="contentText"></textarea>
                            <div id="sourcecontract" contenteditable="true"  style="display:none;font-size:14px!important;width: 742px!important;height:842px;overflow:scroll;font-family: 'Times New Roman';padding:20px 20px!important;"></div>
                        </div>

                        <%--step3--%>
                        <div class="step-pane" id="step3">
                            <div class="col-lg-6">
                                <section class="panel panel-default">
                                    <header class="panel-heading font-bold">Thu phí(VND)</header>
                                    <div class="panel-body">
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label" style="line-height: 30px">Phí công chứng<code>*</code></label>
                                                <div class="col-sm-7">
                                                    <div class="input-group m-b">
                                                        <span class="input-group-addon">
                                                            <i class="fa fa-user" aeditor.cssria-hidden="true"></i>
                                                        </span>
                                                        <s:textfield name="item.notaryCost" ng-model="item.notaryCost" maxlength="15" cssStyle="width:100%;" format="number" onkeypress="return restrictCharacters(this, event, digitsOnly);"
                                                                     placeholder="Phí công chứng" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label" style="line-height: 30px">Thù lao công chứng</label>
                                                <div class="col-sm-7">
                                                    <div class="input-group m-b">
                                                        <span class="input-group-addon">
                                                            <i class="fa fa-user" aeditor.cssria-hidden="true"></i>
                                                        </span>
                                                        <s:textfield name="item.remunerationCost" ng-model="item.remunerationCost" maxlength="15" cssStyle="width:100%;" format="number" onkeypress="return restrictCharacters(this, event, digitsOnly);"
                                                                     placeholder="Giá trị hợp đồng" cssClass="form-control"/>

                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label" style="line-height: 30px">Tổng phí</label>
                                                <div class="col-sm-7">
                                                    <div class="input-group m-b">
                                                        <span class="input-group-addon">
                                                            <i class="fa fa-user" aeditor.cssria-hidden="true"></i>
                                                        </span>
                                                        <s:textfield name="item.notaryCostTotal" ng-model="item.notaryCostTotal"  maxlength="15" cssStyle="width:100%;" format="number" onkeypress="return restrictCharacters(this, event, digitsOnly);"
                                                                     placeholder="Giá trị hợp đồng" cssClass="form-control"/>

                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label" style="line-height: 30px">Ghi chú</label>
                                                <div class="col-sm-7">
                                                    <div class="input-group m-b">
                                                        <span class="input-group-addon">
                                                            <i class="fa fa-user" aeditor.cssria-hidden="true"></i>
                                                        </span>
                                                        <s:textarea name="item.note" ng-model="item.note" maxlength="100" cssStyle="width:100%;"
                                                                     placeholder="Giá trị hợp đồng" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                            </div>
                                    </div>
                                </section>
                            </div>

                            <div class="col-lg-6">
                                <section class="panel panel-default">
                                    <header class="panel-heading font-bold">Ngân hàng</header>
                                    <div class="panel-body">
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label" style="line-height: 30px">Ngân hàng <code>*</code></label>
                                                <div class="col-sm-7">
                                                    <div class="input-group m-b">
                                                        <span class="input-group-addon">
                                                            <i class="fa fa-user" aeditor.cssria-hidden="true"></i>
                                                        </span>
                                                        <s:textfield name="item.bank" ng-model="item.bank" maxlength="100" cssStyle="width:100%;"
                                                                     placeholder="Ngân hàng" cssClass="form-control"/>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label" style="line-height: 30px">Cán bộ tín dụng</label>
                                                <div class="col-sm-7">
                                                    <div class="input-group m-b">
                                                        <span class="input-group-addon">
                                                            <i class="fa fa-user" aeditor.cssria-hidden="true"></i>
                                                        </span>
                                                        <s:textfield name="item.crediterName" ng-model="item.crediterName" maxlength="100" cssStyle="width:100%;"
                                                                     placeholder="Cán bộ tín dụng" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-5 control-label" style="line-height: 30px">Chiết khấu</label>
                                                <div class="col-sm-7">
                                                    <div class="input-group m-b">
                                                        <span class="input-group-addon">
                                                            <i class="fa fa-user" aeditor.cssria-hidden="true"></i>
                                                        </span>
                                                        <s:textfield name="item.bankServiceCost" ng-model="item.bankServiceCost" maxlength="15" cssStyle="width:100%;"
                                                                     placeholder="Chiết khấu" cssClass="form-control"/>
                                                    </div>
                                                </div>
                                            </div>
                                    </div>
                                </section>
                            </div>
                        </div>
                        <div class="step-pane" id="step4">
                            <div class="form-group">
                                <label class="col-sm-3 control-label" style="line-height: 30px">Số tờ/trang HĐ</label>
                                <div class="col-sm-9">
                                    <div class="input-group m-b">
                                                        <span class="input-group-addon">
                                                            <i class="fa fa-user" aeditor.cssria-hidden="true"></i>
                                                        </span>
                                        <s:textfield name="item.numberOfPage" ng-model="item.numberOfPage" maxlength="100" cssStyle="width:100%;"
                                                     placeholder="Số tờ/trang" cssClass="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label" style="line-height: 30px">Số bản công chứng</label>
                                <div class="col-sm-9">
                                    <div class="input-group m-b">
                                                        <span class="input-group-addon">
                                                            <i class="fa fa-user" aeditor.cssria-hidden="true"></i>
                                                        </span>
                                        <s:textfield name="item.numberCopyContract"  ng-model="item.numberCopyContract" maxlength="100" cssStyle="width:100%;"
                                                     placeholder="Số bản công chứng" cssClass="form-control"/>

                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label" style="line-height: 30px">Lưu trữ bản gốc</label>
                                <div class="col-sm-9">
                                    <div class="input-group m-b">
                                                        <span class="input-group-addon">
                                                            <i class="fa fa-user" aeditor.cssria-hidden="true"></i>
                                                        </span>
                                        <s:textfield name="item.originalStorePlace" ng-model="item.originalStorePlace" maxlength="100" cssStyle="width:100%;"
                                                     placeholder="Lưu trữ bản gốc" cssClass="form-control"/>

                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label" style="line-height: 30px">File đính kèm</label>
                                <div class="col-sm-9">
                                    <div class="input-group m-b">
                                        <s:file name="file" ng-model="file" maxlength="100" type="file" cssStyle="width:100%;"/>

                                    </div>

                                </div>
                            </div>

                        </div>
                    </s:form>
                </div>
            </section>


        </section>
    </section>
    <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen" data-target="#nav"></a>
</section>


<script src="<%=request.getContextPath()%>/assets/note/js/fuelux/fuelux.js"></script>

<script src="<%=request.getContextPath()%>/assets/note/js/wysiwyg/jquery.hotkeys.js"></script>
<script src="<%=request.getContextPath()%>/assets/note/js/wysiwyg/bootstrap-wysiwyg.js"></script>
<script src="<%=request.getContextPath()%>/assets/note/js/wysiwyg/demo.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/project/tree/tree.css" type="text/css" />
<script src="<%=request.getContextPath()%>/assets/project/tree/tree.js"></script>
<script src="<%=request.getContextPath()%>/assets/project/exportWord/FileSaver.js"></script>
<script src="<%=request.getContextPath()%>/assets/project/exportWord/jquery.wordexport.js"></script>

<script src="<%=request.getContextPath()%>/assets/project/contract/directives/docsothanhchu.js"></script>
<script>

$(document).ready(function () {

});
function clickNextStep2() {
    document.getElementById("nextStep1").style.display = "none";
    document.getElementById("nextStep2").style.display = "inline";
    document.getElementById("backStep2").style.display = "inline";
    $('#btnNext').click();
}
function clickNextStep3() {
    document.getElementById("nextStep2").style.display = "none";
    document.getElementById("backStep2").style.display = "none";
    document.getElementById("nextStep3").style.display = "inline";
    document.getElementById("backStep3").style.display = "inline";
    $('#btnNext').click();
}
function clickNextStep4() {
    document.getElementById("nextStep3").style.display = "none";
    document.getElementById("backStep3").style.display = "none";
    document.getElementById("finish").style.display = "inline";
    document.getElementById("backStep4").style.display = "inline";
    $('#btnNext').click();
}
function clickBackStep1() {
    document.getElementById("nextStep2").style.display = "none";
    document.getElementById("backStep2").style.display = "none";
    document.getElementById("nextStep1").style.display = "inline";
    $('#btnBack').click();
}
function clickBackStep2() {
    document.getElementById("nextStep3").style.display = "none";
    document.getElementById("backStep3").style.display = "none";
    document.getElementById("nextStep2").style.display = "inline";
    document.getElementById("backStep2").style.display = "inline";
    $('#btnBack').click();
}
function clickBackStep3() {
    document.getElementById("finish").style.display = "none";
    document.getElementById("backStep4").style.display = "none";
    document.getElementById("nextStep3").style.display = "inline";
    document.getElementById("backStep3").style.display = "inline";
    $('#btnBack').click();
}
function submit() {
    document.getElementById("formContract").submit();
}
</script>