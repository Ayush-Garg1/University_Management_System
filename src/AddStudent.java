import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;;

public class AddStudent extends JFrame implements ActionListener{

    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfintermediate, tfadhar;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox cbcource, cbbranch;
    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent(){
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 25));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(250, 150, 150, 30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(450, 150, 250, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 25));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(650, 150, 150, 30);
        add(tffname);

        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 25));
        add(lblrollno);

        labelrollno = new JLabel("1533" + first4);
        labelrollno.setBounds(250, 200, 200, 30);
        labelrollno.setFont(new Font("serif", Font.BOLD, 25));
        add(labelrollno);

        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(450, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 25));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(650, 200, 150, 30);
        add(dcdob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 250, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 25));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(250, 250, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(450, 250, 250, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 25));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(650, 250, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50, 300, 250, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 25));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(250, 300, 150, 30);
        add(tfemail);

        JLabel lblx = new JLabel("High School (%)");
        lblx.setBounds(450, 300, 250, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 25));
        add(lblx);

        tfx = new JTextField();
        tfx.setBounds(650, 300, 150, 30);
        add(tfx);

        JLabel lblintermediate = new JLabel("Intermediate (%)");
        lblintermediate.setBounds(50, 350, 250, 30);
        lblintermediate.setFont(new Font("serif", Font.BOLD, 25));
        add(lblintermediate);

        tfintermediate = new JTextField();
        tfintermediate.setBounds(250, 350, 150, 30);
        add(tfintermediate);

        JLabel lbladhar = new JLabel("Adhaar Number");
        lbladhar.setBounds(450, 350, 250, 30);
        lbladhar.setFont(new Font("serif", Font.BOLD, 25));
        add(lbladhar);

        tfadhar = new JTextField();
        tfadhar.setBounds(650, 350, 150, 30);
        add(tfadhar);
        
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 400, 250, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 25));
        add(lblcourse);

        String[] course = {"", "B.Tech", "BCA", "MCA", "BBA", "MBA", "BSc", "MSc", "BA"};
        cbcource = new JComboBox(course);
        cbcource.setBounds(250, 400, 150, 30);
        add(cbcource);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(450, 400, 250, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 25));
        add(lblbranch);

        String[] branch = {"", "Computer Science", "Mechanical", "Electrical", "Electronics", "Aeronautical", "Civil", "Biotechnology", "Chemical", "IT"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(650, 400, 150, 30);
        add(cbbranch);

        // SUBMIT BUTTON
        submit = new JButton("SUBMIT");
        submit.setBounds(250, 500, 150, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(submit);

        // CANCEL BUTTON
        cancel = new JButton("CANCEL");
        cancel.setBounds(450, 500, 150, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(cancel);
    
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){

            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelrollno.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfintermediate.getText();
            String adhar = tfadhar.getText();
            String course = cbcource.getSelectedItem().toString();
            String branch = cbbranch.getSelectedItem().toString();


            try{
                String query = "insert into student values(\'" + name + "\', \'" + fname + "\', \'" + rollno + "\', \'" + dob + "\', \'" + address + "\', \'" + phone + "\', \'" + email + "\', \'" + x + "\', \'" + xii + "\', \'" + adhar + "\', \'" + course + "\', \'" + branch + "\')";

                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Student Datials Inserted Successfully");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }


        }else if(ae.getSource() == cancel){
            setVisible(false);
            // System.exit(0);
        }
    }


    public static void main(String[] args){
        new AddStudent();
    }
}
