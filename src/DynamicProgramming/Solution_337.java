package DynamicProgramming;

import BinaryTree.TreeNode;

/**
 * 打家劫舍III
 * 树形dp
 */
class Solution_337 {
    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }
    public int[] robTree(TreeNode cur) {
        /*
        返回值表示节点对应的dp数组（长度为2），下标0表示不偷该节点得到的最大金钱
        下标1表示偷该节点得到的最大金钱
         */
        if (cur == null) return new int[] {0, 0}; //递归终止条件
        //后序遍历
        int[] left = robTree(cur.left);
        int[] right = robTree(cur.right);
        //单层递归逻辑
        int val_0 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); //不偷，则可以偷左右节点
        int val_1 = cur.val + left[0] + right[0]; //偷，则不能偷左右节点
        return  new int[] {val_0, val_1};
    }
}
