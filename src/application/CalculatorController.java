package application;

import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CalculatorController {
	Main main = new Main();
	String result="";
	Double resultNumber;
	Double savedNumber;
	String operation;
	@FXML
	Label resultLabel;
	
	//adds a decimal to the result string
	@FXML
	private void decimalButton(){
		//prevents more than one decimal from being added to a string
		if(this.result == ""){
			numberButton("0.");
		}else if (!this.result.contains(".")){
			numberButton(".");
		}
	}
	//generic add number button
	private void numberButton(String number){
		if(this.savedNumber != null){
			this.result += number;
			if(this.savedNumber == Math.round(this.savedNumber)){
				this.resultLabel.setText(Math.round(this.savedNumber) + " " + this.operation + " " + this.result);
			}else{
				this.resultLabel.setText(this.savedNumber.toString() + " " + this.operation + " " + this.result);
			}
		}else{
			this.result += number;
			resultLabel.setText(this.result);
		}
	}
	//adds a zero to the result string
	@FXML
	private void zeroButton(){
		if (this.result != ""){
			numberButton("0");
		}
	}
	//adds a one to the result string
	@FXML
	private void oneButton(){
		numberButton("1");
	}
	//adds a two to the result string
	@FXML
	private void twoButton(){
		numberButton("2");
	}
	//adds a three to the result string
	@FXML
	private void threeButton(){
		numberButton("3");
	}
	//adds a four to the result string
	@FXML
	private void fourButton(){
		numberButton("4");
	}
	//adds a five to the result string
	@FXML
	private void fiveButton(){
		numberButton("5");
	}
	//adds a six to the result string
	@FXML
	private void sixButton(){
		numberButton("6");
	}
	//adds a seven to the result string
	@FXML
	private void sevenButton(){
		numberButton("7");
	}
	//adds an eight to the result string
	@FXML
	private void eightButton(){
		numberButton("8");
	}
	//adds a nine to the result string
	@FXML
	private void nineButton(){
		numberButton("9");
	}
	//clears all of the data
	@FXML
	private void clearButton(){
			this.result = "";
			this.operation = "";
			this.savedNumber = null;
			this.resultNumber = null;
			resultLabel.setText(this.result);
		
	}
	//negates the number
	@FXML
	private void negateButton(){
		try{
			this.resultNumber = Double.parseDouble(this.result);
			this.resultNumber = this.resultNumber * -1;
			this.result = this.resultNumber.toString();
			resultLabel.setText(this.result);
			}catch (Exception e){
				
			}
	}
	//converts the number to a decimal
	@FXML
	private void percentageButton(){
		try {
			this.resultNumber = Double.parseDouble(result);
			this.resultNumber = this.resultNumber / 100;
			this.result = this.resultNumber.toString();
			resultLabel.setText(this.result);
		} catch (Exception e) {
		}
		
	}
	
	//generic set operation function
	private void setOperation(String operation){
		try{
			if (result != ""){
				this.savedNumber = Double.parseDouble(this.result);
				this.operation = operation;
				if(this.savedNumber == Math.round(this.savedNumber)){
					this.resultLabel.setText(Math.round(this.savedNumber) + " " + this.operation + " ");
				}else{
					this.resultLabel.setText(this.savedNumber.toString() + " " + this.operation + " ");
				}
				this.result = "";
			}else{
				this.operation = operation;
				if(this.savedNumber == Math.round(this.savedNumber)){
					this.resultLabel.setText(Math.round(this.savedNumber) + " " + this.operation + " ");
				}else{
					this.resultLabel.setText(this.savedNumber.toString() + " " + this.operation + " ");
				}
			}
		}catch (Exception e){
			
		}
	}
	//sets the operation to a "+",
	//and saves the current number
	@FXML
	private void plusButton(){
		setOperation("+");
	}
	//sets the operation to a "-",
	//and saves the current number
	@FXML
	private void minusButton(){
		setOperation("-");
	}
	//sets the operation to a "*",
	//and saves the current number
	@FXML
	private void multiplyButton(){
		setOperation("x");
	}
	//sets the operation to a "/",
	//and saves the current number
	@FXML
	private void divideButton(){
		setOperation("/");
		
	}
	
	private void equalsFunction(){
		DecimalFormat formatResult = new DecimalFormat("0.###");
		this.result = formatResult.format(this.savedNumber);
		this.resultLabel.setText(result);
		this.result = "";
	}
	//performs the operation specified by the operation string
	@FXML
	private void equalButton(){
		try {
			this.resultNumber = Double.parseDouble(this.result);
			
			switch(this.operation){
			case "+":
				this.savedNumber = this.resultNumber + this.savedNumber;
				equalsFunction();
				break;
			case "-":
				this.savedNumber = this.savedNumber - this.resultNumber;
				equalsFunction();
				break;
			case "x":
				this.savedNumber = this.resultNumber * this.savedNumber;
				//takes care of arithmetic error
				if(this.savedNumber + 0.001 == Math.round(this.savedNumber) || this.savedNumber - 0.001 == Math.round(this.savedNumber) ){
					this.savedNumber = (double) Math.round(this.savedNumber);
				}
				equalsFunction();
				break;
			case "/":
				this.savedNumber = this.savedNumber / this.resultNumber;
				equalsFunction();
				break;
			}
		} catch (Exception e) {
		}
		
	}
	//adds in key event handlers
	@FXML
	public void handlePressedButtons(KeyEvent event){
	    if (event.getCode() == KeyCode.DIGIT0 || event.getCode() == KeyCode.NUMPAD0) {
	        zeroButton();
	    }else if(event.getCode() == KeyCode.DIGIT1 || event.getCode() == KeyCode.NUMPAD1){
	    	oneButton();
	    }else if(event.getCode() == KeyCode.DIGIT2 || event.getCode() == KeyCode.NUMPAD2){
	    	twoButton();
	    }else if(event.getCode() == KeyCode.DIGIT3 || event.getCode() == KeyCode.NUMPAD3){
	    	threeButton();
	    }else if(event.getCode() == KeyCode.DIGIT4 || event.getCode() == KeyCode.NUMPAD4){
	    	fourButton();
	    }else if(event.getCode() == KeyCode.DIGIT5 || event.getCode() == KeyCode.NUMPAD5){
	    	fiveButton();
	    }else if(event.getCode() == KeyCode.DIGIT6 || event.getCode() == KeyCode.NUMPAD6){
	    	sixButton();
	    }else if(event.getCode() == KeyCode.DIGIT7 || event.getCode() == KeyCode.NUMPAD7){
	    	sevenButton();
	    }else if(event.getCode() == KeyCode.DIGIT8 || event.getCode() == KeyCode.NUMPAD8){
	    	eightButton();
	    }else if(event.getCode() == KeyCode.DIGIT9 || event.getCode() == KeyCode.NUMPAD9){
	    	nineButton();
	    }else if(event.getCode() == KeyCode.DECIMAL){
	    	decimalButton();
	    }else if(event.getCode() == KeyCode.ENTER){
	    	equalButton();
	    }else if(event.getCode() == KeyCode.MULTIPLY){
	    	multiplyButton();
	    }else if(event.getCode() == KeyCode.DIVIDE){
	    	divideButton();
	    }else if(event.getCode() == KeyCode.MINUS){
	    	minusButton();
	    }else if(event.getCode() == KeyCode.ADD){
	    	plusButton();
	    }else if(event.getCode() == KeyCode.BACK_SPACE){
	    	clearButton();
	    }
	}	
}
