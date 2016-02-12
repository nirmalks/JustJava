package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;              //for NumberFormat in displayPrice method

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    int pricePerCup = 5;
    int priceOfChocolate = 0;
    int priceOFWhippedCream = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameField = (EditText) findViewById(R.id.enter_name_text_view);
        String name = nameField.getText().toString();

        CheckBox checkbox = (CheckBox) findViewById(R.id.whippedCream_checkbox);
        boolean hasWhippedCream = checkbox.isChecked();

        CheckBox chocoCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocoCheckbox.isChecked();
        if(hasChocolate){
            priceOfChocolate = 2;
        }
        if(hasWhippedCream){
            priceOFWhippedCream = 1;
        }
        String summary = createOrderSummary(name ,pricePerCup, hasWhippedCream , hasChocolate);
        displayMessage(summary);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void increment(View view){
        quantity += 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity -= 1;
        displayQuantity(quantity);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public String createOrderSummary(String name , int price , boolean addWhippedCream , boolean addChocolate){
        int total =  (quantity * price ) + (quantity * priceOfChocolate) + (quantity * priceOFWhippedCream);
        return "Name: " + name +  "\n" + "Add Whipped Cream? "  + addWhippedCream + "\n" + "Add Chocolate topping " + addChocolate + "\n" + "Quantity: " + quantity + "\n" + "Total: $ " +
             total + "\nThank You!";
    }
}