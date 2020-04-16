package questions;

import java.util.HashSet;
import java.util.Set;


class cracking_the_safe {
    
    //input n = 1, k = 2
    //output "01"
    //hint : de bruijn sequence
    //hint2: euler path
    static Set<String> visited;
    static StringBuffer res;
    public static String crackSafe(int n, int k){
        if(n == 1 && k == 1) return "0";
        visited = new HashSet<>();
        res = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n-1 ; i++){
            sb.append("0");
        }
        String start = sb.toString();
        dfs(start, k);
        res.append(start);
        return res.toString();
    }

    private static void dfs(String node, int k){
        for(int i = 0; i<k;i++){
            String new_node = node + i;
            if(!visited.contains(new_node)){
                visited.add(new_node);
                dfs(new_node.substring(1),k);
                res.append(i);
            }
        }
    }
}