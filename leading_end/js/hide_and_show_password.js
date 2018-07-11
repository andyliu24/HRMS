	function hideShowPwd(){
				var pwd = document.getElementById("pass");
				var icon = document.getElementById("ico");
				if(pwd.type == "password"){
					pwd.type = "text";
					//删除class属性
					icon.removeAttribute("class");
					//添加属性class = "fa fa-unlock"
					icon.setAttribute("class","fa fa-unlock");
				}
				else{
					pwd.type = "password";
					icon.removeAttribute("class");
					icon.setAttribute("class","fa fa-lock");
				}
			}