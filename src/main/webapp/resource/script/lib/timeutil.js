function getCurrentDateTime() {
	var d, s;
	d = new Date();
	s = d.getFullYear() + "-";
	s = s + (d.getMonth() + 1) + "-";
	s += d.getDate() + " ";
	s += (d.getHours() < 10) ? ("0" + d.getHours()) : d.getHours();
	s += ":";
	s += (d.getMinutes() < 10) ? ("0" + d.getMinutes()) : d.getMinutes();
	s += ":";
	s += (d.getSeconds() < 10) ? ("0" + d.getSeconds()) : d.getSeconds();
	return (s);
}
function getWeeksAgoDateTime() {
	var d, s;
	d = new Date();
	d.setDate(d.getDate() - 7);
	s = d.getFullYear() + "-";
	s = s + (d.getMonth() + 1) + "-";
	s += d.getDate() + " ";
	s += (d.getHours() < 10) ? ("0" + d.getHours()) : d.getHours();
	s += ":";
	s += (d.getMinutes() < 10) ? ("0" + d.getMinutes()) : d.getMinutes();
	s += ":";
	s += (d.getSeconds() < 10) ? ("0" + d.getSeconds()) : d.getSeconds();
	return (s);
}

function getMonthAgoDateTime(){ 
	date = new Date();
	var daysInMonth = new Array([0],[31],[28],[31],[30],[31],[30],[31],[31],[30],[31],[30],[31]); 
	var strYear = date.getFullYear(); 
	var strDay = date.getDate(); 
	var strMonth = date.getMonth()+1; 
	if(strYear%4 == 0 && strYear%100 != 0){ 
	daysInMonth[2] = 29; 
	} 
	if(strMonth - 1 == 0) { 
	strYear -= 1; 
	strMonth = 12; 
	}else { 
	strMonth -= 1; 
	} 
	strDay = daysInMonth[strMonth] >= strDay ? strDay : daysInMonth[strMonth]; 
	if(strMonth<10) { 
	strMonth=strMonth; 
	} 
	if(strDay<10) { 
	strDay=strDay; 
	} 
	var strHour = "" + date.getHours();
	var strMinute = "" + date.getMinutes();
	var strSecond = "" + date.getSeconds();
	strHour = strHour.length == 1? "0"+ strHour : strHour;
	strMinute = strMinute.length == 1 ?"0"+ strMinute : strMinute;
	strSecond = strSecond.length == 1 ? "0"+ strSecond : strSecond;
	var datestr = strYear + "-" + strMonth + "-" + strDay + " " + strHour + ":" + strMinute +":" + strSecond; 
	return datestr; 
}

function getMonthAgoFirstDate(){ 
	date = new Date();
	var daysInMonth = new Array([0],[31],[28],[31],[30],[31],[30],[31],[31],[30],[31],[30],[31]); 
	var strYear = date.getFullYear(); 
	var strDay = "01";
	var strMonth = date.getMonth()+1; 
	if(strYear%4 == 0 && strYear%100 != 0){ 
	daysInMonth[2] = 29; 
	} 
	if(strMonth - 1 == 0) { 
	strYear -= 1; 
	strMonth = 12; 
	}else { 
	strMonth -= 1; 
	} 
	if(strMonth<10) { 
	strMonth="0"+strMonth; 
	} 
	if(strDay<10) { 
	strDay=strDay; 
	} 
	
	var datestr = strYear + "-" + strMonth + "-" + strDay;
	return datestr; 
} 

function getMonthAgoLastDate(){ 
	date = new Date();
	var daysInMonth = new Array([0],[31],[28],[31],[30],[31],[30],[31],[31],[30],[31],[30],[31]); 
	var strYear = date.getFullYear(); 
	var strDay = date.getDate(); 
	var strMonth = date.getMonth()+1; 
	if(strYear%4 == 0 && strYear%100 != 0){ 
	daysInMonth[2] = 29; 
	} 
	if(strMonth - 1 == 0) { 
	strYear -= 1; 
	strMonth = 12; 
	}else { 
	strMonth -= 1; 
	} 
	strDay = daysInMonth[strMonth]; 
	if(strMonth<10) { 
	strMonth=strMonth; 
	} 
	var datestr = strYear + "-" + strMonth + "-" + strDay;
	return datestr; 
} 

//对Date的扩展，将 Date 转化为指定格式的String 
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
//例子： 
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
Date.prototype.Format = function(fmt) { //author: meizz 
	var o = {
		"M+" : this.getMonth() + 1, //月份 
		"d+" : this.getDate(), //日 
		"h+" : this.getHours(), //小时 
		"m+" : this.getMinutes(), //分 
		"s+" : this.getSeconds(), //秒 
		"q+" : Math.floor((this.getMonth() + 3) / 3), //季度 
		"S" : this.getMilliseconds()
	//毫秒 
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}

/**
 * 将java Date类型转为字符串
 * @param dateStr
 * @returns
 */
function parseCSTDateToStr(dateStr){
	if(dateStr == null || dateStr=="" || dateStr ==undefined){
		return "";
	}
	var str = dateStr.replace("CST","UTC+0800");
	var date = new Date(str);
	return date.Format("yyyy-MM-dd hh:mm:ss");
}

function strToDate(timeStr){
	var t2 = timeStr.split(/[- :]/);
	var d2;
	if(t2[3] == undefined || t2[4] == undefined || t2[5] == undefined ){
		d2 = new Date(t2[0], t2[1]-1, t2[2]);
	}else{
		d2 = new Date(t2[0], t2[1]-1, t2[2], t2[3], t2[4], t2[5]);
	}
	return d2;
}
