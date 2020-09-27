package ru.sergst;

import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Calculator {

    int maxEI = 3;
    int maxSpec = 3;
    int studentsCnt = 100;
    int maxBalls = 300;
    int places = 2;

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.doCalc();
    }

    void doCalc() {
        //Есть maxEI вузов
        List<EducationalInstitution> vuzes = new ArrayList<>(maxEI);
        for (int i = 0; i < maxEI; i++) {
            EducationalInstitution vuz = new EducationalInstitution("ВУЗ №" + (i +1));
            for (int j = 0; j < maxSpec; j++) {
                vuz.specialties.add(new Specialty("Специальность №" + (j + 1)));
            }
            vuzes.add(vuz);
        }

        //и studentsCnt студенктов
        List<Student> students = new ArrayList<>(studentsCnt);
        for (int i = 0; i < studentsCnt; i++) {
            String studentName = "Студент №" + (i + 1);
            students.add(new Student(studentName, balls()));
        }

        //каждый студент подает заявления в maxEI вузов на maxSpec специальностей
        // (т.к. вуза 3 то подаем во все вузы заявления на все специальности для теста пока)
        vuzes.forEach(vuz -> vuz.specialties.forEach(specialty -> students.forEach(student -> {
            Claim claim = new Claim(student, priority());
            specialty.claims.add(claim);
        })));

        int placesCount = vuzes.stream().map(EducationalInstitution::getSpecialties).mapToInt(List::size).sum() * places;
        System.out.println("Всего мест: " + placesCount);
        System.out.println("Всего абитуриентов: " + students.size());
        System.out.println("Средний конкурс на место: " +  Precision.round((double) students.size() / (double) placesCount, 1));

        //проводим зачисление в соответствии с количеством мест, количеством баллов, учитывая минимальный балл и приоритета.

    }

    private int balls() {
        return ThreadLocalRandom.current().nextInt(0, maxBalls + 1);
    }

    private int priority() {
        return ThreadLocalRandom.current().nextInt(0, maxSpec * maxEI + 1);
    }
}
