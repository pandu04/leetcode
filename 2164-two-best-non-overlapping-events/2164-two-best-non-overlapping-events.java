class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));
        int n = events.length;
        int[] maxValues = new int[n];
        maxValues[0] = events[0][2];
        for(int i=1; i<n; i++) {
            maxValues[i] = Math.max(maxValues[i - 1], events[i][2]);
        }
        int maxSum = 0;
        for(int i=0; i<n; i++) {
            maxSum = Math.max(maxSum, events[i][2]);
            int lastNonOverlap = findLastNonOverlapping(events, i);
            if(lastNonOverlap != -1) {
                maxSum = Math.max(maxSum, events[i][2] + maxValues[lastNonOverlap]);
            }
        }
        return maxSum;
    }
    private int findLastNonOverlapping(int[][] events, int index) {
        int left = 0, right = index - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(events[mid][1] < events[index][0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}