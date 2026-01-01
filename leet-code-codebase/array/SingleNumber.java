class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i =  0;i<nums.length ; i++){
            //if(nums[i-1] != nums[i]){
             result ^=nums[i];//XOR remove duplicate elements
        }
       return result; 
    }
}