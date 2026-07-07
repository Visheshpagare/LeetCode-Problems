class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
           set.add(num);
        }
        int ans = 0;
        for(int num: set){
            if(!set.contains(num-1)){
                int len = 1;
              int current = num;
             while (current != Integer.MAX_VALUE &&
                       set.contains(current + 1)) {
                    current++;
                    len++;
                }
                ans = Math.max(ans , len);
        }
    }
        return ans;
   }
}