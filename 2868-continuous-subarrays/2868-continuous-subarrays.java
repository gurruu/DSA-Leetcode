class Solution {
    public long continuousSubarrays(int[] nums) {
        
        int min=nums[0];
        int max=nums[0];
        int i=0;
        int j=0;
        long ans=0;
        int n=nums.length;
        
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        
        while(i<n && j<n)
        {
            maxHeap.offer(nums[i]);
            minHeap.offer(nums[i]);

            while(maxHeap.peek()-minHeap.peek()>2)
            {
                maxHeap.remove(nums[j]);
                minHeap.remove(nums[j]);
                j++;
            }
            

            ans+=i*1L-j*1L+1L;
            i++;
        }
        return ans;
        
    }
}