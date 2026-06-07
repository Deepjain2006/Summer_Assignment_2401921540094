package week2;

import java.util.Arrays;
import java.util.HashMap;

public class Day_1 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    public int firstUniqChar(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for (char ch : s.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        for(int i=0;i<s.length();i++){
            if(hm.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
       HashMap<Character,Integer> hm=new HashMap<>();
       for(char ch: magazine.toCharArray()){
        hm.put(ch,hm.getOrDefault(ch,0)+1);
       }

       for(char c:ransomNote.toCharArray()){
        if(!hm.containsKey(c) || hm.get(c)<=0){
            return false;
        }
        hm.put(c,hm.get(c)-1);
       }
       return true;
    }
}
