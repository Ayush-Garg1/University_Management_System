import java.awt.*;
import javax.swing.*;

public class App extends JFrame implements Runnable{

    Thread t;
    App(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.png"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        t = new Thread(this);
        t.start();

        setVisible(true);

        setLocation(250, 70);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void run(){
        try{
            Thread.sleep(5000);
            setVisible(false);

            new Login();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        new App();
    }
}