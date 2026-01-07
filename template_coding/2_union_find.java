class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int l = s.length();
        int p [] = new int[l];
        for(int i=0;i<l;i++){
            p[i]=i;
        }
        for(var i: pairs){
            int u = i.get(0);
            int v = i.get(1);
            union(p, u, v);
        }
        var mp = new HashMap<Integer, List<Character>>();
        for(int i=0;i<l;i++){
            char c = s.charAt(i);
            int g = find(p, i);
            var list = mp.getOrDefault(g, new ArrayList<Character>());
            list.add(c);
            mp.put(g, list);
        }
        for(var v: mp.values()){
            Collections.sort(v);
        }
        int index[] = new int[l];
        var r = new StringBuilder();
        for(int i=0;i<l;i++){
            int g = find(p, i);
            char c = mp.get(g).get(index[g]++);
            r.append(c);
        }
        return r.toString();
    }

    public void union(int [] p, int u, int v){
        int x = find(p, u);
        int y = find(p, v);
        if(x<y){
            p[y]=x;
        }
        else{
            p[x]=y;
        }
    }

    int find(int [] p, int u){
        if(p[u]!=u){
            int x = find(p, p[u]);
            p[u]=x;
        }
        return p[u];
    }
}