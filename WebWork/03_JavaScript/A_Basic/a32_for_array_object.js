/****************************************
 * JS 는 for 가 복잡하게 많다.
 * 
 * 배열, object, string 과 for
 *  for, for~in, for~of, forEach
 */
console.log("[for, for~in, for~of, forEach]");

const points = [40, 100, 1, 5, 25, 10];
const fruits = ["Banana", "Orange", "Apple", "Mango"];
const cars = ["Saab", "Volvo", "BMW"];
let arr1, arr2;

/***********************************
 * for 사용
 * object 의 property 에 대한 접근 횟수를 줄이는게
 * 성능에 유리하다.
 */

let i;
for(i = 0; i < cars.length; i++){
    console.log(cars[i]);
}

let len = cars.length;
for(i = 0; i < len; i++){
    console.log(cars[i]);
}



/*************************************
 * for ( .. in .. ) 
 *   'property(key/인덱스)' 를 반복한다.  
 *    주로 '객체(object)' 에 대해 사용
 */
console.log("-".repeat(20));
console.log('[for(  in  )');

for(x in cars){
    console.log(x, cars[x]);
}


/************************************
 * for (  of   )  
 *   value 에 대해 순환
 *   ES6 에 등장
 *   iterable 한 객체에 사용가능  (아래 추가 설명)
 *   https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Statements/for...of
 */
console.log("-".repeat(20));
console.log('[for(  of  )]');

for(e of fruits){
    console.log(e);
}

/***********************************
 * 배열.forEach(함수)
 *  배열원소를 하나하나 뽑아내면서 함수가호출되어 실행 (이런식으로 되호출되는 함수를 callback 함수라 한다)
 *  이때의 callback 함수
 * 		매개변수는 (value, index, array)
 * 
 * https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach
 */
console.log("-".repeat(20));
console.log('[배열.forEach(함수)]');

function myFunction(value){
    console.log(value);
}
fruits.forEach(myFunction);

console.log('-'.repeat(20));

fruits.forEach(function(value){  // 이름없는 함수
    console.log(value);
});

console.log('-'.repeat(20));

fruits.forEach(e => console.log(e));  // 화살표 함수

fruits.forEach((value, index) => console.log(value, index));

// 주어진 배열의 값을 x 2 한 배열 구하기
console.log('points =', points);
arr1 = [];
points.forEach(e => arr1.push(e * 2));
console.log('x2 =', arr1);

// 도전: 주어진 배열중 짝수만 담긴 배열 구하기
console.log('points =', points);

arr1 = [];
for(e of points){
    if(e % 2 == 0) arr1.push(e);
}
console.log(arr1);

// forEach + 화살표 + SCE
arr1 = [];
points.forEach(e => e % 2 || arr1.push(e));
console.log(arr1);

/********************************
 * for~in 과 object
 *  for(property in object)
 * 
 * 	object 에서 for~of 는 사용 못함
 * 	
 * 	for~of 는 iterable 한 객체에 대해서만 사용 가능.
 */
console.log("-".repeat(20));
console.log('[object 와 for~in]');
 
const person = {
	firstname : "John",
	lastname : "Doe",
	age : 50,
	eyecolor : "blue"
};

for(prop in person){
    console.log(prop, person[prop]);
}

// for .. in 의 단점
for(const i in {a: 1, b: 2, c: 3}){
	console.log(`i =`, i);  // 일단 결과는 잘 나온다  a, b, c
}

// 마치 {a: 1, b: 2, c: 3} 안에 있는 a,b,c 만 나오는 듯하지만

// prototype 에 있는 것도 나올수 있기 때문에
// 의도치 않은 결과를 내뱉을수도 있다.
// (런타임 환경에 따라서 for..in.. 은 다르게 동작할수 있다)

Object.prototype.test = function(){};
console.log();
for(const i in {a: 1, b: 2, c: 3}){
	console.log(`i =`, i);  // 헉? a, b, c, test 까지?!?
}

// 따라서! object 를 순환(iteration) 할 경우
// ↓아래 3가지를 활용하도록 하자


// 위 object 의 key 들만 뽑아내려면?
console.log(Object.keys(person));

// 위 object 의 value 들만 뽑아내려면?
console.log(Object.values(person));


// [key, value] 를 있는 배열 형태
console.log(Object.entries(person));



/****************************************
 * string 
 * 	 for, for~in, for~of, 
 * 
 * 	 string 은 iterable 하기 때문에 for~of 사용 가능
 */
console.log("-".repeat(20));
console.log('[string 과 for]');
const str = "Hello";

for(i = 0; i < str.length; i++){
    console.log(i, str[i]);
}

for(i in str){
    console.log(i, str[i]);
}

for(ch of str){
    console.log(ch);
}

//str.forEach(ch => console.log(ch));  // forEach 는 배열의 메소드다!

str.split("").forEach(ch => console.log(ch));

/***********************************************
 * iterable
 * 
 * JS 에서 배열과 같이 for ~ of 로 순환할수 있는 객체를 iterable 이라 한다.
 * 
 * JS 의 기본 내장 iterable 은 
 *  String, Array, TypedArray, Map, Set
 * 
 * ★DOM 객체에 대해서도 얼마든지 사용 가능.
 *   ex) getElementsByTagName()
 * 
 * 그 밖에도 얼마든지 사용자 정의 iterable 객체 정의 가능
 * 
 * https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Iteration_protocols
 * 
 * (이는 고급 주제이므로 기회가 되면 다루겠습니다)
 */
 console.log("\n[프로그램 종료]", '\n'.repeat(20));








































