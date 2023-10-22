class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        
        Map<Integer,Integer>map=new HashMap<>();
        for(int x:nums)
        {
            map.put(x,map.getOrDefault(x,0)+1);
        }

        int min=Integer.MAX_VALUE;

        for(int f:map.values())
        {
            min=Math.min(min,f);
        }

        for(int i=min;i>=0;i--)
        {
            int count=makeGroups(map,i);

            if(count>0) return count;

        }
        return nums.length;

    }

    int makeGroups(Map<Integer,Integer>map,int size)
    {
        int count=0;
        for(int v:map.values())
        {
            int minGroup=v/(size+1);
            int rem=v%(size+1);
            if(rem==0)
            {
                count+=minGroup;
            }else if(minGroup>=(size-rem))
            {
                count+=minGroup+1;
            }else{
                return 0;
            }
        }
        return count;
    }
}