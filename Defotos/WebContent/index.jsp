<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Defotos</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/fb.js"></script>
<link type="text/css" rel="stylesheet" href="css/popup.css"/>
<link type="text/css" rel="stylesheet" href="css/menu.css" />
<link type="text/css" rel="stylesheet" href="css/index.css"/>

</head>
<body>
<s:div cssClass="popup">
<h4>FORGOT PASSWORD</h4><img src="images/c1.PNG" id="close"/>

<s:form action="forget" method="post" id="form1" theme="simple">
<s:div cssClass="middlepopup">
<label>Email*</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<s:textfield placeholder="Login Email" cssClass="textpopup" name="forgetpass" errorPosition="top"></s:textfield><br>
<s:submit value="SEND" cssClass="btn"></s:submit>
</s:div>
</s:form>
</s:div>
<s:div cssClass="mainpopup"></s:div>
	<s:div cssClass="main-div">
		<s:div cssClass="smalldiv"></s:div>
		<s:div cssClass="header">
			<s:div cssClass="logo">
			
			</s:div>
			<s:div id="cssmenu">

				<ul>
					<li class="active active1"><s:a href="#" tooltip="Login">Home</s:a></li>
					<li class="active1"><s:a href="register" tooltip="Blog">SignUp</s:a></li>
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

				<p class="text1">Share your photos in every one in our commuity
				</p>
			</s:div>
			<s:div cssClass="loginContainer">
				<s:form action="login" theme="simple">

					<table border="0">
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
							<td><label for="terms" style="font-size: 13px; margin-left: -300px; color: white;">Remember
									me <span style="margin-left:70px; color: white;" class="fp">Forgot
										Password?</span>
							</label></td>
						<tr>
							<td><s:submit name="submit" cssClass="submit" value="Login"></s:submit></td>
						</tr>
						<tr>
							<td><s:submit action="fbsetup" name="submit"
									cssClass="submit" value="Login With Facebook" id="Popup"></s:submit></td>
						</tr>

					</table>
				</s:form>
			</s:div>

		</s:div>

	</s:div>

	<s:div cssClass="footer">

		<s:div cssClass="followdiv">
			<s:div cssClass="follow">
				<ul>
					<li><s:a href="#">
							<img src="images/fb.png" />
						</s:a></li>
					<li><s:a href="#">
							<img src="images/tw.png" />
						</s:a></li>
					<li><s:a href="#">
							<img src="images/in.png" />
						</s:a></li>
					<li><s:a href="#">
							<img src="images/yt.png" />
						</s:a></li>
					<li><s:a href="#">
							<img src="images/nw.png" />
						</s:a></li>
				</ul>
			</s:div>

		</s:div>

	</s:div>
	<s:a action="imgDownload"></s:a>


</body>
</html>