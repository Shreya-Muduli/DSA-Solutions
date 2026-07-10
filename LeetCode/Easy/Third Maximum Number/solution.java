class Solution {
    public int thirdMax(int[] nums) {
        for(int i = 0; i<nums.length-1;i++){
            for(int j = 0; j< nums.length -i-1;j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        int distinct = 1;
        int index = nums.length -1;
        for(int i = index; i>0;i--){
            if(nums[i] != nums[i-1]){
                distinct++;
                if(distinct == 3){
                return nums[i-1];
                }
            }
        }
        return nums[nums.length - 1];
    }
}