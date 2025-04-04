package skillladder.level16_stack_queue_deque;

/**
 *문제
 * 한가롭게 방학에 놀고 있던 도현이는 갑자기 재밌는 자료구조를 생각해냈다. 그 자료구조의 이름은 queuestack이다.
 *
 * queuestack의 구조는 다음과 같다.
 * $1$번,
 * $2$번, ... ,
 * $N$번의 자료구조(queue 혹은 stack)가 나열되어있으며, 각각의 자료구조에는 한 개의 원소가 들어있다.
 *
 * queuestack의 작동은 다음과 같다.
 *
 *
 * $x_0$을 입력받는다.
 *
 * $x_0$을
 * $1$번 자료구조에 삽입한 뒤
 * $1$번 자료구조에서 원소를 pop한다. 그때 pop된 원소를
 * $x_1$이라 한다.
 *
 * $x_1$을
 * $2$번 자료구조에 삽입한 뒤
 * $2$번 자료구조에서 원소를 pop한다. 그때 pop된 원소를
 * $x_2$이라 한다.
 * ...
 *
 * $x_{N-1}$을
 * $N$번 자료구조에 삽입한 뒤
 * $N$번 자료구조에서 원소를 pop한다. 그때 pop된 원소를
 * $x_N$이라 한다.
 *
 * $x_N$을 리턴한다.
 * 도현이는 길이
 * $M$의 수열
 * $C$를 가져와서 수열의 원소를 앞에서부터 차례대로 queuestack에 삽입할 것이다. 이전에 삽입한 결과는 남아 있다. (예제
 * $1$ 참고)
 *
 * queuestack에 넣을 원소들이 주어졌을 때, 해당 원소를 넣은 리턴값을 출력하는 프로그램을 작성해보자.
 *
 * 입력
 * 첫째 줄에 queuestack을 구성하는 자료구조의 개수
 * $N$이 주어진다. (
 * $1 \leq N \leq 100\,000$)
 *
 * 둘째 줄에 길이
 * $N$의 수열
 * $A$가 주어진다.
 * $i$번 자료구조가 큐라면
 * $A_i = 0$, 스택이라면
 * $A_i = 1$이다.
 *
 * 셋째 줄에 길이
 * $N$의 수열
 * $B$가 주어진다.
 * $B_i$는
 * $i$번 자료구조에 들어 있는 원소이다. (
 * $1 \leq B_i \leq 1\,000\,000\,000$)
 *
 * 넷째 줄에 삽입할 수열의 길이
 * $M$이 주어진다. (
 * $1 \leq M \leq 100\,000$)
 *
 * 다섯째 줄에 queuestack에 삽입할 원소를 담고 있는 길이
 * $M$의 수열
 * $C$가 주어진다. (
 * $1 \leq C_i \leq 1\,000\,000\,000$)
 *
 * 입력으로 주어지는 모든 수는 정수이다.
 *
 * 출력
 * 수열
 * $C$의 원소를 차례대로 queuestack에 삽입했을 때의 리턴값을 공백으로 구분하여 출력한다.
 *
 * 예제 입력 1
 * 4
 * 0 1 1 0
 * 1 2 3 4
 * 3
 * 2 4 7
 * 예제 출력 1
 * 4 1 2
 * 각 상태에 대한 큐스택 내부를 표현하면 다음과 같다.
 *
 * 초기 상태 :
 * $[1, 2, 3, 4]$ 
 * 첫 번째 원소 삽입 :
 * $[2, 2, 3, 1]$ 
 * 두 번째 원소 삽입 :
 * $[4, 2, 3, 2]$ 
 * 세 번째 원소 삽입 :
 * $[7, 2, 3, 4]$ 
 * 예제 입력 2
 * 5
 * 1 1 1 1 1
 * 1 2 3 4 5
 * 3
 * 1 3 5
 * 예제 출력 2
 * 1 3 5
 */

import java.util.*;
import java.io.*;

public class P24511 {
    // 스텍은 그냥 패스, 큐는 원소에 포함
    // -> 즉, 수열 C 문자열 + 큐의 원소들에서 수열 C 길이만큼 잘라서 return
    // 자르는 위치틑 큐의 원소들은 모두 포함되고 수열 C의 먼저들어온 문자부터
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            String[] targetString1 = br.readLine().split(" ");
            String[] targetString2 = br.readLine().split(" ");
            int M = Integer.parseInt(br.readLine());
            String[] targetString3 = br.readLine().split(" ");
            List<Integer> targetList = new ArrayList<>();
            for (int i=0; i<N; i++){
                if (targetList.size()==M){
                    break;
                }
                if (targetString1[N-i-1].equals("0")){
                    targetList.add(Integer.parseInt(targetString2[N-i-1]));
                }
            }
            for (int i=0; i<M; i++){
                if (targetList.size()==M){
                    break;
                }
                targetList.add(Integer.parseInt(targetString3[i]));
            }
            targetList.stream().forEach(target->sb.append(target+" "));

            System.out.println(sb);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
