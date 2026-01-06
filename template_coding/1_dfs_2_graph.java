
class Solution {
    void dfs(List<List<Integer>> al, int i, boolean[] vis){
        vis[i] = true;
        var l = al.get(i);
        for(int j=0;j<l.size();j++){
            if(!vis[l.get(j)]){
                dfs(al, l.get(j), vis);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int ne = connections.length;
        int re = n-1;
        if(ne<re){
            return -1;
        }
        int c = 0;
        List<List<Integer>> al = new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++){
            al.add(new ArrayList<Integer>());
        }
        for(int []i: connections){
            int u = i[0];
            int v = i[1];
                al.get(u).add(v);
                al.get(v).add(u);
        }
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(al, i, vis);
                c++;
            }
        }
        return c-1;
    }
}