import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField tf;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    JButton add,sub,mul,div,eq,clr;

    double num1, num2, result;
    char operator;

    Calculator() {

        setTitle("Swing Calculator");
        setSize(300,400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TextField
        tf = new JTextField();
        tf.setFont(new Font("Arial", Font.BOLD, 20));
        add(tf, BorderLayout.NORTH);

        // Panel for buttons
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5,4,5,5));

        // Buttons
        b1=new JButton("1");
        b2=new JButton("2");
        b3=new JButton("3");
        add=new JButton("+");

        b4=new JButton("4");
        b5=new JButton("5");
        b6=new JButton("6");
        sub=new JButton("-");

        b7=new JButton("7");
        b8=new JButton("8");
        b9=new JButton("9");
        mul=new JButton("*");

        b0=new JButton("0");
        clr=new JButton("C");
        eq=new JButton("=");
        div=new JButton("/");

        // Add buttons to panel
        p.add(b1); p.add(b2); p.add(b3); p.add(add);
        p.add(b4); p.add(b5); p.add(b6); p.add(sub);
        p.add(b7); p.add(b8); p.add(b9); p.add(mul);
        p.add(b0); p.add(clr); p.add(eq); p.add(div);

        add(p, BorderLayout.CENTER);

        // Action Listener
        JButton[] buttons = {b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,
                             add,sub,mul,div,eq,clr};

        for(JButton b : buttons)
            b.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        // Numbers
        if(cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') {
            tf.setText(tf.getText() + cmd);
        }

        // Clear
        else if(cmd.equals("C")) {
            tf.setText("");
        }

        // Operators
        else if(cmd.equals("+") || cmd.equals("-") ||
                cmd.equals("*") || cmd.equals("/")) {

            num1 = Double.parseDouble(tf.getText());
            operator = cmd.charAt(0);
            tf.setText("");
        }

        // Equals
        else if(cmd.equals("=")) {

            num2 = Double.parseDouble(tf.getText());

            switch(operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }

            tf.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}