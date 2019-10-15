# 增强for用法

> 增强for循环(掌握)
 
> (1)是for循环的一种
 
> (2)格式：for(元素的数据类型 变量名 : 数组或者Collection集合的对象) {
 使用该变量即可，该变量其实就是数组或者集合中的元素。
 }
 
> (3)好处：简化了数组和集合的遍历

> (4)弊端
 增强for循环的目标不能为null。建议在使用前，先判断是否为null。

# MyBatis中的foreach循环

> foreach元素的属性主要有 item，index，collection，open，separator，close。
> item表示集合中每一个元素进行迭代时的别名，index指 定一个名字，用于表示在迭代过程中，每次迭代到的位置，
> open表示该语句以什么开始，separator表示在每次进行迭代之间以什么符号作为分隔符，
> close表示以什么结束，在使用foreach的时候最关键的也是最容易出错的就是collection属性，该属性是必须指定的


- 如果传入的是单参数且参数类型是一个List的时候，collection属性值为list  
- 如果传入的是单参数且参数类型是一个array数组的时候，collection的属性值为array
- 如果传入的参数是多个的时候

> 我们就需要把它们封装成一个Map了，当然单参数也可以封装成map，
> 实际上如果你在传入参数的时候，在breast里面也是会把它封装成一个Map的，
> map的key就是参数名，所以这个时候collection属性值就是传入的List或array对象在自己封装的map里面的key



  
