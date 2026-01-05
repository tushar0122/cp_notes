private static int lowerBound(List<Integer> arr, int target){
    int x = Collections.binarySearch(arr, target);
    if(x >= 0){
        return target;
    }
    else{
        int insertionPoint = -(x + 1);
        if(insertionPoint >= arr.size()){
            return -1; // target is greater than all elements
        }
        return arr.get(insertionPoint);
    }
}