package org.howard.edu.lsp.finalexam.question2;

/**
 * Report for a course: name and enrollment, populated in {@link #loadData()}.
 */
public class CourseReport extends Report {

    private String courseName;
    private int enrollment;

    @Override
    protected void loadData() {
        this.courseName = "CSCI 363";
        this.enrollment = 45;
    }

    @Override
    protected String formatHeader() {
        return "Course Report";
    }

    @Override
    protected String formatBody() {
        return "Course: " + courseName + System.lineSeparator() + "Enrollment: " + enrollment;
    }

    @Override
    protected String formatFooter() {
        return "End of Course Report";
    }
}
