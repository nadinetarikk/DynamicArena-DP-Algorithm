package csen703.main.assignment2;

public class DynamicArena {
    public static int ClimbDynamicArenaDP(int[] floors) {
        int[] dp = new int[floors.length];
        for (int i = 0; i < dp.length; i++)
            dp[i] = Integer.MIN_VALUE;

        return ClimbDynamicArenaDPHelper(floors, 0, dp);
    }

    public static int ClimbDynamicArenaDPHelper(int[] floors, int i, int[] dp) {
        if (i >= floors.length)
            return 0;

        if (dp[i] != Integer.MIN_VALUE)
            return dp[i];

        int maxAwards = 0;
        for (int j = i + 1; j < floors.length; j++) {

            maxAwards = (floors[j] > floors[i])
                    ? Math.max(maxAwards, floors[j] - floors[i] + ClimbDynamicArenaDPHelper(floors, j + 2, dp))
                    : Math.max(maxAwards, ClimbDynamicArenaDPHelper(floors, i + 1, dp));
        }
        dp[i] = maxAwards;
        return dp[i];
    }
}
