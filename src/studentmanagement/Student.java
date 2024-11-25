//student.java
package studentmanagement;

public class Student {
    private int id;
    private String name;
    private int age;
    private String grade;
    private double gpa;

    public Student(int id, String name, int age, String grade, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.gpa = gpa;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Age=" + age +
                ", Grade=" + grade + ", GPA=" + gpa + "]";
    }
}



