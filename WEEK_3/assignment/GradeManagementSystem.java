class Subject {
    String subjectCode, subjectName, instructor;
    int credits;

    Subject(String code, String name, int credits, String instructor) {
        this.subjectCode = code;
        this.subjectName = name;
        this.credits = credits;
        this.instructor = instructor;
    }
}

class Student {
    String studentId, studentName, className;
    String[] subjects;
    double[] marks; // marks per subject
    double gpa;

    // Static members
    static int totalStudents = 0;
    static String schoolName = "Default School";
    static String[] gradingScale = {"A", "B", "C", "D", "F"};
    static double passPercentage = 40.0;

    Student(String id, String name, String className, String[] subjects) {
        this.studentId = id;
        this.studentName = name;
        this.className = className;
        this.subjects = subjects;
        this.marks = new double[subjects.length];
        this.gpa = 0.0;
        totalStudents++;
    }

    void addMarks(String subject, double mark) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equals(subject)) {
                marks[i] = mark;
            }
        }
    }

    void calculateGPA() {
        double sum = 0;
        for (double m : marks) sum += m;
        double avg = sum / marks.length;
        this.gpa = avg / 25; // convert percentage (100) → GPA (4 scale)
    }

    void generateReportCard() {
        System.out.println("\n--- Report Card: " + studentName + " ---");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + marks[i] + "%");
        }
        System.out.println("GPA: " + gpa + " | Grade: " + getGrade());
    }

    String getGrade() {
        double avg = 0;
        for (double m : marks) avg += m;
        avg /= marks.length;

        if (avg >= 85) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 55) return "C";
        else if (avg >= 40) return "D";
        else return "F";
    }

    boolean checkPromotionEligibility() {
        double avg = 0;
        for (double m : marks) avg += m;
        avg /= marks.length;
        return avg >= passPercentage;
    }

    // Static methods
    static void setGradingScale(String[] scale) {
        gradingScale = scale;
    }

    static double calculateClassAverage(Student[] students) {
        double total = 0;
        for (Student s : students) {
            double sum = 0;
            for (double m : s.marks) sum += m;
            total += sum / s.marks.length;
        }
        return total / students.length;
    }

    static void getTopPerformers(Student[] students, int count) {
        java.util.Arrays.sort(students, (a, b) -> Double.compare(b.gpa, a.gpa));
        System.out.println("\n--- Top " + count + " Performers ---");
        for (int i = 0; i < Math.min(count, students.length); i++) {
            System.out.println(students[i].studentName + " | GPA: " + students[i].gpa);
        }
    }

    static void generateSchoolReport(Student[] students) {
        System.out.println("\n=== " + schoolName + " Report ===");
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Class Average: " + calculateClassAverage(students));
        getTopPerformers(students, 3);
    }
}


