import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day_5 {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char [] ch=s.toCharArray();
            Arrays.sort(ch);
            String sorts=new String(ch);
            if(map.containsKey(sorts)==false){
                map.put(sorts,new ArrayList<>());
            }
            map.get(sorts).add(s);
        }
        list.addAll(map.values());
        return list;
    }

    public int compress(char[] chars) {
        int ind=0;
        int s=0;
        while(s<chars.length){
            int e=s;
            while(e<chars.length && chars[s]==chars[e]){
                e++;
            }
            int c=e-s;
            chars[ind++]=chars[s];
            if(c>=2){
                char[] freq=Integer.toString(c).toCharArray();
                for(char ch:freq){
                    chars[ind++]=ch;
                }
            } 
            s=e;
        }
        return ind;
    }

    
    class Solution {
    int max=0,st=0,e=0;
    public String longestPalindrome(String s) {
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(ispalindrom(s,i,j)==true){
                    if((j-i+1)>max){
                        max=j-i+1;
                        st=i;
                        e=j;
                    }
                }
            }
        }
        return s.substring(st,e+1);
    }

    public boolean ispalindrom(String s,int i,int j){
        while(i<j){
            char ch1=s.charAt(i);
            char ch2=s.charAt(j);
            if(ch1!=ch2){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
}
