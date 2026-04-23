package org.howard.edu.lsp.finalexam.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates polymorphism: {@link Report} references with concrete {@link StudentReport}
 * and {@link CourseReport} instances.
 */
public final class Driver {

    private Driver() {
    }

    /**
     * Entry point: builds a list of reports and generates each via the template method.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        List<Report> reports = new ArrayList<>();
        reports.add(new StudentReport());
        reports.add(new CourseReport());

        for (int i = 0; i < reports.size(); i++) {
            reports.get(i).generateReport();
            if (i < reports.size() - 1) {
                System.out.println();
            }
        }
    }
}
