/*
    변수 (variable)
        값을 담는 공간.  변수이름(variable name)을 부여해서 관리    

 	변수는 사용하기 전에 먼저 '선언(declaration)' 해야 한다
	
     변수 선언 구문 방법 4가지:
		● let 변수이름    ← let 으로 선언된 변수는 값 변경 가능
        ● const 변수이름  ← const 로 선언된 변수는 값 변경 불가. 이는 상수(constant) 라 한다. 반드시 선언시 초기화 해야 한다
        ● var 변수이름    ← var 키워드는 오늘날 JS 에서는 가급적 사용하지 않음.  값 변경 가능
        ● 걍 변수이름..

    변수에 값을 대입 (assign)
         =  대입연산자 (assignment operator) 사용

	변수의 초기화 (initialization)
		변수에 최초로 값(value) 을 대입 (assignment) 하는 것.

    타입 확인
        모든 값이나 변수는 타입(type) 과 값(value) 을 갖고 있다.
        typeof 연산자를 통해 타입 확인 가능.

    변수 이름
        변수 이름은 고유한 식별자 (identifier)로 작명해야 한다
        - 문자, 숫자, _, $ 사용 가능
        - 숫자로 시작하면 안된다
        - 대소문자 구분한다  (case sensitive)
        - 예약어 (reserved word), 키워드는 변수명으로 사용 불가

    
    가급적 코드에서 사용하는 모든 변수들은 코드의 상단에서 선언해두자.
*/     

let num1;
num1 = 20;
console.log('num1 =', num1);

num1 = 30 * 2;
console.log('num1 =', num1);

let num2;  // 한번도 대입하지 않은 변수는 undefined 값을 가진다.
console.log('num2 =', num2);

// 타입 -----------------------------------------------------
// typeof 연산자
console.log('-'.repeat(20))
console.log(typeof 10);  // 10 은 number 타입
console.log(typeof "10");  // "10" 은 string 타입
console.log(typeof(10), typeof("10"));  // 마치 함수처럼 사용 가능

// value 와 type
console.log('num1 =>', num1, typeof(num1));
console.log('num2 =>', num2, typeof(num2));

// 상수
const PI = 3.14;
console.log('PI =', PI);
// PI = 123;  // 에러

// let num1;   // 중복 선언 불가

//--------------------
// var 는 중복 선언 가능
var k = 10;
console.log('k =', k);
var k = 20;
console.log('k =', k);

// 두 변수의 값 바꾸기
console.log('-'.repeat(20))
console.log('[두 변수 값 바꾸기]')
num3 = 100;
num4 = 200;
let temp;	

console.log("바꾸기 전 num3=", num3, "num4=", num4);
temp = num3;
num3 = num4;
num4 = temp;
console.log("바꾼후 num3=", num3, "num4=", num4);

// ES6 부터 등장한 비구조화 할당 구문을 사용하여 
// 아래와 같이 편리하게 두개 변수값 서로 교환 가능
[num3, num4] = [num4, num3];
console.log("바꾼후 num3=", num3, "num4=", num4);


console.log("\n[프로그램 종료]", '\n'.repeat(20));


























