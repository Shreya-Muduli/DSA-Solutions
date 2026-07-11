class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while(i<nums.length){
            int correct = nums[i] -1;
            if(nums[i] != nums[correct]){
                int temp = nums[correct];
                nums[correct] = nums[i];
                nums[i] = temp;
            }else{
                i++;
            }
        }
        int[] missing = new int[2];
        for(int j = 0; j< nums.length; j++){
            if(nums[j] != j+1){
                missing[0] = (nums[j]);
                missing[1] = j + 1;
            }
        }
        return missing;
    }
}