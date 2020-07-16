/**
 * @author MalikCheng
 * @version 1.0
 * @since 2020/7/2 22:08
 */
public class Q2_5_LongestRepeatingCharacterReplacement {

//    输入:
//    s = "ABAB", k = 2
//
//    输出:
//            4
//
//    解释:
//    用两个'A'替换为两个'B',反之亦然
        // https://leetcode-cn.com/problems/longest-repeating-character-replacement/
        // 替换后的最长重复字符
        public int characterReplacement(String s, int k) {
            int[] map = new int[26];
            // 【left-right】可以替换重复字符串的区间长度
            int left=0;
            // 不是窗口内出现最多重复字符数，是在经过所有窗口中  比较出最多的重复字符数，即窗口与窗口比较出大值，是个历史最大值。
            int MostChar =0;
            char[] chars = s.toCharArray();
            int res = 0;
            for(int right=0;right<chars.length;right++){
                int index = chars[right]-'A';
                map[index]++;
                // 窗口右边加一时：当前【left,right】与上一个【left,right+1】窗口比较出 最大重复字符数
                // 窗口向右平移：当前【left,right】与上一个【left’,right+1】窗口比较出 最大重复字符数
                MostChar = Math.max(map[index],MostChar);
                // 看下当前窗口减去历史窗口最大重复字符后，是否还可有不大于k个字符用去替换.
                // 如果可以那就更新结果，结果一满足条件的最大值，窗口右边扩大，继续再去寻找；
                if( right-left+1<= MostChar+k){
                    res = Math.max(res,right-left+1);
                 // 否则我们需要寻找新窗口，【left+1，right+1】 为什么要这样平移尼？
                    // [left+1,left+2]这个窗口也是可以啊，但是是不是这个窗口是不是已经在上个窗口统计过尼，个窗口【left，right】包含了并统计了
                    // left+1 开头的没有统计？？？
                    // 【left+1,right】，而【left+1，right+1
                }else{
                    map[chars[right]-'A']--;
                    left++;
                }
            }
            return res;
        }
}
