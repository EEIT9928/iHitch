<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>假首頁</title> 
<!-- 資源連結 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="css/bootstrap-datepicker.min.css" />
<link rel="stylesheet" type="text/css" media="screen" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css" rel="stylesheet">
<script type="text/javascript" src="//code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
<script src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>

<!-- 資源連結 -->
<script type="text/javascript">
  $(function () {
    $('#datetimepicker1').datetimepicker({format:"YYYY/MM/DD"});
  });
</script>
<style >
body {
	background-image: url("https://media.giphy.com/media/NrGo0fIjPbvmU/source.gif");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
	background-size: cover;
}

#body {
	margin-top: 400px;
}

#fromcity {
	margin-left: 500px;
	width: 200px;
	float: left;
}

#fromarea {
	margin-left: 80px;
	width: 200px;
	float: left;
}

#tocity {
	margin-left: 80px;
	width: 200px;
	float: left;
}

#toarea {
	margin-left: 80px;
	width: 200px;
	float: left;
}

#datetimepicker1 {
	margin-left: 80px;
	width: 200px;
	float: left;
}

#search {
	float: left;
	margin-left: 80px;
}

#header {
	width: auto;
	background-color: rgba(0, 0, 0, 0.4);
}

#logo {
	width: 50;
	height: 80;
	background-color: rgba(255, 255, 255, 0.8);
}

#account {
	margin-top: 40px;
	margin-right: 50px;
	float: right;
}

#singup {
	margin-right: 20px;
}

#header a:visited {
	color: white;
}
#header a{
color: white
}
</style>
</head>
<body>
<div id="header">
<img id="logo" alt="i-hitch" src="https://i.imgur.com/vTa80jY.png"> 
<div id="account"><button id="singup" class="btn btn-primary btn-lg" >建立帳號</button>
<button id="login" class="btn btn-primary btn-lg"><a href="<c:url value="/switch/switchLogin.controller"/>" >登入</a></button></div>
</div>
<div id="body">
<form action="" method="get"> 
<input type="text" class="form-control" id="fromcity" name="from" placeholder="請輸入起點"  >
<input type="text" class="form-control" id="tocity" name="to"  placeholder="  請輸入終點"  >
<div class='input-group date' id='datetimepicker1'>
<input type="text" class="form-control" id="datetext" name="date"  placeholder="請選擇日期">
<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
</div>
<input type="submit" id="search" class="btn btn-success" value="搜尋">
</form>
</div>
</body>
</html>