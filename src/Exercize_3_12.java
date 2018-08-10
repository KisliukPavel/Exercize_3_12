/*Create a class called Invoice that a hardware store might use to represent
an invoice for an item sold at the store. An Invoice should include four pieces of information as
instance variables—a part number (type String), a part description (type String), a quantity of the
item being purchased (type int) and a price per item (double). Your class should have a constructor
that initializes the four instance variables. Provide a set and a get method for each instance variable.
In addition, provide a method named getInvoiceAmount that calculates the invoice amount (i.e.,
multiplies the quantity by the price per item), then returns the amount as a double value. If the
quantity is not positive, it should be set to 0. If the price per item is not positive, it should be set to
0.0. Write a test app named InvoiceTest that demonstrates class Invoice’s capabilities.*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Exercize_3_12 extends Application {

	private String title;

	public Exercize_3_12()
	{
		this.title = "Invoice Class";
	}

	public static void main(String[] args)
	{
		Application.launch(args);
	}

	public void start(Stage primaryStage) throws Exception
	{
		//primaryStage adjustment
		//-----------------------------------------------
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		primaryStage.setTitle(title);
		primaryStage.centerOnScreen();

		//FXML adjustment
		//-----------------------------------------------
		FXMLLoader fxmlLoader_3_11 = new FXMLLoader();
		fxmlLoader_3_11.setLocation(getClass().getResource("MainWindow_3_12.fxml"));
		Parent fxmlMainWindow = fxmlLoader_3_11.load();

		//controller adjustment
		//-----------------------------------------------
		MainWindow_Controller mainController = fxmlLoader_3_11.getController();
		mainController.setMainStage(primaryStage);

		//start-up window
		//-----------------------------------------------
		Scene S_3_11 = new Scene(fxmlMainWindow);
		primaryStage.setScene(S_3_11);
		primaryStage.show();
	}
}
