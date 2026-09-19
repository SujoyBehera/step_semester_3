package week7.class_problems;
public final class PrintableOperations {
    private PrintableOperations(){}
    public static void printAll(Printable[] items){ if(items==null)return; for(Printable item:items) if(item!=null) System.out.println(item.printLabel()); }
}