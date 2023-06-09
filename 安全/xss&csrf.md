# xss and csrf

## xss

xxs (cross-site-scripting)

重点在于`script`注入

- 反射型 直接在url 中添加script 与服务端会进行交互
- 存储型 在提交内容区域注入script 与服务端会进行交互
- dom型 特殊的反射型攻击，不会与服务端交互，比如利用url #锚点不会与服务端交互。

解决方法： 对特殊字符进行转义处理

## csrf

csrf (cross-site request forgery)

重点在于伪造

建造一个第三方页面，在页面中添加form指向攻击站点，由于cookie特性，会自动带上用户标识

解决方法：same-site lax
