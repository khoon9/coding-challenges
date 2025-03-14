package skillladder.level15_divisors_multiples_primes2;

/**
 * 문제
 * 베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
 *
 * 이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.
 *
 * 예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)
 *
 * 자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하는 한 줄로 이루어져 있다.
 *
 * 입력의 마지막에는 0이 주어진다.
 *
 * 출력
 * 각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.
 *
 * 제한
 * 1 ≤ n ≤ 123,456
 * 예제 입력 1
 * 1
 * 10
 * 13
 * 100
 * 1000
 * 10000
 * 100000
 * 0
 * 예제 출력 1
 * 1
 * 4
 * 3
 * 21
 * 135
 * 1033
 * 8392
 */

import java.util.*;
import java.io.*;

public class P4948 {
    // n 에 대하여 n 초과, 2n 이하 소수. 적어도 하나 존재 -> 라는 명제에서 출발한 문제
    // 각 n 대하여 이를 증빙하는 소수들의 개수를 출력
    // 0 입력받아 종료
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = br.readLine())!=null){
                int n = Integer.parseInt(line);
                if (n==0){
                    break;
                }
                int nowValue = n+1;
                int targetCnt = 0;
                while (nowValue<=n*2){
                    if (nowValue <= 1){
                        nowValue++;
                        continue;
                    }
                    boolean flag = true;
                    int targetSqrt = (int) Math.sqrt(nowValue);
                    for (int i=2; i<=targetSqrt; i++){
                        if (nowValue%i==0){
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        targetCnt++;
                    }
                    nowValue++;
                }
                sb.append(targetCnt).append("\n");
            }

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
