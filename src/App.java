import java.awt.*;
import javax.swing.*;

public class App extends JFrame implements Runnable{

    Thread t;
    App(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        t = new Thread(this);
        t.start();

        setVisible(true);

        // int x = 1;
        // for(int i = 0; i <= 1000; i+=2, x++){
            // setLocation(750-i/2, 570-(i/2));
            // setSize(i, i-300);
            // try{
            //     Thread.sleep(0);
            // }catch(Exception e){}
        // }

        setLocation(250, 70);
        setSize(1000, 700);
    }


    public void run(){
        try{
            Thread.sleep(5000);
            setVisible(false);

            new Login();
        }catch(Exception e){

        }
    }


    public static void main(String[] args){
        new App();

    }
}