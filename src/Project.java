import javax.swing.*;
import java.awt.*;
import java.awt.event.*;;

public class Project extends JFrame implements ActionListener{

    Project(){
        setSize(1540, 900);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // NEW INFO
        JMenuBar mb = new JMenuBar();
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
        setJMenuBar(mb);

        JMenuItem faculyInfo = new JMenuItem("New Faculty Information");
        faculyInfo.setBackground(Color.white);
        faculyInfo.addActionListener(this);
        newInformation.add(faculyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);


        // DETAILS
        JMenu detail = new JMenu("Details");
        detail.setForeground(Color.BLUE);
        mb.add(detail);
        setJMenuBar(mb);

        JMenuItem faculyDetail = new JMenuItem("View Faculty Details");
        faculyDetail.setBackground(Color.white);
        faculyDetail.addActionListener(this);
        detail.add(faculyDetail);

        JMenuItem studentDetail = new JMenuItem("View Student Details");
        studentDetail.setBackground(Color.white);
        studentDetail.addActionListener(this);
        detail.add(studentDetail);


        // APPLY LEAVE
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
        setJMenuBar(mb);

        JMenuItem faculyLeave = new JMenuItem("Faculty Leave");
        faculyLeave.setBackground(Color.white);
        faculyLeave.addActionListener(this);
        leave.add(faculyLeave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.white);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);


        // LEAVE DETAILS
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLUE);
        mb.add(leaveDetails);
        setJMenuBar(mb);

        JMenuItem faculyLeaveDetail = new JMenuItem("Faculty Leave Details");
        faculyLeaveDetail.setBackground(Color.white);
        faculyLeaveDetail.addActionListener(this);
        leaveDetails.add(faculyLeaveDetail);

        JMenuItem studentLeaveDetail = new JMenuItem("Student Leave Details");
        studentLeaveDetail.setBackground(Color.white);
        studentLeaveDetail.addActionListener(this);
        leaveDetails.add(studentLeaveDetail);

        // EXAMS
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);
        setJMenuBar(mb);

        JMenuItem results = new JMenuItem("Results");
        results.setBackground(Color.white);
        // results.addActionListener(this);
        exam.add(results);

        JMenuItem uploadMarks = new JMenuItem("Upload Marks");
        uploadMarks.setBackground(Color.white);
        // uploadMarks.addActionListener(this);
        exam.add(uploadMarks);


        // UPDATE INFO
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.BLUE);
        mb.add(updateInfo);
        setJMenuBar(mb);

        JMenuItem updateFacultInfo = new JMenuItem("Update Faculty Details");
        updateFacultInfo.setBackground(Color.white);
        // updateFacultInfo.addActionListener(this);
        updateInfo.add(updateFacultInfo);

        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
        updateStudentInfo.setBackground(Color.white);
        // updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);

        // FEES
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);
        setJMenuBar(mb);

        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.white);
        // feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.white);
        // feeForm.addActionListener(this);
        fee.add(feeForm);

        // UTILITY
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        mb.add(utility);
        setJMenuBar(mb);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.white);
        calc.addActionListener(this);
        utility.add(calc);

        // EXIT
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        mb.add(exit);
        setJMenuBar(mb);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.white);
        ex.addActionListener(this);
        exit.add(ex);

        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Exit")){
            setVisible(false);
        }else if(msg.equals("Calculator")){
            try{
                String[] str = {"calc.exe"};
                Runtime.getRuntime().exec(str);
            }catch(Exception e){
            }
        }else if(msg.equals("Notepad")){
            try{
                String[] str = {"notepad.exe"};
                Runtime.getRuntime().exec(str);
            }catch(Exception e){
            }
        } else if(msg.equals("New Faculty Information")){
            new AddTeacher();
        } else if(msg.equals("New Student Information")){
            new AddStudent();
        } else if(msg.equals("View Faculty Details")){
            new TeacherDetails();
        } else if(msg.equals("View Student Details")){
            new StudentDetails();
        } else if(msg.equals("Faculty Leave")){
            new TeacherLeave();
        } else if(msg.equals("Student Leave")){
            new StudentLeave();
        } else if(msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        } else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }// else if(msg.equals("Results")){

        // } else if(msg.equals("Upload Marks")){
            
        // } else if(msg.equals("Update Faculty Details")){
            
        // } else if(msg.equals("Update Student Details")){
            
        // } else if(msg.equals("Fee Structure")){
            
        // } else if(msg.equals("Student Fee Form")){
            
        // }
    }


    public static void main(String[] args){
        new Project();
    }
}
