require(['jquery','easyui','easyuilangzhCN','main','jwt','sjcl','timeutil'], function ($,easyui,easyuilangzhCN){
	$(function() {
		
		$.parser.parse();
		
		$.ajax({
			url : contextPath+'/api/users/admin3',
			type : 'get',
			dataType : 'json',
			success : function(data) {
				alert(JSON.stringify(data));
			},
			error : function(e) {
				alert(e.responseText);
			}
		});
		
		$("#logout").click(function(){
			logOut();
		});
		
	})
	
	function logOut(){
		$.ajax({
			url : contextPath+'/login/logout',
			type : 'get',
			success : function(data) {
				alert(JSON.stringify(data));
				location.href=contextPath+"/html/login.html";
			},
			error : function(e) {
				alert(e.responseText);
			}
		});
	}
　});



	
