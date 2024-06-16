import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login = new JButton("Login");
    JButton cancel = new JButton("Cancel");
    JTextField tfusername, tfpassword;
    Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        // USERNAME
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);


        // PASSWORD
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 20);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);


        // LOGIN BUTTON
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(login);

        // CANCEL BUTTON
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(cancel);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);


        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String username = tfusername.getText();
            String password = tfpassword.getText();

            String query = "select * from login where username=\'" + username + "\' and password=\'" + password + "\'";

            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new Project();
                }else{
                    JOptionPane.showMessageDialog(null, "😡Invalid username or password");
                    setVisible(false);
                    System.exit(0);
                }
                c.s.close();
            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == cancel){
            setVisible(false);
            System.exit(0);
        }
    }


    public static void main(String[] args){
        new Login();
    }
}
