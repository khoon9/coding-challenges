package skillladder.level09_divisors_multiples_primes;

/**
 *문제
 * 어떤 숫자 n이 자신을 제외한 모든 약수들의 합과 같으면, 그 수를 완전수라고 한다.
 *
 * 예를 들어 6은 6 = 1 + 2 + 3 으로 완전수이다.
 *
 * n이 완전수인지 아닌지 판단해주는 프로그램을 작성하라.
 *
 * 입력
 * 입력은 테스트 케이스마다 한 줄 간격으로 n이 주어진다. (2 < n < 100,000)
 *
 * 입력의 마지막엔 -1이 주어진다.
 *
 * 출력
 * 테스트케이스 마다 한줄에 하나씩 출력해야 한다.
 *
 * n이 완전수라면, n을 n이 아닌 약수들의 합으로 나타내어 출력한다(예제 출력 참고).
 *
 * 이때, 약수들은 오름차순으로 나열해야 한다.
 *
 * n이 완전수가 아니라면 n is NOT perfect. 를 출력한다.
 *
 * 예제 입력 1
 * 6
 * 12
 * 28
 * -1
 * 예제 출력 1
 * 6 = 1 + 2 + 3
 * 12 is NOT perfect.
 * 28 = 1 + 2 + 4 + 7 + 14
 */

import java.util.*;
import java.io.*;

public class P9506 {
    // n이 1 ~ 100,000 -> 전수조사 가능
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null){
                int n = Integer.parseInt(line);

                if (n == -1){
                    break;
                }

                int sum = 0;
                List<Integer> targetNumbers = new ArrayList<>();
                for (int i=1; i<n; i++){
                    if ((n%i)==0){
                        sum += i;
                        targetNumbers.add(i);
                    }
                    if (sum > n){
                        break;
                    }
                }

                if (sum == n){
                    StringBuilder sb_temp = new StringBuilder(n+" = ");
                    for (int i=0; i<targetNumbers.size(); i++){
                        sb_temp.append(targetNumbers.get(i));
                        if (i!=(targetNumbers.size()-1)){
                            sb_temp.append(" + ");
                        } else {
                            sb_temp.append("\n");
                        }
                    }
                    sb.append(sb_temp);
                } else if (sum != n){
                    sb.append(n+" is NOT perfect.\n");
                }
            }
            System.out.println(sb);
        } catch (IOException e){
            System.out.println("IOException 발생");
        }
    }
}
