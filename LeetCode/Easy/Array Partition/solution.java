class Solution {
    public int arrayPairSum(int[] nums) {
        for(int i = 0; i< nums.length; i++){
            for(int j = 0; j< nums.length -i - 1; j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        int sum = 0;
        for(int i = 0; i< nums.length;i=i+2){
            sum += nums[i];
        }
        return sum;
    }
}