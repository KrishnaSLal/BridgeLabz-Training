package com.javagenerics.smartwarehousemanagementsystem;

class Electronics extends WarehouseItem {

    public Electronics(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }
}
