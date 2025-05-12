class Solution {
    private double gain(int passed, int total) {
        return (double) (passed + 1) / (total + 1) - (double) passed / total;
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int[] c : classes) {
            int passed = c[0], total = c[1];
            maxHeap.offer(new double[]{gain(passed, total), passed, total});
        }
        while (extraStudents > 0) {
            double[] top = maxHeap.poll(); 
            int passed = (int) top[1];
            int total = (int) top[2];
            passed++;
            total++;
            extraStudents--;
            maxHeap.offer(new double[]{gain(passed, total), passed, total});
        }
        double totalRatio = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] current = maxHeap.poll();
            totalRatio += current[1] / current[2];
        }

        return totalRatio / classes.length;
    }
}