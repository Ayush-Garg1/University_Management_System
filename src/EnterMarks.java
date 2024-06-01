import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class EnterMarks extends JFrame implements ActionListener{

    Choice crollnum;
    JComboBox cbsem;
    JTextField tfSub1, tfSub2, tfSub3, tfSub4, tfSub5, tfMarks1, tfMarks2, tfMarks3, tfMarks4, tfMarks5;
    JButton submit, cancel;

    EnterMarks(){
        setSize(1000, 500);
        setLocation(300, 150);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 400, 300);
        add(image);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(heading);

        JLabel lblRollNum = new JLabel("Select Roll Number");
        lblRollNum.setBounds(50, 70, 150, 20);
        add(lblRollNum);

        crollnum = new Choice();
        crollnum.setBounds(200, 70, 150, 20);
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

        JLabel lblSem = new JLabel("Select Semester");
        lblSem.setBounds(50, 110, 150, 20);
        add(lblSem);

        String[] semester = {"1", "2" , "3", "4", "5", "6", "7", "8", "9", "10"};
        cbsem = new JComboBox(semester);
        cbsem.setBounds(200, 110, 150, 20);
        cbsem.setBackground(Color.WHITE);
        add(cbsem);

        JLabel lblEnterSubject = new JLabel("Enter Subject");
        lblEnterSubject.setBounds(100, 150, 200, 40);
        add(lblEnterSubject);

        JLabel lblEnterMarks = new JLabel("Enter Marks");
        lblEnterMarks.setBounds(320, 150, 200, 40);
        add(lblEnterMarks);

        tfSub1 = new JTextField();
        tfSub1.setBounds(50, 200, 200, 20);
        add(tfSub1);

        tfSub2 = new JTextField();
        tfSub2.setBounds(50, 230, 200, 20);
        add(tfSub2);

        tfSub3 = new JTextField();
        tfSub3.setBounds(50, 260, 200, 20);
        add(tfSub3);

        tfSub4 = new JTextField();
        tfSub4.setBounds(50, 290, 200, 20);
        add(tfSub4);

        tfSub5 = new JTextField();
        tfSub5.setBounds(50, 320, 200, 20);
        add(tfSub5);

        tfMarks1 = new JTextField();
        tfMarks1.setBounds(250, 200, 200, 20);
        add(tfMarks1);

        tfMarks2 = new JTextField();
        tfMarks2.setBounds(250, 230, 200, 20);
        add(tfMarks2);
        
        tfMarks3 = new JTextField();
        tfMarks3.setBounds(250, 260, 200, 20);
        add(tfMarks3);
        
        tfMarks4 = new JTextField();
        tfMarks4.setBounds(250, 290, 200, 20);
        add(tfMarks4);

        tfMarks5 = new JTextField();
        tfMarks5.setBounds(250, 320, 200, 20);
        add(tfMarks5);

        // SUBMIT BUTTON
        submit = new JButton("Submit");
        submit.setBounds(70, 360, 150, 25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(submit);

        // CANCEL BUTTON
        cancel = new JButton("CANCEL");
        cancel.setBounds(280, 360, 150, 25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                Conn c = new Conn();
                
                String query1 = "insert into subject values(\'" + crollnum.getSelectedItem() + "\', \'" + cbsem.getSelectedItem() + "\', \'" + tfSub1.getText() + "\', \'" + tfSub2.getText() + "\', \'" + tfSub3.getText() + "\', \'" + tfSub4.getText() + "\', \'" + tfSub5.getText() + "\')";
                String query2 = "insert into marks values(\'" + crollnum.getSelectedItem() + "\', \'" + cbsem.getSelectedItem() + "\', \'" + tfMarks1.getText() + "\', \'" + tfMarks2.getText() + "\', \'" + tfMarks3.getText() + "\', \'" + tfMarks4.getText() + "\', \'" + tfMarks5.getText() + "\')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Marks inserted successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new EnterMarks();
    }
}
