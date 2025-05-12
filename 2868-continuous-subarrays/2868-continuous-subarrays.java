class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        int start = 0;
        for (int end = 0; end < n; end++) {
            freqMap.put(nums[end], freqMap.getOrDefault(nums[end], 0) + 1);
            while (freqMap.lastKey() - freqMap.firstKey() > 2) {
                freqMap.put(nums[start], freqMap.get(nums[start]) - 1);
                if (freqMap.get(nums[start]) == 0) {
                    freqMap.remove(nums[start]);
                }
                start++;
            }
            ans += (end - start + 1);
        }
        return ans;
    }
}