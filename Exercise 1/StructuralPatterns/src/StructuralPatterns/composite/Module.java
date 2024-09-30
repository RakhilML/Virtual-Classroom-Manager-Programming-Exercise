package StructuralPatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Module extends CourseComponent {
    private String moduleName;
    private List<CourseComponent> courseComponents = new ArrayList<>();

    public Module(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public String getName() {
        return moduleName;
    }

    @Override
    public void add(CourseComponent courseComponent) {
        courseComponents.add(courseComponent);
    }

    @Override
    public void remove(CourseComponent courseComponent) {
        courseComponents.remove(courseComponent);
    }

    @Override
    public void displayCourseInfo() {
        System.out.println("Module: " + moduleName);
        for (CourseComponent component : courseComponents) {
            component.displayCourseInfo();
        }
    }
}
