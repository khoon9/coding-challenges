package skillladder.level15_divisors_multiples_primes2;

/**
 *문제
 * 두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다. 이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다. 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.
 *
 * 두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 둘째 줄부터 T개의 줄에 걸쳐서 A와 B가 주어진다. (1 ≤ A, B ≤ 45,000)
 *
 * 출력
 * 첫째 줄부터 T개의 줄에 A와 B의 최소공배수를 입력받은 순서대로 한 줄에 하나씩 출력한다.
 *
 * 예제 입력 1
 * 3
 * 1 45000
 * 6 10
 * 13 17
 * 예제 출력 1
 * 45000
 * 30
 * 221
 */

import java.util.*;
import java.io.*;

public class P1934 {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int T = Integer.parseInt(br.readLine());
            List<int[]> targetList = new ArrayList<>();
            for (int i=0;i<T; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                targetList.add(
                        new int[]{
                                Integer.parseInt(st.nextToken())
                                ,Integer.parseInt(st.nextToken())
                        }
                );
            }
            for (int[] targetValues: targetList){
                // A < B
                int A = (targetValues[0]<targetValues[1]?targetValues[0]:targetValues[1]);
                int B = (targetValues[0]<targetValues[1]?targetValues[1]:targetValues[0]);
                int C = 1;
                boolean flag = true;
                while (flag && (A!=1)){
                    for(int i=2;i<=A;i++){
                        if ((A%i==0) && (B%i==0)){
                            C = C*i;
                            A = A/i;
                            B = B/i;
                            break;
                        }
                        if (i==A){
                            flag = false;
                        }
                    }
                }
                sb.append(A*B*C+"\n");
            }

            System.out.println(sb);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
