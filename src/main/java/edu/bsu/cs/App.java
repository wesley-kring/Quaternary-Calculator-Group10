package edu.bsu.cs;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ToggleButton;

public class App extends Application {
    /* This is a placeholder value for what operation will be
    performed when the enter button is pressed */
    private String operaton;
    /* Placeholder value for the numbers on the display, gets updated
    every time a number button is pressed */
    private StringBuilder displayText = new StringBuilder();
    /* This is the calculator class that will be handling all the logic
    for the calculator computations

    This class's methods are called in the equals button task */
    private final Calculator calculator = new Calculator("0");
    //Display for where the strings will be shown
    private final TextField display = new TextField();
    //Number buttons, add a single character to the display text stringBuilder
    private final Button zero = new Button("0");
    private final Button one = new Button("1");
    private final Button two = new Button("2");
    private final Button three = new Button("3");
    //The operation buttons are used to change the state of the operation placeholder
    private final Button add = new Button("+");
    private final Button subtract = new Button("-");
    private final Button multiply = new Button("*");
    private final Button divide = new Button("/");
    private final Button square = new Button("\u33A1");
    private final Button squareRoot = new Button("\u221A");
    private final ToggleButton decimal = new ToggleButton("decimal");


    /*Equals button gets the operator and the display text and adds it
    to the cached number in the calculator object*/
    private final Button equals = new Button("=");
    /*The clear button will clear the display text, if there is no display
    text, the clear button clears the cached number in the calculator*/
    private final Button clear = new Button("C");

    public App() {
        connectButtonEvents();
    }

    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(setCalculatorLayout()));
        primaryStage.setTitle("Quaternary Calculator");
        primaryStage.show();
    }

    //Connecting all of the buttons with the methods that they need
    private void connectButtonEvents(){
        zero.setOnAction(event -> zeroTask());
        one.setOnAction(event -> oneTask());
        two.setOnAction(event -> twoTask());
        three.setOnAction(event -> threeTask());
        clear.setOnAction(event -> clearTask());
        equals.setOnAction(event -> equalsTask());
        add.setOnAction(event -> addTask());
        subtract.setOnAction(event -> subtractTask());
        multiply.setOnAction(event -> multiplyTask());
        divide.setOnAction(event -> divideTask());
        square.setOnAction(event -> squareTask());
        squareRoot.setOnAction(event -> squareRootTask());
        ///decimal.setOnAction(event -> decimalTask());
    }

    //Creating the scene to be called in the start method
    private Parent setCalculatorLayout() {
        //The VBox that will contain all of the elements of the scene
        VBox calculatorUi = new VBox();

        //The HBox that will contain the display TextField
        HBox displayArea = new HBox();
        //Setting the height to 1/4 the height of the scene
        displayArea.prefHeightProperty().bind(calculatorUi.heightProperty().multiply(.25));
        display.setEditable(false);
        //Binding the textField to the size of the HBox
        display.prefHeightProperty().bind(displayArea.heightProperty());
        display.prefWidthProperty().bind(displayArea.widthProperty().multiply(.75));
        decimal.prefHeightProperty().bind(displayArea.heightProperty());
        decimal.prefWidthProperty().bind(displayArea.widthProperty().multiply(.25));
        displayArea.getChildren().addAll(display, decimal);

        HBox buttonRowOne = new HBox();
        //Binding the height of the HBox to 1/4 the height of the scene
        buttonRowOne.prefHeightProperty().bind(calculatorUi.heightProperty().multiply(.25));
        buttonRowOne.getChildren().addAll(zero, one, add, multiply);
        //Setting the width of the buttons to 1/4 the width of the row (because there are 4 buttons)
        zero.prefWidthProperty().bind(buttonRowOne.widthProperty().multiply(.25));
        one.prefWidthProperty().bind(buttonRowOne.widthProperty().multiply(.25));
        add.prefWidthProperty().bind(buttonRowOne.widthProperty().multiply(.25));
        multiply.prefWidthProperty().bind(buttonRowOne.widthProperty().multiply(.25));
        //Setting the height of the buttons to the height of the row
        zero.prefHeightProperty().bind(buttonRowOne.heightProperty());
        one.prefHeightProperty().bind(buttonRowOne.heightProperty());
        add.prefHeightProperty().bind(buttonRowOne.heightProperty());
        multiply.prefHeightProperty().bind(buttonRowOne.heightProperty());

        HBox buttonRowTwo = new HBox();
        //Binding the height of the HBox to 1/4 the height of the scene
        buttonRowTwo.prefHeightProperty().bind(calculatorUi.heightProperty().multiply(.25));
        buttonRowTwo.getChildren().addAll(two, three, subtract, divide);
        //Setting the width of the buttons to 1/4 the width of the row (because there are 4 buttons)
        two.prefWidthProperty().bind(buttonRowTwo.widthProperty().multiply(.25));
        three.prefWidthProperty().bind(buttonRowTwo.widthProperty().multiply(.25));
        subtract.prefWidthProperty().bind(buttonRowTwo.widthProperty().multiply(.25));
        divide.prefWidthProperty().bind(buttonRowTwo.widthProperty().multiply(.25));
        //Setting the height of the buttons to the height of the row
        two.prefHeightProperty().bind(buttonRowTwo.heightProperty());
        three.prefHeightProperty().bind(buttonRowTwo.heightProperty());
        subtract.prefHeightProperty().bind(buttonRowTwo.heightProperty());
        divide.prefHeightProperty().bind(buttonRowTwo.heightProperty());

        HBox buttonRowThree = new HBox();
        //Binding the height of the HBox to 1/4 the height of the scene
        buttonRowThree.prefHeightProperty().bind(calculatorUi.heightProperty().multiply(.25));
        buttonRowThree.getChildren().addAll(equals, clear, square, squareRoot);
        //Setting the width of the buttons to 1/4 the width of the row (because there are 4 buttons)
        equals.prefWidthProperty().bind(buttonRowThree.widthProperty().multiply(.25));
        clear.prefWidthProperty().bind(buttonRowThree.widthProperty().multiply(.25));
        square.prefWidthProperty().bind(buttonRowThree.widthProperty().multiply(.25));
        squareRoot.prefWidthProperty().bind(buttonRowThree.widthProperty().multiply(.25));
        //Setting the height of the buttons to the height of the row
        equals.prefHeightProperty().bind(buttonRowThree.heightProperty());
        clear.prefHeightProperty().bind(buttonRowThree.heightProperty());
        square.prefHeightProperty().bind(buttonRowThree.heightProperty());
        squareRoot.prefHeightProperty().bind(buttonRowThree.heightProperty());

        //Adding all rows to the scene
        calculatorUi.getChildren().addAll(displayArea, buttonRowOne, buttonRowTwo, buttonRowThree);
        calculatorUi.setMinSize(300, 400);
        return calculatorUi;
    }

    //Creating the tasks for all the buttons
    //Number buttons add a digit to the end of the displayText StringBuilder
    private void zeroTask(){
        displayText.append("0");
        display.setText(displayText.toString());
    }
    private void oneTask(){
        displayText.append("1");
        display.setText(displayText.toString());
    }
    private void twoTask(){
        displayText.append("2");
        display.setText(displayText.toString());
    }
    private void threeTask(){
        displayText.append("3");
        display.setText(displayText.toString());
    }
    //Operator buttons change the status of the operator string to their respective operation
    private void addTask(){
        operaton = "+";
        calculator.cacheNumber(displayText.toString());
        displayText = new StringBuilder();
        display.setText(displayText.toString());
    }
    private void subtractTask(){
        operaton = "-";
        calculator.cacheNumber(displayText.toString());
        displayText = new StringBuilder();
        display.setText(displayText.toString());
    }
    private void multiplyTask(){
        operaton = "*";
        calculator.cacheNumber(displayText.toString());
        displayText = new StringBuilder();
        display.setText(displayText.toString());
    }
    private void divideTask(){
        operaton = "/";
        calculator.cacheNumber(displayText.toString());
        displayText = new StringBuilder();
        display.setText(displayText.toString());
    }
    private void squareTask(){
        operaton = "^2";
        calculator.cacheNumber(displayText.toString());
        displayText = new StringBuilder(calculator.square());
        display.setText(displayText.toString());
    }
    private void squareRootTask(){
        operaton = "^1/2";
        calculator.cacheNumber(displayText.toString());
        displayText = new StringBuilder(calculator.squareRoot());
        display.setText(displayText.toString());
    }
    //Clear task clears the displayText
    private void clearTask(){
        //If the display text is empty clear the cached string in the Calculator
        if(displayText.toString().equals("")) {
            calculator.cacheNumber(displayText.toString());
        }
        displayText = new StringBuilder();
        display.setText(displayText.toString());
    }
    private void equalsTask(){
        //Switch case will look at the value of the operation String and perform the according operation
        switch (operaton) {
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
}