/** Develop applet to find factorial of the given number */
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*<applet code="FactorialApplet" width=500 height=250>
</applet>*/
public class FactorialApplet extends Applet implements ActionListener {
    Label L1,L2;
    TextField T1,T2;
    Button B1;
    public void init() {
        L1=new Label("Enter any Number : ");
        add(L1);
        T1=new TextField(10);
        add(T1);
        L2=new Label("Factorial of Num : ");
        add(L2);
        T2=new TextField(10);
        add(T2);
        B1=new Button("Compute");
        add(B1);
        B1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==B1)
        {
        int value=Integer.parseInt(T1.getText());
        int fact=factorial(value);
        T2.setText(String.valueOf(fact));
        }
    }
    int factorial(int n) {    
        if(n==0)
            return 1;
        else
            return n*factorial(n-1);
    }
}
