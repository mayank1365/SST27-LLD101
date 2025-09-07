package com.example.report;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipper {
    public Path zip(Path file, Path outZip) {
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(outZip))) {
            zos.putNextEntry(new ZipEntry(file.getFileName().toString()));
            Files.copy(file, zos);
            zos.closeEntry();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return outZip;
    }
}