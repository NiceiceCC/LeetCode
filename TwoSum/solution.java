class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> seen = new HashMap<>();
        int[] ret = new int[2];
        for(int i = 0; i < nums.length;++i){
            if(seen.containsKey(target-nums[i])){
                ret = new int[]{i, seen.get(target-nums[i])};
                break;
            }
            seen.put(nums[i],i);
        }
        return ret;
    }
}