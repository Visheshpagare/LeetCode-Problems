/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
           return build(preorder , inorder , 0 , inorder.length-1);
    }
    private TreeNode build(int[] preorder , int[] inorder , int start , int end){
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int index = start;
        while(inorder[index] != root.val){
            index++;
        }
        root.left = build(preorder , inorder , start , index -1);
        root.right = build(preorder , inorder , index+1 , end);
        return root;
    }
}