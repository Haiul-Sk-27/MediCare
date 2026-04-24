package com.example.MediCare.service.Impl;

import com.example.MediCare.domain.ImageType;
import com.example.MediCare.exceptions.FileStroageException;
import com.example.MediCare.service.FileStroageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@Slf4j
public class FileStroageServiceImpl implements FileStroageService {

    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024; // 1MB

    @Override
    public String StoreImage(MultipartFile file, String name, ImageType type) {

        if (file == null || file.isEmpty()) {
            throw new FileStroageException("File is empty");
        }

        if (file.getContentType() == null || !file.getContentType().startsWith("image/")) {
            throw new FileStroageException("Only image files are allowed");
        }

        if (file.getSize() > MAX_FILE_SIZE) {
            throw new FileStroageException("File size exceeds 1MB");
        }

        String cleanName = name.trim()
                .toLowerCase()
                .replaceAll("[^a-z0-9]", "_");

       String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String originalName = file.getOriginalFilename();
        String extension = "";

        if (originalName != null && originalName.contains(".")) {
            extension = originalName.substring(originalName.lastIndexOf("."));
        }

        String fileName = cleanName + "_" + dateTime + extension;

        try {
            Path uploadPath = Paths.get("uploads", type.getFolder())
                    .toAbsolutePath()
                    .normalize();

            Files.createDirectories(uploadPath);

            Path targetPath = uploadPath.resolve(fileName);

            Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

            return "/uploads/" + type.getFolder() + "/" + fileName;

        } catch (IOException e) {
            log.error("File upload failed", e);
            throw new FileStroageException("Failed to store file");
        }
    }

    @Override
    public void deleteImage(String imagePath) {
        if(imagePath == null || imagePath.isBlank()) return;

        try{

            Path path = Paths.get(imagePath.replaceFirst("/",""))
                    .toAbsolutePath()
                    .normalize();
            Files.deleteIfExists(path);

        }catch (IOException e){
            log.warn("Filed to delete image");
        }
    }
}