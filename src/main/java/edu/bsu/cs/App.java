package edu.bsu.cs;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class App extends Application {
    /* This is a placeholder value for what operation will be
    performed when the enter button is pressed */
    private String operation;
    /* Placeholder value for the numbers on the display, gets updated
    every time a number button is pressed */
    private StringBuilder displayText = new StringBuilder();
    private boolean isQuaternaryView = true;
    /* This is the calculator class that will be handling all the logic
    for the calculator computations

    This class's methods are called in the equals button task */
    private final Calculator calculator = new Calculator("0");
    //Display for where the strings will be shown
    private final TextField display = new TextField();
    //Number buttons, add a single character to the display text stringBuilder
    private final Button zeroButton = new Button("0");
    private final Button oneButton = new Button("1");
    private final Button twoButton = new Button("2");
    private final Button threeButton = new Button("3");
    //The operation buttons are used to change the state of the operation placeholder
    private final Button addButton = new Button("+");
    private final Button subtractButton = new Button("-");
    private final Button multiplyButton = new Button("*");
    private final Button divideButton = new Button("/");
    private final Button squareButton = new Button("\u33A1");
    private final Button squareRootButton = new Button("\u221A");

    /*Equals button gets the operator and the display text and adds it
    to the cached number in the calculator object*/
    private final Button equalsButton = new Button("=");
    /*The clear button will clear the display text, if there is no display
    text, the clear button clears the cached number in the calculator*/
    private final Button clearButton = new Button("C");
    private final ToggleButton toDecimalButton = new ToggleButton("DECIMAL");
    private final List<String> operations = Arrays.asList("+", "-", "*", "/", "^2", "^1/2");
    private final VBox calculatorUi = new VBox();

    public App() {
        connectButtonEvents();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(setCalculatorLayout()));
        primaryStage.setTitle("Quaternary Calculator");
        styleButtons();
        display.setFont(Font.font("Segoe UI", 30));
        primaryStage.show();
    }

    //Connecting all of the buttons with the methods that they need
    private void connectButtonEvents(){
        zeroButton.setOnAction(event -> addToCalculator("0"));
        oneButton.setOnAction(event -> addToCalculator("1"));
        twoButton.setOnAction(event -> addToCalculator("2"));
        threeButton.setOnAction(event -> addToCalculator("3"));
        clearButton.setOnAction(event -> clearDisplay());
        equalsButton.setOnAction(event -> equalsTask());
        addButton.setOnAction(event -> addToCalculator("+"));
        subtractButton.setOnAction(event -> addToCalculator("-"));
        multiplyButton.setOnAction(event -> addToCalculator("*"));
        divideButton.setOnAction(event -> addToCalculator("/"));
        squareButton.setOnAction(event -> addToCalculator("^2"));
        squareRootButton.setOnAction(event -> addToCalculator("^1/2"));
        toDecimalButton.setOnAction(event -> toggleView());
    }

    private void styleButtons(){
        List<Button> numberButtons = Arrays.asList(zeroButton, oneButton, twoButton, threeButton);
        List<Button> operationButtons = Arrays.asList(addButton, subtractButton, multiplyButton, divideButton, squareButton, squareRootButton);
        List<Button> commandButtons = Arrays.asList(equalsButton, clearButton);

        for (Button button : numberButtons) {button.setStyle("-fx-background-color: ghostwhite");
        button.setFont(Font.font("Segoe UI", 20));}
        for (Button button : operationButtons) {button.setStyle("-fx-background-color: orange");
            button.setFont(Font.font("Segoe UI", 20));}
        for (Button button : commandButtons) {button.setStyle("-fx-background-color: silver");
            button.setFont(Font.font("Segoe UI", 20));}

    }

    //Creating the scene to be called in the start method
    private Parent setCalculatorLayout() {
        List<Button> buttonList1 = Arrays.asList(zeroButton, oneButton, addButton, multiplyButton);
        List<Button> buttonList2 = Arrays.asList(twoButton, threeButton, subtractButton, divideButton);
        List<Button> buttonList3 = Arrays.asList(equalsButton, clearButton, squareButton, squareRootButton);
        calculatorUi.getChildren().addAll(createToggleArea(), createDisplayArea(), createButtonRow(buttonList1), createButtonRow(buttonList2), createButtonRow(buttonList3));
        calculatorUi.setMinSize(300, 450);
        return calculatorUi;
    }


    private void addToCalculator(String value) {
        if (isQuaternaryView) {
            //check if value is operation or not
            if (operations.contains(value)) {
                operation = value;
                calculator.cacheNumber(displayText.toString());
                displayText = new StringBuilder();
            }
            else {
                displayText.append(value);
            }
            display.setText(displayText.toString());

        }
    }

    //Clear task clears the displayText
    private void clearDisplay(){
        if(isQuaternaryView) {
            //If the display text is empty clear the cached string in the Calculator
            if(!displayText.toString().equals(calculator.cache)) {
                displayText = new StringBuilder(calculator.cache);
                display.setText(displayText.toString());
            }
            else{
                displayText = new StringBuilder();
                display.setText(displayText.toString());
            }
        }

    }
    private void equalsTask(){
        if(isQuaternaryView) {
            switch (operation) {
                case "+" -> {
                    displayText = new StringBuilder(calculator.add(displayText.toString()));
                    display.setText(displayText.toString());
                }
                case "-" -> {
                    displayText = new StringBuilder(calculator.subtract(displayText.toString()));
                    display.setText(displayText.toString());
                }
                case "*" -> {
                    displayText = new StringBuilder(calculator.multiply(displayText.toString()));
                    display.setText(displayText.toString());
                }
                case "/" -> {
                    displayText = new StringBuilder(calculator.divide(displayText.toString()));
                    display.setText(displayText.toString());
                }
                case "^2" -> {
                    displayText = new StringBuilder(calculator.square());
                    display.setText(displayText.toString());
                }
                case "^1/2" -> {
                    displayText = new StringBuilder(calculator.squareRoot());
                    display.setText(displayText.toString());
                }
                default -> display.setText(displayText.toString());
            }
        }
        //Switch case will look at the value of the operation String and perform the according operation

    }
    private void toggleView() {
        isQuaternaryView = !isQuaternaryView;
        if(!displayText.isEmpty()) {
            display.setText(isQuaternaryView
                    ? calculator.converter.convertDecimalToQuaternary(Integer.parseInt(String.valueOf(displayText)))
                    : String.valueOf(calculator.converter.convertQuaternaryToDecimal(String.valueOf(displayText))));
        }
        displayText = new StringBuilder(display.getText());

    }

    private HBox createToggleArea() {
        HBox toggleHBox = new HBox();
        toggleHBox.getChildren().addAll(toDecimalButton);
        toggleHBox.setAlignment(Pos.BASELINE_RIGHT);
        return toggleHBox;
    }

    private HBox createDisplayArea() {
        //The HBox that will contain the display TextField
        HBox displayArea = new HBox();
        //Setting the height to 1/4 the height of the scene
        displayArea.prefHeightProperty().bind(calculatorUi.heightProperty().multiply(.25));
        display.setEditable(false);
        //Binding the textField to the size of the HBox
        display.prefHeightProperty().bind(displayArea.heightProperty());
        display.prefWidthProperty().bind(displayArea.widthProperty());
        displayArea.getChildren().addAll(display);
        return displayArea;
    }

    private HBox createButtonRow(List<Button> buttons) {
        HBox buttonRow = new HBox();
        //Binding the height of the HBox to 1/4 the height of the scene
        buttonRow.prefHeightProperty().bind(calculatorUi.heightProperty().multiply(.25));
        for (Button button : buttons) {
            //Setting the width of the buttons to 1/4 the width of the row (because there are 4 buttons)
            button.prefWidthProperty().bind(buttonRow.widthProperty().multiply(.25));
            //Setting the height of the buttons to the height of the row
            button.prefHeightProperty().bind(buttonRow.heightProperty());
        }
        buttonRow.getChildren().addAll(buttons);
        return buttonRow;
    }
}