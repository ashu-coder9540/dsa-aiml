import java.util.HashMap;

public class LongestSubStringWithoutRepeatingCharacter {
    public static int longestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] hash = new int[255];
            for (int j = i; j < n; j++) {
                if (hash[s.charAt(j)] == 1)
                    break;
                int len = j - i + 1;
                maxLen = Math.max(maxLen, len);
                hash[s.charAt(j)] = 1;
            }
        }
        return maxLen;
    }

    public static int longestSubstring2(String s){
         /* #Steps
      1. we can use hashmap to store freq of duplicate char in string
      2. then trave in hashmap and whenever we get duplicate we can move left pointer where last duplicated seen above but that in the range 
      3. keep updating maxLength of Longest Substring Without Repeating Characters
       */
       HashMap<Character, Integer> mp = new HashMap<>();
       int n = s.length();
       int maxLength = 0;
       int winStart = 0;
       for(int winEnd=0; winEnd<n; winEnd++){
        char ch = s.charAt(winEnd);
    //    if char is already seen move left pointer
        if(mp.containsKey(ch)){
            winStart = Math.max(winStart, mp.get(ch)+1);
        }
    //  update last seen idx char
        mp.put(ch, winEnd);

    //  update maxLength
        maxLength = Math.max(maxLength, winEnd - winStart + 1);
       }
       return maxLength;
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        // Using BruteForce 
        int length = longestSubstring(s);
        System.out.println(length);

        // Using Sliding Window
        int length1 = longestSubstring2(s);
        System.out.println(length1);

    }
}
