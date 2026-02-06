import java.util.*;

class Solution {
    
    public int solution(String s) {
        
        if(s.length() == 1) return 1;
        
        List<ParseStr> lists = new ArrayList<>();

        
        for (int i = 1; i <= s.length()/2; i++) {
            String result = parser(s, i);
            
            lists.add(new ParseStr(i, result));
        }
        
        ParseStr min = lists.get(0);
        
        for(ParseStr list: lists) {
            if(list.parseLength < min.parseLength) {
                min = list;
            }
        }
        
        
        int answer = min.parseLength;
        return answer;
    }
    
    
    
    public String parser(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        int curIdx = 0;
        
        while(curIdx  < s.length()) {
            
            if(curIdx+n > s.length()) {
                sb.append(s.substring(curIdx));
                break;
            }
            
            String start = s.substring(curIdx, curIdx + n);
            curIdx += n;
            int cntSame = 1;
            
            while(curIdx +n <= s.length()) {
                if(s.substring(curIdx, curIdx+n).equals(start)) {
                    cntSame++;
                    curIdx+=n;
                } else {
                    break;
                }
            }
            
            if(cntSame > 1) {
                sb.append(cntSame).append(start);
            } else {
                sb.append(start);
            }

        }
        return sb.toString();
    }
}

class ParseStr {
        int parseSize;
        String parseStr;
        int parseLength;
        
        ParseStr (int p, String s) {
            this.parseSize = p;
            this.parseStr = s;
            this.parseLength = s.length();
        }  
    }



