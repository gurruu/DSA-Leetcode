class Solution {
    public int minOperations(int[] nums, int x) {
        
       long sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        
        int res=0;
        long target=sum-x;
        long presum=0;
        Map<Long,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            presum+=nums[i];
            if(presum==target)
            {
                res=Math.max(res,i+1);
            }
            
            if(map.containsKey(presum-target))
            {
                res=Math.max(res,i-map.get(presum-target));
            }
            
            map.put(presum,i);
        }
        // System.out.println(res);
        if(res==0 && sum!=x)
        {
            return -1;
        }
        return nums.length-res;
    }
}