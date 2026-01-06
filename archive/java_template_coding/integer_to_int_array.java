private static int[] unboxing(Integer [] arr){
    return Arrays.stream(arr).mapToInt(i -> i).toArray();
}