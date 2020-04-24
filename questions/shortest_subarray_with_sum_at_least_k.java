package questions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;


public class shortest_subarray_with_sum_at_least_k {
    public int shortestSubarray(int[] A, int K){
        int len = A.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int cur_sum = 0, res = Integer.MAX_VALUE;
        for(int i = 0 ; i < len; i++){
            cur_sum += A[i];
            if(cur_sum >= K) res = Math.min(i+1, res);
            while(!pq.isEmpty() && cur_sum - pq.peek()[0] >= K){
                res = Math.min(i-pq.poll()[1], res);
            }
            pq.offer(new int[]{cur_sum, i});
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int shortestSubarrayWithDq(int[] A, int K){
        int len = A.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] sum = new int[len+1];
        int res = Integer.MAX_VALUE;
        for(int i = 1; i < len+1; i++){
            sum[i] = sum[i-1] + A[i-1];
        }
        for(int i = 0; i < len; i++){
            while(!dq.isEmpty() && sum[i] - sum[dq.peekFirst()] >= K){
                res = Math.min(res, i - dq.pollFirst());
            }
            while(!dq.isEmpty() && sum[i] <= sum[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}