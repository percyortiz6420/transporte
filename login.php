<?php

$con = mysqli_connect("35.193.248.224","percy","percy","transporte");

$username = $_POST["username"];
$password = $_POST["password"];

$statement = mysqli_prepare($con,"SELECT * FROM usuarios WHERE id = ? AND pass = ?");
mysqli_stmt_bind_param($statement, "ss", $username, $password);
mysqli_stmt_execute($statement);

mysqli_stmt_store_result($statement);
mysqli_stmt_bind_result($statement, $id, $piloto)











?>
