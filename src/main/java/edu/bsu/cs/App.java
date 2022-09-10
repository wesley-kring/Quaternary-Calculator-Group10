package edu.bsu.cs;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    private StringBuilder displayText = new StringBuilder();
    private Calculator calculator = new Calculator("0");
    private final TextField display = new TextField();
    private final Button zero = new Button("0");
    private final Button one = new Button("1");
    private final Button two = new Button("2");
    private final Button three = new Button("3");
    private final Button clear = new Button("C");
    private final Button equals = new Button("=");
    ToggleGroup operations = new ToggleGroup();
    private final ToggleButton add = new ToggleButton("+");
    private final ToggleButton subtract = new ToggleButton("-");
    private final ToggleButton multiply = new ToggleButton("*");
    private final ToggleButton divide = new ToggleButton("/");
    private final ToggleButton square = new ToggleButton("x²");
    private final ToggleButton squareRoot = new ToggleButton("√");



    public App() {
        setButtonEvents();
    }

    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(setCalculatorLayout()));
        primaryStage.setTitle("Quaternary Calculator");
        addToggleGroup();
        primaryStage.show();
    }

    public void addToggleGroup(){
        add.setSelected(true);
        add.setUserData("+");
        add.setToggleGroup(operations);
        subtract.setUserData("-");
        subtract.setToggleGroup(operations);
        multiply.setUserData("*");
        multiply.setToggleGroup(operations);
        divide.setUserData("/");
        divide.setToggleGroup(operations);
        square.setUserData("^2");
        square.setToggleGroup(operations);
        squareRoot.setUserData("^1/2");
        squareRoot.setToggleGroup(operations);
    }

    private void setButtonEvents(){
        zero.setOnAction(event -> zeroTask());
        one.setOnAction(event -> oneTask());
        two.setOnAction(event -> twoTask());
        three.setOnAction(event -> threeTask());
        clear.setOnAction(event -> clearTask());
    }

    private Parent setCalculatorLayout() {
        VBox calculatorUI = new VBox(50);
        HBox displayArea = new HBox();
        display.setEditable(false);
        displayArea.getChildren().add(display);
        HBox buttonRowOne = new HBox();
        buttonRowOne.setFillHeight(true);
        buttonRowOne.getChildren().addAll(zero, one, add, multiply);
        HBox buttonRowTwo = new HBox();
        buttonRowTwo.setFillHeight(true);
        buttonRowTwo.getChildren().addAll(two, three, subtract, divide);
        HBox buttonRowThree = new HBox();
        buttonRowThree.setFillHeight(true);
        buttonRowThree.getChildren().addAll(equals, clear, square, squareRoot);
        calculatorUI.getChildren().addAll(displayArea, buttonRowOne, buttonRowTwo, buttonRowThree);
        return calculatorUI;
    }

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
    private void clearTask(){
        displayText = new StringBuilder();
        display.setText(displayText.toString());
    }
}

