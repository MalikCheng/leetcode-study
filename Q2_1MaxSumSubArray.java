
public class Q2_1 {

    // size = k的子数组和的最大值
   
    // Input: [2, 1, 5, 1, 3, 2], k=3 
    // Output: 9
    // Explanation: Subarray with maximum sum is [5, 1, 3].
    // Input: [2, 3, 4, 1, 5], k=2 
    // Output: 7
    // Explanation: Subarray with maximum sum is [3, 4]. 
    
    // 窗口代表：子数组
    // 扩：子数组长度没有到k
    // 平移： 子数组长度=k，统计出最大子数组和
    // 平移: left++,right++; 缩：left++,right不变
    public static int findMaxSumSubArray(int k ,int arr[]){
        if(arr == null) return -1;
        int n = arr.length;
        if(n<k||n==0) return -1;
        int maxSum = 0;
        int windowsRight = 0;
        int windowsLeft = 0;
        int windownSum = 0;
        for(; windowsRight<n; windowsRight++){
            windownSum += arr[windowsRight];
            if(windowsRight>k-1){
                windownSum -= arr[windowsLeft];
                windowsLeft++;
                maxSum = Math.max(maxSum,windownSum);
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
       int[] arr = {2, 1, 5, 1, 3, 2};
       int k = 3;
       System.out.println(findMaxSumSubArray(k, arr));
        
       arr = new int[]{2, 3, 4, 1, 5}; 
       k=2;
       System.out.println(findMaxSumSubArray(k, arr));
    }
}
