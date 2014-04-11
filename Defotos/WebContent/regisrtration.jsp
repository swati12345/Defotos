<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/juery.js"></script>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js" rel="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>

<link rel="stylesheet" type="text/css" href="/Defotos/css/menu.css" />
<link rel="stylesheet" href="js/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="/Defotos/css/register.css" />

<script>
	$(function() {
		$(document).tooltip({});
	});
	</script>

</style>
</head>
<body>
	<s:div cssClass="main">
		<s:div cssClass="header">
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
			<s:div cssClass="middlecontainer">
				<s:div cssClass="headersection">
				</s:div>
				<s:div cssClass="reg_box">
					<s:form action="signup" method="POST" theme="simple"
						enctype="multipart/form-data">

						<table>
							<tr>
								<td><s:textfield name="fname" placeholder="First name"
										title="Only characters." cssClass="textfield"></s:textfield></td>
								<td class="errortd"><s:div cssClass="error">
										<s:fielderror fieldName="fname"></s:fielderror>
									</s:div></td>
							</tr>
							<tr>
								<td><s:textfield name="lname" placeholder="Last name"
										title="Only characters." required="true" cssClass="textfield"></s:textfield></td>
								<td class="errortd"><s:div cssClass="error">
										<s:fielderror fieldName="lname"></s:fielderror>
									</s:div></td>
							</tr>
							<tr>
								<td><s:textfield name="email" placeholder="Email Id"
										title="Enter existing email address." required="true"
										cssClass="textfield" id="valid"></s:textfield></td>
								<td class="emailvalid" style="color:white;"><s:actionerror/></td>
								<td class="errortd"><s:div cssClass="error">
										<s:fielderror fieldName="email"></s:fielderror>
									</s:div></td>
							</tr>
							<tr>
								<td><s:password name="pass" placeholder="********"
										title="Must be at least 5 characters." required="true"
										cssClass="textfield"></s:password></td>
								<td class="errortd"><s:div cssClass="error">
										<s:fielderror fieldName="pass"></s:fielderror>
									</s:div></td>
							</tr>
							<tr>
								<td><s:password name="cpass" title="Enter password again."
										required="true" placeholder="********" cssClass="textfield"></s:password></td>
								<td class="errortd"><s:div cssClass="error">
										<s:fielderror fieldName="cpass"></s:fielderror>
									</s:div></td>
							</tr>
							<tr>
								<td><s:textfield name="contact" placeholder="Contact"
										required="true" cssClass="textfield"></s:textfield></td>
								<td class="errortd"><s:div cssClass="error">
										<s:fielderror fieldName="contact"></s:fielderror>
									</s:div></td>
							</tr>
							<tr>
								<td><s:file name="profileImage" label="User Image"
										cssClass="filetag" accept="image/jpeg,image/jpg,image/png" /></td>

								<td>Image upload</td>
							</tr>

							<tr>
								<td><s:checkbox name="terms" fieldValue="true"
										cssStyle="display:inline;margin-left:100px;" cssClass="check"></s:checkbox></td>
								<td><label for="terms"
									style="font-size: 13px; margin-left: -210px; color: white;">I
										agree to Terms of Service</label></td>
							<tr>
								<td><s:submit name="submit" cssClass="submit"
										cssStyle="margin-left:95px;"></s:submit></td>
							</tr>
						</table>
					</s:form>
				</s:div>
			</s:div>
		</s:div>
	</s:div>
</body>
</html>