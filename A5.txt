<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Shape Area Calculator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background-color: #f4f4f4;
             }

        h1 {
            color: #333;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="number"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #007BFF;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        p {
            margin-top: 20px;
            color: #333;
        }

        #triangleInputs, #squareInputs, #circleInputs {
            margin-top: 20px;
        }

    </style>
</head>
<body>
    <h1>Shape Area Calculator</h1>

    <form method="post" action="">
        <label><input type="radio" name="shape" value="triangle" onchange="showInputs('triangle')"> Triangle</label><br>
        <label><input type="radio" name="shape" value="square" onchange="showInputs('square')"> Square</label><br>
        <label><input type="radio" name="shape" value="circle" onchange="showInputs('circle')"> Circle</label><br><br>

        <div id="triangleInputs" style="display:none;">
            Base: <input type="number" name="base"><br>
            Height: <input type="number" name="height"><br><br>
        </div>

        <div id="squareInputs" style="display:none;">
            Side: <input type="number" name="side"><br><br>
        </div>

        <div id="circleInputs" style="display:none;">
            Radius: <input type="number" name="radius"><br><br>
        </div>

        <input type="submit" value="Calculate Area">
    </form>

    <?php
    abstract class Shape {
        abstract public function calculateArea();
    }

    class Triangle extends Shape {
        private $base, $height;

        public function __construct($base, $height) {
            $this->base = $base;
            $this->height = $height;
        }

        public function calculateArea() {
            return 0.5 * $this->base * $this->height;
        }
    }

    class Square extends Shape {
        private $side;

        public function __construct($side) 
        {
            $this->side = $side;
        }

        public function calculateArea() {
            return $this->side * $this->side;
        }
    }

    class Circle extends Shape {
        private $radius;

        public function __construct($radius) {
            $this->radius = $radius;
        }

        public function calculateArea() {
            return pi() * $this->radius * $this->radius;
        }
    }

    if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["shape"])) {
        $shapeType = $_POST["shape"];
        
        switch ($shapeType) {
            case 'triangle':
                if (isset($_POST["base"], $_POST["height"])) {
                    $triangle = new Triangle($_POST["base"], $_POST["height"]);
                    echo "<p>Area of Triangle: " . $triangle->calculateArea() . "</p>";
                }
                break;
            case 'square':
                if (isset($_POST["side"])) {
                    $square = new Square($_POST["side"]);
                    echo "<p>Area of Square: " . $square->calculateArea() . "</p>";
                }
                break;
            case 'circle':
                if (isset($_POST["radius"])) {
                    $circle = new Circle($_POST["radius"]);
                    echo "<p>Area of Circle: " . $circle->calculateArea() . "</p>";
                }
                break;
            default:
                echo "<p>Please select a shape and enter all required dimensions.</p>";
                break;
        }
    }
    ?>

    <script>
        function showInputs(shape) {
            document.querySelectorAll('#triangleInputs, #squareInputs, #circleInputs').forEach(div => div.style.display = 'none');
            document.getElementById(shape + 'Inputs').style.display = 'block';
        }
    </script>

</body>
</html>
