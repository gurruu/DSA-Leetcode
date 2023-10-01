class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        
        int n=nums.length;
        int arr[]=new int[2*n];
        long sum=0;
        for(int x:nums)
        {
            sum+=x;
        }
        if(target%sum==0) return (int)n*(target/(int)sum);

        int count=(int)target/(int)sum;
        int rem=(int)target-count*(int)sum;
        
        for(int i=0;i<2*n;i++)
        {
            arr[i]=nums[i%n];
        }

        int min=smallestSubarraySumK(arr,2*n,rem);
        if(min==-1) return -1;
        count*=n;
        count+=min;
        return count;


    }
     int smallestSubarraySumK(int arr[], int n, int K)
{
    // Use map here to store the prefixSum ending
    // at ith index.
    HashMap<Integer,
    Integer> mp = new HashMap<Integer,
    Integer>();
 
    // Store the current Prefix sum till ith
    // index;
    int currPrefixSum = 0;
 
    // Store the minimum size subarray whose
    // sum is K
    int result = Integer.MAX_VALUE;
 
    for(int i = 0; i < n; i++){
        currPrefixSum += arr[i];
 
        // Check if the current prefix sum is
        // equals to K
        if(currPrefixSum == K){
            int currLen = i + 1;
            result = Math.min(result, currLen);
        }
 
        // Required PrefixSum
        int requirePrefixSum = currPrefixSum - K;
 
        // Check if there exist any required Prefix Sum or not
        if(mp.containsKey(requirePrefixSum)){
            int foundIdx = mp.get(requirePrefixSum);
            int currIdx = i;
 
            result = Math.min(result, currIdx
                                - foundIdx);
        }
        
        // Store the current prefix sum ending at i
        mp.put(currPrefixSum, i);
    }
 
    if(result >= Integer.MAX_VALUE) return -1;
     
    // return the result
    return result;
}
}