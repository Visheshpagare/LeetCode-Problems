class Solution {
    public String minWindow(String s, String t) {
        int freq[] = new int[128];

        for(int i =0; i<t.length(); i++){
            freq[t.charAt(i)]++;
        }  

        int left = 0;
        int need = t.length();
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for(int rigth = 0; rigth < s.length(); rigth++){
            char ch = s.charAt(rigth);

            if(freq[ch] > 0){
                need--;
            }
            freq[ch]--;

            while(need == 0){
                if(rigth - left + 1 < minLen){
                    minLen = rigth - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                freq[leftChar]++;

                if(freq[leftChar]> 0){
                    need++;
                }
                left++;
            }
        }
        if(minLen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start , start + minLen); 
    }
}