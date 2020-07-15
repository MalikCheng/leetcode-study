public class Q2_2 {
    // 找到连续子数组之和大于等于S的最小长度
    // Example 1:
    // Input: [2, 1, 5, 2, 3, 2], S=7 
    // Output: 2
    // Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
    
    // Example 2:
    // Input: [2, 1, 5, 2, 8], S=7 
    // Output: 1
    // Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
    
    // Example 3:
    // Input: [3, 4, 1, 1, 6], S=8 
    // Output: 3
    // Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
    
    public static int findMinSubArray(int S,int [] arr) {
        if(arr == null) return -1;
        int n = arr.length;
        if(n == 0) return -1;
        int res = Integer.MAX_VALUE;
        int windowSum = 0;
        int windowLeft = 0;
        int windownRight = 0;
        for(;windownRight<n;windownRight++){
           windowSum += arr[windownRight];
           // 窗口达到条件 缩小window,可能右进的数远大于左出的数，所以一直左出到window之和达到边界
            while(windowSum>=S){
                res = Math.min(windownRight-windowLeft+1, res);
                windowSum -= arr[windowLeft];
                windowLeft++;
            }
        }
        return res== Integer.MAX_VALUE?0:res;
    }
    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
        System.out.println(findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));
    }
}
