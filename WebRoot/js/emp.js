function ValidateEmpno() {   //验证编号
  return ValidateRegex("emono",/^\d{4}$/);
}
function ValidateEname(){   //验证姓名
    return ValidateEmpty("ename");
}
function ValidateEmpjob() {   //验证职位
    return ValidateEmpty("job");
}
function ValidateHiredate(){   //验证日期
   return ValidateRegex("hiredate",/^\d{4}-\d{2}-\d{2}$/);
}
function ValidateSal(){   //验证基本工资
   return ValidateRegex("sal",/^\d+(\.\d{1,2})?$/);
}
function ValidateComm(){   //验证基本佣金
  return ValidateRegex("comm",/^\d+(\.\d{1,2})?$/);
}
function Validate() {
    return ValidateEmpno() &&
        ValidateEname() &&
        ValidateEmpjob() &&
        ValidateSal() &&
        ValidateComm() &&
        ValidateHiredate();
}
