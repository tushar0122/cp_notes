    public int[] dijktrasSmallestDis(int [][] edges, int n, List<List<int[]>>adj_list ){
        int s = n;
        int [] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[n]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b)->{
            return a[1]-b[1];
        });
        pq.add(new int[]{n, 0});
        while(pq.size()>0){
            var mnDisNode = pq.poll();
            var node = mnDisNode[0];
            var nodeDis = mnDisNode[1];
            if(nodeDis>dis[node]){
                continue;
            }
            var l = adj_list.get(node);
            for(int[] i: l){
                var newNode = i[0];
                var newNodeDis = i[1];
                int newDis = nodeDis+newNodeDis;
                if(newDis<dis[newNode]){
                    pq.add(new int[]{newNode, newDis});
                    dis[newNode]=newDis;
                }
            }
        }
        return dis;
    }
