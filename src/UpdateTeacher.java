import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;;

public class UpdateTeacher extends JFrame implements ActionListener{

    JTextField tfqualification, tfaddress, tfphone, tfemail, tfdept;
    JLabel labelempid;
    JButton submit, cancel;
    Choice cempid;

    UpdateTeacher(){
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);

        JLabel heading = new JLabel("Update Faculty Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 30));
        add(heading);

        JLabel lblempid = new JLabel("Select Employee ID");
        lblempid.setBounds(50, 100, 200, 20);
        lblempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempid);

        cempid = new Choice();
        cempid.setBounds(250, 100, 200, 20);
        add(cempid);

        try{

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");

            while(rs.next()){
                cempid.add(rs.getString("empid"));
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

        JLabel labelEmpId = new JLabel("Employee ID");
        labelEmpId.setBounds(50, 200, 200, 30);
        labelEmpId.setFont(new Font("serif", Font.BOLD, 25));
        add(labelEmpId);

        labelempid = new JLabel();
        labelempid.setBounds(250, 200, 200, 30);
        labelempid.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelempid);

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
        
        JLabel lblqualification = new JLabel("Qualification");
        lblqualification.setBounds(50, 400, 250, 30);
        lblqualification.setFont(new Font("serif", Font.BOLD, 25));
        add(lblqualification);

        tfqualification = new JTextField();
        tfqualification.setBounds(250, 400, 150, 30);
        add(tfqualification);

        JLabel lbldept = new JLabel("Department");
        lbldept.setBounds(450, 400, 250, 30);
        lbldept.setFont(new Font("serif", Font.BOLD, 25));
        add(lbldept);

        tfdept = new JTextField();
        tfdept.setBounds(650, 400, 150, 30);
        add(tfdept);

        try{
            Conn c = new Conn();
            String query = "select * from teacher where empid=\'"+cempid.getSelectedItem()+"\'";
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
                labelempid.setText(rs.getString("empid"));
                tfqualification.setText(rs.getString("qualification"));
                tfdept.setText(rs.getString("department"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        cempid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "select * from teacher where empid=\'"+cempid.getSelectedItem()+"\'";
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
                        labelempid.setText(rs.getString("rollno"));
                        tfqualification.setText(rs.getString("qualification"));
                        tfdept.setText(rs.getString("department"));
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
            String empid = labelempid.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String qualification = tfqualification.getText();
            String dept = tfdept.getText();


            try{
                String query = "update teacher set address=\'" + address + "\', phone=\'" + phone + "\', email=\'" + email + "\', qualification=\'" + qualification + "\', department=\'" + dept + "\' where empid=\'"+empid+"\'";

                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Faculty Datials Updated Successfully");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }


        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }


    public static void main(String[] args){
        new UpdateTeacher();
    }
}
