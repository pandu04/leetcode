public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freq.keySet());

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char currentChar = maxHeap.poll();
            int count = freq.get(currentChar);
            int addCount = Math.min(count, repeatLimit);
            for (int i = 0; i < addCount; i++) {
                result.append(currentChar);
            }
            count -= addCount;
            if (count > 0) {
                if (maxHeap.isEmpty()) {
                    break;
                }
                char nextChar = maxHeap.poll();
                result.append(nextChar);
                int nextCount = freq.get(nextChar) - 1;
                if (nextCount > 0) {
                    freq.put(nextChar, nextCount);
                    maxHeap.offer(nextChar);
                }
                freq.put(currentChar, count);
                maxHeap.offer(currentChar);
            }
        }

        return result.toString();
    }
}