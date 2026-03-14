import java.util.ArrayList;
import java.util.List;

public class HappyString {
    // Approach-1 (Khandani Backtracking Template - storing all possible strings)
    // T.C : O(n * 3 * 2^(n-1)) ~= O(n*2^n)
    // S.C : O(n * 2^n), total 2^n strings each having length n
        private static void solve(int n, StringBuilder curr, List<String> res) {
            if (curr.length() == n) {
                res.add(curr.toString());
                return;
            }
            for (char ch = 'a'; ch <= 'c'; ch++) {
                if (curr.length() > 0 && curr.charAt(curr.length() - 1) == ch)
                    continue;

                // Backtracking Khandani Template
                curr.append(ch); // Do
                solve(n, curr, res); // Explore
                curr.deleteCharAt(curr.length() - 1); // Undo
            }
        }

        public static String getHappyString(int n, int k) {
            StringBuilder curr = new StringBuilder();
            List<String> res = new ArrayList<>();
            solve(n, curr, res);

            if (res.size() < k) {
                return "";
            }
            return res.get(k - 1);
        }

    public static void main(String[] args) {
        int n = 3, k = 9;
        String ans = getHappyString(n, k);
        System.out.println(k + "th happy string: " + ans);
    }
}
