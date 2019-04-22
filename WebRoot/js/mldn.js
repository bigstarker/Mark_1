
function ValidateEmpty(eleName) {
    var obj = document.getElementById(eleName);//获取对象
    var msg = document.getElementById(eleName + "Msg");//获取提示信息
    if(obj.value !=""){//进行验证
        obj.className = "right";
        if(msg !="") {
            msg.innerHTML = "<font color='green'>内容输入正确</font>";
        }
        return true;
    }else{//验证不通过
        obj.className = "wrong";
        if(msg !="") {
            msg.innerHTML = "<font color='red'>内容不允许为空</font>";
        }
        return false;
    }
}

function ValidateRegex(eleName,regex) {
    var obj = document.getElementById(eleName);//获取对象
    var msg = document.getElementById(eleName + "Msg");//获取提示信息
    if(regex.test(obj.value)){//进行验证
        obj.className = "right";
        if(msg != null) {
            msg.innerHTML = "<font color='green'>内容输入正确</font>";
        }
        return true;
    }else{//验证不通过
        obj.className = "wrong";
        if(msg != null) {	
            msg.innerHTML = "<font color='red'>输入格式错误</font>";
        }
        return false;
    }
}

function changeColor(obj, color) {
    obj.bgColor = color;
}


function checkboxSelect(obj,eleName){
	var item = document.all(eleName);
	if(item.length == undefined){	//表示只有一个元素 不为数组
		document.getElementById(eleName).checked = this.checked ;
	}else{
		for (var x = 0 ; x < item.length ; x++){
			item[x].checked = obj.checked;
		}
	}
		
}

//url：表示要删除的操作路径
//paramName：表示要传递的参数名称
//eleName:表示要取得数据的Id名称
function deleteAll(url,paramName,eleName){
	var data = "";  //保存所有的要删除的数据编号
	 //数据可能为数组也可能只有一个
	var item = document.all(eleName); 
	var count = 0;  //表示保存删除的数据个数
	  //判断是否有要删除的数据
	if(item.length == undefined){//表示只有一个元素 不为数组
		if(document.getElementById(eleName).checked == true ){//表示选中
			data += document.getElementById(eleName).value ;
			count ++;
		}	
	}else{
		for (var x = 0; x < item.length ; x++){
			if(item[x].checked == true){ 
				count ++;
				data += item[x].value + ".";
			}
		}
	}
	if(count > 0){  //有要删除的数据
		if(window.confirm("确定要删除他们吗？")){
			window.location = url + "?" + paramName + "=" +data ;
			//console.log(url + "?" + paramName + "=" + data )
		}
	}else{
		alert("您还未选择要删除的数据!");
	}
}



