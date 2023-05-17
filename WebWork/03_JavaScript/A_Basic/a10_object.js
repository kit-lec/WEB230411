/*
    object

    property : value 쌍으로 구성된 데이터

    {property:value, property:value, ...}

    property 는 중복될수 없다.
    value 는 어떠한 타입도 될수 있다.
        : number, string, array, function, object..

    사실 JavaScript 의 모든 데이터의 실체는 object 이다.
    
    ※일반적으로  object 변수는 는 const 로 선언한다
    그러나 이번단원에서 진도 편의상 let 등을 사용하기도 하겠습니다
 */

let obj1, obj2, obj3, result;

const car = {type: "Fiat", model: "500", color: "white"};

/* object 의 property 사용하기
    방법1 : objectName.propertyName
    방법2 : objectName["propertyName"] 
*/
console.log('-'.repeat(20));
console.log('[object 의 property]');

const person = {
    firstName: "John",
    lastName: "Doe",
    age: 50,
    eyeColor: "blue",
};

console.log(person);
console.log(person.firstName);
console.log(person["firstName"]);  // <- name 은 문자열로!
// console.log(person[firstName]);  // 에러
console.log(typeof person.firstName);

let a = 'firstName', b = 'age';
console.log(`${person[a]} is ${person[b]} yrs old`);

console.log(person.address);  // undefined

// property 변경 가능
console.log(person);
person.firstName = "Jane";
console.log('변경후', person);

//person = 10;

// person 을 const 로 선언 했는데 property 변경 가능?  
// person 을 바꾸지 못한다는 거지 person 의 property 를 변견 못한다는 게 아니다
// person = {name: 'hello'};   <-- person 값 자체를 변경하려 하면 이게 에러다!

// property 추가
person.email = "Jane@mail.com";
console.log('추가후', person);

// property 삭제
// delete 연산자 사용
delete(person.email);
console.log('삭제후', person);

// property name 은 중복불가
obj1 = {
    score : 100,
    "score" : 200,  // property name 을 문자열로 표기해도 동작
    'score' : 300,
    Score: 400,
};
console.log(obj1);

// value 는 어떠한 타입도 가능
obj2 = {
    name: 'John',
    age: 34,
    height: 172.3,
    married: false,
    score: [100, 97, 33],
    family: {
        spouser: 'Jane',
        children: ['Clark', "Steve", `Charlie`],
    },
};

console.log(obj2);
console.log(obj2.name, typeof obj2.name);
console.log(obj2.married, typeof obj2.married);
console.log(obj2.score, typeof obj2.score);
console.log(obj2.family, typeof obj2.family);
console.log(obj2.family.spouser, typeof obj2.family.spouser);
console.log(obj2.family.children[2], typeof obj2.family.children[2]);


/****************************************************
 *  object method 와 this
 * object 의 value 는 어떠한 타입도 가능하다
 * 즉, 함수도 object 의 property value 로 가능하다
 * object 의 property 함수를 메소드(method) 라 부른다.
 * object 안에서 this 는 '자기자신객체', 즉, 해당 object 가 참조(혹은 바인딩) 된 객체를 말한다
 */
console.log('-'.repeat(20));
console.log('[object method 와 this]');

obj3 = {
    firstName: "John",
    lastName : "Doe",
    id       : 5566,
    
    // 아래에서 this 가 없으면 동작 안함
    // 같은 object 내의 property 사용하려면 this 꼭!
    fullName : function(){
        return `${this.id}] ${this.firstName} ${this.lastName}`;
    },
};

console.log(obj3.fullName());




console.log("\n[프로그램 종료]", '\n'.repeat(20));






























