package binarytree;

import java.util.*;

class Solution_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public void inorder_2(TreeNode root, List<Integer> result) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.addFirst(cur);
                cur = cur.left;
            }
            TreeNode temp = stack.removeFirst();
            result.add(temp.val);
            if (temp.right != null) {
                cur = temp.right;
            }
        }
    }

    public void inorder_3(TreeNode root, List<Integer> result) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();

        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            if (cur != null) {
                if (cur.right != null) stack.offerFirst(cur.right);
                stack.offerFirst(cur);
                stack.offerFirst(null);
                if (cur.left != null) stack.offerFirst(cur.left);
            }else {
                result.add(stack.pollFirst().val);
            }
        }
    }
}
