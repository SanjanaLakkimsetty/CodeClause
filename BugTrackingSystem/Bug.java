public class Bug {
    private int id;
    private String description;
    private String status;

    public Bug(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "Open";
    }

    // Getters and setters (not mandatory for this example)
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bug ID: " + id + ", Description: " + description + ", Status: " + status;
    }
}
