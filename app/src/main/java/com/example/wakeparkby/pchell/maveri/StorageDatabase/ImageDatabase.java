package com.example.wakeparkby.pchell.maveri.StorageDatabase;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

public class ImageDatabase {
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef;

    public void upLoadImage(String way){
        Uri file = Uri.fromFile(new File(way));
        storageRef = storageRef.child("images/"+ Profile.getInstance().getUserKey()+"/");
        UploadTask uploadTask = storageRef.putFile(file);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

            }
        });
    }

    public File loadImage() throws IOException {
        storageRef = storage.getReference("images/");
        storageRef.child(Profile.getInstance().getUserKey()+"/");
        File localFile = File.createTempFile("images", "jpg");
        storageRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                // Local temp file has been created
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
        return localFile;
    }

}
