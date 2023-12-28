import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Demo extends JFrame implements ActionListener
{
    JButton button;
    Demo()
    {
        ImageIcon img=new ImageIcon("finalgame.jpg");

        JLabel label=new JLabel();
        label.setIcon(img);
        label.setBackground(Color.white);
        label.setOpaque(true);
        // label.setBounds(0,0,460,330);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        button=new JButton();
        button.setText("LET'S PLAY");
        button.setBounds(500,290,150,30);
        button.addActionListener(this);
        button.setFont(new Font("Verdana",Font.PLAIN,16));
        button.setBackground(Color.blue);
        button.setForeground(Color.white);

        setTitle("Let's Play");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setSize(460,330);
        // setLayout(null);
        setResizable(false);
        //   add(button);
        add(label);
        pack();
        setLayout(null);
        this.add(button);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button)
        {
            second obj=new second();
            dispose();
        }
    }
}

public class first {
    public static void main(String[] args)
    {
        Demo demo =new Demo();
    }
}
