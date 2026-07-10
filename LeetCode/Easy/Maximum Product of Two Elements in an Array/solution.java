class Solution {
    public int maxProduct(int[] nums) {
        for(int i = 0; i<nums.length;i++){
            for(int j = 0; j< nums.length -i -1;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        int max = nums[nums.length -1];
        int secmax = nums[nums.length -2];
       
        return (max-1)*(secmax-1);
    }
    
}