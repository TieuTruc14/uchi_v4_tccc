/**
 * Created by tieut on 10/28/2017.
 */
app.factory('dataContractTemplate',['$http',function($http){

    var url=preUrl+'/json/contractTemplate/list.html';
    var data={};

    data.listByContractKind=function(kindId){
        return $http.get(url+"?kindId="+kindId);
    };



    return data;
}]);
