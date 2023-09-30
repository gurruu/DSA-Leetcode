class Solution {
    public boolean find132pattern(int[] nums) {
        
        Stack<Integer>st=new Stack<>();
        int ind=-1;
        int n=nums.length;
        for(int i=n-1;i>=0;i--)
        {
            if(ind>=0 && nums[i]<nums[ind]){
                return true;
            }
            
            while(!st.isEmpty() && nums[i]>nums[st.peek()])
            {
                ind=st.pop();
            }
            st.push(i);
        }
        return false;
        
    }
}