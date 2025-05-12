class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        List<int[]> indexedNums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indexedNums.add(new int[]{nums[i], i});
        }
        indexedNums.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); 
            }
            return Integer.compare(a[1], b[1]); 
        });

        boolean[] marked = new boolean[n]; 
        long score = 0;
        for (int[] pair : indexedNums) {
            int value = pair[0];
            int idx = pair[1];
            if (!marked[idx]) {
                score += value;
                marked[idx] = true; 
                if (idx > 0) marked[idx - 1] = true;
                if (idx < n - 1) marked[idx + 1] = true;
            }
        }

        return score;
    }
}