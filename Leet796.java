import java.util.*;
public class Leet796 {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            rotate(sb, goal);
            String check = sb.toString();
            if(check.equals(goal)){
                return true;
            }
        }
        return false;
    }
    public StringBuilder rotate(StringBuilder sb, String goal){
        char ch = sb.charAt(0);
        for(int i=1;i<sb.length();i++){
            sb.setCharAt(i-1,sb.charAt(i));
        }
        sb.setCharAt(sb.length()-1,ch);
        // System.out.print(sb+" ");
        return sb;
    }
}