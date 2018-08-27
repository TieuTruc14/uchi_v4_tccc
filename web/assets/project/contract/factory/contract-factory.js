/**
 * Created by tieut on 10/27/2017.
 */
app.factory('dataContract',['$http',function($http){

    var url='json/contract/';
    var urlAdd=preUrl+'/json/contract/add.html';
    var urlContractNumber=preUrl+'/json/contract/get-contract-number.html';
    var data={};

    data.getContract=function(){
        return $http.get(url);
    };
    data.addContract=function(contract){
        return $http.post(urlAdd+"?item="+contract,{headers: {'Content-Type': 'application/json'} });
    };

    data.getContractNumber=function (id) {
        return $http.get(urlContractNumber+"?id="+id);
    };


    return data;
}]);
