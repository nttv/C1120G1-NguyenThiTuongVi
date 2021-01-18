package day_10_dsa_stack_and_queue.bai_tap.demerging;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Comparable<Employee> {
    private String name;
    private char gender;
    private Date birthday;

    public Employee() {
    }

    public Employee(String name, char gender, Date birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Employee o) {
        return this.birthday.compareTo(o.birthday);
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday='" + dateFormat.format(birthday) + '\'' +
                '}';
    }
}
