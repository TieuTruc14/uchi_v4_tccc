/**
 * Created by tieut on 10/28/2017.
 */
app.factory('dataContractKind',['$http',function($http){

    var url=preUrl+'/json/contractKind/list.html';
    var data={};

    data.list=function(){
        return $http.get(url);
    };
    data.getById=function(id){
        return $http.get(url+"?id="+id);
    };

    return data;
}]);
