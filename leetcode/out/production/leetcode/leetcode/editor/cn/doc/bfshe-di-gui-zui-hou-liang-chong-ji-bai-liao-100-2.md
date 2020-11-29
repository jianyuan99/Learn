### 1，BFS解决

看到关于二叉树的问题，首先要想到关于二叉树的一些常见遍历方式，
对于二叉树的遍历有

1. **前序遍历**
2. **中序遍历**
3. **后续遍历**
4. **深度优先搜索（DFS）**
5. **宽度优先搜索（BFS）**


除了上面介绍的5种以外，还有```Morris（莫里斯）的前中后3种遍历方式```，总共也就这8种。所以只要遇到二叉树相关的算法题，首先想到的就是上面的几种遍历方式，然后再稍加修改，基本上也就这个套路。

这题让求的就是让把二叉树中每行都串联起来，对于这道题来说最适合的就是BFS。也就是一行一行的遍历，遍历的时候顺便把他们给串起来，如下图所示

![image.png](https://pic.leetcode-cn.com/1601255715-zYNzNP-image.png)


二叉树BFS的代码如下
```
    public void levelOrder(TreeNode tree) {
        if (tree == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);//相当于把数据加入到队列尾部
        while (!queue.isEmpty()) {
            //poll方法相当于移除队列头部的元素
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }
```

在遍历每一行的时候，只要把他们串联起来就OK，下面就来把上面的代码改造一下

```
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //每一层的数量
            int levelCount = queue.size();
            //前一个节点
            Node pre = null;
            for (int i = 0; i < levelCount; i++) {
                //出队
                Node node = queue.poll();
                //如果pre为空就表示node节点是这一行的第一个，
                //没有前一个节点指向他，否则就让前一个节点指向他
                if (pre != null) {
                    pre.next = node;
                }
                //然后再让当前节点成为前一个节点
                pre = node;
                //左右子节点如果不为空就入队
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return root;
    }
```
看一下运行结果
![image.png](https://pic.leetcode-cn.com/1601607348-lNfALy-image.png)


<br>

上面运行效率并不是很高，这是因为我们把节点不同的入队然后再不停的出队，其实可以不需要队列，每一行都可以看成一个链表比如第一行就是只有一个节点的链表，第二行是只有两个节点的链表（假如根节点的左右两个子节点都不为空）……

![image.png](https://pic.leetcode-cn.com/1602724262-gxSbdy-image.png)
![image.png](https://pic.leetcode-cn.com/1602724301-qvoabL-image.png)

经过上面的几步，很容易把链表给串起来，最后再来看下代码
```
    public Node connect(Node root) {
        if (root == null)
            return root;
        //cur我们可以把它看做是每一层的链表
        Node cur = root;
        while (cur != null) {
            //遍历当前层的时候，为了方便操作在下一
            //层前面添加一个哑结点（注意这里是访问
            //当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node(0);
            //pre表示下一层节点的前一个节点
            Node pre = dummy;
            
            //然后开始遍历当前层的链表
            //因为是完美二叉树，如果有左子节点就一定有右子节点
            while (cur != null && cur.left != null) {
                //让pre节点的next指向当前节点的左子节点，也就是把它串起来
                pre.next = cur.left;
                //然后再更新pre
                pre = pre.next;

                //pre节点的next指向当前节点的右子节点，
                pre.next = cur.right;
                pre = pre.next;
                //继续访问这一行的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，
            //后续继续循环，直到cur为空为止
            cur = dummy.next;
        }
        return root;
    }
```
看一下运行结果，这种实现方式无论是执行时间还是内存消耗都比较满意
![image.png](https://pic.leetcode-cn.com/1602723527-aqALvL-image.png)

<br>

### 2，其他方式解决
上面两种方式都是参照[117. 填充每个节点的下一个右侧节点指针 II](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/solution/bfsjie-jue-zui-hao-de-ji-bai-liao-100de-yong-hu-by/)的题解，第117题不是完美二叉树，所以第117题的答案都可以拿到这里来用，但这里的答案却不能全部用在第117题。

我们还可以参照上面的方式来修改一下

```
    public Node connect(Node root) {
        if (root == null)
            return null;
        Node pre = root;
        Node cur = null;
        while (pre.left != null) {
            //遍历当前这一层的结点，然后把他们的下一层连接起来
            cur = pre;
            //cur不为空，就表示这一层还没遍历完，就继续循环
            while (cur != null) {
                //让下一层的左子节点指向右子节点
                cur.left.next = cur.right;
                //如果cur.next不为空，就表示还没遍历到这一层
                //最后的那个节点的右子节点，就让前一个结点的右
                //子节点指向下一个节点的左子节点
                if (cur.next != null)
                    cur.right.next = cur.next.left;
                //然后继续连接下一个节点的 子节点
                cur = cur.next;
            }
            //继续下一层
            pre = pre.left;
        }
        return root;
    }
```
看一下运行结果
![image.png](https://pic.leetcode-cn.com/1601608302-OUboev-image.png)

<br>

### 3，递归方式
或者也可以改为递归的 方式
```
    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node curr, Node next) {
        if (curr == null)
            return;
        curr.next = next;
        dfs(curr.left, curr.right);
        dfs(curr.right, curr.next == null ? null : curr.next.left);
    }
```
看一下有运行结果
![image.png](https://pic.leetcode-cn.com/1601608701-qYDpSI-image.png)




<br>

**如果觉得有用就给个赞吧，你的赞是给我最大的鼓励，也是我写作的最大动力**

![image.png](https://pic.leetcode-cn.com/d56a80459005b444404d2ad6fbaabdabecd2b9ed3cb2cf432e570c315ae2fcf7-image.png)
##### 查看更多答案，可扫码关注我微信公众号“**[数据结构和算法](https://img-blog.csdnimg.cn/20200807155236311.png)**”
