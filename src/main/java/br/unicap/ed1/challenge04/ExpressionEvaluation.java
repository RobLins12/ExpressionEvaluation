package br.unicap.ed1.challenge04;

public class ExpressionEvaluation<Value>{

    private String [] expression;

    public ExpressionEvaluation(String [] expression){
        this.expression = expression;
    }

    public boolean isOpen(String v){
        return v == "(" || v == "[" || v == "{";
    }

    public boolean isOp(String v){
        return v == "+" || v == "-" || v == "*" || v == "/" || v == "sqrt";
    }

    public boolean isClosed(String v){
        return v == ")" || v == "}" || v == "]";
    }

    public boolean isNum(String v){
        return !isClosed(v) && !isOp(v) && !isOpen(v);
    }


    public Double evaluate(){
        StackCircularLinkedList<String> stackString = new StackCircularLinkedList<>();
        StackCircularLinkedList<Double> stackDouble = new StackCircularLinkedList<>();
        
        for (String v: expression) {
            if (isOp(v)) {
                stackString.push(v);
            }
            if(isNum(v)){
                Double d = Double.parseDouble(v);
                stackDouble.push(d);
            }   
            else if (isClosed(v)) {
                try {
                    Double number2 = 0.0;
                    Double number1 = stackDouble.pop();
                    if(!stackDouble.isEmpty()){
                        number2 = stackDouble.pop();
                    }
                    String lastString = stackString.pop();
                    if (lastString == "+") {
                        stackDouble.push(number2 + number1);
                    }
                    if (lastString == "-") {
                        stackDouble.push(number2 - number1);
                    }
                    if (lastString == "*") {
                        stackDouble.push(number2 * number1);
                    }
                    if (lastString == "/") {
                        stackDouble.push(number2 / number1);
                    }
                    if(lastString == "sqrt"){
                        stackDouble.push(Math.sqrt(number1));
                    }
                } catch (Exception e) {
                }
            }
        }
        return stackDouble.pop();
    }
}
