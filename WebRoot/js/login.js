/**
 * 
 */
function ValidateMid(){
	return ValidateEmpty("mid");
}
function ValidatePassWord(){
	return ValidateEmpty("password");
}
function Validate(){
	return ValidateMid()&&ValidatePassWord();
}