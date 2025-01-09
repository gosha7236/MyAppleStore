<!DOCTYPE html>
<html>
<head>
    <title>MyAppleStore</title>
</head>
<body>
<h2 style="color: aliceblue; background-color: darkslategrey; border-radius: 20px ; padding-left: 10px">MyAppleStore</h2>
<h4>Подробная информация о товаре</h4>
<#list images as img>
<img src = "/images/${img.id}" height = "400px" width="300px" style="margin : 0 1.2rem"/>
</#list>
<br>
<br>
<b>Название товара:</b> ${product.title}<br>
<b>Описание товара:</b> ${product.description}<br>
<b>Цена товара:</b> ${product.price}<br>
<b>Город:</b> ${product.city}<br>
<b>Автор:</b> ${product.author}<br>
<hr>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Удалить товар"/>
</form>
</body>
</html>
