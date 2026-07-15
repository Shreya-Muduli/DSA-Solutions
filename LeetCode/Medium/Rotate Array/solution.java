class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int newk = k%n;
        reverse(nums, 0, n-1);
        reverse(nums,0,newk-1);
        reverse(nums,newk, n-1);
        System.out.print(Arrays.toString(nums));
    }
    public int[] reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end]= temp;
            start++;
            end --;
        }
        return nums;
    }
}