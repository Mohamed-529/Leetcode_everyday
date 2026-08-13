class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> have = new HashMap<>();

        // 1. Build frequency of p
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int k = p.length();

        for (int right = 0; right < s.length(); right++) {

            // 2. Add right character
            char rightChar = s.charAt(right);

            have.put(
                rightChar,
                have.getOrDefault(rightChar, 0) + 1
            );

            // 3. Remove left if window is too large
            if (right - left + 1 > k) {

                char leftChar = s.charAt(left);

                have.put(
                    leftChar,
                    have.get(leftChar) - 1
                );

                if (have.get(leftChar) == 0) {
                    have.remove(leftChar);
                }

                left++;
            }

            // 4. Compare frequencies
            if (need.equals(have)) {
                result.add(left);
            }
        }

        return result;
    }
}