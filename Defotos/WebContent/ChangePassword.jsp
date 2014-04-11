<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style type="text/css">
html,body {
	height: 100%;
	width: 100%;
	padding: 0px;
	background-image: url("/Defotos/images/bck.jpg");
}

.main-div
 {
     margin; 10px;
	height: 100%;
	width: 100%;
	border: 1px solid #000;
}

.sidebar {
	width: 200px;
	height: 100%;
	border: 1px solid #000;
	float: left;
	background: url('/Defotos/images/Capture.PNG');
}

.verticalmenu {
	width: 1030px;
	height: 50px;
	border: 1px solid #000;
	float: left; //
	background: url('/Defotos/images/Capture.PNG');
}

.profilepic {
	width: 200px;
	height: 540px;
	border: 1px solid #000;
	float: left;
	margin-left: 10px;
	margin-top: 10px;
}

.proimag {
	width: 200px;
	height: 200px;
	border: 1px solid #000;
	float: left;
}

.postsection {
	width: 490px;
	height: 150px;
	border: 1px solid #000;
	background-color: blue;
	float: left;
	margin-left: 10px;
	margin-top: 10px;
	border-radius: 5px;
}

.resentupdates {
	width: 300px;
	height: 540px;
	border: 1px solid #000;
	float: left;
	margin-left: 10px;
	margin-top: 10px;
}

.labelhanding {
	width: 490px;
	height: 20px;
	border: 1px solid #000;
	float: left;
	box-shadow: 2px 2px 1px rgba(50, 50, 50, 0.75);
	border-radius: 5px;
}

#tA {
	width: 300px;
	height: 100px;
	border: 1px solid #000;
	margin-left: 10px;
	margin-top: 10px;
}

.logo {
	width: 200px;
	height: 150px;
	border: 1px solid #000;
	float: left;
	
		background-image: url('/Defotos/images/.PNG');
	
}

.menu {
	margin-top: 135px;
	height: 457px;
	width: 200px;
	border: 1px solid #000; 
	text-align: center;
}

.menu ul {
	margin-top: 5px;
}

.menu ul li {
	clear: both;
	list-style: none;
	height: 50px;
	width: 200px;
	border: 1px solid #000;
	margin-left: -40px;
	font-size: large;
	padding-top: 10px;
	text-align: center;
}

.menu ul li a {
	text-decoration: none;
	color: black;
	margin-top: 10px;
}

.verticalmenu ul {
	margin-left: -43px;
}

.verticalmenu ul li {
	list-style: none;
	width: 150px;
	height: 50px;
	border: 1px solid #000;
	float: left;
	margin-top: -15px;
	text-align: justify;
}

.serach {
	margin-top: 5px;
	border: 1px double #000;
}

#imgid {
	margin-top: 3px;
	text-align: center;
}

.img {
	width: 30px;
	height: 30px;
	float: left;
}

.text {
	width: 100px;
	height: 40px;
	margin-left: 10px;
	margin-top: 15px;
	border: 0px solid black;
	float: left;
}
.changpassword
{
border: 1px solid #000;
height: 300px;
width: 500px;
padding: 200px;


}


</style>
</head>

<body>
<s:if test="#session.sessionStatus">
	<s:div cssClass="main-div">
		<s:div cssClass="sidebar">

			<s:div cssClass="logo">

				<img src="/Defotos/images/logo.PNG" height="140px;" width="180px;" style="margin:2px; ">
			</s:div>
			<s:div cssClass="menu">
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Albums</a></li>
					<li>Groups</li>
					<li>Events</li>
					<li>Music</li>
					<li>Videos</li>
				</ul>


			</s:div>

		</s:div>
		<s:div cssClass="verticalmenu">

			<ul>
				<li>Updates</li>
				<li><s:div cssClass="img">
						<img id="imgid" src="" width="30px"
							height="30px" style="margin-top: 10px;" />
					</s:div><span><s:div cssClass="text">My Profile</s:div></span></li>
				<li><s:div cssClass="img" cssStyle="margin-top:10px;">
						<img id="imgid" src=" width="30px"
							height="30px" />
					</s:div><span><s:div cssClass="text" ><s:a href="ch">Change Password</s:a></s:div></span></li>
				<li><s:div cssClass="img" cssStyle="margin-top:10px;">
						<img id="imgid" src="" width="30px"
							height="30px" />
					</s:div><span><s:div cssClass="text">Setting</s:div></span></li>
				<li><s:textfield placeholder="search" cssClass="serach"></s:textfield></li>
				<li>Signout</li>
			</ul>




		</s:div>
		<s:div cssClass="profilepic">
			<s:div cssClass="proimag">
				<img src="/Defotos/images/pic.PNG" height="180px;" width="180px;" style="margin:10px; ">
			</s:div>


		</s:div>
		
				      <s:form action="changePass" theme="simple">
				<s:label for="" cssClass="lables">&nbsp;&nbsp;&nbsp;Old Password</s:label><br/>
				<s:textfield  name="oldPass"> </s:textfield>	
				
				<s:label for="" cssClass="lables">&nbsp;&nbsp;&nbsp;New Password</s:label><br/>
				<s:password  name="newPass"> </s:password>	
				
				<s:label for="" cssClass="lables">&nbsp;&nbsp;&nbsp;Conform Password</s:label><br/>
				<s:password  name="conformPass"> </s:password>	
				
				<s:fielderror fieldName="email"></s:fielderror>
							
				<s:submit value="ok"></s:submit><br></br>
	 </s:form>	 
		</s:div>
	</s:if>
	<s:else>
		<c:redirect url="index"></c:redirect>
	</s:else></style>

	
	 
</body>
</html>