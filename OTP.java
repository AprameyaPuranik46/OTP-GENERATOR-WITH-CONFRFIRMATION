import java.util.Random;
import java.awt.event.*;
import javax.swing.*;

public class OTP {
    public static void main(String[] args) {
        int otplen = 4;
        String otp = generateOTP(otplen);
        System.out.println("Generated OTP: " + otp);

        JFrame f = new JFrame();
        f.setSize(300, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
        
        JLabel l1 = new JLabel("Generated OTP:");
        l1.setBounds(10, 10, 120, 20); 

        JLabel l2 = new JLabel(otp);
        l2.setBounds(140, 10, 120, 20); 

        JTextField t = new JTextField();
        t.setBounds(10, 50, 100, 30);

        JButton b = new JButton("Verify");
        b.setBounds(120, 50, 120, 30);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userInput = t.getText();
                if (userInput.equals(otp)) {
                    JOptionPane.showMessageDialog(f, "OTP Verified!");
                } else {
                    JOptionPane.showMessageDialog(f, "OTP Verification Failed!");
                }
            }
        });

        f.add(l1);
        f.add(l2);
        f.add(t);
        f.add(b);
    }

    public static String generateOTP(int len) {
        String numbers = "0123456789";
        Random rndm_method = new Random();
        char[] otp = new char[len];

        for (int i = 0; i < len; i++) {
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
        }

        return new String(otp);
    }
}