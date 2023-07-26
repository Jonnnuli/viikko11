package shoppinglist.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import java.util.Collections;
import java.util.Comparator;

public class ShoppingListActivity extends AppCompatActivity {

    private PurchaseStorage purchaseStorage;
    private RecyclerView recyclerView;

    private Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        purchaseStorage = PurchaseStorage.getInstance();
        recyclerView = findViewById(R.id.rvShoppingList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ShoppingListAdapter(getApplicationContext(), purchaseStorage.getPurchases()));
    }

    public void sortByAlphabet(View view) {
        Collections.sort(purchaseStorage.getPurchases(), new Comparator<Purchase>() {
            @Override
            public int compare(Purchase purchase1, Purchase purchase2) {
                return purchase1.getPurchase().compareToIgnoreCase(purchase2.getPurchase());
            }
        });
        recyclerView.setAdapter(new ShoppingListAdapter(getApplicationContext(), purchaseStorage.getPurchases()));
    }

    public void sortByCreatedOrder(View view) {
        Collections.sort(purchaseStorage.getPurchases(), new Comparator<Purchase>() {
            @Override
            public int compare(Purchase purchase1, Purchase purchase2) {
                return purchase1.getOrder().compareTo(purchase2.getOrder());
            }
        });
        recyclerView.setAdapter(new ShoppingListAdapter(getApplicationContext(), purchaseStorage.getPurchases()));
    }

    public void switchToAddPurchase(View view) {
        Intent intent = new Intent(this, AddPurchaseActivity.class);
        startActivity(intent);
    }
}