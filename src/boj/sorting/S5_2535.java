// 아시아 정보올림피아드 ( 정답 )
// 알고리즘: 구현, 정렬

package boj.sorting;

import java.io.*;
import java.util.*;

public class S5_2535 {

    static int n;
    static ArrayList<Student> arr = new ArrayList<>();
    static HashMap<Integer, Integer> count = new HashMap<>();

    static class Student {
        int country;
        int sNum;
        int score;

        public Student(int country, int sNum, int score) {
            this.country = country;
            this.sNum = sNum;
            this.score = score;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int country = Integer.parseInt(st.nextToken());
            int sNum = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            arr.add(new Student(country, sNum, score));
        }

        Collections.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.score - o1.score;
            }
        });

        int c = 0;
        int index = 0;
        while (c < 3) {
            int country = arr.get(index).country;
            if (count.get(country) == null) {
                System.out.printf("%d %d\n", arr.get(index).country, arr.get(index).sNum);
                count.put(country, 1);
                c += 1;
            }
            else if (count.get(country) == 1) {
                System.out.printf("%d %d\n", arr.get(index).country, arr.get(index).sNum);
                count.put(country, 2);
                c += 1;
            }
            index += 1;
        }
    }
}
