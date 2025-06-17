import java.util.List;
import java.util.Scanner;

public class ServiceType {
    private int id;
    private String typeName;
    private String description;

    public ServiceType(int id, String typeName, String description) {
        this.id = id;
        this.typeName = typeName;
        this.description=description;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }

    // Optional: Display method
    public void display() {
        System.out.println("Service Type: " + typeName + " (ID: " + id + ")");
    }
    public static void ma() {
        Scanner sc=new Scanner(System.in);
        while(true){
        System.out.println("Enter the Move that you want to take (only integer value) \n 1 for Insert Record \n 2 for Deletion of Record: \n 3 for Updation of record : \n 4 for Feteching out Records");
        int n=sc.nextInt();
        if(n==1){
        System.out.println("Enter the Service Id:");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Type of service:");
        String typename=sc.nextLine();
        System.out.println("Enter the description:");
        String description=sc.nextLine();
        ServiceType St=new ServiceType(id, typename, description);
        ServiceTypeCrud.insertServiceType(St);
        }
        else if(n==2){
            System.out.println("Enter the column name with the help of which you want to delete the records: \n 1 for phone \n 2 for ID");
            int m=sc.nextInt();
            if(m==1){
                System.out.println("Enter the Service name");
                String servicename=sc.next();
                ServiceTypeCrud.deleteServiceByType(servicename);
            }
            else if(m==2){
                System.out.println("Enter the Technician Id:");
                int c=sc.nextInt();
                ServiceTypeCrud.deleteServiceById(c);
            }
            else{
                System.out.println("You have Entered the Wrong value");
            }
        }
        else if(n==3){
            System.out.println("Enter the column name with the help of which you want to delete the records: \n 1 for phone \n 2 for ID");
            int m=sc.nextInt();
            sc.nextLine();
            if(m==1){
                System.out.println("Typename");
                String typename=sc.next();
                System.out.println("Enter description");
                String description=sc.next();
                ServiceTypeCrud.updateServiceByType(typename, description);
            }
            else if(m==2){
               System.out.println("Typename");
                String typename=sc.next();
                System.out.println("Enter description");
                String description=sc.next();
                System.out.println("Enter Id");
                int id=sc.nextInt();
                ServiceTypeCrud.updateServiceById(id, typename, description);
            }
        }
        else if(n==4){
            System.out.println("Here are the records:");
             List<ServiceType> l=ServiceTypeCrud.reader();
            for(int i=0;i<l.size();i++){
                System.out.println(l.get(i).id+" "+l.get(i).typeName+" "+l.get(i).description);
            }
        }
        else{
            System.out.println("You want to exit");
            break;
        }
        }
        sc.close();
    }
        
}

