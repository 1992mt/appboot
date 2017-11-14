/**
 * 搜索心得
 * @param flag
 */
function searchExperience(flag) {
	//				if(flag){
	var userId = $("#userId").val();
	//				}

	var manageFlag = $("#manageId").val();
	var username = $("#usernameId").val();
	$
			.ajax({
				type : 'post',
				url : "listAllByPage",
				dataType : 'json',
				data : {
					"rows" : 20,
					"page" : 0,
					"userId" : userId
				},
				success : function(data) {
					if (data) {
						console.log("success");
						//清空列表数据
						$(".am-list li").remove();
						$
								.each(
										data,
										function(i, n) {
											//
											var deleteExp = '<a class="am-u-sm-2 am-u-sm-offset-10" data-id="'
													+ n.id
													+ '" onclick="deleteExperience('
													+ n.id + ')">删除</a>';//删除
											var commentHtml = '<a data-id="'
													+ n.id
													+ '"  onclick="addComment('+ n.id + ')">评论</a>';//评论
											var commentMoreHtml = '&nbsp;&nbsp;&nbsp;<a  data-id="'
													+ n.id
													+ '" onclick="window.location=\'toComment?id='
													+ n.id
													+ '\'">更多&gt;&gt;</a>';//更多
											var liStr = '<li class="am-g"><div><a class="am-u-sm-9" href=".'+n.fileurl+'" class="am-list-item-hd ">'
													+ n.userName
													+ '&nbsp;&nbsp;&nbsp;'
													+ n.content + '</a>';
											if (manageFlag
													|| username == n.userName) {//管理员或者自己可以删除心得
												liStr += deleteExp;
											}
											liStr += '</div><div><span class="am-u-sm-8">时间：'
													+ n.addtime
													+ '</span><div class="commentClass">'
													+ commentHtml
													+ commentMoreHtml
													+ '</div></div></li>';
											$(".am-list").append(liStr);
										});
					} else {
						console.log("fail");
					}
				},
				error : function() {
					console.log("exception");
				}
			})
};

/**
 * 删除心得
 */
function deleteExperience(expiddel) {
	console.log("expiddel:" + expiddel);
	$('#my-confirm').modal({
		relatedTarget : this,
		onConfirm : function(options) {
			/*  var $link = $(this.relatedTarget).prev('a');
			 var msg = $link.length ? '你要删除的链接 ID 为 ' + $link.data('id') :
			   '确定了，但不知道要整哪样';
			 alert(msg); */
			$.ajax({
				type : 'post',
				url : "deletExperience",
				dataType : 'json',
				cache : false,
				data : {
					"id" : expiddel
				},
				success : function(data) {
					if (data.flag) {//删除成功
						alert("删除成功");
						searchExperience();
					} else {
						alert("删除失败");
						console.log("fail");
					}
				},
				error : function() {
					console.log("exception");
				}
			})
		},
		// closeOnConfirm: false,
		onCancel : function() {
			// alert('算求，不弄了');
		}
	});
};

/**
 * 评论心得
 * 
 */
function addComment(expId) {
		$('#my-prompt').modal({
			relatedTarget : this,
			onConfirm : function(e) {
				//alert('你输入的是：' + e.data || '')
				$.ajax({
					type : 'post',
					url : "addComment",
					dataType : 'json',
					cache : false,
					data : {
						"userId" : $("#userId").val(),
						"expId" : expId,
						"content" : e.data
					},
					success : function(data) {
						if (data>0) {//评论成功
							searchExperience();
						} else {
							console.log("fail");
						}
					},
					error : function() {
						console.log("exception");
					}
				})
			},
			onCancel : function(e) {
				//alert('不想说!');
			}
		});
	};
	
	
/**
 * 查询评论
 */
function listCommentByPage(){
//	if(flag){
	var userId = $("#userId").val();
	//				}

	var expId=$("#expId").val();
	var manageFlag = $("#manageId").val();
	var username = $("#usernameId").val();
	$.ajax({
				type : 'post',
				url : "listCommentByPage",
				dataType : 'json',
				data : {
					"rows" : 20,
					"page" : 0,
					"id" : expId
				},
				success : function(data) {
					if (data) {
						console.log("success");
						//清空列表数据
						$(".am-list li").remove();
						$.each(data,function(i, n) {
											//
											var deleteExp = '<a class="am-u-sm-2 am-u-sm-offset-10" data-id="'
													+ n.id
													+ '" onclick="deleteComment('
													+ n.id + ')">删除</a>';//删除
											var liStr = '<li class="am-g"><div><a class="am-u-sm-9" href="#" class="am-list-item-hd ">'
													+ n.userName
													+ '&nbsp;&nbsp;&nbsp;'
													+ n.content + '</a>';
											if (manageFlag
													|| username == n.userName) {//管理员或者自己可以删除心得
												liStr += deleteExp;
											}
											liStr += '</div><div><span class="am-u-sm-10">时间：'
													+ n.commenttime
													+ '</span><div class="commentClass">'
													+ '</div></div></li>';
											$(".am-list").append(liStr);
										});
					} else {
						$(".am-list").append("暂无数据");
						console.log("fail");
					}
				},
				error : function() {
					console.log("exception");
				}
			});
}

/**
 * 删除评论
*/
function deleteComment(commentId){
	console.log("commentId:" + commentId);
	$('#my-confirm').modal({
		relatedTarget : this,
		onConfirm : function(options) {
			/*  var $link = $(this.relatedTarget).prev('a');
			 var msg = $link.length ? '你要删除的链接 ID 为 ' + $link.data('id') :
			   '确定了，但不知道要整哪样';
			 alert(msg); */
			$.ajax({
				type : 'post',
				url : "deleteComment",
				dataType : 'json',
				cache : false,
				data : {
					"id" : commentId
				},
				success : function(data) {
					if (data>0) {//删除成功
						alert("删除成功");
						listCommentByPage();
					} else {
						alert("删除失败");
						console.log("fail");
					}
				},
				error : function() {
					console.log("exception");
				}
			})
		},
		// closeOnConfirm: false,
		onCancel : function() {
			// alert('算求，不弄了');
		}
	});
}
