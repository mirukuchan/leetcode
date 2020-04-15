package questions;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

import utils.leetCodeParser;
import utils.datastructure.*;

public class populating_Next_Right_Pointers_in_Each_Node_II{

    // normal solution
    public Node connect(final Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        while(!Q.isEmpty()){
            int n = Q.size();
            for(int i = 0; i < n; i++){
                Node node = Q.poll();
                if(i < n - 1) node.next = Q.peek();
                if(node.left != null) Q.add(node.left);
                if(node.right != null) Q.add(node.right);
            }
        } 
        return root;
    }

    // O(1) space solution
    public Node connectR(final Node root){
        Node pRoot = root;
        Node dummy = new Node();
        Node pre = dummy;
        while(pRoot != null){
            if(pRoot.left != null){
                pre = pRoot.left;
                pre = pre.next;
            }
            if(pRoot.right != null){
                pre = pRoot.right;
                pre = pre.next;
            }
            pRoot = pRoot.next;
            if(pRoot == null){
                pRoot = dummy;
                pre = dummy;
                dummy.next = null;
            }
        }
        return root;
    }

    // private static void traverse(BiNode root){
    //     if(root == null) return;
            
    //     System.out.print(root.val);
    //     traverse(root.left);
    //     traverse(root.right);
    //     return;
    // }

    public static void main(final String args[]){
        try {
            File f = new File("questions/input.txt");
            if(f.isFile() && f.exists()){
                BufferedReader bufferedreader = new BufferedReader(new FileReader(f));
                FileWriter writer = new FileWriter("questions/output.txt");
                BufferedWriter bufferedwriter = new BufferedWriter(writer);
                String line = null;
                while(( line = bufferedreader.readLine()) != null){
                    // run()
                    BiNode root = new BiNode();
                    root = leetCodeParser.bTree(line);
                    bufferedwriter.write(line + "\r\n");

                }
                bufferedreader.close();
                bufferedwriter.close();
            }

        } catch(Exception e){
            e.printStackTrace();
        } 
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(final int _val) {
            val = _val;
        }
    
        public Node(final int _val, final Node _left, final Node _right, final Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}

