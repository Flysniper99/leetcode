package binarytree;

import java.util.HashSet;

class FindElements {
    HashSet<Integer> valSet = new HashSet<>();

    public FindElements(TreeNode root) {
        dfs(root, 0);
    }

    public boolean find(int target) {
        return valSet.contains(target);
    }

    public void dfs(TreeNode root, int val) {
        if (root == null) return;
        root.val = val;
        valSet.add(root.val);
        dfs(root.left, 2 * root.val + 1);
        dfs(root.right, 2 * root.val + 2);
    }
}
