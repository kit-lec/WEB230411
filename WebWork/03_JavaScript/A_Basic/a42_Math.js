/*
    JavaScript 의 Math object

    수학연산 관련 기본적인 상수나 함수 제공
    https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Math
*/
let arr, result;
/**************
 * 상수들
 * Math 의 property 로 제공
 */
 console.log('Math 의 상수 property 들');
 arr = [
    Math.E,   // Euler's number
    Math.PI,  // 원주율
    Math.SQRT2,  // root 2
    Math.SQRT1_2,  // root 1/2
    Math.LN2,   // natural logarithm of 2
    Math.LN10,  // natural logarithm of 10
    Math.LOG2E, // base 2 logarithm of E
    Math.LOG10E, // base 10 logarithm of E
 ]
 arr.forEach(n => console.log(n));


/************************
 * number 에서 integer 로 변환(혹은 추출) 하는 Math 메소드들
 * Math.round(x)	반올림
 * Math.floor(x)	x 보다 작은 수 중에 가장 큰 정수
 * Math.ceil(x)	    x 보다 큰 수 중에 가장 작은 정수
 * Math.trunc(x)	x 의 소숫점 이하 잘라낸 정수
 */
console.log('-'.repeat(20));
console.log('round() floor() ceil() trunc()');

arr = [1.2, 1.7, -1.2, -1.7];
console.log('arr: ', arr);
 

// [1, 2, -1, -2]
// result = [];
// arr.forEach(n => result.push(Math.round(n)));
result = arr.map(n => Math.round(n));
console.log('round():', result);
    
console.log('floor():', arr.map(n => Math.floor(n)));
console.log('ceil():', arr.map(n => Math.ceil(n)));
console.log('trunc():', arr.map(n => Math.trunc(n)));


/**********************************
 * pow(), sqrt(), abs()
 */
// console.log('-'.repeat(20))
// console.log('[pow(), sqrt(), abs()]');

// arr = [

// ];
// arr.forEach(n => console.log(n));



/**********************************
 * 삼각함수 sin(), cos(), tan()
 * 매개변수는 radian 값이다 
 */
// console.log('-'.repeat(20))
// console.log('삼각함수');

// arr = [

// ];
// arr.forEach(n => console.log(n));

/********************************
 * min(), max()
 */
// console.log('-'.repeat(20));
// console.log('min() max()');

// TODO

/*******************************
 * random()
 * 0 <= x  < 1  사이의 난수(실수 number) 리턴
 */
// console.log('-'.repeat(20));
// console.log('random()');

// TODO


/************************
 * log(), log2(), log10()
 * natural logarithm 
 */
// console.log('-'.repeat(20))
// console.log('자연로그함수');

// arr = [
    
// ];
// arr.forEach(n => console.log(n));


 console.log("\n[프로그램 종료]", '\n'.repeat(20));
 
 






















 