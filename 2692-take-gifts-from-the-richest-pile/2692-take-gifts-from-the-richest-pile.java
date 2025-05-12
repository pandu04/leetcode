import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            maxHeap.add((long) gift);
        }
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) break; 
            long largest = maxHeap.poll();
            long remaining = (long) Math.sqrt(largest);
            if (remaining > 0) {
                maxHeap.add(remaining);
            }
        }
        long totalGifts = 0;
        while (!maxHeap.isEmpty()) {
            totalGifts += maxHeap.poll();
        }

        return totalGifts;
    }
}