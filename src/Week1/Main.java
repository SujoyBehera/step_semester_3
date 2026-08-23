package Week1;
import java.util.Scanner;
class Book{
    Boolean isIssued = false;
    issueBook(String book_Name,String name){
        String book = book_Name;
        String person = name;
        isIssued = true;
        if(isIssued){
            System.out.println("Book issued Successfully");
        }
    }
    return_Book(String book_Name,String name){
        isIssued = false;
        if(isIssued){
            System.out.println("Book was not issued");
        }
        else{
            System.out.println("Book returned successfully");
        }

    }


}
public class Main {
    public void static main(String[] args){
        String Book_name;
        String name;
        Scanner sc = new Scanner(System.in);
        Book_name=sc.nextLine();
        name= sc.nextLine();
        sc.close();
        b1 = new Book(Book_name,name).issueBook;

    }
}
