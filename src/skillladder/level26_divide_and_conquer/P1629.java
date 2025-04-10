package skillladder.level26_divide_and_conquer;

/**
 *문제
 * 자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.
 *
 * 출력
 * 첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.
 *
 * 예제 입력 1
 * 10 11 12
 * 예제 출력 1
 * 4
 */

import java.util.*;
import java.io.*;

public class P1629 {
    // 목표: 거듭제곱의 나머지 값 구하기
    // 유의:
    // 구하기 문제
    // (A^B)%C -> (((A^(B/2))%C)((A^(B/2))%C))%C
    private static Map<Long, Long> cach;
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            long A = Integer.parseInt(st1.nextToken());
            long B = Integer.parseInt(st1.nextToken());
            long C = Integer.parseInt(st1.nextToken());
            cach = new HashMap<>();
            functino1(A, B, C);
            sb.append(cach.get(B));

            System.out.println(sb);
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static long functino1(long a, long b, long c){
        if (cach.containsKey(b)){
            return cach.get(b);
        }
        if (b>1){
            if (b%2==0){
                cach.put(b, (functino1(a, b/2, c)*functino1(a, b/2, c))%c);
                return cach.get(b);
            } else {
                cach.put(b, ((a%c)*((functino1(a, b/2, c)*functino1(a, b/2, c))%c))%c);
                return cach.get(b);
            }
        }
        cach.put(b, ((long) (Math.pow(a,b)))%c);
        return cach.get(b);
    }
}
