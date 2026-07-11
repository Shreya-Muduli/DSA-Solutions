class Solution {
    public List<Integer> findDuplicates(int[] nums) {
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
        List<Integer> dupe = new ArrayList<>();
        for(int j = 0; j< nums.length; j++){
            if(nums[j] != j+1){
                dupe.add(nums[j]);
            }
        }
        return dupe;
    }
}