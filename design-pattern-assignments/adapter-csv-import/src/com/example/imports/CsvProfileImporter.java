package com.example.imports;

import java.nio.file.Path;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader reader;
    private final ProfileService service;

    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.reader = csvReader;
        this.service = profileService;
    }

    @Override
    public int importFrom(Path csvFile) {
        int count = 0;

        for (String[] row : reader.read(csvFile)) {
            if (row.length < 3) {
                System.out.println("Skipping invalid row: " + String.join(",", row));
                continue;
            }

            String id = row[0].trim();
            String email = row[1].trim();
            String displayName = row[2].trim();

            try {
                service.createProfile(id, email, displayName);
                ++count;
            } catch (Exception e) {
                System.err
                        .println("Failed to create profile for row: " + String.join(",", row) + " - " + e.getMessage());
            }
        }

        return count;
    }

}
