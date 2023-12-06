// 나이순 정렬 ( 정답 )
// 알고리즘: 정렬

package boj.sorting;

import java.io.*;
import java.util.*;

public class S5_10814 {
    static int n;
    static ArrayList<Person> arr = new ArrayList<>();

    static class Person {
        int age;
        String name;
        int index;

        Person(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Person p = new Person(age, name, i);
            arr.add(p);
        }

        // 나이순 오름차순 정렬
        // 나이가 같으면 입력순
        Collections.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.age == o2.age) {
                    return o1.index - o2.index;
                }
                else {
                    return o1.age - o2.age;
                }
            }
        });

        for (Person person : arr) {
            System.out.printf("%d %s\n", person.age, person.name);
        }
    }
}
