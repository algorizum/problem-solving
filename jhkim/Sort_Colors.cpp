class Solution {
public:
    void sortColors(vector<int>& nums) {
        int cur = 0;
        int swapped = 0;
        for(int i=0;i<nums.size()-1;++i)
        {
            if(nums[i]==cur)
                continue;
            
            swapped = 0;
            for(int j=i+1;j<nums.size();++j)
            {
                if(nums[j]==cur)
                {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;                    
                    swapped = 1;
                    break;
                }
            }
            
            if(swapped==0)
            {
                if(cur==2)
                    break;
                
                cur += 1;
                i -= 1;
            }
        }
    }
};
