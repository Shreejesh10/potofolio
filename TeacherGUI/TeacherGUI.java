import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherGUI  {
    ArrayList<Teacher>teacherArrayList=new ArrayList<Teacher>();//Creating array list whith the class Teacher
    private JFrame frame,lecturerFrame,tutorFrame,gradeAssignmentFrame,setSalaryFrame,removeFrame;

    private JPanel panel, lecturerPanel, tutorPanel,gradeAssignmentPanel,setSalaryPanel,removePanel;

    private JButton lecturerButton, tutorButton ,assignmentGradeButton,setSalaryButton,removeButton,displayButton,clearButton,addLecturer,lecClearButton,tutorClearButton,addTutorButton,gradeButton,
    gradeClearButton,salaryClear,addSalaryButton,removeTutorButton,removeClear,lecBackButton,tutBackButton,gradeAssignmentBackButton,setSalaryBackButton,removeTutorBackButton;

    private JLabel lecTeacherIdLabel,lecTeacherNameLabel,lecAddressLabel,lecWorkingTypeLabel,lecEmploymentStatusLabel,lecGradedScoreLabel,lecYearsOfExperienceLabel,lecDepartmentLabel,lecWorkingHoursLabel,tutTeacherNameLabel,tutTeacherIdLabel,
    tutAddressLabel,tutWorkingTypeLabel,tutWorkingHourLabel,tutSalaryLabel,tutPerformanceIndexLabel,tutSpecializationLabel,tutAcademicQualificationLabel,tutEmploymentStatusLabel,gradeTeacherIdLabel,
    gradeGradedScoreLabel,gradeDepartmentLabel,gradeYearsOfExperienceLabel,salaryTeacherIdLabel,salaryLabel,salaryPerformanceLabel,removeTeacherIdLabel;

    private JTextField lecTeacherIdText,lecTeacherNameText,lecAddressText,lecWorkingTypeText,lecEmploymentStatusText,lecGradedScoreText,lecYearsOfExperienceText,lecDepartmentText,lecWorkingHoursText,tutTeacherNameText,tutTeacherIdText,
    tutAddressText,tutWorkingTypeText,tutWorkingHourText,tutSalaryText,tutPerformanceIndexText,tutSpecializationText,tutAcademicQualificationText,tutEmploymentStatusText,gradeTeacherIdText,
    gradeGradedScoreText,gradeDepartmentText,gradeYearsOfExperienceText,salaryTeacherIdText,salaryText,salaryPerformanceText,removeTeacherIdText;

    public TeacherGUI() {
        // Frame
        frame = new JFrame("Teacher GUI");
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creating panel with grid bag layout for the main frame
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        panel.setBounds(20,20,350,200);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        //lecturerFrame
        lecturerFrame=new JFrame("Lecturer GUI");
        lecturerFrame.setSize(750,450);
        lecturerFrame.setLayout(null);

        // lecturer Button
        lecturerButton = new JButton("Lecturer");
        lecturerButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    lecturerFrame.setVisible(true);
                    frame.setVisible(false);
                    //frame.setVisible(false);
                }
            });

        addLecturer= new JButton("Add Lecturer");
        addLecturer.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{
                        if(lecTeacherIdText.getText().equals("")||lecTeacherNameText.getText().equals("")||lecAddressText.getText().equals("")||lecWorkingTypeText.getText().equals("")||lecDepartmentText.getText().equals("")||
                        lecEmploymentStatusText.getText().equals("")||lecGradedScoreText.getText().equals("")||lecYearsOfExperienceText.getText().equals("")||lecWorkingHoursText.getText().equals("")){
                            JOptionPane.showMessageDialog(addLecturer,"Empty Fields Found");//checking if the fields are empty or not
                        }
                        else{
                            //Takes value from the text Field 
                            //Changing the value of int to Double

                            int lecTeacherId =(int)(Double.parseDouble(lecTeacherIdText.getText()));
                            int lecYearsofExperience= (int)(Double.parseDouble(lecYearsOfExperienceText.getText()));
                            int lecGradedScore= (int)(Double.parseDouble(lecGradedScoreText.getText()));
                            int lecWorkingHours= (int)(Double.parseDouble(lecWorkingHoursText.getText()));
                            String lecTeacherName=lecTeacherNameText.getText();
                            String lecAddress = lecAddressText.getText();
                            String lecWorkingType = lecWorkingTypeText.getText();
                            String lecEmpStatus= lecEmploymentStatusText.getText();
                            String lecDepartment = lecDepartmentText.getText();

                            //stores the value in  a new object
                            Lecturer l1 = new Lecturer(lecDepartment,lecYearsofExperience,lecTeacherId,lecTeacherName,lecAddress,lecWorkingType,lecEmpStatus,lecWorkingHours,lecGradedScore);
                            // update the value in array list
                            teacherArrayList.add(l1);
                            JOptionPane.showMessageDialog(addLecturer,"Successfull");

                            lecTeacherIdText.setText("");
                            lecGradedScoreText.setText("");
                            lecTeacherNameText.setText("");
                            lecAddressText.setText("");
                            lecWorkingTypeText.setText("");
                            lecEmploymentStatusText.setText("");
                            lecYearsOfExperienceText.setText("");
                            lecDepartmentText.setText("");
                            lecWorkingHoursText.setText("");
                        }
                    }
                    catch(NumberFormatException e1){
                        JOptionPane.showMessageDialog(addLecturer,"Enter only numbers for Id,Years of Experience,GradedScore");
                    }
                }
            });
        lecClearButton = new JButton("Clear all the Fields");
        lecClearButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if (JOptionPane.showConfirmDialog(null,"Are you sure you want to clear all the fields?","Confirmation",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                        lecTeacherIdText.setText("");
                        lecGradedScoreText.setText("");
                        lecTeacherNameText.setText("");
                        lecAddressText.setText("");
                        lecWorkingTypeText.setText("");
                        lecEmploymentStatusText.setText("");
                        lecYearsOfExperienceText.setText("");
                        lecDepartmentText.setText("");
                        lecWorkingHoursText.setText("");
                    }

                }
            });

        //Lecturer Panel
        lecturerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints lecConstraints = new GridBagConstraints();
        lecConstraints.fill = GridBagConstraints.HORIZONTAL;//
        lecConstraints.insets = new Insets(10,10,10,10);//specify the space at the edge
        lecturerPanel.setBounds(10,10,700,350);
        lecturerFrame.add(lecturerPanel);

        //Lecturer label
        lecTeacherIdLabel = new JLabel("Teacher ID");
        lecTeacherNameLabel=new JLabel("Teacher Name");
        lecAddressLabel= new JLabel("Address");
        lecWorkingTypeLabel = new JLabel("Working Type");
        lecEmploymentStatusLabel = new JLabel("Employment Status");
        lecGradedScoreLabel= new JLabel("GradedScore");
        lecYearsOfExperienceLabel= new JLabel("Years of Experience");
        lecGradedScoreLabel= new JLabel("GradedScore");
        lecDepartmentLabel= new JLabel("Department");
        lecWorkingHoursLabel= new JLabel("WorkingHours");
        //LecturerTextField
        lecTeacherIdText= new JTextField(15);
        lecTeacherNameText = new JTextField(15);
        lecAddressText= new JTextField(15);
        lecWorkingTypeText = new JTextField(15);
        lecEmploymentStatusText= new JTextField(15);
        lecGradedScoreText= new JTextField(15);
        lecYearsOfExperienceText = new JTextField(15);
        lecGradedScoreText=new JTextField(15);
        lecDepartmentText= new JTextField(15);
        lecWorkingHoursText= new JTextField(15);

        // Tutor Button
        tutorButton = new JButton("Tutor");
        tutorButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    tutorFrame.setVisible(true);
                    frame.setVisible(false);
                }

            });
        tutorClearButton = new JButton("Clear all the fields");
        tutorClearButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(JOptionPane.showConfirmDialog(null,"Are you sure you want to clear all the fields?","Confirmation",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                        tutTeacherNameText.setText("");
                        tutTeacherIdText.setText("");
                        tutAddressText.setText("");
                        tutWorkingTypeText.setText("");
                        tutWorkingHourText.setText("");
                        tutEmploymentStatusText.setText("");
                        tutPerformanceIndexText.setText("");
                        tutSpecializationText.setText("");
                        tutSalaryText.setText("");
                        tutAcademicQualificationText.setText("");

                    }
                }
            });
        addTutorButton = new JButton("Add Tutor");
        addTutorButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{
                        if(tutTeacherNameText.getText().equals("")||tutTeacherIdText.getText().equals("")||tutAddressText.getText().equals("")||tutWorkingTypeText.getText().equals("")||tutWorkingHourText.getText().equals("")||
                        tutSalaryText.getText().equals("")||tutPerformanceIndexText.getText().equals("")||tutSpecializationText.getText().equals("")||tutAcademicQualificationText.getText().equals("")||
                        tutEmploymentStatusText.getText().equals("")){
                            JOptionPane.showMessageDialog(addTutorButton,"Empty Fields Found!!");
                        }else{

                            int tutorId =(int)(Double.parseDouble(tutTeacherIdText.getText()));
                            double tutorSalary = Double.parseDouble(tutSalaryText.getText());
                            int tutorWorkingHours =(int)(Double.parseDouble(tutWorkingHourText.getText()));
                            int tutorPerIndex= (int)(Double.parseDouble(tutPerformanceIndexText.getText()));
                            String tutorName= tutTeacherNameText.getText();
                            String tutorWorkingType= tutWorkingTypeText.getText();
                            String tutorAddress= tutAddressText.getText();
                            String tutorEmpStatus= tutEmploymentStatusText.getText();
                            String tutorSpecialization = tutSpecializationText.getText();
                            String tutorAcademicQuali = tutAcademicQualificationText.getText();

                            Tutor t1= new Tutor(tutorId,tutorName,tutorAddress,tutorWorkingType,tutorEmpStatus,tutorWorkingHours,tutorSalary,tutorSpecialization,tutorAcademicQuali,tutorPerIndex);

                            teacherArrayList.add(t1);
                            JOptionPane.showMessageDialog(addTutorButton,"Successfull");
                            tutTeacherNameText.setText("");
                            tutTeacherIdText.setText("");
                            tutAddressText.setText("");
                            tutWorkingTypeText.setText("");
                            tutWorkingHourText.setText("");
                            tutEmploymentStatusText.setText("");
                            tutSalaryText.setText("");
                            tutPerformanceIndexText.setText("");
                            tutSpecializationText.setText("");
                            tutAcademicQualificationText.setText("");

                        }
                    }catch(NumberFormatException e1){
                        JOptionPane.showMessageDialog(addTutorButton,"Enter only numbers for TecherId ,Salary,WorkingHours,Performance Index");
                    }
                }
            });
        //Tutor Frame
        tutorFrame= new JFrame("Tutor");
        tutorFrame.setSize(750,450);
        tutorFrame.setLayout(null);

        //Tutor Panel
        tutorPanel = new JPanel(new GridBagLayout());
        GridBagConstraints tutorConstraints= new GridBagConstraints();
        tutorConstraints.fill = GridBagConstraints.HORIZONTAL;
        tutorConstraints.insets= new Insets(10,10,10,10);
        tutorPanel.setBounds(10,10,700,400);
        tutorFrame.add(tutorPanel);

        //Tutor Label
        tutTeacherIdLabel = new JLabel("Teacher ID");
        tutTeacherNameLabel=new JLabel("Teacher Name");
        tutAddressLabel= new JLabel("Address");
        tutWorkingTypeLabel = new JLabel("Working Type");
        tutEmploymentStatusLabel = new JLabel("Employment Status");
        tutWorkingHourLabel = new JLabel("Working Hours");
        tutSalaryLabel= new JLabel("Salary");
        tutPerformanceIndexLabel= new JLabel("Performance Index");
        tutSpecializationLabel= new JLabel("Specialization");
        tutAcademicQualificationLabel= new JLabel("Academic Qualification");
        //TutorTextField
        tutTeacherIdText= new JTextField(15);
        tutTeacherNameText = new JTextField(15);
        tutAddressText= new JTextField(15);
        tutWorkingTypeText = new JTextField(15);
        tutEmploymentStatusText= new JTextField(15);
        tutWorkingHourText= new JTextField(15);
        tutSalaryText = new JTextField(15);
        tutSpecializationText=new JTextField(15);
        tutAcademicQualificationText = new JTextField(15);
        tutPerformanceIndexText = new JTextField(15);

        //Grade The Assignment Button
        assignmentGradeButton=new JButton("Grade The Assignment");
        assignmentGradeButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    gradeAssignmentFrame.setVisible(true);
                    frame.setVisible(false);
                }
            });

        gradeButton= new JButton("Grade the Assignment");
        gradeButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{
                        if(gradeTeacherIdText.getText().equals("")||gradeGradedScoreText.getText().equals("")||gradeDepartmentText.getText().equals("")||gradeYearsOfExperienceText.getText().equals("")){

                            JOptionPane.showMessageDialog(gradeButton,"Empty Fields Found!!");

                        }
                        else{
                            //Taking the value of GradeAssignment 
                            Double idCheck=Double.parseDouble(gradeTeacherIdText.getText());
                            int gradeGradedScore = (int)(Double.parseDouble(gradeGradedScoreText.getText()));
                            int gradeTeacherId = (int)(Double.parseDouble(gradeTeacherIdText.getText()));
                            int gradeYearsofExperience =(int)(Double.parseDouble(gradeYearsOfExperienceText.getText()));
                            String gradeDepartment = gradeDepartmentText.getText();
                            boolean idFound=false;//it is done for the teacher id

                            //running loop to store the value in array list
                            for (Teacher i: teacherArrayList){
                                if(i.getTeacherId()==gradeTeacherId){
                                    idFound=true;// if the id matches from the lecturer field then the code executes
                                    if(i instanceof Lecturer){
                                        //creating variable for printing the grade in optionpanel
                                        String gradeMessage =((Lecturer)i).gradeAssignment(gradeGradedScore,gradeDepartment, gradeYearsofExperience); //upcasting to retriving the value
                                        JOptionPane.showMessageDialog(gradeButton,gradeMessage);
                                    }else{
                                        JOptionPane.showMessageDialog(gradeButton,"This Id does not belong to a lecturer");
                                    }
                                }
                            }
                            gradeTeacherIdText.setText("");
                            gradeGradedScoreText.setText("");
                            gradeDepartmentText.setText("");
                            gradeYearsOfExperienceText.setText("");

                            if(idFound==false){ 
                                JOptionPane.showMessageDialog(gradeButton,"There teacher Id does not Exists");
                            }
                        }
                    }catch(NumberFormatException e1){
                        JOptionPane.showMessageDialog(addTutorButton,"Enter only numbers for TecherId , GradedScore, Years of Experience, Working Hours");
                    }

                }
            });
        gradeClearButton= new JButton("Clear");
        gradeClearButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(JOptionPane.showConfirmDialog(null,"Are you sure you want to clear all the Fields...?","Confirmation",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                        gradeTeacherIdText.setText("");
                        gradeGradedScoreText.setText("");
                        gradeDepartmentText.setText("");
                        gradeYearsOfExperienceText.setText("");

                    }
                }
            });
        //Grade the assignment Frame
        gradeAssignmentFrame= new JFrame("Grade the Assignment");
        gradeAssignmentFrame.setSize(500,400);
        gradeAssignmentFrame.setLayout(null);

        //GradeAssignment Panel
        gradeAssignmentPanel=new JPanel(new GridBagLayout());
        GridBagConstraints gradeConstraints= new GridBagConstraints();
        gradeConstraints.fill= GridBagConstraints.HORIZONTAL;
        gradeConstraints.insets = new Insets(10,10,10,10);
        gradeAssignmentPanel.setBounds(10,10,450,350);
        gradeAssignmentFrame.add(gradeAssignmentPanel);

        //grade Assigment Label
        gradeTeacherIdLabel= new JLabel("Teacher Id");
        gradeGradedScoreLabel=  new JLabel("GradedScore");
        gradeDepartmentLabel= new JLabel("Department");
        gradeYearsOfExperienceLabel= new JLabel("Years Of Experience");

        //grade Assignment Text
        gradeTeacherIdText= new JTextField(15);
        gradeGradedScoreText = new JTextField(15);
        gradeDepartmentText= new JTextField(15);
        gradeYearsOfExperienceText = new JTextField(15);

        //Set the salary button
        setSalaryButton = new JButton("Set the salary of Tutor");
        setSalaryButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    setSalaryFrame.setVisible(true);
                    frame.setVisible(false);
                }
            });

        addSalaryButton = new JButton("Set the Salary");
        addSalaryButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{
                        if(salaryTeacherIdText.getText().equals("")||salaryText.getText().equals("")||salaryPerformanceText.getText().equals("")){

                            JOptionPane.showMessageDialog(setSalaryButton,"Empty Fields Found!!");
                        }
                        else{

                            int salaryTeacherId= (int)(Double.parseDouble(salaryTeacherIdText.getText()));
                            int salary = (int)(Double.parseDouble(salaryText.getText()));
                            int salaryPerformance =(int)(Double.parseDouble(salaryPerformanceText.getText()));
                            boolean idFound=false;
                            for(Teacher i:teacherArrayList){
                                if(i.getTeacherId() == salaryTeacherId){
                                    idFound = true;
                                    if(i instanceof Tutor){
                                        String tutorMessage=((Tutor)i).setSalary(salary,salaryPerformance);
                                        JOptionPane.showMessageDialog(addSalaryButton,tutorMessage);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"Id does not belong to Tutor");
                                    }
                                }
                            }

                            salaryTeacherIdText.setText("");
                            salaryText.setText("");
                            salaryPerformanceText.setText("");
                            if(idFound==false){
                                JOptionPane.showMessageDialog(addSalaryButton,"The TeacherId does not exists");
                            }
                        }
                    }catch(NumberFormatException e1){
                        JOptionPane.showMessageDialog(null,"Enter only numbers for TeacherId,Salary and PerformanceIndex");
                    }

                }
            });

        salaryClear= new JButton("Clear");
        salaryClear.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                    if(JOptionPane.showConfirmDialog(null,"Are you sure you want to clear all the Fields...?","Confirmation",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){

                        salaryTeacherIdText.setText("");
                        salaryText.setText("");
                        salaryPerformanceText.setText("");

                    }

                }
            });
        //SetSalaryFrame
        setSalaryFrame=new JFrame("Set the salary of Tutor");
        setSalaryFrame.setSize(450,400);
        setSalaryFrame.setLayout(null);

        //Set Salary Panel
        setSalaryPanel= new JPanel(new GridBagLayout());
        GridBagConstraints salaryConstraints = new GridBagConstraints();
        salaryConstraints.fill = GridBagConstraints.HORIZONTAL;
        salaryConstraints.insets = new Insets(10,10,10,10);
        setSalaryPanel.setBounds(10,10,350,300);
        setSalaryFrame.add(setSalaryPanel);

        //SetSalary Label
        salaryTeacherIdLabel= new JLabel("Teacher Id");
        salaryLabel= new JLabel("Salary");
        salaryPerformanceLabel= new JLabel("Performance Index");

        //Set SalaryText
        salaryTeacherIdText= new JTextField(15);
        salaryText= new JTextField(15);
        salaryPerformanceText= new JTextField(15);

        //Tutor Remove Button
        removeButton = new JButton("Remove the Tutor");
        removeButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    removeFrame.setVisible(true);
                    frame.setVisible(false);
                }
            });

        removeTutorButton= new JButton("Remove the Tutor");
        removeTutorButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{
                        if(removeTeacherIdText.getText().equals("")){

                            JOptionPane.showMessageDialog(gradeButton,"Empty Fields Found!!");
                        }
                        else{
                            int removeTeacherId= (int)(Double.parseDouble(removeTeacherIdText.getText()));
                            boolean idFound =false;
                            
                             for(Teacher i:teacherArrayList){
                                if(i.getTeacherId() == removeTeacherId){
                                    idFound = true;
                                    if(i instanceof Tutor){
                                        String removeMessage=((Tutor)i).removeTutor();
                                        JOptionPane.showMessageDialog(removeTutorButton,removeMessage);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"Id does not belong to Tutor");
                                    }
                                }
                            }
                            removeTeacherIdText.setText("");
                            if(idFound==false){
                                JOptionPane.showMessageDialog(null,"Teacher Id doesnot Exist");
                            }

                        }

                    }catch(NumberFormatException e1){
                        JOptionPane.showMessageDialog(removeTutorButton,"Enter only number");
                    }

                }
            });
        removeClear= new JButton("Clear");
        removeClear.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(JOptionPane.showConfirmDialog(null,"Are you sure you want to clear all the Fields...?","Confirmation",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                        removeTeacherIdText.setText("");

                    }
                }
            });

        //TutorRemove.Frame
        removeFrame= new JFrame("Remove the Tutor");
        removeFrame.setSize(400,400);

        //Tutor Panel
        removePanel= new JPanel(new GridBagLayout());
        GridBagConstraints removeConstraints = new GridBagConstraints();
        removeConstraints.fill = GridBagConstraints.HORIZONTAL;
        removeConstraints.insets = new Insets(10,10,10,10);
        removeFrame.add(removePanel,BorderLayout.CENTER);

        //remove the tutor Label
        removeTeacherIdLabel = new JLabel("Teacher Id");

        //remove the tutor Text
        removeTeacherIdText = new JTextField(15);

        //Display Button
        displayButton= new JButton("Display");

        //Back Button for all the frames
        lecBackButton = new JButton("Back<-");
        lecBackButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    frame.setVisible(true);
                    lecturerFrame.setVisible(false);
                }
            });
        tutBackButton = new JButton("Back<-");
        tutBackButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    frame.setVisible(true);
                    tutorFrame.setVisible(false);
                }
            });
        gradeAssignmentBackButton = new JButton("Back<-");
        gradeAssignmentBackButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    frame.setVisible(true);
                    gradeAssignmentFrame.setVisible(false);
                }
            });
        setSalaryBackButton = new JButton("Back<-");
        setSalaryBackButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    frame.setVisible(true);
                    setSalaryFrame.setVisible(false);
                }
            });
        removeTutorBackButton = new JButton("Back<-");
        removeTutorBackButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    frame.setVisible(true);
                    removeFrame.setVisible(false);
                }
            });

        //GridBagLayout for button
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(lecturerButton, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(tutorButton, constraints);
        constraints.gridx=0;
        constraints.gridy=2;
        panel.add(assignmentGradeButton,constraints);
        constraints.gridx=1;
        constraints.gridy=2;
        panel.add(setSalaryButton,constraints);
        constraints.gridx=1;
        constraints.gridy=3;
        panel.add(removeButton,constraints);
        constraints.gridx=0;
        constraints.gridy=3;
        panel.add(displayButton,constraints);

        //Grid bag Layout for lecturer
        lecConstraints.gridx = 0;
        lecConstraints.gridy =1;
        lecturerPanel.add(lecTeacherIdLabel, lecConstraints);
        lecConstraints.gridx = 1;
        lecConstraints.gridy =1;
        lecturerPanel.add(lecTeacherIdText, lecConstraints);
        lecConstraints.gridx=0;
        lecConstraints.gridy=2;
        lecturerPanel.add(lecTeacherNameLabel,lecConstraints);
        lecConstraints.gridx=1;
        lecConstraints.gridy=2;
        lecturerPanel.add(lecTeacherNameText,lecConstraints);
        lecConstraints.gridx=0;
        lecConstraints.gridy=3;
        lecturerPanel.add(lecAddressLabel,lecConstraints);
        lecConstraints.gridx=1;
        lecConstraints.gridy=3;
        lecturerPanel.add(lecAddressText,lecConstraints);
        lecConstraints.gridx=0;
        lecConstraints.gridy=4;
        lecturerPanel.add(lecWorkingTypeLabel,lecConstraints);
        lecConstraints.gridx=1;
        lecConstraints.gridy=4;
        lecturerPanel.add(lecWorkingTypeText,lecConstraints);
        lecConstraints.gridx=0;
        lecConstraints.gridy=5;
        lecturerPanel.add(lecEmploymentStatusLabel,lecConstraints);
        lecConstraints.gridx=1;
        lecConstraints.gridy=5;
        lecturerPanel.add(lecEmploymentStatusText,lecConstraints);
        lecConstraints.gridx=3;
        lecConstraints.gridy=2;
        lecturerPanel.add(lecYearsOfExperienceLabel,lecConstraints);
        lecConstraints.gridx=4;
        lecConstraints.gridy=2;
        lecturerPanel.add(lecYearsOfExperienceText,lecConstraints);
        lecConstraints.gridx=3;
        lecConstraints.gridy=1;
        lecturerPanel.add(lecGradedScoreLabel,lecConstraints);
        lecConstraints.gridx=4;
        lecConstraints.gridy=1;
        lecturerPanel.add(lecGradedScoreText,lecConstraints);
        lecConstraints.gridx=1;
        lecConstraints.gridy=7;
        lecturerPanel.add(addLecturer,lecConstraints);
        lecConstraints.gridx=4;
        lecConstraints.gridy=7;
        lecturerPanel.add(lecClearButton,lecConstraints);
        lecConstraints.gridx=3;
        lecConstraints.gridy=3;
        lecturerPanel.add(lecDepartmentLabel,lecConstraints);
        lecConstraints.gridx=4;
        lecConstraints.gridy=3;
        lecturerPanel.add(lecDepartmentText,lecConstraints);
        lecConstraints.gridx=3;
        lecConstraints.gridy=4;
        lecturerPanel.add(lecWorkingHoursLabel,lecConstraints);
        lecConstraints.gridx=4;
        lecConstraints.gridy=4;
        lecturerPanel.add(lecWorkingHoursText,lecConstraints);
        lecConstraints.gridx=0;
        lecConstraints.gridy=0;
        lecturerPanel.add(lecBackButton,lecConstraints);

        //Grid Bag Layout for Tutor
        tutorConstraints.gridx=0;
        tutorConstraints.gridy=1;
        tutorPanel.add(tutTeacherIdLabel,tutorConstraints);
        tutorConstraints.gridx=1;
        tutorConstraints.gridy=1;
        tutorPanel.add(tutTeacherIdText,tutorConstraints);
        tutorConstraints.gridx=0;
        tutorConstraints.gridy=2;
        tutorPanel.add(tutTeacherNameLabel,tutorConstraints);
        tutorConstraints.gridx=1;
        tutorConstraints.gridy=2;
        tutorPanel.add(tutTeacherNameText,tutorConstraints);
        tutorConstraints.gridx=0;
        tutorConstraints.gridy=3;
        tutorPanel.add(tutAddressLabel,tutorConstraints);
        tutorConstraints.gridx=1;
        tutorConstraints.gridy=3;
        tutorPanel.add(tutAddressText,tutorConstraints);
        tutorConstraints.gridx=0;
        tutorConstraints.gridy=4;
        tutorPanel.add(tutSalaryLabel,tutorConstraints);
        tutorConstraints.gridx=1;
        tutorConstraints.gridy=4;
        tutorPanel.add(tutSalaryText,tutorConstraints);
        tutorConstraints.gridx=0;
        tutorConstraints.gridy=5;
        tutorPanel.add(tutAcademicQualificationLabel,tutorConstraints);
        tutorConstraints.gridx=1;
        tutorConstraints.gridy=5;
        tutorPanel.add(tutAcademicQualificationText,tutorConstraints);
        tutorConstraints.gridx=3;
        tutorConstraints.gridy=2;
        tutorPanel.add(tutWorkingTypeLabel,tutorConstraints);
        tutorConstraints.gridx=4;
        tutorConstraints.gridy=2;
        tutorPanel.add(tutWorkingTypeText,tutorConstraints);
        tutorConstraints.gridx=3;
        tutorConstraints.gridy=1;
        tutorPanel.add(tutWorkingHourLabel,tutorConstraints);
        tutorConstraints.gridx=4;
        tutorConstraints.gridy=1;
        tutorPanel.add(tutWorkingHourText,tutorConstraints);
        tutorConstraints.gridx=3;
        tutorConstraints.gridy=3;
        tutorPanel.add(tutPerformanceIndexLabel,tutorConstraints);
        tutorConstraints.gridx=4;
        tutorConstraints.gridy=3;
        tutorPanel.add(tutPerformanceIndexText,tutorConstraints);
        tutorConstraints.gridx=3;
        tutorConstraints.gridy=4;
        tutorPanel.add(tutSpecializationLabel,tutorConstraints);
        tutorConstraints.gridx=4;
        tutorConstraints.gridy=4;
        tutorPanel.add(tutSpecializationText,tutorConstraints);
        tutorConstraints.gridx=3;
        tutorConstraints.gridy=5;
        tutorPanel.add(tutEmploymentStatusLabel,tutorConstraints);
        tutorConstraints.gridx=4;
        tutorConstraints.gridy=5;
        tutorPanel.add(tutEmploymentStatusText,tutorConstraints);
        tutorConstraints.gridx=4;
        tutorConstraints.gridy=6;
        tutorPanel.add(tutorClearButton,tutorConstraints);
        tutorConstraints.gridx=1;
        tutorConstraints.gridy=6;
        tutorPanel.add(addTutorButton,tutorConstraints);
        tutorConstraints.gridx=0;
        tutorConstraints.gridy=0;
        tutorPanel.add(tutBackButton,tutorConstraints);

        //Grade the Assignment Constraints
        gradeConstraints.gridx=0;
        gradeConstraints.gridy=1;   
        gradeAssignmentPanel.add(gradeTeacherIdLabel,gradeConstraints);
        gradeConstraints.gridx=1;
        gradeConstraints.gridy=1;
        gradeAssignmentPanel.add(gradeTeacherIdText,gradeConstraints);
        gradeConstraints.gridx=0;
        gradeConstraints.gridy=2;   
        gradeAssignmentPanel.add(gradeGradedScoreLabel,gradeConstraints);
        gradeConstraints.gridx=1;
        gradeConstraints.gridy=2;
        gradeAssignmentPanel.add(gradeGradedScoreText,gradeConstraints);
        gradeConstraints.gridx=0;
        gradeConstraints.gridy=3;   
        gradeAssignmentPanel.add(gradeDepartmentLabel,gradeConstraints);
        gradeConstraints.gridx=1;
        gradeConstraints.gridy=3;
        gradeAssignmentPanel.add(gradeDepartmentText,gradeConstraints);
        gradeConstraints.gridx=0;
        gradeConstraints.gridy=4;   
        gradeAssignmentPanel.add(gradeYearsOfExperienceLabel,gradeConstraints);
        gradeConstraints.gridx=1;
        gradeConstraints.gridy=4;
        gradeAssignmentPanel.add(gradeYearsOfExperienceText,gradeConstraints);
        gradeConstraints.gridx=0;
        gradeConstraints.gridy=5;   
        gradeAssignmentPanel.add(gradeButton,gradeConstraints);
        gradeConstraints.gridx=1;
        gradeConstraints.gridy=5;
        gradeAssignmentPanel.add(gradeClearButton,gradeConstraints);
        gradeConstraints.gridx=0;
        gradeConstraints.gridy=0;
        gradeAssignmentPanel.add(gradeAssignmentBackButton,gradeConstraints);

        //Set the salary GridBag Constraints
        salaryConstraints.gridx=0;
        salaryConstraints.gridy=1;
        setSalaryPanel.add(salaryTeacherIdLabel,salaryConstraints);
        salaryConstraints.gridx=1;
        salaryConstraints.gridy=1;
        setSalaryPanel.add(salaryTeacherIdText,salaryConstraints);
        salaryConstraints.gridx=0;
        salaryConstraints.gridy=2;
        setSalaryPanel.add(salaryLabel,salaryConstraints);
        salaryConstraints.gridx=1;
        salaryConstraints.gridy=2;
        setSalaryPanel.add(salaryText,salaryConstraints);
        salaryConstraints.gridx=0;
        salaryConstraints.gridy=3;
        setSalaryPanel.add(salaryPerformanceLabel,salaryConstraints);
        salaryConstraints.gridx=1;
        salaryConstraints.gridy=3;
        setSalaryPanel.add(salaryPerformanceText,salaryConstraints);
        salaryConstraints.gridx=0;
        salaryConstraints.gridy=4;
        setSalaryPanel.add(addSalaryButton,salaryConstraints);
        salaryConstraints.gridx=1;
        salaryConstraints.gridy=4;
        setSalaryPanel.add(salaryClear,salaryConstraints);
        salaryConstraints.gridx=0;
        salaryConstraints.gridy=0;
        setSalaryPanel.add(setSalaryBackButton,salaryConstraints);

        //Remove the tutor Label
        removeConstraints.gridx=0;
        removeConstraints.gridy=1;
        removePanel.add(removeTeacherIdLabel,removeConstraints);
        removeConstraints.gridx=1;
        removeConstraints.gridy=1;
        removePanel.add(removeTeacherIdText,removeConstraints);
        removeConstraints.gridx=0;
        removeConstraints.gridy=3;
        removePanel.add(removeTutorButton,removeConstraints);
        removeConstraints.gridx=1;
        removeConstraints.gridy=3;
        removePanel.add(removeClear,removeConstraints);
        removeConstraints.gridx=0;
        removeConstraints.gridy=0;
        removePanel.add(removeTutorBackButton,removeConstraints);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] Args) {
        new TeacherGUI();
    }
}
