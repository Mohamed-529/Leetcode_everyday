class Solution {
    public int reverse(int x) {
        int rev = 0;
        
        while (x != 0) {
            // Extract the last digit (e.g., 123 % 10 = 3)
            int pop = x % 10;
            
            // Move the original number one decimal place to the left
            x /= 10;
            
            // CRITICAL STEP: Check for 32-bit signed integer overflow
            // Integer.MAX_VALUE = 2147483647, Integer.MIN_VALUE = -2147483648
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0; // Overflow would happen, return 0 as required
            }
            
            // Build the reversed number
            rev = rev * 10 + pop;
        }
        
        return rev;
    }
}
