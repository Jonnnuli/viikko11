package shoppinglist.app;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PurchaseViewHolder extends RecyclerView.ViewHolder {
    TextView newPurchase;
    TextView remember, order;
    ImageView imageDelete, imageEdit, imageTime, imageAlpha;

    EditText editPurchase, editRemember;

    public PurchaseViewHolder(@NonNull View itemView) {
        super(itemView);
        newPurchase = itemView.findViewById(R.id.textViewPurchase);
        remember = itemView.findViewById(R.id.textViewToRemember);
        imageDelete = itemView.findViewById(R.id.imageViewDelete);
        imageEdit = itemView.findViewById(R.id.imageVieweEdit);
        editPurchase = itemView.findViewById(R.id.editPurchase);
        editRemember = itemView.findViewById(R.id.editReminder);
        //imageTime = itemView.findViewById(R.id.imageViewTime);
        //imageAlpha = itemView.findViewById(R.id.imageViewAlpha);
        order = itemView.findViewById(R.id.textViewNumber);

    }
}
