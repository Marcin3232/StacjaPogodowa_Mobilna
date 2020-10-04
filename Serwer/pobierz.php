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
$query=mysqli_query($con,"SELECT * FROM logs ORDER BY id DESC LIMIT 4");
if($query)
{
while($row=mysqli_fetch_array($query))
	{
$flag=array('temperatura'=>$row[1],
'wilgotnosc'=>$row[2],
'cisnienie'=>$row[3]);


	}
print(json_encode(array('czujnik'=>$flag)));
}
mysqli_close($con);
?>
				