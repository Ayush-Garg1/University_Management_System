import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;;

public class AddTeacher extends JFrame implements ActionListener{

    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfintermediate, tfadhar;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox cbqual, cbdept;
    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddTeacher(){
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);

        JLabel heading = new JLabel("New Faculty Details");
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

        JLabel lblempid = new JLabel("Employee ID");
        lblempid.setBounds(50, 200, 200, 30);
        lblempid.setFont(new Font("serif", Font.BOLD, 25));
        add(lblempid);

        labelempid = new JLabel("101" + first4);
        labelempid.setBounds(250, 200, 200, 30);
        labelempid.setFont(new Font("serif", Font.BOLD, 25));
        add(labelempid);

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
        
        JLabel lblqual = new JLabel("Qualification");
        lblqual.setBounds(50, 400, 250, 30);
        lblqual.setFont(new Font("serif", Font.BOLD, 25));
        add(lblqual);

        String[] course = {"","Phd", "M.Tech", "B.Tech", "MCA", "BCA", "MBA", "BBA", "MSc", "BSc", "MA", "BA"};
        cbqual = new JComboBox(course);
        cbqual.setBounds(250, 400, 150, 30);
        add(cbqual);

        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(450, 400, 250, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 25));
        add(lblbranch);

        String[] branch = {"", "Computer Science", "Mechanical", "Electrical", "Electronics", "Aeronautical", "Civil", "Biotechnology", "Chemical", "IT"};
        cbdept = new JComboBox(branch);
        cbdept.setBounds(650, 400, 150, 30);
        add(cbdept);

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
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){

            String name = tfname.getText();
            String fname = tffname.getText();
            String empid = labelempid.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfintermediate.getText();
            String adhar = tfadhar.getText();
            String qual = cbqual.getSelectedItem().toString();
            String dept = cbdept.getSelectedItem().toString();


            try{
                String query = "insert into teacher values(\'" + name + "\', \'" + fname + "\', \'" + empid + "\', \'" + dob + "\', \'" + address + "\', \'" + phone + "\', \'" + email + "\', \'" + x + "\', \'" + xii + "\', \'" + adhar + "\', \'" + qual + "\', \'" + dept + "\')";

                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Faculty Datials Inserted Successfully");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }


        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }


    public static void main(String[] args){
        new AddTeacher();
    }
}
