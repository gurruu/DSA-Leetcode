class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int count1=0,count2=0,element1=0,element2=0;
        for(int x:nums)
        {
            if(x==element1) count1++;
            else if(x==element2) count2++;
            else if(count1==0){
                count1=1;
                element1=x;
            }
            else if(count2==0)
            {
                count2=1;
                element2=x;
            }else{
                count1--;
                count2--;
            }
        }

        List<Integer>res=new ArrayList<>();
        count1=0;
        count2=0;
        for(int x:nums)
        {
            if(x==element1) count1++;
            else if(x==element2) count2++;
        }
        int n=nums.length;

        if(count1>n/3) res.add(element1);
        if(count2>n/3) res.add(element2);

        return res;

    }
}