import java.time.LocalDateTime;
import java.util.Scanner;

public class Request {
    private int requestId;
    private int citizenId;
    private int serviceTypeId;
    private String description;
    private int priority; // 1 - High, 2 - Medium, 3 - Low
    private String status; // e.g., Pending, In Progress, Resolved
    private LocalDateTime dateSubmitted;
    private Integer technicianId; // Nullable

    // Constructor
    public Request(int requestId, int citizenId, int serviceTypeId, String description,
                   int priority, String status, LocalDateTime dateSubmitted, Integer technicianId) {
        this.requestId = requestId;
        this.citizenId = citizenId;
        this.serviceTypeId = serviceTypeId;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.dateSubmitted = dateSubmitted;
        this.technicianId = technicianId;
    }

    // Getters and Setters
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(int citizenId) {
        this.citizenId = citizenId;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(LocalDateTime dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public Integer getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Integer technicianId) {
        this.technicianId = technicianId;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + requestId +
                ", citizenId=" + citizenId +
                ", serviceTypeId=" + serviceTypeId +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", status='" + status + '\'' +
                ", dateSubmitted=" + dateSubmitted +
                ", technicianId=" + technicianId +
                '}';
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the request id");
        int requestId=sc.nextInt();
        System.out.println("Enter the citizen Id");
        int citizenId=sc.nextInt();
        System.out.println("Enter the service id:");
        int serviceTypeId=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the description:");
        String description=sc.nextLine();
        System.out.println("Enter the priority");
        int priority=sc.nextInt();
        System.out.println("Enter the status:");;
        String status=sc.next();
        System.out.println("Enter the date of submitiion");
        LocalDateTime dateSubmitted=LocalDateTime.now();
        System.out.println("Enter the Technician Id:");
        Integer technicianId=sc.nextInt();
        Request R=new Request(requestId, citizenId, serviceTypeId, description, priority, status, dateSubmitted, technicianId);
        RequestInsertion.insertRequest(R);
    }
}
