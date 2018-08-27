/**
 * Created by tieut on 10/28/2017.
 */
app.controller('contractCtrl',['$scope','$http','$filter','$window','fileUpload','$timeout','$q','dataContract','dataContractKind','dataContractTemplate','dataUser'
    ,function ($scope,$http,$filter,$window,fileUpload,$timeout,$q,dataContract,dataContractKind,dataContractTemplate,dataUser) {
    $scope.item=contract;

    listContractKind();
    function listContractKind(){
        dataContractKind.list().then(function(response){
            $scope.contractKinds=response.data.items;
        },function(response){
            // failure callback
            $("#errorEdit").modal('show');
        });
    }

    getContractNumber();
    function getContractNumber() {
        dataContract.getContractNumber(toDay.getFullYear()).then(function (response) {
            $scope.item.contractNumber=response.data.value;
        });
    }
    /*load date default*/
    $scope.item.receivedDate=("0" + toDay.getDate()).slice(-2) + '/' + ("0" + (toDay.getMonth() + 1)).slice(-2) + '/' +  toDay.getFullYear();
    $scope.item.notaryDate=("0" + toDay.getDate()).slice(-2) + '/' + ("0" + (toDay.getMonth() + 1)).slice(-2) + '/' +  toDay.getFullYear();
    /*load notary and drafter*/
    getNotarys();
    getDrafters();
    function getNotarys() {
        dataUser.getByPosition("02").then(function (response) {
            $scope.notarys=response.data.items;
        })
    }
    function getDrafters() {
        dataUser.getByPosition("03").then(function (response) {
            $scope.drafters=response.data.items;
        })
    }
    /*load bank*/

    function getBanks() {
        dataUser.listBank().then(function (response) {
            $scope.banks=response.data.items;
        })
    }

    $scope.changeContractKind=function (kindId) {
        dataContractTemplate.listByContractKind(kindId).then(function (response) {
            $scope.contractTemplates=response.data.items;
        })
    };
    $scope.changeContractTemplate=function (templateId) {
        $scope.contractTemp=$scope.loadContractTemplate(templateId);
        if($scope.contractTemp!=null){
            $scope.item.content=$scope.contractTemp.content;
        }
    }
    $scope.loadContractTemplate=function (tempId) {
        var temp=$filter('filter')($scope.contractTemplates,{id:tempId},true);
        if(temp!=null && temp!='undefined' && temp!="") return (temp[0]);
        return null;
    }
    
    $scope.addContract=function () {
        var contractAdd=JSON.parse(JSON.stringify($scope.item)).toString();
        console.log(contractAdd);
        console.log($scope.item);
        // var contractAdd=angular.toJson($scope.items);
        dataContract.addContract(contractAdd).then(function (response) {
            console.log(response);
        })
    }
    
    // $scope.docsotien=function (sotien) {
    //     $scope.item.note=DocTienBangChu(sotien);
    // }
}]);
