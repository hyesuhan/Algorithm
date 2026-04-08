import java.util.*;

class Solution {
    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isMinus = false;
		
		int index = 0;
		
		// 1. 공백은 무시한다.
		s = s.trim();
        if (s.isEmpty()) return 0;
		
		// 2. 맨 앞에 부호가 있다면 결정하고 아니라면 양수이다.
		if(s.charAt(0) == '-') {
			isMinus = true;
			index++;
		}
        else if (s.charAt(0) == '+') {
            index++;
        }

		
		// 3. 이제부터는 계속 돌 것이다. 
		// 3-1. 정수를 만나면 sb에 append 를 하고
		// 3-2. 만약 문자를 만나면 정지한다.
		while (index < s.length()) {
			char currentChar = s.charAt(index);
			if (Character.isDigit(currentChar)) {
				sb.append(currentChar);
				index++;
			} else break;
		}

        if (sb.length() == 0) return 0;
		
		String result = sb.toString();
		
		// 4. 만약 sb가 Integer 사이즈보다 크다면 반올림 해야 한다.
		try {
            String ansString = (isMinus ? "-" : "") + result;

			return Integer.parseInt(ansString);
		} catch (NumberFormatException e) {
			if (s.isEmpty()) return 0;
			
			if (s.charAt(0) == '-') return Integer.MIN_VALUE;
			else return Integer.MAX_VALUE;
		}
		
	}
    
}
