package views;

public enum InputAction {
    SELECT(">"),
    DELIVER("+"),
    EXIT("!"),
    SHOW_ALL(">>");

    final private String value;

    InputAction(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static InputAction fromString(String text) throws InputException {
        for (InputAction action : InputAction.values()) {
            if (action.toString().equalsIgnoreCase(text)) {
                return action;
            }
        }
        throw new InputException();
    }
}
