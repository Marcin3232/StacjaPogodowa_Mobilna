<?php

    $servername = "localhost";
    $username = "Admin";
    $password = "password";
    $dbname = "databasename";

    $con = new mysqli($servername, $username, $password, $dbname);
    // sprawdzenie polaczenia
    if ($con->connect_error) {
        die("Database Connection failed: " . $con->connect_error);
		echo "Error";
    }
$query="SELECT * FROM logs ORDER BY id DESC LIMIT 100";
$result=mysqli_query($con,$query);
$number_of_rows=mysqli_num_rows($result);

$respone=array();
if($number_of_rows>0){
while($row=mysqli_fetch_assoc($result)){
    $response[]=$row;
}
}
header('Content-Type: application/json');
echo json_encode(array("czujnik"=>$response));

mysqli_close($con);
?>
