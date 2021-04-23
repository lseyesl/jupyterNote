# other

## gcc

gcc 编译c++ `gcc file -lstdc++`

## virtual

虚函数的意义在于动态链接（后期绑定）

```c++
    virtual void fn () = 0 // 纯虚函数 没有具体的函数实现，只是占位  使用情况：基类中不能对虚函数给出有意义的实现
    virtual void fn(){} // 不纯虚函数 可以有具体的实现
```

```c++
    #include <iostream> 
    using namespace std;

    class Shape {
       protected:
          int width, height;
       public:
          Shape( int a=0, int b=0)
          {
             width = a;
             height = b;
          }
          int area()
          {
             cout << "Parent class area :" <<endl;
             return 0;
          }
    };
    class Rectangle: public Shape{
       public:
          Rectangle( int a=0, int b=0):Shape(a, b) { }
          int area ()
          { 
             cout << "Rectangle class area :" <<endl;
             return (width * height); 
          }
    };
    class Triangle: public Shape{
       public:
          Triangle( int a=0, int b=0):Shape(a, b) { }
          int area ()
          { 
             cout << "Triangle class area :" <<endl;
             return (width * height / 2); 
          }
    };
    // 程序的主函数
    int main( )
    {
       Shape *shape;
       Rectangle rec(10,7);
       Triangle  tri(10,5);

       // 存储矩形的地址
       shape = &rec;
       // 调用矩形的求面积函数 area
       shape->area();

       // 存储三角形的地址
       shape = &tri;
       // 调用三角形的求面积函数 area
       shape->area();

       return 0;
    }


// 输出
// Parent class area 
// Parent class area 
/*

    修改 Shape area方法
    
    class Shape {
       protected:
          int width, height;
       public:
          Shape( int a=0, int b=0)
          {
             width = a;
             height = b;
          }
          virtual int area()
          {
             cout << "Parent class area :" <<endl;
             return 0;
          }
    };
    
    则会正常输出
    Rectangle class area
    Triangle class area

*/
```

## const 
const是constant的简写，只要一个变量前面用const来修饰，就意味着该变量里的数据可以被访问，不能被修改。也就是说const意味着只读（readonly）。

规则：const离谁近，谁就不能被修改；

const修饰一个变量，一定要给这个变量初始化值，若不初始化，后面就无法初始化。

本质：const在谁后面谁就不可以修改，const在最前面则将其后移一位，二者等效。

const关键字作用

为给读你代码的人传达非常有用的信息，声明一个参数为常量是为了告诉用户这个参数的应用目的；
通过给优化器一些附加信息，使关键字const也许能产生更紧凑的代码；
合理使用关键字const可以使编译器很自然的保护那些不希望被修改的参数，防止无意的代码修改，可以减少bug的出现；
const关键字应用

欲阻止一个变量被改变，可使用const，在定义该const变量时，需先初始化，以后就没有机会改变他了；
对指针而言，可以指定指针本身为const，也可以指定指针所指的数据为const，或二者同时指定为const；
在一个函数声明中，const可以修饰形参表明他是一个输入参数，在函数内部不可以改变其值；
对于类的成员函数，有时候必须指定其为const类型，表明其是一个常函数，不能修改类的成员变量；
对于类的成员函数，有时候必须指定其返回值为const类型，以使得其返回值不为“左值”。

Bjarne 在他的 The C++ Programming Language 里面给出过一个助记的方法： 把一个声明从右向左读。

```c
char  * const cp; ( * 读成 pointer to ) 
cp is a const pointer to char 

const char * p; 
p is a pointer to const char; 

char const * p;
```

## Lambda 函数与表达式

Lambda函数的语法定义如下：

```c
[capture](parameters) mutable ->return-type{statement}
```
其中：

 [capture]：捕捉列表。捕捉列表总是出现在 lambda 表达式的开始处。事实上，[] 是 lambda 引出符。编译器根据该引出符判断接下来的代码是否是 lambda 函数。捕捉列表能够捕捉上下文中的变量供 lambda 函数使用。
 (parameters)：参数列表。与普通函数的参数列表一致。如果不需要参数传递，则可以连同括号 () 一起省略。
 mutable：mutable 修饰符。默认情况下，lambda 函数总是一个 const 函数，mutable 可以取消其常量性。在使用该修饰符时，参数列表不可省略（即使参数为空）。
 ->return_type：返回类型。用追踪返回类型形式声明函数的返回类型。出于方便，不需要返回值的时候也可以连同符号 -> 一起省略。此外，在返回类型明确的情况下，也可以省略该部分，让编译器对返回类型进行推导。
 {statement}：函数体。内容与普通函数一样，不过除了可以使用参数之外，还可以使用所有捕获的变量。
在 lambda 函数的定义式中，参数列表和返回类型都是可选部分，而捕捉列表和函数体都可能为空，C++ 中最简单的 lambda 函数只需要声明为：

```c
[]{};
```