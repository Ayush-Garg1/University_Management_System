import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.sql.*;


public class TeacherLeave extends JFrame implements ActionListener{

    Choice cempid, ctime;
    JDateChooser dcdate;
    JButton submit, cancel;

    TeacherLeave(){
        setSize(500, 550);
        setLocation(550, 100);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblempid = new JLabel("Search by Employee ID");
        lblempid.setBounds(60, 100, 200, 20);
        lblempid.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblempid);

        cempid = new Choice();
        cempid.setBounds(60, 130, 200, 20);
        add(cempid);

        try{

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");

            while(rs.next()){
                cempid.add(rs.getString("Employee ID"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 25);
        add(dcdate);

        JLabel lbltime = new JLabel("Duration");
        lbltime.setBounds(60, 260, 200, 20);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbltime);

        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        // SUBMIT BUTTON
        submit = new JButton("SUBMIT");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(submit);

        // CANCEL BUTTON
        cancel = new JButton("CANCEL");
        cancel.setBounds(200, 350, 100, 25);
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
            String empid = cempid.getSelectedItem();
            String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

            try{
                // String query = "insert into studentleave values (\'"+ rollno + "\', \'" + date + "\', \'" + duration + "'\'')";
                String query = "insert into teacherleave values(\'" + empid + "\', \'" + date + "\', \'" + duration + "\')";
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
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
        new TeacherLeave();
    }
}
