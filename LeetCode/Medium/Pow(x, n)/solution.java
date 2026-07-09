class Solution {
    public double myPow(double x, int n) {
        if(n == 1){
            return x;
        }
        else{
            double m = n;
            double power = Math.pow(x,n);
            return power;
        }
    }
}