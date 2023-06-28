class Solution {
    
    class Node{
        int node;
        double pro;
        public Node(int node,double pro)
        {
            this.node=node;
            this.pro=pro;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        PriorityQueue<Node>pq=new PriorityQueue<>((a, b) -> (((Double) b.pro).compareTo((Double) a.pro)));
        double dis[]=new double[n];
        Arrays.fill(dis,Double.MIN_VALUE);
        List<List<double[]>>g=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            g.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            double w=succProb[i];
            double a1[]={v,w};
            double a2[]={u,w};
            g.get(u).add(a1);
            g.get(v).add(a2);
        }
        
        boolean visited[]=new boolean[n];
        Arrays.fill(visited,false);
        
        pq.add(new Node(start,1.0));
        dis[start]=1.0;
        visited[start]=true;
        
        while(pq.isEmpty()==false)
        {
            Node pair=pq.poll();
            int u=pair.node;
            double p=pair.pro;
            visited[u]=true;
            // System.out.println(p);
            for(double v[]:g.get(u))
            {
                if(visited[(int)v[0]]==false && dis[(int)v[0]]< p*v[1])
                {
                    
                    dis[(int)v[0]]=p*v[1];
                    pq.add(new Node((int)v[0],dis[(int)v[0]]));
                }
            }
        }
        
        return dis[end];
        
    }
}