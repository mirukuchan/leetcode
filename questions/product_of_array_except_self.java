package questions;
import utils.leetCodeParser;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


class product_of_array_except_self {
    //input [1,2,3,4]
    //output [24,12,8,6]
    private static int[] productExceptSelf(int[] nums){
        int[] result = new int[nums.length];
        for(int i = 0, tmp = 1; i < nums.length; i++){
            result[i] = tmp;
            tmp *= nums[i];
        } 
        for(int i = nums.length-1, tmp = 1; i >= 0; i-- ){
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }

    // public static void main(String args[]){
    //     try{
    //         File file = new File("questions/input.txt");
    //         Scanner in = new Scanner(file);
    //         PrintWriter out = new PrintWriter("questions/output.txt");
    //         while(in.hasNextLine()){
    //             String line = in.nextLine();
    //             int[] input = leetCodeParser.array1d(line);
    //             int[] result = productExceptSelf(input);
    //             for(int i : result) out.println(i);
    //             out.println("\n");
    //         }
    //         in.close();
    //         out.close();
    //     } catch(Exception e){
    //         e.printStackTrace();
    //     }
    // }
}