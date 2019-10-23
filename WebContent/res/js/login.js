window.onload = function() {
	onTest();
}
var isPhone = false,
	isPasswd = false;

function onTest() {
	phoneTest();
	passwdTest();
	submitTest();
}
function phoneTest() {
	var phoneInput = document.getElementById("phone");
	var tipSpan = document.getElementById("msg");
	var phoneStr = null; //  输入的内容
//	phoneInput.onfocus = function() {
//		change(tipSpan, phoneInput, "#ccc", "请填写11位电话号码");
//	}
	phoneInput.onblur = function() {
		phoneStr = phoneInput.value;
		if (phoneStr == "") {
			change(tipSpan, phoneInput, "red", "请填写电话号码");
			isPhone = false;
		} else if (phoneStr.length != 11 || isNaN(phoneStr)) {
			change(tipSpan, phoneInput, "red", "请填写正确的电话号码");
			isPhone = false;
		} else {
//			change(tipSpan, phoneInput, "green", phonetips.ok);
			isPhone = true;
		}
	}
}

function passwdTest() {
	var passwdInput = document.getElementById("passwd");
	var tipSpan = document.getElementById("msg");
	var passwdStr = null; //  输入的内容
//	passwdInput.onfocus = function() {
//		change(tipSpan, passwdInput, "#ccc", "请输入密码");
//	}
	passwdInput.onblur = function() {
		passwdStr = passwdInput.value;
		if (passwdStr == "") {
			change(tipSpan, passwdInput, "red", "请输入密码");
			isPasswd = false;
		} else if (passwdStr.length < 6 || passwdStr.length > 12) {
			change(tipSpan, passwdInput, "red", "密码错误！");
			isPasswd = false;
		} else {
//			change(tipSpan, passwdInput, "green", passwdtips.ok);
			isPasswd = true;
		}
	}
}
function submitTest() {
	var submitBtn = document.getElementById("sub");
	submitBtn.onclick = function() {
		if (isPhone && isPasswd) {
			return true;
		} else {
			alert("检查一下，还有错误哦~");
			return false;
		}
	}

}
function change(tipSpan, Input, color, tip) {
	Input.style.borderColor = color;
	tipSpan.style.color = color;
	tipSpan.innerHTML = tip;
}