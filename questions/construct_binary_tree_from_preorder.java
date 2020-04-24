package questions;

public class construct_binary_tree_from_preorder {
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder){
        return helper(preorder, Integer.MAX_VALUE);
    }

    public TreeNode helper(int[] A, int bound){
        if(i == A.length || A[i] > bound) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = helper(A, root.val);
        root.right = helper(A, bound);
        return root;
    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }
}