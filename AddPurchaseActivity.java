package shoppinglist.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddPurchaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_purchase);
    }

    public void addPurchase(View view) {

        EditText newPurchase = findViewById(R.id.editTextPurchase);
        EditText toRemember = findViewById(R.id.editTextToRemember);

        String purchase = newPurchase.getText().toString();
        String remember = toRemember.getText().toString();
        if (remember.equals("")) {
            int size = PurchaseStorage.getInstance().getArraySize();
            PurchaseStorage.getInstance().addPurchase(new Purchase(purchase, remember, size));

        }
        else {
            String remember1 = "Muista: " + remember;
            int size = PurchaseStorage.getInstance().getArraySize();
            PurchaseStorage.getInstance().addPurchase(new Purchase(purchase, remember1, size));
        }



        Intent intent = new Intent(this, ShoppingListActivity.class);
        startActivity(intent);

    }

    public void cancel(View view) {
        Intent intent = new Intent(this, ShoppingListActivity.class);
        startActivity(intent);
    }
}