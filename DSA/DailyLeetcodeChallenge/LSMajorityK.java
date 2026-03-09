import java.util.HashMap;

public class LSMajorityK {
    public static int longestSubarray(int[] arr, int k) {
    //   Bruteforce: check for all subarray
        int n = arr.length;
        int maxLen=0;
        for(int i=0; i<n; i++){
            int cgK=0, clK=0;
            for(int j=i; j<n; j++){
                if(arr[j] > k) cgK++;
                else clK++;
                
                if(cgK > clK){
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }
    // Optimal: using prefix sum and hashmap
     public static int longestSubarray2(int[] arr, int k) {
        int n = arr.length;
        int prefSum = 0, maxLen = 0;
        HashMap<Integer, Integer> psMap = new HashMap<>();
        psMap.put(0, -1);
        for(int i=0; i<n; i++){
            prefSum += (arr[i] > k) ? 1 : -1;
            if(prefSum > 0){
                maxLen = i+1;
            }
            if(psMap.containsKey(prefSum-1)){
                maxLen = Math.max(maxLen, i - psMap.get(prefSum - 1));
            }
            if(!psMap.containsKey(prefSum)){
                psMap.put(prefSum, i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 1};
        int k = 2;
        System.out.println(longestSubarray(arr, k));
        System.out.println(longestSubarray2(arr, k));
    }
}
