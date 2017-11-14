$(function() {
	ajaxSetup();
});
function ajaxSetup(){
	$.ajaxSetup({
		cache: false,
	    contentType:"application/x-www-form-urlencoded;charset=utf-8",  
	　  	beforeSend: function (xhr) {
	　  		var authorization = localStorage.getItem('authorization');
	　  		var userCode =localStorage.getItem('userCode');
	　  		xhr.setRequestHeader("authorization", userCode+"_"+authorization);
	   	},
	    complete:function(XMLHttpRequest,textStatus){  
	    }  
	}); 
}

