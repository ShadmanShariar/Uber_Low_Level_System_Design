package com.example.Uber.service.Implementation;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.azure.storage.blob.BlobClient;
import com.example.Uber.service.BlobStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class BlobStorageServiceImpl implements BlobStorageService {
//    private final BlobContainerClient blobContainerClient;
//    public BlobStorageServiceImpl(@Value("${azure.storage.connection-string}") String connectionString,
//                                  @Value("${azure.storage.container-name}") String containerName) {
//        this.blobContainerClient = new BlobContainerClientBuilder()
//                .connectionString(connectionString)
//                .containerName(containerName)
//                .buildClient();
//    }
//    @Override
//    public String uploadProfilePic(String id, MultipartFile file) throws IOException {
//        String fileName = id + "_" + file.getOriginalFilename();
//        BlobClient blobClient = blobContainerClient.getBlobClient(fileName);
//        blobClient.upload(file.getInputStream(), file.getSize(), true);
//        return blobClient.getBlobUrl();
//    }

}
