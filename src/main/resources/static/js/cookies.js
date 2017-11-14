//取Cookie的值  
function GetCookie(name) {  
    var arg = name + "=";  
    var alen = arg.length;  
    var clen = document.cookie.length;  
    var i = 0;  
    while (i < clen) {  
        var j = i + alen;  
        if (document.cookie.substring(i, j) == arg) return getCookieVal(j);  
        i = document.cookie.indexOf(" ", i) + 1;  
        if (i == 0) break;  
    }  
    return null;  
}  
 //写入到Cookie  
//name:cookie名称  value:cookie值   
function SetCookie(name, value) {  
    var Days = 30;  
    var exp = new Date();  
    exp.setTime(exp.getTime() + 60 * 10000);//过期时间 10分钟  
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();  
}  
  
function getCookieVal(offset) {  
    var endstr = document.cookie.indexOf(";", offset);  
    if (endstr == -1) endstr = document.cookie.length;  
    return unescape(document.cookie.substring(offset, endstr));  
}  