package BinaryTree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    public void preorder_2(TreeNode root, List<Integer> result) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.removeFirst();
            result.add(cur.val);
            if (cur.right != null) stack.addFirst(cur.right);
            if (cur.left != null) stack.addFirst(cur.left);
        }
    }

    public void preorder_3(TreeNode root, List<Integer> result) {
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) return;

        stack.offerFirst(root); //初始化
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst(); //一定要出栈
            if (cur != null) { //还没有被访问
                if (cur.right != null) stack.offerFirst(cur.right);
                if (cur.left != null) stack.offerFirst(cur.left);
                stack.offerFirst(cur);
                stack.offerFirst(null); //跟在cur节点后面。表示已经访问过，但是没有处理
            }else{
                result.add(stack.pollFirst().val);
            }
        }
    }
}    