/*
    앞글자만 대문자로 만들기

입력예]
i am a PROGRAMMER

출력예]
I Am A Programmer

*/

const letterCapitalize = function(text) {
    text = text.trim().toLowerCase(); // 일단 죄다 소문자로.
    const arr = text.split(/\s+/); // 공백으로 단어 쪼개기

    let result = []; // 단어들을 담을 배열 준비.
    for(let i = 0; i < arr.length; i++){  // 각 단어별로 순환.
        let first = arr[i].charAt(0).toUpperCase(); // 첫글자 분리 + 대문자로
        let rest = arr[i].slice(1);  // 두번째 글자부터 끝까지
        result.push(first + rest); // 단어 다시 합친뒤 배열에 넣기
    }

   return result.join(" ");   // 배열에 담긴 단어들로 문장 조립
};

let value = "i am a PROGRAMMER";
console.log(letterCapitalize(value));