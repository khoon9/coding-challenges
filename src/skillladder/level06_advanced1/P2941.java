package skillladder.level06_advanced1;

/**
 * 문제
 * 예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
 *
 * 크로아티아 알파벳	변경
 * č	c=
 * ć	c-
 * dž	dz=
 * đ	d-
 * lj	lj
 * nj	nj
 * š	s=
 * ž	z=
 * 예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 *
 * dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.
 *
 * 입력
 * 첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
 *
 * 단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.
 *
 * 출력
 * 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 *
 * 예제 입력 1
 * ljes=njak
 * 예제 출력 1
 * 6
 * 예제 입력 2
 * ddz=z=
 * 예제 출력 2
 * 3
 * 예제 입력 3
 * nljj
 * 예제 출력 3
 * 3
 * 예제 입력 4
 * c=c=
 * 예제 출력 4
 * 2
 * 예제 입력 5
 * dz=ak
 * 예제 출력 5
 * 3
 */

import java.util.*;

public class P2941 {
    // 먼저 확인해야 하는 크로아티아 알파벳 부터 검사
    // 입력받은 문자열을 char[] 형식으로 변환
    // 크로아티아 알파벳이 검출되면 그 즉시 발견된 크로아티아 알파벳 길이만큼 건너뛰고, 알파벳 개수 +1 기록
    // 발견되지 않으면 알파벳 개수 +1 기록 후 다음 알파벳으로 넘어가기
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);

        String threeCharString = "dz=";
        String[] twoCharStrings = {"c=","c-","d-","lj","nj","s=","z="};
        char[] targetChars = scanner.nextLine().toCharArray();
        int i=0;
        int targetCnt = 0;
        while (i<targetChars.length){
            if (i+2<targetChars.length){
                if (threeCharString.equals(String.valueOf(targetChars[i])+String.valueOf(targetChars[i+1])+String.valueOf(targetChars[i+2]))){
                    i += 3;
                    targetCnt++;
                    continue;
                }
            }
            boolean continueNext = false;
            if (i+1<targetChars.length) {
                for (String twoCharString : twoCharStrings) {
                    if (twoCharString.equals(String.valueOf(targetChars[i]) + String.valueOf(targetChars[i + 1]))) {
                        i += 2;
                        targetCnt++;
                        continueNext = true;
                        break;
                    }
                }
                if (continueNext) {
                    continue;
                }
            }
            i++;
            targetCnt++;
        }
        System.out.println(targetCnt);
    }
}
