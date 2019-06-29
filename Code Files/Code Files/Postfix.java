//David Jin
import java.util.Stack;

public class Postfix
{
    public static String toPostfix(String infix)
    {
        String postfix="";
        Stack operators=new Stack();
        int i=0;
        while(i<infix.length())
        {
            if(Character.isDigit(infix.charAt(i)))
            {
                while(i<infix.length() && (Character.isDigit(infix.charAt(i)) || infix.charAt(i)=='.'))
                {
                    postfix+=infix.charAt(i);
                    i++;
                }
                postfix+=" ";
                continue;
            }
            switch(infix.charAt(i))
            {
                case '(' :
                case '[' :
                case '{' :
                    operators.push(infix.charAt(i));
                    break;
                case '*' :
                case '/' :
                    while(!operators.isEmpty() && (operators.peek().equals('*') || operators.peek().equals('/')))
                        postfix+=operators.pop();
                    operators.push(infix.charAt(i));
                    break;
                case '+' :
                case '-' :
                    while(!operators.isEmpty() && !operators.peek().equals('(') && !operators.peek().equals('[') && !operators.peek().equals('{'))
                        postfix+=operators.pop();
                    operators.push(infix.charAt(i));                
                    break;
                case ')' :
                    while(!operators.peek().equals('('))
                        postfix+=operators.pop();
                    operators.pop();
                    break;
                case ']' :
                    while(!operators.peek().equals('['))
                        postfix+=operators.pop();
                    operators.pop();
                    break;
                case '}' :
                    while(!operators.peek().equals('{'))
                        postfix+=operators.pop();
                    operators.pop();
                    break;                
            }
            i++;
        }
        while(!operators.isEmpty())
            postfix+=operators.pop();
        return postfix;
    }
}