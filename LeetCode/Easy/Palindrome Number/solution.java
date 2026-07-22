class Solution {
    public boolean isPalindrome(int x) {
        // Special cases:
        // 1. Negative numbers are not palindromes (e.g., -121 -> 121-).
        // 2. If the last digit is 0, the first digit must also be 0 (only possible if x == 0).
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // For even-length numbers: x == revertedNumber (e.g., 1221 -> x = 12, revertedNumber = 12)
        // For odd-length numbers: x == revertedNumber / 10 (e.g., 121 -> x = 1, revertedNumber = 12 -> 12 / 10 = 1)
        return x == revertedNumber || x == revertedNumber / 10;
    }
}