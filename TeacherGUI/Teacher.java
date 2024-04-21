
public class Teacher {

    // These are private instance variables for the Teacher class
    private int teacherId;          // instance variable for teacherId
    private String teacherName;     // instance variable for teacherName
    private String address;         // instance variable for Address
    private String workingType;     // instance variable for workingType
    private String employmentStatus;// instance variable for employmentStatus
    private int workingHours;       // instance variable for workingHours

    // This is the constructor of the Teacher class, used to initialize the instance variables
    public Teacher(int teacherId, String teacherName, String address, String workingType, String employmentStatus) {
        this.teacherId = teacherId;         // constructor for Id 
        this.teacherName = teacherName;     // constructor for name
        this.address = address;             // constructor for address
        this.workingType = workingType;     // constructor for workingType
        this.employmentStatus = employmentStatus; // constructor for employmentStatus
    }

    // This is a setter method to set the working hours
    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    // These are getter methods to retrieve the values of instance variables
    public int getTeacherId() {
        return this.teacherId;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public String getAddress() {
        return this.address;
    }

    public String getWorkingType() {
        return this.workingType;
    }

    public String getEmploymentStatus() {
        return this.employmentStatus;
    }

    public int getWorkingHours() {
        return this.workingHours;
    }

    // This method displays information about the teacher
    public void display() {
        System.out.println("Display all data");
        System.out.println("Name of the teacher: " + this.getTeacherName());
        System.out.println("Id of the teacher: " + this.getTeacherId());
        System.out.println("Address of the teacher: " + this.getAddress());
        System.out.println("Working Type of the teacher: " + this.getWorkingType());
        System.out.println("Employment Status of the teacher: " + this.getEmploymentStatus());

        // Checking whether the working hour is assigned or not
        if (workingHours == 0) {
            System.out.println("Working hour is not assigned");
        } else {
            System.out.println("Working hour is assigned");
        }
        
        }
                  
    
}
