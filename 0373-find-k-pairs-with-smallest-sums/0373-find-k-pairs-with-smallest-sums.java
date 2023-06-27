class Solution {
    class Pair {
        int index ;
        long sum;
        int[] arr;
        
        Pair(int id , int n1 , int n2){
            this.index = id;
            arr = new int[]{n1,n2};
            sum = (long)n1 + (long)n2;
        }
    }
    class ComPair implements Comparator<Pair> {
        public int compare(Pair p1 , Pair p2) {
            return Long.compare(p1.sum , p2.sum);
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        
        if( nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return res;
        
        Queue<Pair> pq = new PriorityQueue<>(k, new ComPair());
        
        for(int i=0;i<nums1.length && i<k ; i++){
            pq.offer(new Pair( 0 , nums1[i] , nums2[0] ));
        }
        for(int i=1;i<=k && !pq.isEmpty() ;i++){
            Pair p = pq.poll();
            List<Integer> tmp = new ArrayList<>();
            int m=0;
            while(m<p.arr.length){
                tmp.add(p.arr[m++]);
            }
            res.add(tmp);
            if(p.index < nums2.length-1){
                int next = p.index+1;
                pq.offer(new Pair(next , p.arr[0] , nums2[next]));
            }
        }
        return res;
    }
}