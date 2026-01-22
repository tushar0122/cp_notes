

public int lowerBound(List<Integer> l, int s, int e, int target){
    if(s>=e)return s;
    int m = s+(e-s)/2;
    int o = l.get(m);
    if(o >= (target)){
       return lowerBound(l, s, m, target);
    }
    else {
       return lowerBound(l, m+1, e, target);
    }
}

public int upperBound(List<Integer> l, int s, int e, int target){
    if(s>=e)return s;
    int m = s+(e-s)/2;
    int o = l.get(m);
    if(o<=target){
       return upperBound(l, m+1, e, target);
    }
    else {
       return upperBound(l, s, m, target);
    }
}