class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        int count = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 0) ? -1 : 1;

            if (countMap.containsKey(count)) {
                maxLen = Math.max(maxLen, i - countMap.get(count));
            } else {
                countMap.put(count, i);
            }
        }

        return maxLen;
    }
}
