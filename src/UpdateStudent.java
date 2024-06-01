import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class UpdateStudent extends JFrame implements ActionListener{

    JTextField tfcourse, tfaddress, tfphone, tfemail, tfbranch;
    JLabel labelrollno;
    JButton submit, cancel;
    Choice crollnum;

    UpdateStudent(){
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 30));
        add(heading);

        JLabel lblRollNum = new JLabel("Select Roll Number");
        lblRollNum.setBounds(50, 100, 200, 20);
        lblRollNum.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblRollNum);

        crollnum = new Choice();
        crollnum.setBounds(250, 100, 200, 20);
        add(crollnum);

        try{

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");

            while(rs.next()){
                crollnum.add(rs.getString("rollno"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 25));
        add(lblname);

        JLabel labelName = new JLabel();
        labelName.setBounds(250, 150, 150, 30);
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelName);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(450, 150, 250, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 25));
        add(lblfname);

        JLabel lblFname = new JLabel();
        lblFname.setBounds(650, 150, 150, 30);
        lblFname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblFname);

        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 25));
        add(lblrollno);

        labelrollno = new JLabel();
        labelrollno.setBounds(250, 200, 200, 30);
        labelrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelrollno);

        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(450, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 25));
        add(lbldob);

        JLabel labeldob = new JLabel();
        labeldob.setBounds(650, 200, 150, 30);
        labeldob.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labeldob);

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

        JLabel labelx = new JLabel();
        labelx.setBounds(650, 300, 150, 30);
        labelx.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelx);

        JLabel lblintermediate = new JLabel("Intermediate (%)");
        lblintermediate.setBounds(50, 350, 250, 30);
        lblintermediate.setFont(new Font("serif", Font.BOLD, 25));
        add(lblintermediate);

        JLabel lblxii = new JLabel ();
        lblxii.setBounds(250, 350, 150, 30);
        lblxii.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblxii);

        JLabel lbladhar = new JLabel("Adhaar Number");
        lbladhar.setBounds(450, 350, 250, 30);
        lbladhar.setFont(new Font("serif", Font.BOLD, 25));
        add(lbladhar);

        JLabel labelAdhaar = new JLabel();
        labelAdhaar.setBounds(650, 350, 150, 30);
        labelAdhaar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelAdhaar);
        
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 400, 250, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 25));
        add(lblcourse);

        tfcourse = new JTextField();
        tfcourse.setBounds(250, 400, 150, 30);
        add(tfcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(450, 400, 250, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 25));
        add(lblbranch);

        tfbranch = new JTextField();
        tfbranch.setBounds(650, 400, 150, 30);
        add(tfbranch);

        try{
            Conn c = new Conn();
            String query = "select * from student where rollno=\'"+crollnum.getSelectedItem()+"\'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelName.setText(rs.getString("name"));
                lblFname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("class_x"));
                lblxii.setText(rs.getString("class_xii"));
                labelAdhaar.setText(rs.getString("adhaar"));
                labelrollno.setText(rs.getString("rollno"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        crollnum.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "select * from student where rollno=\'"+crollnum.getSelectedItem()+"\'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        labelName.setText(rs.getString("name"));
                        lblFname.setText(rs.getString("fname"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelx.setText(rs.getString("class_x"));
                        lblxii.setText(rs.getString("class_xii"));
                        labelAdhaar.setText(rs.getString("adhaar"));
                        labelrollno.setText(rs.getString("rollno"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

         // SUBMIT BUTTON
         submit = new JButton("Update");
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
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String rollno = labelrollno.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course = tfcourse.getText();
            String branch = tfbranch.getText();


            try{
                String query = "update student set address=\'" + address + "\', phone=\'" + phone + "\', email=\'" + email + "\', course=\'" + course + "\', branch=\'" + branch + "\' where rollno=\'"+rollno+"\'";

                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Student Datials Updated Successfully");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }


        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }


    public static void main(String[] args){
        new UpdateStudent();
    }
}
