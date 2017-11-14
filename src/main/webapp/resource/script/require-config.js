requirejs.config({
    // baseUrl: 'js/lib',
    paths: {
        jquery:'lib/jquery.min',
        easyui:'lib/jquery.easyui.min',
        easyuimobile:'lib/jquery.easyui.mobile',
        easyuilangzhCN:'lib/easyui-lang-zh_CN',
        main:'main',
        jwt:'jwt/jwt-token',
        sjcl:'jwt-lib/sjcl/sjcl',
        timeutil:'lib/timeutil'
    },
    shim: {
    	'jquery':{
    	　　　　　　exports: '$'
    	　　　　},
    	 'main':{
  	　　　　　　exports: 'main',
  	      		deps: ['jquery']
  	　　　　},
    	'easyui':{
    	　　　　　　exports: 'easyui',
    	      	   deps: ['jquery']
    	　　　　},
    	'easyuilangzhCN':{
  	　　　　　　exports: 'easyui',
	      	   deps: ['jquery','easyui']
  	　　　　},
    	'easyuimobile':{
  	　　　　　　exports: 'easyuimobile',
  	      	   deps: ['jquery','easyui']
  	　　　　},
		'datagridscrollview':{
		　　　　exports: 'datagridscrollview',
		    	   deps: ['jquery','easyui']
		},
		'timeutil':{
		　　　　exports: 'timeutil'
		},
		 'jwt':{
			　exports: 'jwttoken'
		 },
		 'sjcl':{
			 exports: 'sjcltoken'
		 }
　　}
});


var contextPath = (function(){
	var location = (window.location+'').split('/');
	var basePath = location[0]+'//'+location[2];
	if(location[3]=="html"){
		return basePath;
	}else{
		return basePath+'/'+location[3];
	}
})();



