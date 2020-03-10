public class NonDeterministicAutomaton {
    private String expression;
    private String prefixExpression;

    public NonDeterministicAutomaton(String expression) {
        this.expression = expression;
        this.prefixExpression = Utils.infixToPrefix(expression);
    }
}
