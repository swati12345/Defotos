<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Defotos</title>
<link rel="stylesheet" type="text/css"
	href="/FinalProject/css/index.css" />
<script type="text/javascript"
	src="/FinalProject/js/jquery-1.10.2.min.js"></script>
<script>
	
</script>
<style type="text/css">
.header {
	border: 0px solid #000;
	width: 100%;
	height: 50px;
}

.logo {
	border: 0px solid #000;
	width: 200px;
	height: 50px;
	float: left;
	background-image: url("/FinalProject/images/logo_img.PNG");
}

#cssmenu,#cssmenu ul,#cssmenu li #cssmenu a {
	list-style: none;
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 14px;
	font-family: Helvetica;
	line-height: 1;
}

#cssmenu {
	width: 650px;
	float: left;
	margin-left: 400px;
	border: 0px solid #000;
}

#cssmenu ul {
	margin-top: 5px;
	margin-left: 50px;
}

#cssmenu ul:before {
	content: '';
	display: block;
}

#cssmenu ul:after {
	content: '';
	display: table;
	clear: both;
}

#cssmenu a,#cssmenu a:link,#cssmenu a:visited {
	padding: 15px 20px;
	display: block;
	text-decoration: none;
	color: #ffffff;
	text-shadow: 0 -1px 1px #27240d;
}

#cssmenu a:hover {
	color: #27240d;
	text-shadow: 0 1px 1px #bfb241;
}

#cssmenu li {
	float: left; //
	border-right: 1px solid #aca13a;
	background-color: blue;
}

#cssmenu .active1 {
	float: left;
	border-right: 1px solid #aca13a;
}

#cssmenu li:hover {
	
}

#cssmenu li:first-child {
	border-left: none;
	-webkit-border-radius: 4px 0 0 4px;
	-moz-border-radius: 4px 0 0 4px;
	border-radius: 4px 0 0 4px;
}

.inline {
	width: 100%;
	height: 60px;
	float: right;
}

.inline ul {
	list-style: none;
	padding: 10px;
}

.inline ul li {
	width: 29%;
	float: left;
	padding-left: 15px;
}

.inline ul li a {
	display: block;
	font-family: Montserrat, sans-serif;
	float: left;
	text-decoration: none;
	color: #aaa;
	font-size: 17px;
	font-weight: normal;
	width: 200px;
	margin-top: -15px;
	padding: 0;
	height: 35px;
	text-align: center;
	line-height: 35px;
	text-transform: uppercase;
	border: solid 1px transparent;
	font-weight: bold;
}

.inline ul li a:HOVER {
	color: #cccccc;
	border: solid 1px #0e0e0e;
	box-shadow: 0px 0px 4px #100f10;
	border: solid 1px #0e0e0e;
}

.container {
	width: 99.99%;
	height: 480px;
	border: 1px solid #000;
	background-color: black;
	background-image: url("/FinalProject/images/octicons-bg.png");
}

.slider {
	border: 1px solid white;
	width: 800px;
	height: 450px;
	float: left;
}

.text {
	color: white;
	font-size: 75px;
	margin-left: 100px;
	margin-top: 100px;
	font-weight: 15px;
}

.text1 {
	color: white;
	font-size: 35px;
	margin-left: 100px;
	font-weight: 25px;
}

.loginContainer {
	border: 1px solid white;
	width: 540px;
	height: 450px;
	margin-left: 800px;
	
}
table
{

margin-top: 50px;
margin-left: 50px;
}
.errorMessage {
	list-style: none;
	width: 224px;
	padding: 5px 10px 5px 20px;
} 
.errorMessage li span{
	margin-top: -20px;
}
.submit
{
color: #fff;
background-color: #569e3d;
background-image: -moz-linear-gradient(#79d858, #569e3d);
background-image: -webkit-linear-gradient(#79d858, #569e3d);
background-image: linear-gradient(#79d858, #569e3d);
background-repeat: repeat-x;
border-color: #4a993e;
margin-top:10px;
width: 300px;
height: 50px;
font-size: 40px;
padding: 10px;

}
.textfield
{
padding: 10px;
font-size: 16px;
border-radius: 5px;
width: 300px;

}
a{

text-decoration: none
}
</style>
</head>
<body>
	<s:div cssClass="main-div">
		<s:div cssClass="smalldiv"></s:div>
		<s:div cssClass="header">
			<s:div cssClass="logo">
			</s:div>
			<s:div id="cssmenu">

				<ul>
					<li class="active active1"><s:a href="#" tooltip="Login">Home</s:a></li>
					<li class="active1"><s:a href="#" tooltip="Blog">SignUp</s:a></li>
					<li class="active1"><s:a href="#" tooltip="Contact Us">About Defotos</s:a></li>
					<li class="active1"><s:a href="#" tooltip="About Us">About Us</s:a></li>
					<li class="last"><s:a href="#" tooltip="Home">Contact Us</s:a></li>
				</ul>
			</s:div>

		</s:div>
		<s:div cssClass="container">
			<s:div cssClass="slider">
				<p class="text">
					Share Interact and </br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Discover
				</p>

				<p class="text1">share your photos in every one in our commuity
				</p>
			</s:div>
			<s:div cssClass="loginContainer">
				<s:form action="login" theme="simple">

					<table border="1">
						<tr>
							<td><s:textfield name="username" placeholder="Username"
									cssClass="textfield"></s:textfield></td>
						</tr>
						<tr>
							<td class="errortd"><s:div cssClass="error">
									<s:fielderror fieldName="username"></s:fielderror>
								</s:div></td>
						</tr>
						<tr>
							<td><s:password name="password" placeholder="*****"
									cssClass="textfield"></s:password></td>
						</tr>
						<tr>
							<td class="errortd"><s:div cssClass="error">
									<s:fielderror fieldName="password"></s:fielderror>
								</s:div></td>
						</tr>
						<tr>
							<td><s:checkbox name="terms" fieldValue="true"
									cssStyle="display:inline;" cssClass="loginbtn"></s:checkbox></td>
							<td><label for="terms"
								style="font-size: 20px; margin-left: -300px; color: white;">Remember Me<s:a cssStyle="margin-left: 20px;color: white;" herf="">Forgot Password</s:a></label></td>
						<tr>
							<td><s:submit name="submit" cssClass="submit" value="Login"></s:submit></td>
						</tr>

					</table>
				</s:form>

			</s:div>

		</s:div>


		<s:div cssClass="secondcontainer">

		</s:div>

		<s:div cssClass="footer">


		</s:div>
	</s:div>

</body>
</html>