package com.tree.binarysearchtree.ecommerceproductinventory;

class ProductInventoryBST {

    Product root;

    // Insert product
    void insert(int sku, String name, double price) {
        root = insertRec(root, sku, name, price);
    }

    Product insertRec(Product root, int sku, String name, double price) {
        if (root == null)
            return new Product(sku, name, price);

        if (sku < root.sku)
            root.left = insertRec(root.left, sku, name, price);
        else if (sku > root.sku)
            root.right = insertRec(root.right, sku, name, price);

        return root;
    }

    //Lookup by SKU
    Product search(int sku) {
        return searchRec(root, sku);
    }

    Product searchRec(Product root, int sku) {
        if (root == null || root.sku == sku)
            return root;

        return sku < root.sku
                ? searchRec(root.left, sku)
                : searchRec(root.right, sku);
    }

    //Update price
    boolean updatePrice(int sku, double newPrice) {
        Product p = search(sku);
        if (p != null) {
            p.price = newPrice;
            return true;
        }
        return false;
    }

    // Sorted SKU list
    void displaySorted() {
        if (root == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        inorder(root);
    }

    void inorder(Product root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(
                "SKU: " + root.sku +
                ", Name: " + root.name +
                ", Price: ₹" + root.price
            );
            inorder(root.right);
        }
    }
}
