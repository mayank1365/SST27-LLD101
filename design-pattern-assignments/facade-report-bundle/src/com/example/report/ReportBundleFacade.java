package com.example.report;

import java.nio.file.Path;
import java.util.Map;

public class ReportBundleFacade {
    private final JsonWriter jsonWriter = new JsonWriter();
    private final Zipper zipper = new Zipper();
    private final AuditLog auditLog = new AuditLog();

    public Path export(Map<String, Object> data, Path outDir, String baseName) {
        Path json = jsonWriter.write(data, outDir, baseName);
        Path zip = zipper.zip(json, outDir.resolve(baseName + ".zip"));
        auditLog.log("exported " + zip);
        return zip;
    }
}