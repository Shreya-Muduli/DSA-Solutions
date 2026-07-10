class Solution {
    public int heightChecker(int[] heights) {
        int [] expected = heights.clone();
        int count = 0;
        for(int i = 0; i< expected.length-2; i++){
            for(int j = 0; j<expected.length -i -1; j++){
                if(expected[j] > expected[j+1]){
                    int temp = expected[j];
                    expected[j]= expected[j+1];
                    expected[j+1] = temp;
                }
            }
        }
        for(int i = 0; i< heights.length; i++){
            if(heights[i] != expected[i]){
                count++;
            }
        }
        return count;
    }
}