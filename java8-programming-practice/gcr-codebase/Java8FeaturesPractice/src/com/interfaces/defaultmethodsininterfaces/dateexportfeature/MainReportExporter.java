package com.interfaces.defaultmethodsininterfaces.dateexportfeature;

public class MainReportExporter {

    public static void main(String[] args) {

        ReportExporter exporter = new SalesReportExporter();

        exporter.exportToCSV();
        exporter.exportToPDF();
        exporter.exportToJSON();   // default method
    }
}

class SalesReportExporter implements ReportExporter {

    @Override
    public void exportToCSV() {
        System.out.println("Sales report exported to CSV.");
    }

    @Override
    public void exportToPDF() {
        System.out.println("Sales report exported to PDF.");
    }
}
