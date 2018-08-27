/**
 * Created by tieut on 11/1/2017.
 */
app.factory('dataUser',['$http',function($http){

    var urlPosition=preUrl+'/json/user/get-by-position.html';
    var url=preUrl+'/json/user/get.html';
    var urlBank=preUrl+'/json/bank/list.html';
    var data={};

    data.getUserById=function(id){
        return $http.get(url+"?id="+id);
    };
    data.getByPosition=function(position){
        return $http.get(urlPosition+"?position="+position);
    };

    data.listBank=function(){
        return $http.get(urlBank);
    };

    return data;
}]);
