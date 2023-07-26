package shoppinglist.app;

import java.util.ArrayList;

public class PurchaseStorage {

    private static PurchaseStorage purchaseStorage = null;
    private ArrayList<Purchase> purchases = new ArrayList<>();

    private int arraySize = 0;
    private PurchaseStorage() {

    }

    public static PurchaseStorage getInstance() {
        if(purchaseStorage == null) {
            purchaseStorage = new PurchaseStorage();
        }
        return purchaseStorage;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
        arraySize++;
    }
    public Purchase getPurchaseById(int id) {
        return purchases.get(id);
    }
    public void removePurchase(String id) {
        int i = 0;
        for (Purchase purchase: purchases) {
            if (purchase.getId().equals(id)) {
                break;
            }
            i++;
        }
        purchases.remove(i);
    }

    public int getArraySize() {
        return arraySize;
    }

    public int getPurchasesSize() {
        return purchases.size();
    }

}
