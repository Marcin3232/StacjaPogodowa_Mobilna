# StacjaPogodowa_Mobilna
Extension of the previous project of the weather station. A mobile application where you can see the current sensor result, the last 100 records or graph visualizations.

# Usage
- Clone this repository
- Run in the android studio environment

the minimum android version is 28.

# Technologies

 - Java
 - MySQL
 - PHP
 

# Documentation
Main screenshot:
<p align="center">
  <img  width="425" height="210" src="https://github.com/Marcin3232/StacjaPogodowa_Mobilna/blob/master/ImageToReadme/r1.PNG">
</p>

On the server, we need 2 php scripts that return a json object. One to one data taking temperature, humidity and preassure. Second return 100 last records in database.
First one records, to display current measure.


```
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
```
Second returning 100 last records:

```
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
```
The app connects to the Rest app using the volley library.Two models of connecting to the server result from developing knowledge and facilitating the next steps. 

<p align="center">
  <img width="210" height="425" src="https://github.com/Marcin3232/StacjaPogodowa_Mobilna/blob/master/ImageToReadme/r2.PNG">
</p>

The snippet of the server connection request code:

```
private void jsonParse() {
        String url = "www.takedata.pl/pobierz.php";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override

                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jobj = response.getJSONObject("czujnik");
                            for (int i = 0; i < jobj.length(); i++) {
                                int temperatura = jobj.getInt("temperatura");
                                int cisnienie = jobj.getInt("cisnienie");
                                int wilgotnosc = jobj.getInt("wilgotnosc");
                                temp.setText(String.valueOf(temperatura) + " °C");
                                cis.setText(String.valueOf(cisnienie) + " hPa");
                                wilg.setText(String.valueOf(wilgotnosc) + " %");
                            }
                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
    
  ```
  View the last 100 records:
  
  <p align="center">
  <img width="210" height="425" src="https://github.com/Marcin3232/StacjaPogodowa_Mobilna/blob/master/ImageToReadme/r3.PNG">
</p>


The mpandroid library was used to visualize the charts.

  <p align="center">
  <img width="210" height="425" src="https://github.com/Marcin3232/StacjaPogodowa_Mobilna/blob/master/ImageToReadme/r4.PNG">
</p>

# Possibilities for further development

- possible visual changes
- possible to changes takes data on database
- extension of the main project to a greater number of sensors


# License
MIT License
```

Copyright (c) [2020] [Mobile Weather Station]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```


