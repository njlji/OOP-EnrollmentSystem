package models;
import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Section> sections;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.sections = new ArrayList<>();
    }

    public String getDepartmentName() { return departmentName; }
    public List<Section> getSections() { return sections; }
    public void addSection(Section section) { this.sections.add(section); }

    // NEW: Method to remove a section by its name
    public boolean removeSection(String sectionName) {
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionName().equalsIgnoreCase(sectionName)) {
                sections.remove(i);
                return true; // Successfully removed
            }
        }
        return false; // Section not found
    }
}