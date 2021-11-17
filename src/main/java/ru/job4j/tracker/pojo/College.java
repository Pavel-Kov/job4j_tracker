package ru.job4j.tracker.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Иванов Иван");
        student.setGroup("гр. 21");
        student.setCreated(new Date());

        System.out.println("ФИО: " + student.getName() + System.lineSeparator()
                        + "Группа: " + student.getGroup() + System.lineSeparator()
                        + "Дата поступления: " + student.getCreated());
    }
}
