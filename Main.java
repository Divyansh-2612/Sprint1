import java.sql.SQLException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc=new Scanner(System.in);
        while(true){
        System.out.println("Enter the number where you want to go: \n 1 for Citizen \n 2 for Technician \n 3 for Request \n 4 for Service Request");
        int n=sc.nextInt();
        if(n==1){
            Citizen.ma();
        }
        else if(n==2){
            Technician.ma();
        }
        else if(n==3){
            System.out.print("Enter your id: ");
            int id=sc.nextInt();
            Request.requestRaised(id);
         }
        else if(n==4){
            ServiceType.ma();
        }
        else{
            System.out.println("You want to exit");
            break;
        }
    }
    sc.close();}
    
}
