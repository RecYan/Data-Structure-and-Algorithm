# Data Structure and Algorithm

---

1. 数组结构
+ 实现了数组的增删改查、实现了动态扩容和泛型
+ 分析了该类的相关算法复杂度

2. 栈结构
+ 基于上面的动态数组，实现了栈结构，模拟了push、pop、peek等相关方法
+ 使用该结构完成了leetcode第20题（括号匹配问题）

3. 队列结构
+ 基于原有的动态数组，实现了队列的基本操作
+ 使用循环队列改进了出栈时的复杂度  O(n)-->O(1)
+ 编写了测试用例进行了简单的运算测试，进行了10000次操作测试，耗时结果如下：
>ArrayQueue time: 4.317554243 s  
>loopQueue time: 0.012931983 s

4. 链表结构<真正的动态结构>
>动态数组、栈、队列 -->其底层依靠静态数组
>*动态*的特性主要由resize方法实现相应的扩容和缩容

+ 链表内部维护节点内部类，节点类中包含两个部分：存于节点的信息和执行下一个节点的next引用
+ 实现了链表的添加、并使用虚拟头结点，对代码进行优化，重点关注add()，理解其中逻辑
+ 实现了链表的删、改、查操作，需要注意cur节点和prev节点所规定的约束和size的取值范围【见代码注释】
+ 使用上述实现的链表，模拟了栈数据结构
+ 改进上述实现的链表，增加了tail尾节点，模拟了队数据结构，即head为队首、tail为队尾
+ 在运算量超过百万次时，推荐使用基于数组的栈和链表结构，运算速度较快












