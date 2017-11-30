# 一个完整的编译器前端

来自龙书`附录A`

## 源语言

一个程序由一个块组成，该块中包含可选的声明和语句。语法符号**basic**表示基本类型。  

program -> block

block   -> { decls stmts }

decls   -> decls decl
         | **null**
         
decl    -> type **id** ;

type    -> type \[ **num** \] 
         | **basic**
  
stmts   -> stmts stmt
         | **null**

把赋值当作一个语句（而不是表达式中的运算符）可以简化翻译工作。  

stmt    -> loc = bool ;
         | **if** ( bool ) stmt
         | **if** ( bool ) stmt **else** stmt
         | **while** ( bool ) stmt
         | **do** stmt **while** ( bool ) ;
         | **break** ;
         | block
         
loc     -> loc \[ bool \]
         | **id**

表达式的产生式处理了运算符的结合性和优先级。它们对每个优先级级别都使用了一个非终结符号，而非终结符号**factor**用来表示括号中的表达式、标识符、数组引用和常量。  
      
bool    -> bool || join
         | join 

join    -> join && equality
         | equality

equality    -> equality == rel
             | equality != rel
             | rel

rel     -> expr < expr
         | expr <= expr
         | expr >= expr
         | expr > expr
         | expr
         
expr    -> expr + term
         | expr - term
         | term
         
term    -> term * unary
         | term / unary
         | unary

unary   -> ! unary
         | - unary
         | factor

factor  -> ( bool )
         | loc
         | **num**
         | **real**
         | **true**
         | **false**










