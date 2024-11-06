package com.example.Uber.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface BlobStorageService {

    String uploadLogo(UUID id, MultipartFile file) throws IOException;

}