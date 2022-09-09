package edu.bsu.cs;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App extends Application {

    private final Button addButton = new Button("+");
    private final Button subtractButton = new Button("-");
    private final Button multiplyButton = new Button("*");
    private final Button divideButton = new Button("/");
    private final Button zeroButton = new Button("0");
    private final Button oneButton = new Button("1");
    private final Button twoButton = new Button("2");
    private final Button threeButton = new Button("3");
    private final Button equalButton = new Button("=");
    private final Button clearButton = new Button("C");
    private List<String> inputValuesList = new ArrayList<>();
    private int stage = 0;
    private final List<String> operations = Arrays.asList("+", "-", "*", "/", "=", "C");
    private boolean isEquals = false;
    private boolean isFinishedInt = false;
    private List<String> operatorList = new ArrayList<>();
    private List<Integer> finalValuesList = new ArrayList<>();
    private List<String> tempIntValues = new ArrayList<>();

    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(setCalculatorLayout()));
        primaryStage.setTitle("Quaternary Calculator");
        primaryStage.show();
    }

    private Parent setCalculatorLayout() {
        VBox calculatorUI = new VBox();
        GridPane calculatorGrid = new GridPane();
        calculatorGrid.add(threeButton, 0, 0);
        threeButton.setOnAction(event -> addToCalculator("3"));
        calculatorGrid.add(twoButton, 1, 0);
        twoButton.setOnAction(event -> addToCalculator("2"));
        calculatorGrid.add(oneButton, 0, 1);
        oneButton.setOnAction(event -> addToCalculator("1"));
        calculatorGrid.add(zeroButton, 1, 1);
        zeroButton.setOnAction(event -> addToCalculator("0"));
        calculatorGrid.add(multiplyButton, 2, 0);
        multiplyButton.setOnAction(event -> addToCalculator("*"));
        calculatorGrid.add(divideButton, 2, 1);
        divideButton.setOnAction(event -> addToCalculator("/"));
        calculatorGrid.add(addButton, 2, 2);
        addButton.setOnAction(event -> addToCalculator("+"));
        calculatorGrid.add(subtractButton, 2, 3);
        subtractButton.setOnAction(event -> addToCalculator("-"));
        calculatorGrid.add(equalButton, 0, 2);
        equalButton.setOnAction(event -> addToCalculator("="));
        calculatorGrid.add(clearButton, 0, 3);
        clearButton.setOnAction(event -> addToCalculator("C"));
        calculatorUI.getChildren().add(calculatorGrid);
        return calculatorUI;
    }

    private void addToCalculator(String input) {
        inputValuesList.add(input);
        String inputValuesString = String.join("", inputValuesList);
        System.out.println("Calculator screen: " + inputValuesString);

        if (input.equals("=")) {
            isEquals = true;
            isFinishedInt = true;
        } else if (input.equals("C")) {
            //clear screen
            inputValuesString = "";
            tempIntValues.clear();
            finalValuesList.clear();
        }
        if (isEquals) {
            //split up input and do operations
            int lastValue = Integer.parseInt(String.join("", tempIntValues));
            finalValuesList.add(lastValue);
            System.out.println("Finished with values list: " + finalValuesList);
            System.out.println("Finished with operator list: " + operatorList);
        } else {
            //gather input
            int value;
            try {
                isFinishedInt = isOperation(input);
                if (isFinishedInt) {
                    isFinishedInt = false;
                    operatorList.add(input);
                    if (tempIntValues.size() > 0) {
                        value = Integer.parseInt(String.join("", tempIntValues));
                        tempIntValues.clear();
                    }
                    else {
                        value = !inputValuesString.isEmpty() ? Integer.parseInt(inputValuesString) : 0;
                    }
                    finalValuesList.add(value);

                } else {
                    value = Integer.parseInt(input);
                    tempIntValues.add(String.valueOf(value));
                }
            } catch (NumberFormatException exception) {
                System.err.println(exception.getMessage());
            }
        }

    }
    private boolean isOperation(String value) {
        return operations.contains(value);
    }
}

