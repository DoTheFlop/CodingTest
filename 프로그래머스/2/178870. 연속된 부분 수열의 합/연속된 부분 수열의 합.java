public class Solution {
    public static int[] solution(int[] sequence, int k) {
        int n = sequence.length;

        int maxSum = 0;
        int end = 0;
        int interval = n;
        int[] result = new int[2];

        for (int start = 0; start < n; start++) {
            while (maxSum < k && end < n) {
                maxSum += sequence[end];
                end++;
            }
            if (maxSum == k && end - 1 - start < interval) {
                result[0] = start;
                result[1] = end - 1;
                interval = end - 1 - start;
            }
            maxSum -= sequence[start];
        }

        return result;
    }
}