class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        lo,hi,rain = 0,len(height)-1,0
        minh = 0
        while lo<hi:
            if minh >= height[lo]:
                rain += minh - height[lo]
                lo +=1
            elif minh>= height[hi]:
                rain += minh - height[hi]
                hi -=1
            if minh < min(height[lo],height[hi]):
                minh = min(height[lo],height[hi])
                
        return rain