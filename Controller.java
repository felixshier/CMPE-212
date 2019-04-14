package sample;

import java.util.*;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;
import java.awt.event.MouseEvent;
import javafx.scene.input.*;
import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {

    private String orderD;
    private String pizzaSize;
    private String pizzaCheese;
    private String pizzaTopping;
    private String pineapple;
    private String greenPepper;
    private String ham;
    private int numberPizzas;
    private int totalCost;
    private String totalOrder;
    //private ArrayList<LineItem> pizzaOrder = new ArrayList<LineItem>();
    private Pizza pizza;

    @FXML
    private ToggleGroup ToggleSize;

    @FXML
    private ToggleGroup ToggleCheese;

    @FXML
    private RadioButton Small;

    @FXML
    private RadioButton Medium;

    @FXML
    private RadioButton Large;

    @FXML
    private RadioButton Single;

    @FXML
    private RadioButton Double;

    @FXML
    private RadioButton Triple;

    @FXML
    private Button Submit;

    @FXML
    private CheckBox Pineapple;

    @FXML
    private CheckBox GreenPepper;

    @FXML
    private CheckBox Ham;

    @FXML
    private Button add;

    @FXML
    private Button submit;

    @FXML
    private TextArea orderDisplay;

    @FXML
    private TextField ppp;

    @FXML
    private TextField numPs;

    @FXML
    public String getSize() {
        if (Small.isSelected())
            pizzaSize = "Small";
        else if (Medium.isSelected())
            pizzaSize = "Medium";
        else if (Large.isSelected())
            pizzaSize = "Large";
        else
            pizzaSize = "Small";
        return pizzaSize;
    }
    @FXML
    public String getCheese() {
        if (Single.isSelected())
            pizzaCheese = "Single";
        else if (Double.isSelected())
            pizzaCheese = "Double";
        else if (Triple.isSelected())
            pizzaCheese = "Triple";
        else
            pizzaCheese = "Single";
        return pizzaCheese;
    }

    @FXML
    public String getToppings(CheckBox topping) {
        if(topping.isSelected())
            pizzaTopping = "Single";
        else
            pizzaTopping = "None";
    return pizzaTopping;
    }

    public LineItem setPizza() {
        Pizza pizza = null;
        LineItem order = null;
        numberPizzas = Integer.parseInt(numPs.getText());
        try {
            pizza = new Pizza(getSize(), getCheese(), getToppings(Pineapple), getToppings(GreenPepper), getToppings(Ham));
            order = new LineItem(numberPizzas, pizza);
        }
        catch(IllegalPizza illPiz) {
            System.out.println(illPiz.getMessage());
        }
        return order;
    }

    @FXML
    private float getCost() {
        float cost;
        LineItem order = setPizza();
        cost = order.getCost();
        String pCost = cost + "";
        ppp.setText(pCost);
        return cost;
    }

    @FXML
    public void addButton(ActionEvent action) {
        float cost;
        LineItem order = setPizza();
        cost = getCost();
        totalCost += cost;
        totalOrder += ", " + order;
        String orderD = order + ". Cost: $" + cost + "\n";
        orderDisplay.appendText(orderD);
    }

    @FXML
    public void submitButton(ActionEvent action) {
        JOptionPane.showConfirmDialog(null, "Your order is:" + totalOrder + "\nthe cost is: $" + totalCost);
    }

}
