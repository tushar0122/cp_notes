private static Integer[] boxing(int [] arr){
    return Arrays.stream(arr).boxed().toArray(Integer[]::new);
}