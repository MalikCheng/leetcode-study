import java.util.HashMap;

public class Q2_3LongestSubStringWithDistinctChar {
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

    // 窗口: 子串
    // 扩： 子串不同字符个数没有到k, 不同字符个数<= k  此刻寻找可行解
    // 如果窗口长度能确定，可以平移窗口。例如Q2-1，题目说明了子数组固定长度;或通过其他方法验证，可以使用固定长度
    // 这里窗口长度不固定，所以
    // 缩： 子串不同字符个数>k,一直缩小left边界; 当子串不同字符个数<=k再去扩右  此刻转换不可行解到可行解
    public static int findLongestSubArrayWithDistChar(int k, String str) {
        if (str == null) return -1;
           
        int n = str.length();
        if (n == 0 || n < k)  return 0;
          
        HashMap<Character, Integer> distCharMap = new HashMap<>();
        int windowRight = 0;
        int windowLeft = 0;
        int res = 0;
        for (; windowRight < n; windowRight++) {
            distCharMap.put(str.charAt(windowRight),distCharMap.getOrDefault(str.charAt(windowRight),0)+1 );

            while (distCharMap.keySet().size() > k) {
                distCharMap.put(str.charAt(windowLeft), distCharMap.get(str.charAt(windowLeft))-1 );
                if(distCharMap.get(str.charAt(windowLeft))==0){
                    distCharMap.remove(str.charAt(windowLeft));
                }
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
        System.out.println(findLongestSubArrayWithDistChar(2, "abacbbbb"));
    }
}
