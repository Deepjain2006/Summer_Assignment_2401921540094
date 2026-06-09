public class Day_3 {

    public int strStr(String haystack, String needle) {
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0; 
        int j = 0; 
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; 
            }
            j++; 
        }
        return i == s.length();
    }

    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        for(int i=n/2;i>=1;i--){
            if(n%i==0){
                String substr=s.substring(0,i);
                StringBuilder newstr=new StringBuilder();
                for(int j=1;j<=n/i;j++){
                    newstr.append(substr);
                }
                if(newstr.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
}
