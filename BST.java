import java.io.*;
import java.util.*;
// may have some bugs, pls look at the function 

import javax.print.attribute.standard.PagesPerMinute;
public class BST
{
    TreeNode root;
    private static class TreeNode {
        private int       value;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;
        private TreeNode(int dataItem, TreeNode left, TreeNode right, TreeNode 
parent) {
            value       =   dataItem;
            this.left   =   left;
            this.right  =   right;
            this.parent =   parent;
        }

    }
    public BST() {
        root = null;
    }

    // the method to replace root
    public TreeNode DeleteRootAndReplaceLeftMin(TreeNode root){
        TreeNode temp = root;
        while(root.left != null){
            root = root.left;
        }
        root.parent.left = null;
        root.parent.right = root.right;
        root.left = temp.left;
        root.right = temp.right;
        root.parent = null;
        return root;
    }

    // this method may have some bugs 
    public void addTreeNode(int data)
    {
        root = addTreeNode(root, data);
    }

    private TreeNode addTreeNode(TreeNode node, int data)
    {
        if (node == null)
            node = new TreeNode(data);
        else
        {
            if (data <= node.value)
                node.left = addTreeNode(node.left, data);
            else
                node.right = addTreeNode(node.right, data);
        }
        return node;
    }

    // to string in pre order
    public String toStringPreorder(TreeNode root) {
        String s = "";
        if (root == null) {
            return "";
        }
    
        s += root.toString();
        s += toStringPreorder(root.left);
        s += toStringPreorder(root.right);
        return s;
    }

    public String toString() {
        return toStringPreorder(root);
    }

    // main function
    public static void main(String[] args) {
        BST tree = new BST();
        tree.addTreeNode(24);
        tree.addTreeNode(5);
        tree.addTreeNode(16);
        tree.addTreeNode(16);
        tree.addTreeNode(11);
        System.out.println(tree);
    }
}

