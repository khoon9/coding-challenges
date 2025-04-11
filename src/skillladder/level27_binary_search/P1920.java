package skillladder.level27_binary_search;

/**
 * 문제
 * N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
 *
 * 출력
 * M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
 *
 * 예제 입력 1
 * 5
 * 4 1 5 2 3
 * 5
 * 1 3 7 9 5
 * 예제 출력 1
 * 1
 * 1
 * 0
 * 0
 * 1
 */

import java.util.*;
import java.io.*;

public class P1920 {
    // 목표: 리스트 안에 특정 값 포함 여부 반환
    // 유의:
    // 구하기 문제
    // 입력 N, M -> 10^5, 10^5 -> O(MN) -> 연산 반복 최대 10^10 -> 시간 초과 우려 발생
    // -> O(MlogN) 으로 줄이도록 목표
    // 입력 배열(arr) -> 정렬 -> 이진 탐색 구조 => O(NlogN) + O(MlogN) 복잡도 요구
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st1. nextToken());
            }
            int M= Integer.parseInt(br.readLine());
            int[] arrM = new int[M];
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i=0; i<M; i++){
                arrM[i] = Integer.parseInt(st2. nextToken());
            }
            Arrays.sort(arr);
            for (int i=0; i<M; i++){
                if (function1(arr, 0, arr.length-1, arrM[i])){
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    // arr은 오름차순 정렬되어 주어진다고 가정. 이진 탐색 후 조회 결과 반환 (존재 여부).
    public static boolean function1(int[] arr, int l, int r, int targetValue){
        if (r - l < 0){
            return false;
        }
        if (r - l == 0){
            if (arr[l]==targetValue){
                return true;
            } else{
                return false;
            }
        }
        int mid = l + (r - l)/2;
        if (targetValue>arr[mid]){
            return function1(arr, mid+1, r, targetValue);
        } else {
            return function1(arr, l, mid, targetValue);
        }
    }
}
