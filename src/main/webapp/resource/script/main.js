$(function() {
	ajaxSetup();
});
function ajaxSetup(){
	$.ajaxSetup({
		cache: false,
	    contentType:"application/x-www-form-urlencoded;charset=utf-8",  
	　  	beforeSend: function (xhr) {
	　  		var authorization = createAuthorization();
	　  		//console.log(authorization);
	　  		xhr.setRequestHeader("authorization", authorization);
	   		},
	    complete:function(XMLHttpRequest,textStatus){  
	    }  
	}); 
}

function guid() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
        return v.toString(16);
    });
}

function createAuthorization(){
	var userCode = localStorage.getItem('userCode');
		var header = {"typ":"JWT","alg":"HS256"};
		var d = new Date();
		var now = d.getTime()/1000;
		console.log(d.Format("yyyy-MM-dd hh:mm:ss"));
		d.setSeconds(d.getSeconds()+300);
		var exp = d.getTime()/1000; //3秒过期
		console.log(d.Format("yyyy-MM-dd hh:mm:ss"));
		var signature ={
			"jti":guid(),//黑名单方式需要jti
			"iss":"lhy",
			"sub":userCode,
			"iat":now,
			"exp":exp
		};
		var token = new jwt.WebToken(JSON.stringify(signature), JSON.stringify(header));
		var signed = token.serialize("helloworld");
		return userCode+"_"+signed;
}
