package Algorithm;
/**
	前缀树实现
		数字放在路径上 而不是节点上
*/

public class TrieTree {

	public static class TrieNode {
		public int path; //多少个字符 经过该节点
		public int end; //有多少个字符串以该节点结尾
		public TrieNode[] nexts; //路径

		public TrieNode() {
			path = 0;
			end = 0;
			nexts = new TrieNode[26]; //a-z ascll:0-25
		}
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a'; //node下标
				if (node.nexts[index] == null) { //前缀树中当前位置的节点后面是否有节点连接
					node.nexts[index] = new TrieNode();// 建立路径
				}
				node = node.nexts[index];
				node.path++;
			}
			node.end++; //字符串遍历到最后一个元素 end+1
		}

		public void delete(String word) {
			if (search(word) != 0) {
				char[] chs = word.toCharArray();
				TrieNode node = root;
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					/**
						通过节点的下一个节点的path值判断
							如果path--的值为零 --> 下面的节点元素没有重复 
								node.next置null
					*/
					if (--node.nexts[index].path == 0) {
						node.nexts[index] = null;
						return;
					}
					node = node.nexts[index];
					//node.path--;
				}
				node.end--; //end值 判断字符串有几个是重复的
			}
		}

		//word插入多少次
		public int search(String word) {
			if (word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.end;
		}

		//pre出现的数量
		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.path;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNumber("zuo"));

	}

}
