package skillladder.level25_greedy_algorithm;

/**
 *문제
 * 세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
 *
 * 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
 *
 * 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.
 *
 * 출력
 * 첫째 줄에 정답을 출력한다.
 *
 * 예제 입력 1
 * 55-50+40
 * 예제 출력 1
 * -35
 * 예제 입력 2
 * 10+20+30+40
 * 예제 출력 2
 * 100
 * 예제 입력 3
 * 00009-00009
 * 예제 출력 3
 * 0
 */

import java.util.*;
import java.io.*;

public class P1541 {
    // 목표: 괄호 주입으로 연산 결과 최소화한 값 구하기
    // 유의:
    // 연산 과정 최댓값 10^6 -> int 범위 내에 속함
    // 숫자는 0부터 시작 가능, 최대 5자리
    // 연산자는 2개가 연달아 나타나지 않고 +와 -만 존재
    // 맨 처음과 마지막은 숫자
    // ex) 012-3+34-355
    // -> 가장 앞의 '-'를 기준으로 뒷 부분의 + 연산 작업까지 음수로 변환 반복
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            char[] charArr = br.readLine().toCharArray();
            int answer = 0;
            int nowValue = 0;
            int target = 0;
            int nowOperator = 1;
            for (int i=0; i<=charArr.length; i++){
                if (i==charArr.length){
                    nowValue += target;
                    answer += nowOperator*nowValue;
                    break;
                }
                if (charArr[i]>='0' && charArr[i]<='9'){
                    target = target*10+(charArr[i]-'0');
                    continue;
                }
                if (charArr[i]=='+'){
                    nowValue += target;
                    target = 0;
                    continue;
                }
                if (charArr[i]=='-'){
                    nowValue += target;
                    target = 0;
                    answer += nowOperator*nowValue;
                    nowValue = 0;
                    nowOperator = -1;
                    continue;
                }
            }
            sb.append(answer);

            System.out.println(sb);
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
