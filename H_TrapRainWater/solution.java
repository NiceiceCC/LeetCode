class Solution {
    public int trap(int[] height) {
        if (height.length==0)
            return 0;
        int lo=0,hi=height.length-1,rain = 0, minh = 0;
		
        while(lo<hi){
            if (minh >= height[lo])
                rain += minh - height[lo++];
            else if(minh >= height[hi])
                rain += minh - height[hi--];
            int curMin = Math.min(height[lo],height[hi]);
            if (curMin>minh)
                minh =a curMin;
        }
        return rain;            
    }
}