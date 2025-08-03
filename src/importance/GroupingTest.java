package importance;

import lambda.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupingTest {

    public static void main(String[] args) {

        List<Student> list = List.of(
                new Student("aaa", 1, 90)
                , new Student("bbb", 3, 50)
                , new Student("ccc", 3, 89)
                , new Student("ddd", 1, 65)
                , new Student("eee", 2, 99)
                , new Student("fff", 2, 65)
                , new Student("ggg", 1, 97)
        );

        // 1. 학년별 학생 이름 출력
        Map<Integer, List<String>> res1 = list.stream()
                .collect(Collectors.groupingBy(Student::getGrade
                        , Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println("res1 = " + res1);

        // 2. 학년별 학생 수 출력
        Map<Integer, Long> res2 = list.stream().collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));
        System.out.println("res2 = " + res2);

        // 3. 학년별 학생 평균 성적 출력
        Map<Integer, Double> res3 = list.stream().collect(Collectors.groupingBy(Student::getGrade, Collectors.averagingInt(Student::getScore)));
        System.out.println("res3 = " + res3);

        // 4. 학년별 가장 점수가 높은 학생 출력 reducing / maxBy
        Map<Integer, Optional<Student>> res4_1 = list.stream().
                collect(Collectors.groupingBy(Student::getGrade
                        , Collectors.reducing((s1, s2) -> s1.getScore() > s2.getScore() ? s1 : s2)));
        Map<Integer, Optional<Student>> res4_2 = list.stream().
                collect(Collectors.groupingBy(Student::getGrade
                        , Collectors.maxBy(Comparator.comparing(Student::getScore))));
        System.out.println("res4_1 = " + res4_1);
        System.out.println("res4_2 = " + res4_2);

        // 5. 학년별 가장 점수가 높은 학생의 이름 출력: collectingAndThen + maxBy
        Map<Integer, String> res5 = list.stream()
                .collect(Collectors.groupingBy(Student::getGrade
                        , Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Student::getScore)), opt -> opt.get().getName())));
        System.out.println("res5 = " + res5);
    }

}
