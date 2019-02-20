package Algorithm;

import java.util.LinkedList;

/**
	二叉树 层序遍历
		使用队列辅助
*/
public class LevelOrder
{
  public void levelOrder(Node root)
  {
	  if(root == null)
	  {
		  return ;
	  }
	  LinkedList<Node> queue = new LinkedList<>(); //模拟队列结构
	  Node current = null;
	  queue.offer(root);//将根节点入队
	  while(!queue.isEmpty())
	  {
		  current = queue.poll();//出队队头元素并访问
		  System.out.print(current.val +"-->"); //打印当前节点元素
		  if(current.left != null)//如果当前节点的左节点不为空入队
		  {
			  queue.offer(current.left);
		  }
		  if(current.right != null)//如果当前节点的右节点不为空，把右节点入队
		  {
			  queue.offer(current.right);
		  }
	  }
	  
  }
 
}

