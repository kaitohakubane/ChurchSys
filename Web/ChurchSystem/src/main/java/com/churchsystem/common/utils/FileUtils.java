package com.sneakergo.common.utils;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Hung on 11/19/2016.
 */
public class FileUtils {
    public static void saveImageFile(MultipartFile picture, File imageDirectory, String imageName) throws IOException {

        File imageFile = new File(imageDirectory.getAbsolutePath() + File.separator + imageName);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(imageFile));
        FileCopyUtils.copy(picture.getInputStream(), stream);
        stream.close();
    }
}
