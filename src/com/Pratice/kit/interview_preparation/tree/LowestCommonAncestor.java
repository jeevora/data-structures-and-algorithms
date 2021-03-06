package com.Pratice.kit.interview_preparation.tree;

import java.util.*;
import java.io.*;

public class LowestCommonAncestor {

    // O(depth of the tree)
    public static Node lca(Node root, int v1, int v2) {
        if(root.data > v1 && root.data > v2)
            return lca(root.left, v1, v2);
        if(root.data < v1 && root.data < v2)
            return lca(root.right, v1, v2);
        return root;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(new File("src/com/Pratice/sample_test_cases/interview_preparation/binary_search_tree_lowest_common_ancestor/input/input00.txt"));
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }

}
