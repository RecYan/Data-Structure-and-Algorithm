# Data Structure and Algorithm

+ [手写数据结构](#1)
	+ [数组结构](#1.1)
	+ [栈结构](#1.2)
	+ [队列结构](#1.3)
	+ [链表结构](#1.4)
	+ [二分搜索树结构](#1.5)
	+ [集合和映射](#1.6)
+ [手写算法](#2)
	+ [基本排序算法](#2.1)
	+ [算法题及解题思路](#2.1)

---
<a name="1"></a>
# 手写数据结构 #

<a name="1.1"/></a>
## 1. 数组结构 ##
+ 实现了数组的增删改查、实现了动态扩容和泛型
+ 分析了该类的相关算法复杂度  

<a name="1.2"/></a>
## 2. 栈结构 ##
+ 基于上面的动态数组，实现了栈结构，模拟了push、pop、peek等相关方法
+ 使用该结构完成了leetcode第20题（括号匹配问题）  

<a name="1.3"/></a>
## 3. 队列结构 ##
+ 基于原有的动态数组，实现了队列的基本操作
+ 使用循环队列改进了出栈时的复杂度  O(n)-->O(1)
+ 编写了测试用例进行了简单的运算测试，进行了10000次操作测试，耗时结果如下：
>ArrayQueue time: 4.317554243 s  
>loopQueue time: 0.012931983 s  

<a name="1.4"/></a>
## 4. 链表结构<真正的动态结构> ##
```
动态数组、栈、队列 -->其底层依靠静态数组
*动态*的特性主要由resize方法实现相应的扩容和缩容
```
+ 链表内部维护节点内部类，节点类中包含两个部分：存于节点的信息和执行下一个节点的next引用  
+ 实现了链表的添加、并使用虚拟头结点，对代码进行优化，重点关注add()，理解其中逻辑  
+ 实现了链表的删、改、查操作，需要注意cur节点和prev节点所规定的约束和size的取值范围【见代码注释】  
+ 使用上述实现的链表，模拟了栈数据结构  
+ 改进上述实现的链表，增加了tail尾节点，模拟了队数据结构，即head为队首、tail为队尾  
+ 在运算量超过百万次时，推荐使用基于数组的栈和链表结构，运算速度较快  
+ **理解递归思想、宏观表现和微观实现、注意画图理解<类似于程序栈操作>**  
+ **完成leetcode第205题，使用基本链表、带虚拟头结点链表、递归三种实现**  

<a name="1.5"/></a>
## 5. 二分搜索树结构   ##
+ 二分搜索树中**元素需要具备可比性**  
+ 定义该二分搜索树中每个节点值都大于其左子树所有节点的值，小于其右子树所有节点的值，每颗子树都为二分搜索树  
```
递归：**BST中递归思路**  
1.递归终止条件  
2.递归组成逻辑  
3.对外暴露基本方法，屏蔽内部调用的递归方法  
```
+ 使用递归实现了基本的添加功能、查找功能*（注意理解递归写法、思路）*
+ **深度优先遍历**，递归实现了遍历的功能（前、中、后序），不同于上面两种操作，遍历需要顾及左右两个子树  
+ 使用非递归方式 利用*栈结构* 实现了前序遍历  
+ **广度优先遍历**，利用*队列结构* 实现了树的层序遍历  
+ 实现了删除最大、最小和指定值的操作【依据二分搜索树规律】  
+ Hibbard Deletion 删除BST中指定的元素  
> 三种情况：1.左子树为空、2.右子树为空、3.左右子树不为空：找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点，用这个节点顶替待删除节点的位置  
```
删除BST任意节点思路<左右都有孩子的节点>：
1.找到d节点右子树中最小的节点s ，即： s=min(d->right)
2.再让s节点代替d节点的位置，即：s->right=delMin(d->right)
```
![sBST删除任意节点](https://i.imgur.com/gzkhGmJ.jpg)

<a name="1.6"/></a>
## 6.集合和映射 ##
+ 基于BST实现了简易的Set集合

 
---

<a name="2"/></a>
# 手写算法 #

<a name="2.1"/></a>
## 1.基本排序算法   ##
``` java
二分排序：O(logN)
冒泡排序:O(N*N) 基本思想：最大的数放与数组末尾，依次向前（两两交换）  
选择排序:O(N*N) 基本思想：最小的数放于数组前面，依次向后（元素与后面待排元素比较 再交换，交换次数降低）  
插入排序:O(N*N) 基本思想：每一步将一个待排序的元素，插入到前面已经排的有序序列中去，直到插完所有元素为止  
归并排序：O(NlogN) 基本思想：递归实现归并排序的分治合并  
使用该思想 解决了 小和问题 和 逆序对 问题  
快速排序：O(NlogN) 基本思想：类似于“荷兰国旗”问题解题思路  
						  经典快排：选取数组中最后一个元素作为比较对象(num),将数组分为小于等于num和大于num的两段，在分别递归实现排序  
 						--> 改进的快速排序：采用“荷兰国旗”的三段式思路，将数组分为小于num 等于num 和大于num的三段  
						--> num选取的改进 --> 随机快排：num是从数组中等概率随机选取出来的，排序思路与改进的快排一致  
堆排序：O(NlogN) 基本思路：1. heapinsert操作将数组转换为大根堆  
                         2. heapify操作一次将末尾元素进行排序
                         3. 对于节点i,其左孩子下标为2*i+1, 右孩子下标为2*i+2, 父节点下标为(i-1)/2
快排和堆排的详细思路见代码注释
排序算法稳定性问题：
1.排序稳定性：在排序过程中，任一相同的值，在排序过后位置仍保持不变。如 5 3(下标为1) 3 6 1 --> 1 3(下标仍为1) 3 5 6
2.排序算法稳定性总结：
                  O(N*N):冒泡排序(可具备)、插入排序(可具备)、选择排序(不稳定):其算法过程中 找最小的元素与前面元素交换，该过程破坏了稳定性  
                  O(N*logN):归并排序(可具备)、快速排序(不稳定)：随机选数作为比较的num时破坏了稳定性、堆排序(不稳定)：建立大根堆时破坏了稳定性  
工程综合排序：
基本类型排序：使用快排   
自定义类型排序：使用归并排序  
样本量小于魔数{样本量较小时}使用插入排序  
三种排序组合使用  
```
<a name="2.2"/></a>
## 2.算法题及解题思路   ##
``` java
具体思路见代码注释
1. 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用非基于比较的排序
2. 用数组结构实现大小固定的队列和栈
3. 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作（pop、push、getMin操作的时间复杂度都是O(1)）  
4. 队列结构实现栈结构
5. 栈结构实现队列结构
6. 猫狗队列问题
7. 转圈打印矩阵
8. 顺时针90度旋转正方形矩阵
9. 之”字形打印矩阵
10. 判断一个链表是否为回文结构
```










