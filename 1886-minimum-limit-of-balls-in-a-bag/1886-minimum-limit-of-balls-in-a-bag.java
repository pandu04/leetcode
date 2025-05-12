class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1; 
        int right = Arrays.stream(nums).max().getAsInt(); 
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canDivide(nums, maxOperations, mid)) {
                result = mid; 
                right = mid - 1;
            } else {
                left = mid + 1; 
            }
        }

        return result;
    }

    private boolean canDivide(int[] nums, int maxOperations, int penalty) {
        int operations = 0;

        for (int balls : nums) {
            if (balls > penalty) {
                operations += (balls - 1) / penalty;
            }
            if (operations > maxOperations) {
                return false;
            }
        }

        return true;
    }
}