class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> seen;//unordered_map uses hashtable (O(1)); map uses self balancing BST(O(logN))
        vector<int> ret(2,-1);
        for(int i = 0; i < nums.size();++i){
            if(seen.find(target-nums[i]) != seen.end()){
                ret[0]=i;
                ret[1] = seen[target-nums[i]];
                break;
            }
            seen[nums[i]] = i;
        }
        return ret;
    }
};