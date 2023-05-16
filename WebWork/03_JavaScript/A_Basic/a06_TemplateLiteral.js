/*
    Template Literal 문법 (ES6 등장)
    ES6 에는 문자열 조합을
    편리하게 할수 있는 방법 제공
        '이전에는 Template String이라 불렸지만
        'ES2015 명세서 부터는 Template Literal 이라 부름
    
    backtick (`) 문자 사용한 문자열 포맷팅
        문자열 안에서 ${변수}
        문자열 안에서 ${값}
        ..

    공식]
        https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Template_literals        

    이와같이 불리기도 한다]
        Template Literals
        Template Strings
        String Templates
        Back-Tics Syntax
*/

let myName;
myName = '아이언맨';
myName = "아이언맨";

console.log('Hello, ' + myName + "!");
console.log(`Hello, ${myName}!`);

// 리터럴 내 줄바꿈 가능
let lyric = `
    동해물과 백두산이
    마르고 닳도록
    하느님이 보우하사
    우리나라만세`;

console.log(lyric);

//---------------------------------------------------
const myObject = {name: "John", age: 40};
console.log(myObject);
console.log('myObject =', myObject);
console.log(`myObject = ${myObject}`); // myObject = [object Object]
console.log('myObject = ' + myObject);
console.log(myObject.toString());

// 문자열 연결연산(+)  => 'myObject = ' + myObject.toString()
// template literal 도 내부적으로 문자열 연결연산(+)  
            // => 'myObject = ' + myObject.toString()


            
console.log("\n[프로그램 종료]", '\n'.repeat(20));





























