package skillladder.level16_stack_queue_deque;

/**
 *문제
 * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 *
 * 명령은 총 다섯 가지이다.
 *
 * 1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
 * 2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
 * 3: 스택에 들어있는 정수의 개수를 출력한다.
 * 4: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * 5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
 * 입력
 * 첫째 줄에 명령의 수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
 *
 * 둘째 줄부터 N개 줄에 명령이 하나씩 주어진다.
 *
 * 출력을 요구하는 명령은 하나 이상 주어진다.
 *
 * 출력
 * 출력을 요구하는 명령이 주어질 때마다 명령의 결과를 한 줄에 하나씩 출력한다.
 *
 * 예제 입력 1
 * 9
 * 4
 * 1 3
 * 1 5
 * 3
 * 2
 * 5
 * 2
 * 2
 * 5
 * 예제 출력 1
 * 1
 * 2
 * 5
 * 3
 * 3
 * -1
 * -1
 */

import java.util.*;
import java.io.*;

public class P28278 {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            P28278 sample = new P28278();

            int N = Integer.parseInt(br.readLine());
            Deque<Integer> targetStack = new ArrayDeque<>();
            for (int i=0; i<N; i++){
                String[] targetStrings = br.readLine().split(" ");
                String numString = targetStrings[0];
                int num2 = 0;
                if (targetStrings.length==2){
                    num2 = Integer.parseInt(targetStrings[1]);
                }

                switch (numString){
                    case("1"):
                        sample.functionNum1(targetStack,num2);
                        break;
                    case("2"):
                        sb.append(sample.functionNum2(targetStack)).append("\n");
                        break;
                    case("3"):
                        sb.append(sample.functionNum3(targetStack)).append("\n");
                        break;
                    case("4"):
                        sb.append(sample.functionNum4(targetStack)).append("\n");
                        break;
                    case("5"):
                        sb.append(sample.functionNum5(targetStack)).append("\n");
                        break;
                    default:
                        break;
                }
            }

            System.out.println(sb);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void functionNum1(Deque<Integer> targetStack, int num2){
        targetStack.addLast(num2);
    }
    public int functionNum2(Deque<Integer> targetStack){
        if (targetStack.peekLast()==null){
            return -1;
        } else {
            return targetStack.removeLast();
        }
    }
    public int functionNum3(Deque<Integer> targetStack){
        return targetStack.size();
    }
    public int functionNum4(Deque<Integer> targetStack){
        if (targetStack.isEmpty()){
            return 1;
        } else {
            return 0;
        }
    }
    public int functionNum5(Deque<Integer> targetStack){
        if (targetStack.peekLast()==null){
            return -1;
        } else {
            return targetStack.peekLast();
        }
    }
}
