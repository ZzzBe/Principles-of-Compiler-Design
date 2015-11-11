Java 程序设计：
为UnLinker.java 文件中的UnLinker 类实现成员函数String clean(String text)。
函数clean 的功能是：屏蔽字符串参数text 中的网页链接信息，并返回屏蔽后的结果；
如果无需屏蔽，则返回原来的字符串. 每个网页链接从左至右依次分成前缀，域名和后缀
三部分，各部分定义如下：
1) 前缀是以下三种情况的一种：
http://
http://www.
www.
2) 域名包含一个或多个字符，每个字符是一个英文字母（大小写均可），或者是一
个数字（0 到9），或者是一个句点（.）.
3) 后缀是以下五种情况的一种：
.com
.org
.edu
.info
.tv
除了上述的规定外，参数text 可以含有其它的字符. 另外需要注意的是，每个网页链
接都会在满足上述条件的前提下尽可能地向左右延伸，例如，当
text=”espihttp://www.tv.org.superwww.cali.comaladocious”时，其中包含的网页链接为
http://www.tv.org.superwww.cali.com，而不是http://www.tv.org 和www.cali.com.
在屏蔽网页链接时，每个识别到的链接必须被一个字符串”OMIT”和紧跟一个数字替
换，例如. text 中的第一个链接被”OMIT1”替换，第二个链接被”OMIT2”替换，依此类推. 如
下表例子所示.
参数text                                                              clean (String text)的返回值
espihttp://www.tv.org.superwww.cali.comaladocious                     espiOMIT1aladocious
check www.foo.com 4 www.foo.com www.scoopz.com                        check OMIT1 4 OMIT2 OMIT3
check www.foo.com 4 www.foo.comwww.scoopz.com                         check OMIT1 4 OMIT2
check www.foo.com 4 www.foo.comhttp://scoopz.com                      check OMIT1 4 OMIT2OMIT3
http://411.com goodz 4 www.733t.com, 2http://..com                    OMIT1 goodz 4 OMIT2, 2OMIT3

说明：
1) 字符串text 的长度在1 到50 之间；
2) 字符串text 只含有字母、数字、空格以及逗号（,）、句点（.）、冒号（:）和斜线
（/）。




UnLinker.java是本次实验的实现文件。

通过查询资料，使用java中util.regex包进行处理。先写出需要屏蔽字符串的正则表达式。再对其进行处理为正则表达式编译后的表达形式，再将其输入字符串就行匹配，最后使用OMIT替换掉屏蔽的字符串。
同时，设计一个计数器，计算OMIT的个数。

java.util.regex包主要由三部分构成：Pattern、Matcher和PatternSyntax- Exception。

l.Pattern对象是正则表达式编译后的表达形式。Pattern类没有提供公共构造器。为了创建模式，首先必须调用它的一个public static compile方法，这样会返回一个Pattern对象。这些方法接受正则表达式作为第一个实参；本章下面几页将讲解所需的语法。

2.Matcher对象是解释模式和对输入字符串执行匹配操作的引擎。和Pattern类一样，Matcher没有定义公共构造器。通过调用Pattern对象的matcher方法获得Matcher对象。

3.PatternSyntaxException对象是不可控异常，它指出正则表达式模式中的语法错误。 
