class Solution {
public:
    int trap(vector<int>& height) {
        int rain = 0;
        if (height.size()==0) return rain;
        
        int lo = 0, hi = height.size()-1, minh = 0;
        while(lo<hi){
            if (minh>= height[lo])
                rain += minh - height[lo++];
            else if (minh>= height[hi])
                rain += minh - height[hi--];
            int curMinH = min(height[lo], height[hi]);
            if (minh < curMinH)
                minh = curMinH;            
        }            
        return rain;
    }
};