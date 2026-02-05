package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    public static void main(String[] args) {

        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        int rowsRead = 0;
        int rowsWritten = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputPath);

        // Case C: Missing input file
        if (!inputFile.exists()) {
            System.out.println("ERROR: Input file not found: " + inputPath);
            return;
        }

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))
        ) {

            // Always write header to output
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            String line = reader.readLine(); // read header
            if (line == null) {
                // Empty file (no header)
                printSummary(rowsRead, rowsWritten, rowsSkipped, outputPath);
                return;
            }

            while ((line = reader.readLine()) != null) {
                rowsRead++;

                line = line.trim();
                if (line.isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                String idStr = parts[0].trim();
                String name = parts[1].trim();
                String priceStr = parts[2].trim();
                String category = parts[3].trim();

                int productId;
                BigDecimal price;

                try {
                    productId = Integer.parseInt(idStr);
                    price = new BigDecimal(priceStr);
                } catch (Exception e) {
                    rowsSkipped++;
                    continue;
                }

                // ----- TRANSFORMATIONS -----

                // 1. Uppercase name
                name = name.toUpperCase();

                boolean wasElectronics = category.equals("Electronics");

                // 2. 10% discount if Electronics
                if (wasElectronics) {
                    price = price.multiply(new BigDecimal("0.9"));
                }

                // Round price
                price = price.setScale(2, RoundingMode.HALF_UP);

                // 3. Premium Electronics rule
                if (wasElectronics && price.compareTo(new BigDecimal("500.00")) > 0) {
                    category = "Premium Electronics";
                }

                // 4. PriceRange
                String priceRange;
                if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                    priceRange = "Low";
                } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                    priceRange = "Medium";
                } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                    priceRange = "High";
                } else {
                    priceRange = "Premium";
                }

                // ----- WRITE OUTPUT -----
                writer.write(productId + "," +
                             name + "," +
                             price.toPlainString() + "," +
                             category + "," +
                             priceRange);
                writer.newLine();

                rowsWritten++;
            }

            printSummary(rowsRead, rowsWritten, rowsSkipped, outputPath);

        } catch (IOException e) {
            System.out.println("ERROR: Problem processing files.");
        }
    }

    private static void printSummary(int read, int written, int skipped, String outputPath) {
        System.out.println("Rows read: " + read);
        System.out.println("Rows transformed: " + written);
        System.out.println("Rows skipped: " + skipped);
        System.out.println("Output written to: " + outputPath);
    }
}
