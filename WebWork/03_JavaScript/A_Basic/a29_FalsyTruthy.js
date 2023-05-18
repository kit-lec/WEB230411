/*
    조건문 : Conditional Statements 에서

    거짓(Falsy) 으로 평가될때!
        false, 0, '', null, undefined, NaN   <-- 'Falsy 한 값'이라 한다

    참(Truthy) 으로 평가될때
        true, 37, 'Mark', {}, [], Infinity   <-- 'Truthy 한 값' 이라 한다

    https://developer.mozilla.org/ko/docs/Glossary/Truthy
    https://developer.mozilla.org/ko/docs/Glossary/Falsy

*/
function print(data){
    if(data) 
        console.log(data, '-- Truthy 판정');
    else
        console.log(data, '-- Falsy 판정');
}

print(true);
print(false);
print(10 > 20);

// Falsy 
print(0);
print(0.0);
print('');
print(null);
print(undefined);
print(NaN);

console.log(!0);   // true
console.log(!"이진수");

// truthy
print(true);
print(37);
print(-37);
print('Mark');
print(' ');
print({a: 10, b: 20});
print([10, 20, 30]);
print({});
print([]);

console.log("\n[프로그램 종료]", '\n'.repeat(20));





































