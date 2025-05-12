class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<TreeNode> currentLevelNodes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevelNodes.add(node);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (level % 2 == 1) {
                int left = 0, right = currentLevelNodes.size() - 1;
                while (left < right) {
                    int temp = currentLevelNodes.get(left).val;
                    currentLevelNodes.get(left).val = currentLevelNodes.get(right).val;
                    currentLevelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }
            level++;
        }

        return root;
    }
}