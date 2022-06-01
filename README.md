<p align="center">
  <img src="https://github.com/Stevanus-Christian/Android-CRUD-MySQL-Retrofit/blob/main/MySQL-Logo.wine.png">
</p>
<br>

# Android CRUD MySQL with Retrofit
Simple Android CRUD MySQL with Retrofit
<br>
<table style="width:100%">
  <tr>
    <th>Create</th>
    <th>Read</th>
    <th>Update</th>
    <th>Delete</th>
  </tr>
  <tr>
    <td>Click on Floating Action Button to Insert data</td>
    <td>Data automatically shown on main activity with Card View when data is not null</td>
    <td>Long click on Card View and choose Update</td>
    <td>Long click on Card View and choose Delete</td>
  </tr>
</table>

# API
### koneksi.php
```php
<?php
$host = "localhost";
$user = "id18651426_usermotogp";
$pass = "SI61PABLanjutan!@";
$db = "id18651426_dbmotogp";

$konek = mysqli_connect($host, $user, $pass, $db) or die("MySQL Tidak Terhubung");
?>
```

### create.php
```php
<?php
require("koneksi.php");

if($_SERVER["REQUEST_METHOD"] == "POST"){
    $nama = $_POST["nama"];
    $nomor = $_POST["nomor"];
    $sponsor = $_POST["sponsor"];
    $negara = $_POST["negara"];
    
    $perintah = "INSERT INTO tblrider(nama, nomor, sponsor, negara) VALUES('$nama', '$nomor', '$sponsor', '$negara')";
    $eksekusi = mysqli_query($konek, $perintah);
    $cek = mysqli_affected_rows($konek);
    
    if($cek > 0){
        $response["kode"] = 1;
        $response["pesan"] = "Sukses Menyimpan Data";
    }
    else{
        $response["kode"] = 0;
        $response["pesan"] = "Gagal Menyimpan Data";
    }
}
else{
    $response["kode"] = 0;
    $response["pesan"] = "Tidak Ada POST Data";
}

echo json_encode($response);
mysqli_close($konek);
```

### retrieve.php
```php
<?php
require("koneksi.php");

$perintah = "SELECT * FROM tblrider";
$eksekusi = mysqli_query($konek, $perintah);
$cek = mysqli_affected_rows($konek);

if($cek > 0){
    $response["kode"] = 1;
    $response["pesan"] = "Data Tersedia";
    $response["data"] = array();
    
    while($get = mysqli_fetch_object($eksekusi)){
        $var["id"] = $get -> id;
        $var["nama"] = $get -> nama;
        $var["nomor"] = $get -> nomor;
        $var["sponsor"] = $get -> sponsor;
        $var["negara"] = $get -> negara;
        $var["foto"] = $get -> foto;
        $var["created_at"] = $get -> created_at;
        $var["updated_at"] = $get -> updated_at;
        
        array_push($response["data"], $var);
    }
}
else{
    $response["kode"] = 0;
    $response["pesan"] = "Data Tidak Tersedia";
}

echo json_encode($response);
mysqli_close($konek);
```

### delete.php
```php
<?php
require("koneksi.php");
 
$response = array();
 
if($_SERVER['REQUEST_METHOD'] == 'POST'){
    $id = $_POST["id"];
    
    $perintah = "DELETE FROM tblrider WHERE id='$id'";
    $eksekusi = mysqli_query($konek, $perintah);
    $cek = mysqli_affected_rows($konek);
    
    if($cek > 0){
        $response["kode"] = 1;
        $response["pesan"] = "Sukses Menghapus Data";
    }
    else{
        $response["kode"] = 0;
        $response["pesan"] = "Gagal Menghapus Data";
    }
}
else{
    $response["kode"] = 0;
    $response["pesan"] = "Tidak ada Hapus Data";
}
 
echo json_encode($response);
mysqli_close($konek);
```

### update.php
```php
<?php
require("koneksi.php");
 
$response = array();
 
if($_SERVER["REQUEST_METHOD"] == "POST"){
    $id = $_POST["id"];
    $nama = $_POST["nama"];
    $nomor = $_POST["nomor"];
    $sponsor = $_POST["sponsor"];
    $negara = $_POST["negara"];
    
    $perintah = "UPDATE tblrider SET nama='$nama', nomor='$nomor', sponsor='$sponsor', negara='$negara' WHERE id='$id'";
    $eksekusi = mysqli_query($konek, $perintah);
    $cek = mysqli_affected_rows($konek);
    
    if($cek > 0){
        $response["kode"] = 1;
        $response["pesan"] = "Sukses Mengubah Data";
    }
    else{
        $response["kode"] = 0;
        $response["pesan"] = "Gagal Mengubah Data";
    }
}
else{
    $response["kode"] = 0;
    $response["pesan"] = "Tidak ada Post Data";
}
 
echo json_encode($response);
mysqli_close($konek);
?>
```

# How To Use
1. Clone or Download this project
2. Create and then import database "id18651426_dbmotogp"
3. Make API for cCRUD data
4. Run this project on Android Studio
5. Enjoy

# License
<b>Do What The F*ck You Want To Public License</b> 
<br>
For more information click [here](http://www.wtfpl.net/about/).
