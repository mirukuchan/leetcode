package utils;
import utils.datastructure.*;

public class leetCodeParser{

    private static String removeSpace(String s){
        return s.replaceAll("\s", "");
    }
    // 1-D array
    // input: [1,1,2,3]
    public static int[] array1d(String s){
        s = removeSpace(s);
        s = s.replaceAll("\\[|\\]", "");
        String[] S = s.split(",");
        int[] res = new int[S.length];
        for(int i = 0; i<res.length; i++){
            res[i] = Integer.valueOf(S[i]);
        }
        return res;
    }

    // 2-D array
    // input: [[1,2,3,4],[4,3,2,1]]
    public static int[][] array2d(String s){
        s = removeSpace(s);
        s = s.substring(1, s.length()-2);
        String[] S = s.split(",");
        int dim2 = S[0].split(",").length;
        int[][] res = new int[S.length][dim2];
        for(int i = 0; i<S.length; i++){
            res[i] = array1d(S[i]);
        }
        return res;
    }

    // Bi-tree
    // input [1,2,3,4,5,#,7]
    public static BiNode bTree(String s){
        s = removeSpace(s);
        s = s.substring(1,s.length()-1);
        String[] S = s.split(",");
        BiNode root = createBtree(1, S);
        return root;        
    }

    private static BiNode createBtree(int i,String[] S){
        if(i > S.length) return null;
        BiNode node = new BiNode();
        if (S[i-1].equals("null"))
            return null;
        node.val = Integer.valueOf(S[i-1]);
        node.left = createBtree(i*2, S);
        node.right = createBtree(i*2+1, S);
        
        return node;
    }


}