<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ejemplo Pagina Login</title>
</head>
<body>
	<form method="post" action="LoginCheck">
		<table>
			<tr>
				<td>Usuario</td>
				<td><input type="text" name="usuario"></td>
			</tr>
			<tr>
				<td>Pass</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>