import java.util.*;
public class Leet2490 {
    public boolean isCircularSentence(String sentence) {
        String[] str = sentence.split(" ");
        if(str.length == 1){
            String a = str[0];
            if(a.charAt(0) != a.charAt(a.length()-1)){
                return false;
            }else{
                return true;
            }
        }
        String first = str[0];
        String last = str[str.length-1];
        if(first.charAt(0) != last.charAt(last.length()-1)){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str[0].charAt(str[0].length()-1));
        for(int i=1;i<str.length;i++){
            String a = str[i];
            if(a.charAt(0) == sb.charAt(sb.length()-1)){
                sb.append(a.charAt(0));
                sb.append(a.charAt(a.length()-1));
            }else{
                return false;
            }
        }
        return true;
    }
}