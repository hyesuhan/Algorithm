class Solution {
    
    public String solution(String new_id) {
        
        String Id1 = level1(new_id);
        String Id2 = level2(Id1);
        String Id3 = level3(Id2);
        String Id4 = level4(Id3);
        String Id5 = level5(Id4);
        String Id6 = level6(Id5);
        // String newId = level7(6thId);
        
        String answer = level7(Id6);
        return answer;
    }
    
    static String level1(String id) {
        return id.toLowerCase();
    }

    static String level2(String id) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : id.toCharArray()) {
            if ((c >= 'a' && c <= 'z' )|| (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
            sb.append(c);
            }
        }
    return sb.toString();
    }
    
    static String level3(String id) {
        return id.replaceAll("\\.{2,}", ".");
    }

    static String level4(String id) {
        if(id.startsWith(".") && id.length() > 0)
            id = id.substring(1);
        if(id.endsWith(".") && id.length() > 0)
            id=id.substring(0, id.length()-1);
        return id;
    
    }

    static String level5(String id) {
        if(id.isEmpty())
            return "a";
        return id;
    }

    static String level6(String id) {
        if(id.length() > 15)
            id = id.substring(0, 15);
       return level4(id);
    }

    static String level7(String id) {
        while(id.length() < 3)
            id += id.substring(id.length() -1);
        return id;
    }
}

