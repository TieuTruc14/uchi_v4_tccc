/**
 * Created by tieut on 10/27/2017.
 */
var app = angular.module('contract', ["ngSanitize"]);
// app.run(function(editableOptions) {
//     editableOptions.theme = 'bs3'; // bootstrap3 theme. Can be also 'bs2', 'default'
// });

/*load default doi tuong de gan chung*/
var contract={id:"",type:"",contractTemplate:"",contractNumber:"",contractValue:"",relationObject:"",propertyInfo:"",notary:"",drafter:"",receivedDate:"",notaryDate:"",numberCopyContract:"",numberOfPage:"",notaryCost:"",remunerationCost:"",notaryCostTotal:"",notaryOutside:"",notaryPlaceOutside:"",bank:"",bankServiceCost:"",crediterName:"",fileName:null,filePath:"",errorStatus:false,errorUser:"",errorDescription:"",additionStatus:false,additionDescription:"",cancelStatus:false,cancelDescription:"",cancelRelationContract:"",contractPeriod:"",mortageCancelStatus:false,mortageCancelDate:"",mortageCancelNote:"",originalStorePlace:"",note:"",summary:"",content:"",jsonProperty:"",jsonPrivy:"",userCreated:"",dateCreated:"",userUpdated:"",dateUpdated:""};


var privy={ name: "",type:"", id: "",action:"", persons: [ ] };
var person= {template:"", id: "",name: "",birthday:"",passport:"",certification_date:"",certification_place:"",address:"",position:"", description:"",org_name:"",org_address:"",org_code:"",first_registed_date:"",number_change_registed:"",change_registed_date:"",department_issue:"" };
// var duongsu_pre='<div ng-repeat="item in privys.privy track by $index"> <div class=""><b style="font-family: Times New Roman; font-size: 14pt;" class=""> Bên <span ng-model="item.action" editspan="item.action" class="inputcontract" contenteditable="true">{{item.action}}</span></b> (sau đây gọi là {{item.name}}): </div> <div ng-repeat="user in item.persons track by $index" class="personList"><div ng-switch on="user.template">';
var duongsu_pre='<div ng-repeat="item in privys.privy track by $index"> <div class="" ng-switch on="item.type"> <div ng-switch-when="0"> </div> <div ng-switch-default> <b style="font-family: Times New Roman; font-size: 14pt;" class=""> Bên <span ng-model="item.action" editspan="item.action" class="inputcontract" contenteditable="true">{{item.action}}</span></b> (sau đây gọi là {{item.name}}): </div> </div> <div ng-repeat="user in item.persons track by $index" class="personList"> <div ng-switch on="user.template">';
var duongsu_suff='</div></div></div>';

var taisan={ type: "", id:"",template:"", property_info:"", owner_info:"", other_info:"",restrict:"",apartment:{apartment_address:"",apartment_number:"",apartment_floor:"",apartment_area_use:"",apartment_area_build:"",apartment_structure:"",apartment_total_floor:""}, land: { land_certificate:"", land_issue_place:"", land_issue_date:"", land_map_number:"", land_number:"", land_address:"", land_area:"", land_area_text:"", land_public_area:"", land_private_area:"", land_use_purpose:"", land_use_period:"", land_use_origin:"", land_associate_property:"", land_street:"", land_district:"", land_province:"", land_full_of_area:"" }, vehicle:{ car_license_number:"", car_regist_number:"", car_issue_place:"", car_issue_date:"", car_frame_number:"", car_machine_number:"" } };
var taisan_pre='<div ng-repeat="item in listProperty.properties track by $index"><div ng-switch on="item.template">';
var taisan_suff='</div></div>';


/*lay ngay hien tại để gán max cho datepicker*/
var toDay=new Date();
var endDateofDatepicker=("0" + toDay.getDate()).slice(-2) + '/' + ("0" + (toDay.getMonth() + 1)).slice(-2) + '/' +  toDay.getFullYear();
/*khu vực viet câm' nhập các ký tự trên bàn phím*/
var digitsOnly = /[1234567890]/g;
var forDate=/[1234567890/]/g;
var NoOnly = /[~]/g;
var integerOnly = /[0-9\.]/g;
var alphaOnly = /[A-Za-z]/g;

function restrictCharacters(myfield, e, restrictionType) {
    if (!e) var e = window.event
    if (e.keyCode) code = e.keyCode;
    else if (e.which) code = e.which;
    var character = String.fromCharCode(code);

    // if they pressed esc... remove focus from field...
    if (code==27) { this.blur(); return false; }

    // ignore if they are press other keys
    // strange because code: 39 is the down key AND ' key...
    // and DEL also equals .
    if (!e.ctrlKey && code!=9 && code!=8 && code!=36 && code!=37 && code!=38 && (code!=39 || (code==39 && character=="'")) && code!=40) {
        if (character.match(restrictionType)) {
            return true;
        } else {
            return false;
        }

    }
}