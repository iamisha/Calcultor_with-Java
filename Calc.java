
/* import java.awt.*;
 * import javax.swing.*;
 * import java.awt.event.*;
 */

//trying to make the code more comprehensible using branches of packages...
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

class Calc {

    // declaration
    JFrame fr;
    JTextField text_first, text_second, text_res;
    JButton btn_add, btn_subs, btn_mult, btn_div, btn_mod, btn_pow;

    public Calc() {

        fr = new JFrame("Sweet-Calculator");
        fr.setSize(400, 600);

        text_first = new JTextField("Enter your fist num...");
        text_second = new JTextField("Enter your second num...");
        text_res = new JTextField();

        text_first.setBounds(80, 100, 240, 50);
        fr.add(text_first);
        text_second.setBounds(80, 180, 240, 50);
        fr.add(text_second);
        text_res.setBounds(150, 260, 100, 50);
        fr.add(text_res);

        btn_add = new JButton("+");
        btn_add.setBounds(20, 400, 120, 60);
        btn_add.setForeground(Color.CYAN);
        btn_add.setBackground(Color.BLACK);
        fr.add(btn_add);

        btn_subs = new JButton("-");
        btn_subs.setBounds(140, 400, 120, 60);
        btn_subs.setForeground(Color.CYAN);
        btn_subs.setBackground(Color.BLACK);
        fr.add(btn_subs);

        btn_mult = new JButton("x");
        btn_mult.setBounds(260, 400, 120, 60);
        btn_mult.setForeground(Color.CYAN);
        btn_mult.setBackground(Color.BLACK);
        fr.add(btn_mult);

        btn_div = new JButton("/");
        btn_div.setBounds(20, 450, 120, 60);
        btn_div.setForeground(Color.RED);
        btn_div.setBackground(Color.GRAY);
        fr.add(btn_div);

        btn_mod = new JButton("%");
        btn_mod.setBounds(140, 450, 120, 60);
        btn_mod.setForeground(Color.RED);
        btn_mod.setBackground(Color.ORANGE);
        fr.add(btn_mod);

        btn_pow = new JButton("^");
        btn_pow.setBounds(260, 450, 120, 60);
        btn_pow.setForeground(Color.RED);
        btn_pow.setBackground(Color.GRAY);
        fr.add(btn_pow);

        // connecting the class Controller with class Calc()...
        Controller crl = new Controller(this);
        btn_add.addActionListener(crl);
        btn_subs.addActionListener(crl);
        btn_mult.addActionListener(crl);
        btn_div.addActionListener(crl);
        btn_mod.addActionListener(crl);
        btn_pow.addActionListener(crl);

        fr.getContentPane().setBackground(Color.WHITE);
        Font font = new Font("arial", Font.BOLD, 14);
        text_res.setFont(font);

        fr.setLayout(null);
        fr.setVisible((true));
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Calc();
    }

}

class Controller implements ActionListener {
    Calc calc; // creating the object of the class Calc()...provides all the property of the
               // class Calc()...

    public Controller(Calc calc) {
        this.calc = calc;
    }

    public void actionPerformed(ActionEvent e) {

        int num_f = Integer.parseInt(calc.text_first.getText());
        int num_s = Integer.parseInt(calc.text_second.getText());

        Object source = e.getSource();
        if (source == calc.btn_add) {

            int ans = num_f + num_s;
            calc.text_res.setText("" + ans);
        } else if (source == calc.btn_subs) {
            int ans = num_f - num_s;
            calc.text_res.setText("" + ans);
        } else if (source == calc.btn_mult) {
            int ans = num_f * num_s;
            calc.text_res.setText("" + ans);
        } else if (source == calc.btn_div) {
            int ans = num_f / num_s;
            calc.text_res.setText("" + ans);
        } else if (source == calc.btn_mod) {
            int rem = num_f % num_s;
            calc.text_res.setText(rem + "");
        } else if (source == calc.btn_pow) {
            double ans = Math.pow(num_f, num_s);
            calc.text_res.setText("" + ans);
        }

    }
}
