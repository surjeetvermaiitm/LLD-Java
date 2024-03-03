package DesignPattern.InterpreterDesignPattern;

public class MainExpression {
    public static void main(String[] args) {
        //initialize the context

        Context context =new Context();
        context.put("a",2);
        context.put("b",6);

        AbstractExpression expression1=new MultiplyNonTerminalExpression(new NumberTerminalExpression("a"),new NumberTerminalExpression("b"));

        System.out.println(expression1.interpret(context));
    }
}
