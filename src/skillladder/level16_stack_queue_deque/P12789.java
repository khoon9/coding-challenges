package skillladder.level16_stack_queue_deque;

/**
 *문제
 * 인하대학교 학생회에서는 중간, 기말고사 때마다 시험 공부에 지친 학우들을 위해 간식을 나눠주는 간식 드리미 행사를 실시한다. 승환이는 시험 기간이 될 때마다 간식을 받을 생각에 두근두근 설레서 시험 공부에 집중을 못 한다. 이번 중간고사에서도 역시 승환이는 설레는 가슴을 안고 간식을 받기 위해 미리 공지된 장소에 시간 맞춰 도착했다. 그런데 이게 무슨 날벼락인가! 그 곳에는 이미 모든 학생들이 모여있었고, 승환이는 마지막 번호표를 받게 되었다. 설상가상으로 몇몇 양심에 털이 난 학생들이 새치기를 거듭한 끝에 대기열의 순서마저 엉망이 되고 말았다. 간식을 나눠주고 있던 인규는 학우들의 터져 나오는 불만에 번호표 순서로만 간식을 줄 수 있다고 말했다.
 *
 * 그제야 학생들이 순서대로 줄을 서려고 했지만 공간이 너무 협소해서 마음대로 이동할 수 없었다. 다행히도 대기열의 왼쪽에는 1열로 설 수 있는 공간이 존재하여 이 공간을 잘 이용하면 모두가 순서대로 간식을 받을 수 있을지도 모른다. 자칫 간식을 못 받게 될지도 모른다는 위기감을 느낀 승환이는 자신의 컴퓨터 알고리즘적 지식을 활용해 과연 모든 사람들이 순서대로 간식을 받을 수 있는지 확인하는 프로그램을 만들기로 했다. 만약 불가능 하다면 승환이는 이번 중간고사를 망치게 될 것 이고 가능하다면 힘을 얻어 중간고사를 잘 볼 수 있을지도 모른다.
 *
 * 사람들은 현재 1열로 줄을 서있고, 맨 앞의 사람만 이동이 가능하다. 인규는 번호표 순서대로만 통과할 수 있는 라인을 만들어 두었다. 이 라인과 대기열의 맨 앞 사람 사이에는 한 사람씩 1열이 들어갈 수 있는 공간이 있다. 현재 대기열의 사람들은 이 공간으로 올 수 있지만 반대는 불가능하다. 승환이를 도와 프로그램을 완성하라.
 *
 * 현재 간식 배부 공간을 그림으로 나타내면 다음과 같다.
 *
 * (BOJ 12789 그림 참고)
 *
 * 위 예제는 다음 그림과 같이 움직였을 때 모두가 순서대로 간식을 받을 수 있다..
 *
 *
 *
 * 입력
 * 입력의 첫째 줄에는 현재 승환이의 앞에 서 있는 학생들의 수 N(1 ≤ N ≤ 1,000,자연수)이 주어진다.
 *
 * 다음 줄에는 승환이 앞에 서있는 모든 학생들의 번호표(1,2,...,N) 순서가 앞에서부터 뒤 순서로 주어진다.
 *
 * 출력
 * 승환이가 무사히 간식을 받을 수 있으면 "Nice"(따옴표는 제외)를 출력하고 그렇지 않다면 "Sad"(따옴표는 제외)를 출력한다.
 */

import java.util.*;

public class P12789 {
    // 꼭 순서대로 받는 걸 원하고 있음
    // 옆 열에 스텍 구조로 대기 가능
    // 옆 열로 빠진 후 다시 대기열로 돌아가지 못 함
    // 만약 대기열이 비어있고 옆 열에 사람이 존재하는 경우, 번호표와 부합하지 않다면 더이상 진행 불가
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt();
        scanner.nextLine();
        StringTokenizer st = new StringTokenizer(scanner.nextLine());
        boolean flag = true;
        Deque<Integer> targetStack1 = new ArrayDeque<>();
        Deque<Integer> targetStack2 = new ArrayDeque<>();
        for (int i=0; i<N; i++){
            targetStack1.addLast(Integer.parseInt(st.nextToken()));
        }
        int needNumber = 1;
        while (!targetStack1.isEmpty() || !targetStack2.isEmpty()){
            if (!targetStack1.isEmpty() && targetStack1.peekFirst()==needNumber){
                needNumber++;
                targetStack1.removeFirst();
                continue;
            }
            if (!targetStack2.isEmpty() && targetStack2.peekFirst()==needNumber){
                needNumber++;
                targetStack2.removeFirst();
                continue;
            }
            // 더이상 진행 불가능한 상태 -> Sad
            if (targetStack1.isEmpty() && !targetStack2.isEmpty()){
                flag = false;
                break;
            }
            // 옆 열로 빠져서 대기열의 다음 사람 번호표 확인하기
            if (!targetStack1.isEmpty()) {
                targetStack2.addFirst(targetStack1.removeFirst());
            }
        }
        if (flag){
            sb.append("Nice");
        } else{
            sb.append("Sad");
        }

        System.out.println(sb);
    }
}
