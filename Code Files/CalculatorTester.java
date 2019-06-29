//David Jin
import javax.swing.JOptionPane;

public class CalculatorTester
{
    public static void main(String[] args)
    {
        System.out.println(Calculator.calculate(JOptionPane.showInputDialog("Enter your expression:")));
    }
}