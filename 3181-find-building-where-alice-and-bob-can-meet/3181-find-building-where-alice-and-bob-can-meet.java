class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int q = queries.length;
        int[] ans = new int[q];
        List<int[]>[] later = new List[n];
        for (int i = 0; i < n; i++) {
            later[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < q; i++) {
            int a = queries[i][0], b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            
            if (a == b || heights[a] < heights[b]) {
                ans[i] = b;
            } else {
                later[b].add(new int[]{a, i});
                ans[i] = -1;
            }
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!map.isEmpty() && map.firstKey() <= heights[i]) {
                map.remove(map.firstKey());
            }
            
            for (int[] query : later[i]) {
                int h = Math.max(heights[i], heights[query[0]]);
                Integer pos = map.ceilingKey(h + 1);
                if (pos != null) {
                    ans[query[1]] = map.get(pos);
                }
            }
            
            map.put(heights[i], i);
        }
        
        return ans;
    }
}