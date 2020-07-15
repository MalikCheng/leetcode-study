import java.util.HashMap;

public class Q2_3 {
    // 找到含有k个不同字符的最长子数组长度

    // Input: String="araaci", K=2
    // Output: 4
    // Explanation: The longest substring with no more than '2' distinct characters
    // is "araa".

    // Input: String="araaci", K=1
    // Output: 2
    // Explanation: The longest substring with no more than '1' distinct characters
    // is "aa".

    // Input: String="cbbebi", K=3
    // Output: 5
    // Explanation: The longest substrings with no more than '3' distinct characters
    // are "cbbeb" & "bbebi".
    public static int findLongestSubArrayWithDistChar(int k, String str) {
        if (str == null) return -1;
           
        int n = str.length();
        if (n == 0 || n < k)  return 0;
          
        HashMap<Character, Integer> distCharMap = new HashMap<>();
        int windowRight = 0;
        int windowLeft = 0;
        int res = 0;
        for (; windowRight < n; windowRight++) {
            distCharMap.put(str.charAt(windowRight), 1);

            if (distCharMap.keySet().size() > k) {
                distCharMap.remove(str.charAt(windowLeft));
                windowLeft++;
            }
            res = Math.max(res, windowRight - windowLeft + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(findLongestSubArrayWithDistChar(2, "araaci"));
        System.out.println(findLongestSubArrayWithDistChar(1, "araaci"));
        System.out.println(findLongestSubArrayWithDistChar(3, "cbbebi"));
        System.out.println(findLongestSubArrayWithDistChar(1, "aaaaa"));
    }
}
