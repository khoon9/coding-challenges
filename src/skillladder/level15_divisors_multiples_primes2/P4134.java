package skillladder.level15_divisors_multiples_primes2;

/**
 *문제
 * 정수 n(0 ≤ n ≤ 4*109)가 주어졌을 때, n보다 크거나 같은 소수 중 가장 작은 소수 찾는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다.
 *
 * 출력
 * 각각의 테스트 케이스에 대해서 n보다 크거나 같은 소수 중 가장 작은 소수를 한 줄에 하나씩 출력한다.
 *
 * 예제 입력 1
 * 3
 * 6
 * 20
 * 100
 * 예제 출력 1
 * 7
 * 23
 * 101
 */

import java.util.*;
import java.io.*;

public class P4134 {
    // 주어진 숫자 별로 그 이상의 값에 대한 소수 구하기
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int T = Integer.parseInt(br.readLine());
            List<Long> targetList = new ArrayList<>();
            for (int i=0; i<T; i++){
                targetList.add(Long.parseLong(br.readLine()));
            }
            for (int i=0; i<T; i++){
                boolean flag1 = true;
                long targetValue = targetList.get(i);
                long targetPrime = -1;
                if (targetValue <= 1){
                    targetValue = 2;
                }
                while (flag1){
                    boolean flag2 = true;
                    long sqrtValue = (long) Math.sqrt(targetValue);
                    for (long j=2l; j<=sqrtValue; j++){
                        if (targetValue%j==0){
                            flag2 = false;
                            break;
                        }
                    }
                    if (flag2){
                        targetPrime = targetValue;
                        flag1 = false;
                    } else {
                        targetValue++;
                    }
                }
                sb.append(targetPrime).append("\n")   ;
            }

            System.out.println(sb);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
