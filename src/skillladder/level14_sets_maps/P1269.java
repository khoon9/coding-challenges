package skillladder.level14_sets_maps;

/**
 *문제
 * 자연수를 원소로 갖는 공집합이 아닌 두 집합 A와 B가 있다. 이때, 두 집합의 대칭 차집합의 원소의 개수를 출력하는 프로그램을 작성하시오. 두 집합 A와 B가 있을 때, (A-B)와 (B-A)의 합집합을 A와 B의 대칭 차집합이라고 한다.
 *
 * 예를 들어, A = { 1, 2, 4 } 이고, B = { 2, 3, 4, 5, 6 } 라고 할 때,  A-B = { 1 } 이고, B-A = { 3, 5, 6 } 이므로, 대칭 차집합의 원소의 개수는 1 + 3 = 4개이다.
 *
 * 입력
 * 첫째 줄에 집합 A의 원소의 개수와 집합 B의 원소의 개수가 빈 칸을 사이에 두고 주어진다. 둘째 줄에는 집합 A의 모든 원소가, 셋째 줄에는 집합 B의 모든 원소가 빈 칸을 사이에 두고 각각 주어진다. 각 집합의 원소의 개수는 200,000을 넘지 않으며, 모든 원소의 값은 100,000,000을 넘지 않는다.
 *
 * 출력
 * 첫째 줄에 대칭 차집합의 원소의 개수를 출력한다.
 *
 * 예제 입력 1
 * 3 5
 * 1 2 4
 * 2 3 4 5 6
 * 예제 출력 1
 * 4
 */

import java.util.*;
import java.util.stream.*;
import java.io.*;

public class P1269 {
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int aNum = Integer.parseInt(st1.nextToken());
            int bNum = Integer.parseInt(st1.nextToken());
            Set<Integer> A = new HashSet<>();
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i=0; i<aNum; i++){
                A.add(Integer.parseInt(st2.nextToken()));
            }
            Set<Integer> B = new HashSet<>();
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for (int i=0; i<bNum; i++){
                B.add(Integer.parseInt(st3.nextToken()));
            }
            Set<Integer> targetSet = A.stream().collect(Collectors.toSet());
            targetSet.removeAll(B);
            B.removeAll(A);
            targetSet.addAll(B);
            sb.append(targetSet.size()+"\n");

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
