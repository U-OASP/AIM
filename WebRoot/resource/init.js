//itsm地址 最后必须加上/
//var itsm = "http://192.8.124.183:9080/itsm/";
//var itsm = "http://192.8.124.183:9080/cas/login";
var itsm = "http://192.8.124.183:9080/itsm/";

/**
 * 执行调用本地ActiveX
 * 
 * @param exeName
 */
function Execute (exeName) {
	//王帅 客户端执行函数
	window.oldOnError = window.onerror;
	//出现错误
		window.onerror = function (err) {
		if (err.indexOf('utomation' ) != -1) {
			alert('IE安全级别设置过高，命令已经被强制禁止！');
			return true;
		}
		else 
			return false;
	};
 
	var wsh = new ActiveXObject('WScript.Shell');
	try
	{
		if (wsh)
		{	

			var base_path = new String();
			//重新设置
			base_path  = "C:\\统一安全平台";
			wsh.CurrentDirectory = base_path + "\\" ;
			wsh.Run(exeName);

		}
	}
	catch(e)
	{
		alert(e.description)
	}

	window.onerror = window.oldOnError;
}
