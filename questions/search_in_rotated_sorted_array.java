package questions;

public class search_in_rotated_sorted_array {

    // input[4,5,6,7,0,1,2] 3 retrun - 1
    // input[4,5,6,7,0,1,2] 0 return 4
    // need to be solved under the complexity in the order of O(logN) 
    public int search(int[] nums, int target){
        if(nums == null || nums.length == 0) return -1;
        int N = nums.length, start = nums[0], end = nums[N-1];
        if(target < start && target > end) return -1;
        int left = 0, right = N-1;
        while(left <= right){
            int mid = left + ((right - left ) >> 1);
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[left]){
                if(nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else {
                if(nums[mid] < target && nums[right] >= target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }


}