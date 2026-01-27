package com.annotations.deprecated;

class LegacyAPI {

    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. It is deprecated!");
    }

    public void newFeature() {
        System.out.println("This is the new feature. Recommended to use!");
    }
}
