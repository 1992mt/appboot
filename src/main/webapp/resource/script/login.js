require(['jquery','easyui','easyuilangzhCN','main','jwt','sjcl'], function ($,easyui,easyuilangzhCN){
	$(function() {
		
		$.parser.parse();
		
		$('#dlg1').dialog('center');
		$("#clear").click(function() {
			$("#ff").form("clear");
		});
		
		$(document).keydown(function(e) {
			e = window.event || arguments.callee.caller.arguments[0];
			if (e.keyCode == 13) {
				submit();
			}
		});
		
		$("#submit").click(function(){
			submit();
		});
	})
	
	function submit() {
			var userCode =$("#userCode").val();
			var password =$("#password").val();
			$("#ff").form("submit", {
				url : contextPath + "/login",
				onSubmit : function(param) {
					var ret = $(this).form('validate');
					if (ret) {
						$("#submit").linkbutton("disable");
					}
					return ret;
				},
				success : function(data) {
					$('#submit').linkbutton('enable');
					alert(data);
					data = JSON.parse(data);
					if (data.token.indexOf("valid user") < 0) {
				　  		localStorage.setItem('userCode',data.userCode);
				　  		location.href=contextPath+"/html/user.html";
					} else {
						$.messager.alert('提示', '账号或密码错误', 'info');
					}
				}
			});
		}
　});



	