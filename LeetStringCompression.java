import java.util.*;
class LeetStringCompression {
    public String compressedString(String word) {
        if(word == null || word.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char current = word.charAt(0);
        int count = 1;
        for(int i=1;i<word.length();i++){
            if(current == word.charAt(i)){
                count++;
            }else{
                while(count > 9){
                    sb.append(9).append(current);
                    count -= 9;
                }
                sb.append(count).append(current);
                current = word.charAt(i);
                count = 1;
            }
        }
        while(count > 9){
            sb.append(9).append(current);
            count -= 9;
        }
        sb.append(count).append(current);
        return sb.toString();
    }
}