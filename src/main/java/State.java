import java.util.HashMap;

public class State {
    public static final char EPSILON = 'ε';

    private String name;
    private boolean isFinal;
    private HashMap<Character, State> transitions;

    public State(String name, boolean isFinal) {
        this.name = name;
        this.isFinal = isFinal;
        transitions = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTransition(Character key, State newState) {
        transitions.put(key, newState);
    }
}
