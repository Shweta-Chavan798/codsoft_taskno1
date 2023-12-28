import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class second extends JFrame implements ActionListener {
    int x,y;
    JButton button1;
    JButton button3,button2;
    JTextField text;
    JLabel resultLabel,resultLabel1;
    int attempt = 0,count=0;
    int maxAttempt = 6;

    second() {

        ImageIcon image = new ImageIcon("robot1.jpg");
        JLabel label1 = new JLabel();
        label1.setIcon(image);
        label1.setBounds(25, 150, 200, 302);

        JLabel label3 = new JLabel();
        label3.setText("Guess the Number !!");
        label3.setBounds(120, 50, 300, 25);
        label3.setForeground(Color.blue);
        label3.setFont(new Font("Verdana", Font.ITALIC, 28));

        JLabel label2 = new JLabel();
        label2.setText("Enter the number (1 to 100)");
        label2.setBounds(300, 150, 280, 25);
        label2.setFont(new Font("Verdana", Font.BOLD, 16));


        text = new JTextField();
        text.setBounds(300, 200, 70, 30);
        text.setFont(new Font("Verdana", Font.BOLD, 12));

        button1 = new JButton();
        button1.setText("Guess");
        button1.setBounds(400, 200, 80, 30);
        generateRandom();
        button1.addActionListener(this);


        button2 = new JButton();
        button2.setText("EXIT");
        button2.setBounds(300, 350, 70, 30);

        button3 = new JButton();
        button3.setText("TRY AGAIN");
        button3.setBounds(400, 350, 100, 30);
        button3.addActionListener(this);

        resultLabel = new JLabel();
        resultLabel.setBounds(280, 270, 300, 30);
        resultLabel.setFont(new Font("Verdana", Font.ITALIC, 20));
        resultLabel.setForeground(Color.BLUE);

        resultLabel1 = new JLabel();
        resultLabel1.setBounds(320, 410, 300, 30);
        resultLabel1.setFont(new Font("Verdana", Font.BOLD, 24));
        resultLabel1.setForeground(Color.BLUE);


        add(label1);
        add(label2);
        add(label3);
        add(text);
        add(button1);
        add(resultLabel);
        add(button2);
        add(button3);

        add(resultLabel1);
        setTitle("Guess the Number");
        setSize(600, 550);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }

    public void generateRandom()
    {
        Random random = new Random();
        x = random.nextInt(100) + 1;
        System.out.println(x);
    }

    public void score()
    {
        if(attempt>=maxAttempt)
        {
            if(count==1)
            {
                //JOptionPane.showMessageDialog(this,"Score :100%");
                resultLabel1.setText("Score : 6");
            }
            else if(count==2)
            {
                //JOptionPane.showMessageDialog(this,"Score :50%");
                resultLabel1.setText("Score : 5");
            }
            else if(count==3)
            {
                // JOptionPane.showMessageDialog(this,"Score :25%");
                resultLabel1.setText("Score : 4");
            }
            else if(count==4)
            {
                resultLabel1.setText("Score : 3");
            }
            else if(count==5)
            {
                resultLabel1.setText("Score : 2");
            }
            else if(count==6)
            {
                resultLabel1.setText("Score : 1");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button1) {

            if (attempt >= maxAttempt) {
                resultLabel.setText("Sorry!! Try Again");
                return;
            }
            String name = text.getText();
            int y = Integer.parseInt(name);

            count++;
            if (x == y) {
                // JOptionPane.showMessageDialog(this,"Congratulations! You guessed the correct number:");
                resultLabel.setText("Congratulations! You guessed the correct number:");
                attempt=6;
                score();
            }
            else if (y > x) {
                //JOptionPane.showMessageDialog(this,"Too high! Try again.");
                resultLabel.setText("Too high! Try again.");
                //score();
            } else {
                //JOptionPane.showMessageDialog(this,"Too low! Try again.");
                resultLabel.setText("Too low! Try again.");
                //score();
            }
            attempt++;
            text.setText(null);
        }

        if(e.getSource()==button3)
        {
            attempt=0;
            generateRandom();
            text.setText(null);
        }

        if (e.getSource() == button2)
        {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION)
            {
                dispose(); // Close the JFrame
                //System.exit(0); // Terminate the application
            }
        }

    }
}


