/* 배열Array 의 메소드

    indexOf(v)  특정 항목(v)이 어디에 있는지 알아내기 (ES5)

    가령. 찾고자 하는 대상이 특정 조건의 object 이면.  어떻게 찾나?
    주어진 판별 함수를 매개변수로 주면
      findIndex(판별함수)  배열 인덱스를 리턴 (ES6)   
      find(판별함수) : 배열 원소 자체를 리턴  (ES6)

    indexOf(), findIndex(), find() 는 
        가장 '첫번째'로 찾은 것으로 리턴한다.

    Array.findIndex : https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/findIndex
    Array.find : https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/find
*/

//-----------------------------------------------
// indexOf(v)
let superheroes = ["아이언맨", "캡틴", "토르", "헐크"]
let index 

// TODO

//----------------------------------------------
// findIndex(함수)

let todos = [
    {
      id: 1,
      text: "자바스크립트 입문",
      done: true
    },
    {
      id: 2,
      text: "함수 배우기",
      done: true
    },
    {
      id: 3,
      text: "객체와 배열 배우기",
      done: true
    },
    {
      id: 4,
      text: "배열 내장함수 배우기",
      done: false
    }
  ];

// TODO

//---------------------
// find(판별함수) : 배열 원소 자체(값)를 리턴

// TODO

console.log("\n[프로그램 종료]", '\n'.repeat(20));

