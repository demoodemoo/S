<!-- 
xml
<bookstore>
  <book>
    <title>Harry Potter and the Sorcerer's Stone</title>
    <author>J.K. Rowling</author>
    <year>1997</year>
  </book>
  <book>
    <title>The Hobbit</title>
    <author>J.R.R. Tolkien</author>
    <year>1937</year>
  </book>
</bookstore>

xsd
<?xml version="1.0" encoding="utf-8"?>
<xs:schema attributeFormDefault="unqualified" elementFormDefault="qualified" xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="bookstore">
    <xs:complexType>
      <xs:sequence>
        <xs:element maxOccurs="unbounded" name="book">
          <xs:complexType>
            <xs:sequence>
              <xs:element name="title" type="xs:string" />
              <xs:element name="author" type="xs:string" />
              <xs:element name="year" type="xs:unsignedShort" />
            </xs:sequence>
          </xs:complexType>
        </xs:element>
      </xs:sequence>
    </xs:complexType>
  </xs:element>
</xs:schema>

-->

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>

  <style>
    .calculator {
      width: 250px;
      margin: 50px auto;
      border: 2px solid #333;
      border-radius: 5px;
      padding: 10px;
    }

    #display {
      width: 100%;
      padding: 10px;
      font-size: 20px;
      margin-bottom: 10px;
    }

    .buttons {
      display: grid;
      grid-template-columns: repeat(4, 1fr);
      gap: 5px;
    }

    button {
      padding: 10px;
      font-size: 18px;
      background-color: #eee;
      border: none;
      cursor: pointer;
    }

    button:hover {
      background-color: #ccc;
    }
  </style>

  <body>
    <input id="email" type="text" placeholder="email" />
    <input id="password" type="password" placeholder="password" />
    <button id="submit">Sign UP</button>
    <button type="reset">Clear</button>
    <button id="fib" onclick="fib()">fibonacchi</button>
    <label id="error"></label>

    <video height="300px" width="300px" src="temp.mp4" controls></video>

    <div class="calculator">
      <input type="text" id="display" disabled />
      <div class="buttons">
        <button onclick="clearDisplay()">C</button>
        <button onclick="appendToDisplay('/')">/</button>
        <button onclick="appendToDisplay('*')">*</button>
        <button onclick="appendToDisplay('7')">7</button>
        <button onclick="appendToDisplay('8')">8</button>
        <button onclick="appendToDisplay('9')">9</button>
        <button onclick="appendToDisplay('-')">-</button>
        <button onclick="appendToDisplay('4')">4</button>
        <button onclick="appendToDisplay('5')">5</button>
        <button onclick="appendToDisplay('6')">6</button>
        <button onclick="appendToDisplay('+')">+</button>
        <button onclick="appendToDisplay('1')">1</button>
        <button onclick="appendToDisplay('2')">2</button>
        <button onclick="appendToDisplay('3')">3</button>
        <button onclick="calculate()">=</button>
        <button onclick="appendToDisplay('0')">0</button>
        <button onclick="appendToDisplay('.')">.</button>
      </div>
    </div>

    <script>
      function appendToDisplay(value) {
        document.getElementById("display").value += value;
      }

      function clearDisplay() {
        document.getElementById("display").value = "";
      }

      function calculate() {
        try {
          const result = eval(document.getElementById("display").value);
          document.getElementById("display").value = result;
        } catch (error) {
          document.getElementById("display").value = "Error";
        }
      }

      function fib() {
        alert("Fibonacci clicked");

        let error = document.getElementById("error");
        error.innerText = "0 1";

        let prev = 0;
        let curr = 1;

        for (let i = 0; i < 100; i++) {
          let next = prev + curr;
          error.innerText += "\n" + i + ") " + next;
          prev = curr;
          curr = next;
        }
      }

      let time = new Date().getHours();
      if (time > 5 && time < 12) {
        error.innerText = "good morning";
      } else if (time >= 12 && time < 17) {
        error.innerText = "afternoon";
      } else if (time >= 17 && time < 18) {
        error.innerText = "evening";
      } else {
        error.innerText = "night";
      }

      let submit = document.querySelector("#submit");
      submit.addEventListener("click", () => {
        alert("hello");

        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;
        let error = document.getElementById("error");

        if (email === "" || password === "") {
          error.innerText = "Please don't leave any field empty.";
        } else if (!validEmail(email)) {
          error.innerText = "Please enter a valid email address.";
        } else {
          error.innerText = "";
        }
      });

      function validEmail(email) {
        let parts = email.split("@");
        if (parts.length !== 2) return false;

        let localpart = parts[0];
        let domainpart = parts[1];

        if (localpart === "" || domainpart === "") return false;

        let domainParts = domainpart.split(".");
        if (domainParts.length < 2) return false;

        return true;
      }
    </script>
  </body>
</html>

<!-- php

<?php
// Base class
class Shape {
    // Method to calculate area (placeholder)
    public function calculateArea() {
        // Placeholder implementation
        return 0;
    }
}

// Derived class Rectangle inheriting from Shape
class Rectangle extends Shape {
    // Properties
    private $width;
    private $height;

    // Constructor
    public function __construct($width, $height) {
        $this->width = $width;
        $this->height = $height;
    }

    // Method to calculate area for rectangle
    public function calculateArea() {
        return $this->width * $this->height;
    }
}

// Derived class Circle inheriting from Shape
class Circle extends Shape {
    // Property
    private $radius;

    // Constructor
    public function __construct($radius) {
        $this->radius = $radius;
    }

    // Method to calculate area for circle
    public function calculateArea() {
        return pi() * $this->radius * $this->radius;
    }
}

// Usage
$rectangle = new Rectangle(5, 4);
$circle = new Circle(3);

echo "Area of Rectangle: " . $rectangle->calculateArea() . "\n"; // Output: 20
echo "Area of Circle: " . $circle->calculateArea() . "\n"; // Output: 28.274333882308
?>


<?php
// Database connection
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "pharmacy";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Create new item
if(isset($_POST['submit'])) {
    $name = $_POST['name'];
    $quantity = $_POST['quantity'];
    
    $sql = "INSERT INTO items (name, quantity) VALUES ('$name', '$quantity')";
    
    if ($conn->query($sql) === TRUE) {
        header("Location: ".$_SERVER['PHP_SELF']);
        exit();
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }
}

// Delete item
if(isset($_GET['delete'])) {
    $id = $_GET['delete'];
    
    $sql = "DELETE FROM items WHERE id=$id";
    
    if ($conn->query($sql) === TRUE) {
        header("Location: ".$_SERVER['PHP_SELF']);
        exit();
    } else {
        echo "Error deleting record: " . $conn->error;
    }
}

?>

<!DOCTYPE html>
<html>
<head>
    <title>Pharmacy Inventory</title>
</head>
<body>

<h2>Add New Item</h2>
<form method="post">
    Name: <input type="text" name="name" required><br>
    Quantity: <input type="number" name="quantity" required><br>
    <input type="submit" name="submit" value="Add Item" class="btn">
</form>

<h2>Inventory</h2>

<?php
// Display items
$sql = "SELECT * FROM items";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        echo "<div class='item'>";
        echo "<strong>Name:</strong> " . $row["name"] . " | ";
        echo "<strong>Quantity:</strong> " . $row["quantity"] . " | ";
        echo "<a href='edit.php?id=".$row["id"]."' class='btn'>Edit</a> | ";
        echo "<a href='?delete=".$row["id"]."' onclick=\"return confirm('Are you sure you want to delete this item?');\" class='btn'>Delete</a>";
        echo "</div>";
    }
} else {
    echo "No items found";
}

$conn->close();
?>

</body>
</html>
 
Path: edit.php

<?php
// Database connection
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "pharmacy";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Update item
if(isset($_POST['update'])) {
    $id = $_POST['id'];
    $name = $_POST['name'];
    $quantity = $_POST['quantity'];
    
    $sql = "UPDATE items SET name='$name', quantity='$quantity' WHERE id=$id";
    
    if ($conn->query($sql) === TRUE) {
        header("Location: index.php");
        exit();
    } else {
        echo "Error updating record: " . $conn->error;
    }
}

// Fetch item details
if(isset($_GET['id'])) {
    $id = $_GET['id'];
    
    $sql = "SELECT * FROM items WHERE id=$id";
    $result = $conn->query($sql);
    
    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
    } else {
        echo "Item not found";
        exit();
    }
} else {
    echo "Item ID not provided";
    exit();
}

$conn->close();
?>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Item</title>
</head>
<body>

<h2>Edit Item</h2>
<form method="post">
    <input type="hidden" name="id" value="<?php echo $row['id']; ?>">
    Name: <input type="text" name="name" value="<?php echo $row['name']; ?>" required><br>
    Quantity: <input type="number" name="quantity" value="<?php echo $row['quantity']; ?>" required><br>
    <input type="submit" name="update" value="Update">
</form>

</body>
</html> -->

<!-- ruby -->
<!-- 

ap.rb
require 'sinatra'
# Method to reverse the name
def reverse_name(first_name, last_name)
"#{last_name} #{first_name}"
end
get '/' do
erb :index
end
post '/reverse' do
first_name = params[:first_name]
last_name = params[:last_name]
@reversed_name = reverse_name(first_name, last_name)
erb :reverse
end

index.erb
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-
scale=1.0">

<title>Reverse Name</title>
<style>
body {
font-family: Arial, sans-serif;
background-color: #f8f8f8;
text-align: center;
display: flex;
justify-content: center;
align-items: center;
height: 100vh;
margin: 0;
}
.card {

width: 300px;
padding: 20px;
background-color: white;
border-radius: 8px;
box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
display: flex;
flex-direction: column;
}
h1 {
color: #333;
}
form {
margin-top: 20px;
}
label {
display: block;
margin-bottom: 5px;
color: #333;
}
input[type="text"] {
padding: 8px;
margin-bottom: 30px;
width: 100%;
border: 1px solid #ccc;
border-radius: 4px;
box-sizing: border-box;
}
button[type="submit"] {
padding: 10px 20px;
background-color: rosybrown;
color: white;
border: none;
border-radius: 4px;
cursor: pointer;
width: 100%;
}
</style>
</head>
<body>
<div class="card">
<h1>Reverse Name</h1>

<form action="/reverse" method="POST">
<input type="text" id="first_name" name="first_name" placeholder
= "First Name" required><br>
<input type="text" id="last_name" name="last_name" placeholder =
"Last Name" required><br>
<button type="submit">Reverse Name</button>
</form>
</div>
</body>
</html>
reverse.erb
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-
scale=1.0">

<title>Reversed Name</title>
<style type="text/css">
html { height: 100% }
body {
height: 100vh; /* corrected from 100vw */
display: flex;
justify-content: center;
align-items: center;
margin: 0;
padding: 0;
background-color: #f8f8f8; /* added background color */
font-size: 40px;
}
h1 {
color: #333; /* color for the heading */
}
p {
color: rosybrown;
font-weight: bold;
}
</style>
</head>

<body>
<h1>Hello! &nbsp</h1>
<p><%= @reversed_name %></p>
</body>
</html>
 -->
