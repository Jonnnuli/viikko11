package shoppinglist.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ShoppingListAdapter extends RecyclerView.Adapter<PurchaseViewHolder> {
    //työntää oikeat käyttäjät näkymään

    private Context context;
    private ArrayList<Purchase> purchases = new ArrayList<>();

    public ShoppingListAdapter(Context context, ArrayList<Purchase> purchases) {
        this.context = context;
        this.purchases = purchases;
    }

    @NonNull
    @Override
    public PurchaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PurchaseViewHolder(LayoutInflater.from(context).inflate(R.layout.purchase_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseViewHolder holder, int position) { //laittaa ne oikeet tiedot näkyviin
        holder.newPurchase.setText(purchases.get(position).getPurchase());
        holder.remember.setText(purchases.get(position).getRemember());
        holder.editPurchase.setText(purchases.get(position).getPurchase());
        holder.editRemember.setText(purchases.get(position).getRemember());
        holder.order.setText(purchases.get(position).getOrder());

        holder.imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                PurchaseStorage.getInstance().removePurchase(purchases.get(pos).getId());
                notifyItemRemoved(pos);
            }
        });

        holder.imageEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();

                if (holder.editPurchase.getVisibility() == View.VISIBLE) {
                    Purchase purchase = PurchaseStorage.getInstance().getPurchaseById(pos);
                    purchase.setPurchase(holder.editPurchase.getText().toString());
                    purchase.setRemember(holder.editRemember.getText().toString());
                    holder.editPurchase.setVisibility(View.GONE);
                    holder.editRemember.setVisibility(View.GONE);
                    notifyDataSetChanged();
                }
                else {
                    holder.editPurchase.setVisibility(View.VISIBLE);
                    holder.editRemember.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return purchases.size();
    }
}

