/* 정규표현식 에 사용하는 각종 표현식들
 * 	정규표현식		설명
 * 	^			문자열 시작
 * 	$			문자열 종료
 * 	.			임의의 문자 [단 ‘'는 넣을 수 없습니다.]
 * 	*			앞 문자가 0개 이상의 개수가 존재할 수 있습니다.
 * 	+			앞 문자가 1개 이상의 개수가 존재할 수 있습니다.
 * 	?			앞 문자가 없거나 하나 있을 수 있습니다.
 * []			문자의 집합이나 범위를 표현합니다. -기호를 통해 범위를 나타낼 수 있습니다. ^가 존재하면 not을 나타냅니다.
 * {}			횟수 또는 범위를 나타냅니다.
 * ()			괄호안의 문자를 하나의 문자로 인식합니다. (그룹)
 * |			패턴을 OR 연산을 수행할 때 사용합니다.
 * \s			공백 문자
 * \S			공백 문자가 아닌 나머지 문자
 * \w			알파벳이나 숫자
 * \W			알파벳이나 숫자를 제외한 문자
 * \d			[0-9] 숫자
 * \D			숫자를 제외한 모든 문자
 * 
 * 
 * 정규표현식에 사용되는 escaped character 들
 *    \.[]{}()<>*+-=!?^$|
 */

// 도우미 메소드
function regExpTest(regex, input){
    console.log("[정규표현식 매칭 테스트]-----------------");
    console.log("정규표현식:", regex);
    console.log("입력문자열:", input);

    let matches = input.matchAll(regex);  // 매칭 수행

    let matchCount = 0;
    for(let match of matches){
        matchCount++;
        console.log(`    매치${matchCount}: ${match[0]} {${match.index}~${match.index + match[0].length}}`);
        // 그룹이 있다면 그룹도 출력        
        if(match.length > 1){
            let start = match.index;
            for(let i = 1; i < match.length; i++){
                if(match[i]){  // group 결과가 undefine 가 아닌 경우
                    console.log(`\t group(${i}): ${match[i]} {${start}~${start + match[i].length}}`);
                    start += match[i].length;
                }
            }
        }
    }
    
    (matchCount == 0) && console.log(" X매치 없슴X");
    
    console.log();
}

function test(regex, arrInput){
    for(input of arrInput) regExpTest(regex, input);
}

//--------------------------------------------------
let title, regex, arrInput;

{
    //─────────────────────────────────────────
    title = "^ : 바로 문자뒤의 문자열로 시작됨";
    regex = ""; 
    arrInput = [
        
    ];

    //─────────────────────────────────────────
    // title = "$ : 문자열의 마지막이 이 문자열로 마무리 됨";
    // regex = ""; 
    // arrInput = [
    // ];

    //─────────────────────────────────────────
    // title = "^표현식$ : 정확하게 전체패턴매칭되는 문자열";
    // regex = "";
    // arrInput = [
    // ];

    //─────────────────────────────────────────
    // title = " . : 어떤 문자든지 임의의 '한문자'를 말한다.꼭 하나의 문자와 매칭";
    // regex = ""; 
    // arrInput = [
    // ];

    //─────────────────────────────────────────
    // title = " * : 바로 앞의 문자가 없거나 한개 이상의 경우를 매칭";
    // regex = "";
    // arrInput = [
    // ];

    //─────────────────────────────────────────
    // title = " + : 바로 앞의 문자를 나타내면 꼭 한개 혹은 그 이상을 매칭";
    // regex = "";
    // arrInput = [
    // ];

    //─────────────────────────────────────────
    // title = " ? : 바로 앞의 문자가 한개 있거나 없는것을 매칭";
    // regex = "";
    // arrInput = [
    // ];

    //─────────────────────────────────────────
    // title = " [] : 안에 존재하는 문자들중 한 문자만을 매칭";
    // regex = "";
    // arrInput = [
    // ];

    //─────────────────────────────────────────
    // title = " {} : 앞에 있는 문자나 문자열의 등장개수를 정함";
    // regex = "";
    // arrInput = [
    // ];

    //─────────────────────────────────────────
    // title = " () : ()안에 있는 글자들을 그룹화 ";
    // regex = "";
    // arrInput = [
    // ];

    //─────────────────────────────────────────
    // title = " | : OR 연산자  역할";
    // regex = "";
    // arrInput = [
    // ];		

    //─────────────────────────────────────────
    // title = "i옵션 : 대소문자 구분안하고 매칭 ";  // 타 언어 정규표현식과 다름
    // regex = "";
    // arrInput = [
    // ];

    //─────────────────────────────────────────
    // title = "\\s : 공백,  \\S : 공백아닌 문자";   // 공백 : 띄어쓰기, \n, \t, \r ... 
    // regex = "";
    // arrInput = [
    // ];

    //─────────────────────────────────────────
    // title = "\\w : 알파벳이나 숫자, \\W 알파벳이나 숫자를 제외한 문자";
    // regex = "";
    // arrInput = [
    // ];

    //─────────────────────────────────────────
    // title = "\\d : [0-9] 숫자, \\D 숫자를 제외한 모든 문자";
    // regex = "";
    // arrInput = [
    // ];

    //─────────────────────────────────────────
    // title = "escaped character 매칭 시키기";
    // regex = "";
    // arrInput = [
    // ];

}


//*****************************************
// 패턴매칭 수행
console.log(title);
test(regex, arrInput);

console.log("\n[프로그램 종료]", '\n'.repeat(10));


