class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals , new Comparator<>(){
            public int compare(int i1[] , int i2[]){
                return Integer.compare(i1[1] , i2[1]);
            }
        });
        int end = intervals[0][1];
        int ans = 0;
        for(int i =1; i<intervals.length; i++){
            // int arr[] = intervals[i];
            if(intervals[i][0] <end){
                ans++;
            } else {
                end = intervals[i][1];
            }
        }
        return ans;
    }
}