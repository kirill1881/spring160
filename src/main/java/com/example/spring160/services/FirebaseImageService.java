package com.example.spring160.services;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;

@Service
public class FirebaseImageService {
    private Storage storage = StorageOptions.getDefaultInstance().getService();

    public String save(MultipartFile multipartFile) throws Exception{
        String imageName = String.valueOf(System.currentTimeMillis());
        BlobId blobId = BlobId.of("spring160-ebd2f.appspot.com", imageName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType(multipartFile.getContentType())
                .build();

        storage = StorageOptions.newBuilder()
                .setCredentials(ServiceAccountCredentials.
                        fromStream(new FileInputStream("spring160-ebd2f-firebase-adminsdk-65v8x-5f5defac19.json")))
                .build()
                .getService();

        storage.create(blobInfo, multipartFile.getInputStream());
        return imageName;
    }
}
