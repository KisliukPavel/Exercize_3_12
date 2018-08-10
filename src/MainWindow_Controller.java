import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow_Controller {

	@FXML
	private TextArea textArea_Invoice;

	@FXML
	private TextField textField_InvoiceAmount;

	//------------------------------------------------------------------
	private Stage mainStage;
	private Invoice invoice;
	//------------------------------------------------------------------

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@FXML
	void onAction_CreateInvoice(ActionEvent event) {
		this.startDialogueWindow();
		this.setTextAera();
	}

	@FXML
	void onAction_InvoiceAmount(ActionEvent event) {
		this.textField_InvoiceAmount.setText(String.format("%.2f", this.invoice.getInvoiceAmount()));
	}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	//------------------------------------------------------------------
	void setMainStage(Stage mainStage)
	{
		this.mainStage = mainStage;
	}

	private void startDialogueWindow() {
		try {
			//Stage adjustment
			//-----------------------------------------------
			Stage dialogueStage = new Stage();
			dialogueStage.setResizable(false);
			dialogueStage.sizeToScene();
			dialogueStage.setTitle("CreateInvoice_Dialogue");
			dialogueStage.centerOnScreen();

			//FXML adjustment
			//-----------------------------------------------
			FXMLLoader fxmlLoaderDialogue = new FXMLLoader();
			fxmlLoaderDialogue.setLocation(getClass().getResource("CreateInvoice_Dialogue.fxml"));
			Parent fxmlDialogue = fxmlLoaderDialogue.load();


			CreateInvoice_Controller CI_Controller = fxmlLoaderDialogue.getController();
			CI_Controller.setInvoice(this.invoice);

			//modality adjustment
			//-----------------------------------------------
			dialogueStage.initModality(Modality.WINDOW_MODAL);
			dialogueStage.initOwner(this.mainStage);

			//start-up window
			//-----------------------------------------------
			Scene SDialogue = new Scene(fxmlDialogue);
			dialogueStage.setScene(SDialogue);
			dialogueStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setTextAera()
	{
		String SPN = String.format("%-31s%s%n", "Part number:", this.invoice.getpartNumber());
		String SPD = String.format("%-30s%s%n", "Part descriprion:", this.invoice.getpartDescription());
		String SQ = String.format("%-26s%s%n", "Quantity of the items:", this.invoice.getquantity_Of_The_Item_Being_Purchased());
		String SP = String.format("%-31s%s%n", "Price per item:", this.invoice.getprice_Per_Item());
		this.textArea_Invoice.setText(SPN + SPD + SQ + SP);

	}
	//------------------------------------------------------------------

	@FXML
	void initialize() {
		this.invoice = new Invoice();
	}

}