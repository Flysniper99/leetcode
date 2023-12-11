import java.util.*;

class Solution_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

    public  void postorder_2(TreeNode root, List<Integer> result) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.removeFirst();
            result.add(cur.val);
            if (cur.left != null) stack.addFirst(cur.left);
            if (cur.right != null) stack.addFirst(cur.right);
        }
        Collections.reverse(result);
    }
}
