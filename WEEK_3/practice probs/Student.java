public class Student {
    private String studentId, name, course;
    private double grade;

    // Default constructor
    public Student() {}

    // Parameterized constructor
    public Student(String studentId, String name, double grade, String course) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }

    // Getters & Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    // Calculate letter grade
    public String calculateLetterGrade() {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }

    // Display student info
    public void displayStudent() {
        System.out.println("ID: " + studentId + ", Name: " + name +
                           ", Grade: " + grade + " (" + calculateLetterGrade() + ")" +
                           ", Course: " + course);
    }

    // Main method
    public static void main(String[] args) {
        // Using default constructor + setters
        Student s1 = new Student();
        s1.setStudentId("S101");
        s1.setName("Alice");
        s1.setGrade(85.5);
        s1.setCourse("Math");
        s1.displayStudent();

        // Using parameterized constructor
        Student s2 = new Student("S102", "Bob", 92.0, "Physics");
        s2.displayStudent();
    }
}
