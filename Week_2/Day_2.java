 package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day_2 {

    public boolean checkInclusion(String s1, String s2) {
        int[] first= new int[26] ,second=new int[26];
        for(char c:s1.toCharArray()){
            first[c-'a']+=1;
        }
        int window=s1.length()-1;
        for(int i=0;i<s2.length();i++){
            second[s2.charAt(i)-'a']+=1;
            if(i>=window){
                if(match(first,second)) return true;
                second[s2.charAt(i-window)-'a']-=1;
            }
        }
        return false;
    }
    private boolean match(int [] first,int [] second){
        for(int i=0;i<26;i++){
            if(first[i]!=second[i]) return false;
        }
        return true;
    }
    
    public int lengthOfLongestSubstring(String s) {
        int st=0;
        int e=0;
        int maxlen=0;
        List<Character> list=new ArrayList<>();
        while(e<s.length()){
            if(!list.contains(s.charAt(e))){
                list.add(s.charAt(e));
                e++;
                maxlen=Math.max(maxlen,list.size());
            }
            else{
                list.remove(Character.valueOf(s.charAt(st)));
                st++;
            }
        }
        return maxlen;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        int [] pc=new int[26];
        int [] sc=new int[26];

        for(char c:p.toCharArray()){
            pc[c-'a']++;
        }

        for(int i=0;i<s.length();i++){
            sc[s.charAt(i)-'a']++;

            if(i>=p.length()){
                sc[s.charAt(i-p.length())-'a']--;
            }

            if(Arrays.equals(pc,sc)){
                list.add(i-p.length()+1);
            }
        }
        return list;
    }
}