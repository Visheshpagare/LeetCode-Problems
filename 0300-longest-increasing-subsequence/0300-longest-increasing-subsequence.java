class Solution {

    int[][] dp;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return LISHelper(-1, 0, nums);
    }

    public int LISHelper(int prev, int curr, int[] nums) {

        if (curr == nums.length) {
            return 0;
        }

        if (dp[prev + 1][curr] != -1) {
            return dp[prev + 1][curr];
        }

        int op1 = 0;
        if (prev == -1 || nums[prev] < nums[curr]) {
            op1 = 1 + LISHelper(curr, curr + 1, nums);
        }

        int op2 = LISHelper(prev, curr + 1, nums);

        return dp[prev + 1][curr] = Math.max(op1, op2);
    }
}