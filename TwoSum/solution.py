class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        val2idx = {} #value-index pairs stored in dict
        for idx,n in enumerate(nums):
            if target-n in val2idx: #found target
                return [idx,val2idx[target-n]]
            val2idx[n] = idx
        return None