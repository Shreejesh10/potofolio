public class Tutor extends Teacher {

    // These are private instance variables specific to the Tutor class
    private double salary;
    private String specialization;
    private String academicQualification;
    private int performanceIndex;
    private boolean isCertified;

    // Constructor for the Tutor class, initializing its properties and calling the superclass constructor
    public Tutor(int teacherId, String teacherName, String address, String workingType, String employmentStatus,
    int workingHours, double salary, String specialization, String academicQualification, int performanceIndex) {
        // Calling the superclass constructor using 'super'
        super(teacherId, teacherName, address, workingType, employmentStatus);
        this.setWorkingHours(workingHours);
        this.salary = salary;
        this.specialization = specialization;
        this.academicQualification = academicQualification;
        this.performanceIndex = performanceIndex;
        this.isCertified = false;
    }

    // Getter methods for the private instance variables
    public double getSalary() {
        return this.salary;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public String getAcademicQualification() {
        return this.academicQualification;
    }

    public int getPerformanceIndex() {
        return this.performanceIndex;
    }

    public boolean getIsCertified() {
        return this.isCertified;
    }

    // Setter method for salary and certification based on performance index and working hours
    public String setSalary(double salary, int performanceIndex) {
        if (performanceIndex > 5 && getWorkingHours() > 20) {
            double appraisal = 0;
            if (performanceIndex >= 5 && performanceIndex <= 7) {
                appraisal = 0.05;
            } else if (performanceIndex >= 8 && performanceIndex <= 9) {
                appraisal = 0.10;
            } else if (performanceIndex == 10) {
                appraisal = 0.20;
            }
            this.salary = salary + (appraisal * salary);
            this.isCertified = true;
            return "Salary has been set to "+this.salary;
        }
        if (isCertified == false) {
            if (performanceIndex <= 5) {
                return"The performance index of the teacher is not enough";
            } else {
                return"The teacher does not meet the working hour required";
            }
        }
        return "This salary could not be set.";
    }

    // Method to remove a tutor if not certified, resetting properties to default values
    public String removeTutor() {
        if (this.getIsCertified() == false) {
            this.performanceIndex = 0;
            this.salary = 0;
            this.specialization = null;
            this.academicQualification = null;
            this.isCertified = false;
            return "Tutor is removed ";
        } else {
            return"Tutor cannot be removed.";
        }
    }

    // Display method to print information about the tutor, including superclass information
    public void display() {
        super.display();
        if (this.getIsCertified()) {
            System.out.println("Salary of the tutor is:" + this.salary);
            System.out.println("Specialization:" + this.specialization);
            System.out.println("Academic Qualification:" + this.academicQualification);
            System.out.println("Performance Index:" + this.performanceIndex);
        }
    }
    
}
