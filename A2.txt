// form.html

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <link rel="stylesheet" href="styles.css">

</head>
<body>
    <script>
        function data() {
            var a = document.getElementById("n1").value;
            var b = document.getElementById("n2").value;
            var c = document.getElementById("n3").value;
            var password = document.getElementById("n4").value;
            var conf_password = document.getElementById("n5").value;

            // Email validation regular expression
            var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

            if (a === "" || b === "" || c === "" || password === "" || conf_password === "") {
                alert("Please fill all the details");
                return false;
            }
            else if (b.length !== 10) {
                alert("Phone number should be of 10 digits");
                return false;
            }
            else if (!emailRegex.test(c)) {
                alert("Please enter a valid email address");
                return false;
            }
            else if (password !== conf_password) {
                alert("Password Mismatch");
                return false;
            }
            else {
                return true;
            }
        }
    </script>

    <h1>Registration Form</h1>
    <form onsubmit="return data()" action="success.html">
        Name: <input type="text" id="n1"><br><br>
        Phone: <input type="text" id="n2"><br><br>
        Email: <input type="email" id="n3"><br><br>
        Password: <input type="password" id="n4"><br><br>
        Confirm Password: <input type="password" id="n5"><br><br>
        <input type="submit" value="Submit"><br><br>
    </form>
</body>
</html>


// ===============================================================
styles.css
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

h1 {
    text-align: center;
    color: #333;
}

form {
    max-width: 400px;
    margin: 20px auto;
    background: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

input[type="text"],
input[type="email"],
input[type="password"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ddd;
    border-radius: 4px;
}

input[type="submit"] {
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    border: none;
    border-radius: 4px;
    color: #fff;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

input[type="submit"]:hover {
    background-color: #0056b3;
}


// ===============================================================

success.html

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success</title>
</head>
<body>
    <h1>Your form has been submitted successfully!!!!!!!!!</h1>
</body>
</html>