import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class CreateInvoice_Controller {

	@FXML
	private GridPane GridPane_Main;

	@FXML
	private Button button_OK;

	@FXML
	private Button button_Cancel;

	@FXML
	private TextField textField_PartNumber;

	@FXML
	private TextField textField_PartDescription;

	@FXML
	private TextField textField_Quantity;

	@FXML
	private TextField textField_PricePerItem;

	//------------------------------------------------------------------
	private Invoice invoice;
	private boolean[] checkTextfield = {false, false, false, false}; //Finite-state machine
	//------------------------------------------------------------------

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@FXML
	void onAction_OK(ActionEvent event) {
		this.invoice.setpartNumber(this.textField_PartNumber.getText());
		this.invoice.setpartDescription(this.textField_PartDescription.getText());
		this.invoice.setquantity_Of_The_Item_Being_Purchased(Integer.valueOf(this.textField_Quantity.getText()));
		this.invoice.setprice_Per_Item(Double.valueOf(this.textField_PricePerItem.getText()));
		this.onAction_Cancel(event);
	}

	@FXML
	void onAction_Cancel(ActionEvent event) {
		event.consume();
		Stage stage = (Stage) this.button_Cancel.getScene().getWindow();
		stage.close();
	}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	//------------------------------------------------------------------
	public void setInvoice(Invoice invoice)
	{
		this.invoice = invoice;
	}
	//------------------------------------------------------------------

	@FXML
	void initialize() {

		this.textField_PartNumber.textProperty().addListener((observable, oldValue, newValue) -> {
			this.checkPartNumber(newValue);
			checkInput();
		});

		this.textField_PartDescription.textProperty().addListener((observable, oldValue, newValue) -> {
			this.checkPartDescription(newValue);
			checkInput();
		});

		this.textField_Quantity.textProperty().addListener((observable, oldValue, newValue) -> {
			this.checkQuantity(newValue);
			checkInput();
		});

		this.textField_PricePerItem.textProperty().addListener((observable, oldValue, newValue) -> {
			this.checkPricePerItem(newValue);
			checkInput();
		});
	}

	private void checkInput()
	{
		for(int i = 6; i < 10; i++) {
			TextField T = (TextField)GridPane_Main.getChildren().get(i);
			if(!(this.checkTextfield[i - 6])) {
				if(T.getText().length() != 0) {
					T.setStyle("-fx-control-inner-background: pink;");
				}
			}
			else{
				T.setStyle("-fx-control-inner-background: white;");
			}
		}
		for(boolean b : checkTextfield){
			if(!b) {
				this.button_OK.setDisable(true);
				return;
			}
		}
		this.button_OK.setDisable(false);
	}

	//------------------------------------------------------------------
	private void checkPartNumber(String partN)
	{
		this.checkTextfield[0] = (partN.length() > 0);
	}

	private void checkPartDescription(String partD)
	{
		this.checkTextfield[1] = (partD.length() > 0);
	}

	private void checkQuantity(String quantity)
	{
		if(0 == quantity.length()) {
			this.checkTextfield[2] = false;
			return;
		}
		for(char ch : quantity.toCharArray()) {
			if(!(Character.isDigit(ch))) {
				this.checkTextfield[2] = false;
				return;
			}
		}
		this.checkTextfield[2] = true;
	}

	private void checkPricePerItem(String price)
	{
		if(0 == price.length()) {
			this.checkTextfield[3] = false;
			return;
		}
		int countOfPeriods = 0;//количество точек
		for(char ch : price.toCharArray()) {
			if(!(Character.isDigit(ch))) {
				if(ch != '.') {
					this.checkTextfield[3] = false;
					return;
				}
				else {
					countOfPeriods++;
				}
			}
		}
		//если количество точек больше 1 - это не число
		this.checkTextfield[3] = (countOfPeriods <= 1);
	}
}
