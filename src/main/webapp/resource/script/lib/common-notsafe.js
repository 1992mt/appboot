function createAuthorization(){
	var authorization = localStorage.getItem('authorization');
	if(authorization== null ||authorization=="null"){
		authorization ="";
	}
	return authorization;
}
	 

