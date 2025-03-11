package skillladder.level14_sets_maps;

/**
 *문제
 * 문자열 S가 주어졌을 때, S의 서로 다른 부분 문자열의 개수를 구하는 프로그램을 작성하시오.
 *
 * 부분 문자열은 S에서 연속된 일부분을 말하며, 길이가 1보다 크거나 같아야 한다.
 *
 * 예를 들어, ababc의 부분 문자열은 a, b, a, b, c, ab, ba, ab, bc, aba, bab, abc, abab, babc, ababc가 있고, 서로 다른것의 개수는 12개이다.
 *
 * 입력
 * 첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000 이하이다.
 *
 * 출력
 * 첫째 줄에 S의 서로 다른 부분 문자열의 개수를 출력한다.
 *
 * 예제 입력 1
 * ababc
 * 예제 출력 1
 * 12
 */

import java.util.*;
import java.util.stream.*;

public class P11478 {
    // 문자열을 길이를 기준으로 순회하며 쪼갠다
    // 쪼갠 문자열을 Set에 추가한다
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String targetString = scanner.nextLine();
        Set<String> targetSet = new HashSet<>();
        // i는 길이를 의미
        for (int i=1; i<=targetString.length(); i++){
            // j는 쪼개는 문자열의 첫 글자 idx 위치를 의미
            for (int j=0; j+i<=targetString.length(); j++){
                String targetValue = targetString.substring(j,j+i);
                targetSet.add(targetValue);
            }
        }
        sb.append(targetSet.size()+"\n");

        System.out.println(sb);
    }
}
