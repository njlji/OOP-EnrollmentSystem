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
}