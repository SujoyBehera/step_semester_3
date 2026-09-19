package week7.class_problems;
public class Invoice implements Printable {
    private final String invoiceNumber;
    public Invoice(String invoiceNumber){ if(invoiceNumber==null||invoiceNumber.trim().isEmpty()) throw new IllegalArgumentException("invoiceNumber cannot be blank"); this.invoiceNumber=invoiceNumber; }
    public String printLabel(){ return "Invoice label: "+invoiceNumber; }
}