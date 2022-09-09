package pExceptions;

import javax.swing.JFormattedTextField;
import javax.swing.text.JTextComponent;

public class EmptyFieldException extends IllegalArgumentException {
    public EmptyFieldException() {
        super("O campo não deve estar vazio.");
    }

    public EmptyFieldException(String s) {
        super(s);
    }

    public static String getEmptyMessage(String componentName) {
        if (componentName.contains(" e "))
            return "Os campos " + componentName + " não devem estar vazios.";
        else
            return "O campo " + componentName + " não deve estar vazio.";
    }

    public static void checkComponent(JTextComponent component) {
        checkComponent(component, component.getName());
    }
    
    public static void checkComponent(JTextComponent component, String componentName) {
        if (!component.getText().trim().isEmpty())
            return;
        
        component.requestFocus();
        throw new EmptyFieldException(getEmptyMessage(componentName));
    }

    public static boolean isEmpty(JTextComponent component) {
        return component.getText().trim().isEmpty();
    }

    public static void checkDuracao(JFormattedTextField component) {
        if (!component.getText().matches("^\\s*:\\s*$"))
            return;

        component.requestFocus();
        throw new EmptyFieldException(getEmptyMessage("duração"));
    }

    public static void checkDataPub(JFormattedTextField component) {
        if (!component.getText().matches("^\\s*[-/]\\s*[-/]\\s*$"))
            return;

        component.requestFocus();
        throw new EmptyFieldException(getEmptyMessage("data de publicação"));
    }
}