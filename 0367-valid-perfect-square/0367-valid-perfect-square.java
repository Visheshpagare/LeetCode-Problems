class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;

        while((long) i*i <= num){
            if(i*i == num){
                return true;
            }
            i++;
        }
        return false;
    }
}