class Solution {
    public boolean isPalindrome(int x) {
        // Edge Cases: 
        // 1. Negative numbers are NOT palindromes (e.g., -121 backward is 121-)
        // 2. Numbers ending in 0 are NOT palindromes, unless the number itself is 0 (e.g., 10, 200)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        
        // Reverse only the second half of the number
        while (x > reversedHalf) {
            int lastDigit = x % 10;
            reversedHalf = (reversedHalf * 10) + lastDigit;
            x /= 10; // Remove the last digit from x
        }

        // For even-length numbers (e.g., 1221): x will be 12, reversedHalf will be 12 -> x == reversedHalf
        // For odd-length numbers (e.g., 12321): x will be 12, reversedHalf will be 123 -> x == reversedHalf / 10
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
