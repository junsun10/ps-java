// 국영수 ( 정답 )
// 알고리즘: 정렬
// 조건에 맞게 정렬

package boj.sorting;

import java.io.*;
import java.util.*;

public class S4_10825 {
    public static int n;    // 학생 수
    public static ArrayList<Student> students = new ArrayList<>();  // 학생 배열

    static class Student implements Comparable<Student> {
        String name;    // 이름
        int korean;     // 국어 점수
        int english;    // 영어 점수
        int math;       // 수학 점수

        Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student x) {
            if (this.korean == x.korean) {
                if (this.english == x.english) {
                    if (this.math == x.math) {
                        for (int i = 0; i < Math.min(this.name.length(), x.name.length()); i++) {
                            // 사전순
                            if (this.name.charAt(i) > x.name.charAt(i)) {
                                return 1;
                            } else if (this.name.charAt(i) < x.name.charAt(i)) {
                                return -1;
                            }
                        }
                    }
                    return x.math - this.math;  // 내림차순
                }
                return this.english - x.english;    // 오름차순
            }
            return x.korean - this.korean;  // 내림차순
        }
    }

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());    // 학생 수 입력
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            Student student = new Student(name,korean,english,math);
            students.add(student);  // 학생 추가
        }
    }

    public static void solution() {
        Collections.sort(students); // 정렬
        for (int i = 0; i < n; i++) {
            System.out.println(students.get(i).name);
        }
    }
}

