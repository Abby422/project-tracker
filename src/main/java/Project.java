import java.time.LocalDateTime;
import java.util.ArrayList;

public class Project {
    private String department;
    private String assetName;
    private String productOwner;
    private String projectDescription;
    private String gitLink;
    private String projectBenefit;
    private String deployedServer;
    private String commonIssues;
    private static ArrayList<Project> instances = new ArrayList<>();
    private boolean status;
    private LocalDateTime createdAt;
    private int id;
    public Project(String department,String assetName, String productOwner,
                   String projectDescription, String gitLink,String projectBenefit,String deployedServer,
                   String commonIssues) {
        this.department = department;
        this.assetName = assetName;
        this.productOwner = productOwner;
        this.projectDescription = projectDescription;
        this.gitLink = gitLink;
        this.projectBenefit = projectBenefit;
        this.deployedServer = deployedServer;
        this.commonIssues = commonIssues;
        this.status = true;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.id = instances.size();

    }

    public Project(String name, String description, String department) {
        this.department = department;
        this.assetName = assetName;
        this.projectDescription = projectDescription;
        this.status = true;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.id = instances.size();
    }

    public String getDepartment() {
        return department;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getProductOwner() {
        return productOwner;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public String getGitLink() {
        return gitLink;
    }

    public String getProjectBenefit() {
        return projectBenefit;
    }

    public String getDeployedServer() {
        return deployedServer;
    }

    public String getCommonIssues() {
        return commonIssues;
    }

    public static ArrayList<Project> getAll() {
        return instances;
    }

    public int getId() {
        return id;
    }
    public static Project findById(int id){
        return instances.get(id-1); //why minus 1? See if you can figure it out.
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
