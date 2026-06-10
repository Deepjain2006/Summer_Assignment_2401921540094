import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day_4 {
    
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        String [] ch=s.split(" ");

        for(String i:ch){
            StringBuilder t=new StringBuilder(i);
            t.reverse();
            sb.append(t);
            sb.append(" ");

        }

        return sb.toString().trim();
    }

    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> str = new Stack<>();

        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            }
            else if (c == '[') {
                num.push(k);
                k = 0;
                str.push("[");
            }
            else if (c != ']') {
                str.push(String.valueOf(c));
            }
            else {
                StringBuilder temp = new StringBuilder();
                while (!str.peek().equals("[")) {
                    temp.insert(0, str.pop());
                }
                str.pop(); // remove '['
                int count = num.pop();
                StringBuilder rep = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    rep.append(temp);
                }
                str.push(rep.toString());
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!str.isEmpty()) {
            ans.insert(0, str.pop());
        }
        return ans.toString();
    }

    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        solve("",0,0,n,list);
        return list;
    }

    public void solve(String curr,int open,int close,int tot,List<String> ans){
        if(curr.length()==2*tot){
            ans.add(curr);
            return;
        }

        if(open<tot){
            solve(curr+"(",open+1,close,tot,ans);
        }

        if(close<open){
            solve(curr+')',open,close+1,tot,ans);
        }
    }
}
