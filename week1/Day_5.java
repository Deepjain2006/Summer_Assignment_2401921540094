public class Day_5 {
    
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if((ch>=97 && ch<=122) || (ch>=48 && ch<=57)){
                sb.append(s.charAt(i));
            }
        }
        for(int i=0;i<sb.length()/2;i++){
            char st = sb.charAt(i);
            char e=sb.charAt(sb.length()-1-i);

            if(st!=e){
                return false;
            }
        }
        return true;
    }

    public void reverseString(char[] s) {
        int start=0;
        int end=s.length-1;

        while(start<end){
            swap(s,start,end);
            start++;
            end--;
        }
    }
    static void swap(char [] s,int x,int y){
        char temp=s[x];
        s[x]=s[y];
        s[y]=temp;
    }

    
    public String longestCommonPrefix(String[] strs) {
        String s="";
        for(int i=0;i<strs[0].length();i++){
            char ch=strs[0].charAt(i);
            boolean b=true;
            for(int j=0;j<strs.length;j++){
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    b = false;
                    break;
                }
            }
            if(b){
                s+=ch;
            }
            else{
                break;
            }
        }
        return s;
    }
}
