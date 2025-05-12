import java.util.*;

public class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int operations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] level = new int[size];

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level[i] = node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            operations += countMinSwaps(level);
        }

        return operations;
    }

    private int countMinSwaps(int[] arr) {
        int n = arr.length;
        int swaps = 0;

        int[][] indexed = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexed[i][0] = arr[i];
            indexed[i][1] = i;
        }

        Arrays.sort(indexed, Comparator.comparingInt(a -> a[0]));
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] || indexed[i][1] == i) continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = indexed[j][1];
                cycleSize++;
            }

            if (cycleSize > 1) swaps += (cycleSize - 1);
        }

        return swaps;
    }
}
