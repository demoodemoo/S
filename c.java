<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Calculator</title>
<style>
    body {
        font-family: Arial, sans-serif;
    }
    .calculator {
        width: 250px;
        margin: 50px auto;
        border: 1px solid #ccc;
        border-radius: 5px;
        padding: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }
    .result {
        font-size: 20px;
        margin-bottom: 10px;
        text-align: right;
    }
    button {
        width: 50px;
        height: 50px;
        margin: 5px;
        font-size: 18px;
        border: none;
        cursor: pointer;
    }
    button.operator {
        background-color: #ff9800;
        color: white;
    }
    button.equal {
        background-color: #4caf50;
        color: white;
    }
</style>
</head>
<body>

<div class="calculator">
    <div class="result" id="result">0</div>
    <button onclick="clearResult()">C</button>
    <button onclick="appendToResult('7')">7</button>
    <button onclick="appendToResult('8')">8</button>
    <button onclick="appendToResult('9')">9</button>
    <button onclick="appendToResult('+')" class="operator">+</button>
    <button onclick="appendToResult('4')">4</button>
    <button onclick="appendToResult('5')">5</button>
    <button onclick="appendToResult('6')">6</button>
    <button onclick="appendToResult('-')" class="operator">-</button>
    <button onclick="appendToResult('1')">1</button>
    <button onclick="appendToResult('2')">2</button>
    <button onclick="appendToResult('3')">3</button>
    <button onclick="appendToResult('*')" class="operator">*</button>
    <button onclick="appendToResult('0')">0</button>
    <button onclick="appendToResult('.')">.</button>
    <button onclick="calculate()" class="equal">=</button>
    <button onclick="appendToResult('/')" class="operator">/</button>
</div>

<script>
    function appendToResult(value) {
        document.getElementById('result').innerText += value;
    }
    
    function clearResult() {
        document.getElementById('result').innerText = '';
    }
    
    function calculate() {
        var result = eval(document.getElementById('result').innerText);
        document.getElementById('result').innerText = result;
    }
</script>

</body>
</html>
