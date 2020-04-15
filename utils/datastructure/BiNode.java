package utils.datastructure;

public class BiNode {
    public int val;
    public BiNode left;
    public BiNode right;
    
    public BiNode(){};
    public BiNode(int val) {
        this.val = val;
    }
    public BiNode(int val, BiNode left, BiNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
