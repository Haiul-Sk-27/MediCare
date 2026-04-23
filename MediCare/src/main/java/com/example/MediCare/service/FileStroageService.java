package com.example.MediCare.service;

import com.example.MediCare.domain.ImageType;
import org.springframework.web.multipart.MultipartFile;

public interface FileStroageService {

    String StoreImage(MultipartFile file, String name, ImageType type);
    void deleteImage(String imagePath);
}
