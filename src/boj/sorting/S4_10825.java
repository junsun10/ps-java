// 국영수 ( 정답 )
// 알고리즘: 정렬
// 조건에 맞게 정렬

package boj.sorting;

import java.io.*;
import java.util.*;

public class S4_10825 {
    public static int n;
    public static ArrayList<Student> students = new ArrayList<>();

    static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;

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
                            if (this.name.charAt(i) > x.name.charAt(i)) {
                                return 1;
                            } else if (this.name.charAt(i) < x.name.charAt(i)) {
                                return -1;
                            }
                        }

                    }
                    return x.math - this.math;
                }
                return this.english - x.english;
            }
            return x.korean - this.korean;
        }
    }

    public static void main(String[] args) throws Exception {
        read();
        solution();
    }

    public static void read() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            Student student = new Student(name,korean,english,math);
            students.add(student);
        }
    }

    public static void solution() {
        Collections.sort(students);
        for (int i = 0; i < n; i++) {
            System.out.println(students.get(i).name);
        }
    }
}

