class Leet2914 {
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[2];
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                arr[0] = nums[i];
                arr[1] = nums[i]+1;
                break;
            }
        }
        return arr;
    }
}