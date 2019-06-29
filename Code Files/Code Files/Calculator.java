//David Jin
import java.util.Stack;

public class Calculator
{
    public static double calculate(String infix)
    {
        String postfix=Postfix.toPostfix(infix);
        Stack operands=new Stack();
        do
        {
            switch(postfix.charAt(0))
            {
                case '*':
                    operands.push((double)operands.pop()*(double)operands.pop());
                    if(postfix.length()==1)
                        return (double)operands.pop();
                    postfix=postfix.substring(1);
                    break;
                case '/':
                    operands.push((double)operands.pop()/(double)operands.pop());
                    if(postfix.length()==1)
                        return (double)operands.pop();
                    postfix=postfix.substring(1);
                    break;
                case '+':
                    operands.push((double)operands.pop()+(double)operands.pop());
                    if(postfix.length()==1)
                        return (double)operands.pop();
                    postfix=postfix.substring(1);
                    break;
                case '-':
                    operands.push((double)operands.pop()-(double)operands.pop());
                    if(postfix.length()==1)
                        return (double)operands.pop();
                    postfix=postfix.substring(1);
                    break;
                default:
                    try
                    {
                        operands.push(Double.parseDouble(postfix.substring(0, postfix.indexOf(" "))));
                        postfix=postfix.substring(postfix.indexOf(" ")+1);
                    }
                    catch(Exception e)
                    {
                        int i=0;
                        String number="";
                        while(Character.isDigit(postfix.charAt(i)) || postfix.charAt(i)=='.')
                        {
                            number+=postfix.charAt(i);
                            i++;
                        }
                        postfix=postfix.substring(i);
                        operands.push(Double.parseDouble(number));
                    }
            }
        }while(postfix.length()>=1);
        return (double)operands.pop();
    }
}
/*                case '*':
                    operands.push(Double.parseDouble((String)operands.pop())*Double.parseDouble((String)operands.pop()));
                    postfix=postfix.substring(1);
                    break; 
*/