package com.interfaces.defaultmethodsininterfaces.dateexportfeature;

interface ReportExporter {

    // Existing export options
    void exportToCSV();
    void exportToPDF();

    // New feature added later
    default void exportToJSON() {
        System.out.println("Exporting report to JSON using standard format.");
    }
}
