package session_1.assignment_problems;
public class M1FromParallelArraystoaClass {

    public static class PlacementRecord{
        String studentName;
        String company;
        double packageLpa;
        PlacementRecord(String studentName, String company, double packageLpa){
            this.studentName=studentName;
            this.company=company;
            this.packageLpa=packageLpa;
        }
        void printRecord(){
            System.out.println(studentName+" -> "+company+" @ "+packageLpa+" LPA ");
        }
    }
    public static void main(String[] args){
        PlacementRecord r1 = new PlacementRecord("ravi","TCS", 4.5);
        PlacementRecord r2 = new PlacementRecord("Anitha","Zoho",6.2);
        PlacementRecord r3 = new PlacementRecord("karthik","Infosys",4.0);
        PlacementRecord[] record= {r1, r2, r3};
        for(int i = 0; i < record.length; i++){
            record[i].printRecord();

        }
    }
}



