### 문제 정의

---

문자열 s를 integer 로 만들어야 한다.

1. 공백은 무시한다.
2. `-` 또는 `+` 이면 부호를 결정하고 없다면 양수로 취급한다.
3. 숫자가 아닌 문자가 나오면 stop
4. 처음부터 끝까지 0이면 이를 건너뛴다. 만약 끝까지 숫자가 없으면 결과는 `0` 이다.
5. 만약 32bit 범위를 넘어가게 되면, 반올림해 최대 정수로 취급한다.

```java
class Solution {
	public int myAtoi(String s) {
	
		StringBuilder sb = new StringBuilder();
		char[] numArray = {'0', '1', '2', '3', '4', '5','6','7','8','9'};
		String numString = String.valueOf(numArray);
		int index = 0;
		
		// 1. 공백은 무시한다.
		s.replace(" ", "");
		
		// 2. 맨 앞에 부호가 있다면 결정하고 아니라면 양수이다.
		if(s.charAt(0) == '-') {
			sb.append("-");
			index++;
		}
		
		// 3. 이제부터는 계속 돌 것이다. 
		// 3-1. 정수를 만나면 sb에 append 를 하고
		// 3-2. 만약 문자를 만나면 정지한다.
		while (index < s.length()) {
			char currentChar = s.charAt(index);
			if (numString.contains() {
				sb.append(currentChar);
				index++;
			} else break;
		}
		
		String result = sb.toString;
		
		// 4. 만약 sb가 Integer 사이즈보다 크다면 반올림 해야 한다.
		try {
			int result = Integer.parseInt(sb.toString());
			return result
		} catch (NumberFormtException e) {
			if (s.isEmpty()) retur 0;
			
			if (s.charAt(0) == '-') return Integer.MIN_VALUE;
			else return Integer.MAX_VALUE;
		}
		
	}
}
```

### Java 문자열 공백 제거 방법

일반적인 상황에서도 쓰고 싶기에 `Replace` 를 사용하려 한다.

이는 문자열 중 첫 번째 인자를 두 번째 인자로 대체한다.

이에 따라 문자열에서 공백을 제거하고 싶다면, 다음을 하면 된다.

`s.replace(" ", "")`

근데 이걸 까먹고 있었다. String 은 **불변 객체** 이다.

그렇기 때문에 만약 `s.replace(" ", "")` 를 하게 된다면, 새로운 문자열에 할당을 해 주던가 아니면

`trim()` 을 통해서 다시 할당해야 한다.

~~그리고 맨 앞의 공백 `" "` 만 무시해야 하는 거구나..~~

### Java `Switch - Case` 문

구현할 때 최근 종종 쓸 일이 있어서 정리하려 한다.

```java
switch(val) {
	case A:
		실행문;
		break;
	case B:
		실행문;
		break;
	default;
		실행문;
		break;
}
```

### StringBuilder

간단하게 `append()` 함수로 가변 string을 만들 수 있는 도구

그러나 아직 String은 아니기 때문에 print 의 경우 Object 를 출력할 수 있지만, 아직 String이 아니라서 불가능하다.

`Integer.parseInt(s.toString);`

또는

`new Integer(s.toString);` 을 해줘야 String으로 변환 후 integer 이 된다.

### Try - Catch 문

```java
try {
	실행문;
	//만약 여기서 오류가 발생하면 아래에서 catch 해야 한다.
} catch(exception e) {
	// Exception 에 대한 handleing 처리가 이루어진다.
}
```

**관련 예외 정리**

`ArithmeticException` 나눗셈 시 0 으로는 나눌 수 없습니다.

`NumberFormatException` 숫자 타입이 아닐 경우

`IndexOutOfBoundsException` 

그런데 문제는 Overflow는 Exception 처리가 불가능하기에

다음의 선택지가 있을 수 있겠다.

```java
int a = Integer.MAX_VALUE;
int b = 1;

try {
	int sum = Math.addExact(a, b);
}
catch (ArithmeticException e) {
	System.out.println("Overflow occured");
}
```

몰랐는데, NumberFormatException 도 사실 범위를 초과할 경우에도 예외를 잡기 때문에 (즉, 더 이상 숫자가 아니기에) 

이를 통해 제어가 가능할 것 같다.

<img width="433" height="455" alt="image" src="https://github.com/user-attachments/assets/3baba982-a3e5-45aa-806c-091d47f2cb72" />
