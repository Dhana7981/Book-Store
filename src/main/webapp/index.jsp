<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dhana</title>
</head>
<body>
	<h2>Welcome to jlc BookStore</h2>
	<h2>Search Books Here</h2>
	<form action='searchBooks'>
	<font color='red' size='4'>${MSG}</font>
	<table>
	<tr>
	<td>Select Category</td>
	</tr>
	<tr>
	<td>
	<select name='category'>
	<option value=''>----select Category----</option>
	<option value='Java'>Java Programming</option>
	<option value='Python'>Python Programming</option>
	<option value='Web'>Web development</option>
	</select>
	</td>
	</tr>
	<tr>
	<td><input type='submit' value='Show Books'/></td>
	</tr>
	</table>
	</form>
</body>
</html>