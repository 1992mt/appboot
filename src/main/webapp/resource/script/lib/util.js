function isNumber(value){
	return /^[0-9]*$/.test(value);
} 
function isNull(value){
	return (value=="" ||value == null ||value ==undefined);
}
function isPhone(value){
	var reg = new RegExp("^(0|86|17951)?1[0-9]{10}$");
	return reg.test(value);
}


/**
 * 获取cookie中用户的购物车
 * @param openId
 */
function getCartCache(openId){
//		var cart = [{
//			prodId: 1,
//			acount: 5
//		},{
//			prodId: 2,
//			acount: 1
//		}];
	var cartCacheJson = $.cookie('cartCache_'+openId);
	if(isNull(cartCacheJson)){
	//$.cookie('cartCache', cartCache, {
	//	path : '/'
	//});
		return [];
	}else{
		var cartCache =JSON.parse(cartCacheJson);
		return cartCache;
	}
}
/**
 * 保存购物车信息到cookie
 * @param openId
 * @param cart
 */
function setCartCache(openId,cart){
//	$.cookie('cartCache_'+openId, cart, {
//		path : '/'
//	});
	$.cookie('cartCache_'+openId, cart);
}

(function($) {
	
	$.fn.getIndexUrl = function(){
		var t = location.href.split("/");
		var url = t[0]+"//"+t[1]+t[2]+"/"+t[3]+"/";
		return url;
	}
	
	$.fn.getUrl = function(){
		var t = location.href.split("/");
		var url = t[0]+"//"+t[1]+t[2]+"/";
		return url;
	}
	
	$.fn.serializeForm = function() {
		var formArray = $(this).serializeArray();
		var oRet ={};
		$(formArray).each(function(i,val){
			var name = oRet[this.name];
			if( name==null || name==""|| name==undefined){
				 oRet[this.name] = this.value;
			}else{
				 oRet[this.name]+=","+this.value;
			}
        	
        });
		return oRet;
    }
	
}(jQuery));


function flycart(){
	var cart = $(".mycart #cartIcon");
    var offset = cart.offset(); 
    $(".my_item .item_add[flyed=false]").click(function(event){ 
        var addcar = $(this);
        var prod = {};
        var prodBtn = addcar.find("a");
        var p = addcar.parents(".my_item");
        var img = p.find("img");
        var src = img.attr('src'); 
        var flyer = $('<img class="u-flyer" src="'+src+'">'); 
        
        prod.prodId = prodBtn.attr("data-prodId");
		prod.prodName = prodBtn.attr("data-prodName");
		prod.prodType = prodBtn.attr("data-prodType");
		 var acount = 1;
	        var ac = p.find("input[name=number]");
	        if(ac.length !=0){
	        	if(!isNumber(ac.val())){
	        		alert("请输入正确的商品数量！");
	        		return;
	        	}
	        	acount = Number(ac.val());
	        }
		prod.acount = acount;
		prod.price = prodBtn.data("price");
		var srcl = src.split("images/");
		if(srcl.length >0){
			prod.pPath= src.split("images/")[1];
		}
        var price = prod.price;
       
        flyer.fly({ 
            start: { 
            	width: img.width()/2+"px", //开始时宽度 
                height: img.height()/2+"px", //开始时高度 
            	left: event.screenX-300, //开始位置（必填）#fly元素会被设置成position: fixed  大屏幕-300
                top: event.screenY-200 //开始位置（必填） 大屏幕-400
            }, 
            end: { 
                left: offset.left+10, //结束位置（必填） 
                top: offset.top+10, //结束位置（必填） 
                width: 10, //结束时宽度 
                height: 10 //结束时高度 
            }, 
            onEnd: function(){ //结束回调 
                //$(this).remove(); //移除dom 
                $(".u-flyer").remove();
                //设置badge数目
                var badge = $(".mycart .badge");
                if(badge.length ==0){
                	badge.text(1);
                }else{
                	var old = badge.text();
                	badge.text(Number(old)+Number(acount));
                }
                //设置总金额
                var total = $(".mycart #totalP");
                var totalP =total.text();
                total.text((Number(totalP)+Number(price)*Number(acount)).toFixed(2));
                
                //缓存保存商品编号
        		var cartt = getCartCache(openId);
        		var sameFlag = false;
        		$(cartt).each(function(i,val){
        			if(val.prodId == prod.prodId){
        				sameFlag = true;
        				val.acount = Number(val.acount)+Number(acount);
        				return false;
        			}
        		});
        		if(!sameFlag){
        			cartt.push(prod);
        		}
        		var cartJson = JSON.stringify(cartt);
        		//alert(cartJson);
        		setCartCache(openId, cartJson);
            } 
        }); 
    });
    $(".my_item .item_add[flyed=false]").attr("flyed",true);
}

function setFileboxLabel(){
 	$(".filebox-label").css({
 		width:"100%",
 		height:"100%",
 		"margin-top":"-3px"
 	});
 	$(".filebox").css("margin-top","-60px");
}

function enterKeydown(callback){
	$(document).keydown(function(e) {
		e = window.event || arguments.callee.caller.arguments[0];
			if (e.keyCode == 13) {
				callback();
			}
	});
}

