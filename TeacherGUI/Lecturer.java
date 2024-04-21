
// This class extends the Teacher class, inheriting its properties and methods
public class Lecturer extends Teacher {

    // These are private instance variables specific to the Lecturer class
    private String department;
    private int yearsOfExperience;
    private int gradedScore;
    private boolean hasGraded;

    // Constructor for the Lecturer class, initializing its properties and calling the superclass constructor
    public Lecturer(String department, int yearsOfExperience, int teacherId, String teacherName, String address,
    String workingType, String employmentStatus, int workingHours,int gradedScore) {
        // Calling the superclass constructor using 'super'
        super(teacherId, teacherName, address, workingType, employmentStatus);
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
        this.gradedScore = gradedScore;
        this.hasGraded = false;
        this.setWorkingHours(workingHours);
    }
    // Getter methods for the private instance variables
    public String getDepartment() {
        return this.department;
    }

    public int getYearsOfExperience() {
        return this.yearsOfExperience;
    }

    public int getGradedScore() {
        return this.gradedScore;
    }

    public boolean getHasGraded() {
        return this.hasGraded;
    }

    // Setter method for the graded score
    public void setGradedScore(int gradedScore) {
        this.gradedScore = gradedScore;
    }

    // Method to grade an assignment based on experience, department, and scored points
    public String gradeAssignment(int gradedScore, String department, int yearsOfExperience) {
        this.gradedScore = gradedScore;//Changing the code for showing the grade on option panel
        if ((yearsOfExperience >= 5) && (this.department.equals(department))) {
            if (gradedScore >= 70) {
                return "Student has scored A";
            } else if (gradedScore >= 60) {
                return "Student has scored B";
            } else if (gradedScore >= 50) {
                return "Student has scored C";
            } else if (gradedScore >= 40) {
                return "Student has scored D";
            } else if (gradedScore < 40) {
                return "Student has scored E";
            }
            this.hasGraded = true;
        }
        if (hasGraded == false) {
            if (yearsOfExperience < 5) {
                return "The lecturer is not experienced";
            } else {
                return "Department of the tutor does not match with the provided department";
            }
        }
        return "This score has not graded";
    }
    
    // Method overriding to display information about the lecturer, including superclass information
    public void display() {
        super.display();
        System.out.println("Department of the teacher: " + this.getDepartment());
        System.out.println("Years of experience of teacher: " + this.getYearsOfExperience());
        System.out.println("Teacher has graded score: " + this.getGradedScore());

        if (this.hasGraded == false) {
            System.out.println("The lecturer has not graded the score");
        }
    }
}

