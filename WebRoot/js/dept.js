function validateDeptno(){

	return ValidateEmpty("deptno");
}
function validateDname(){
	
	return ValidateEmpty("dname");
}
function validateLoc(){
	return ValidateEmpty("loc");
}

function validateInsert(){
	
	return validateDeptno() && validateDname() &&validateLoc();
}

function validateUpdate(){
	
	return  validateDname() &&validateLoc();
}

