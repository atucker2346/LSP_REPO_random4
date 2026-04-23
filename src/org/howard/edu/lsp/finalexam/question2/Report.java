package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract base for reports using the Template Method pattern.
 * The workflow is fixed: {@link #loadData()}, then header, body, and footer formatting,
 * orchestrated by {@link #generateReport()}.
 */
public abstract class Report {

    /**
     * Loads report-specific data; subclasses set fields used by formatting methods.
     */
    protected abstract void loadData();

    /**
     * @return header text (without section banner)
     */
    protected abstract String formatHeader();

    /**
     * @return body text (without section banner)
     */
    protected abstract String formatBody();

    /**
     * @return footer text (without section banner)
     */
    protected abstract String formatFooter();

    /**
     * Template method: runs the required workflow and prints the report in the required layout.
     */
    public final void generateReport() {
        loadData();
        System.out.println("=== HEADER ===");
        System.out.println(formatHeader());
        System.out.println();
        System.out.println("=== BODY ===");
        System.out.println(formatBody());
        System.out.println();
        System.out.println("=== FOOTER ===");
        System.out.println(formatFooter());
    }
}
