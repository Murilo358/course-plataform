package com.video.courses.repositories.videosUpload;

public interface VideoUploadRepository {

    long createPreVideoRegister(String uploadUrl, String errorMessage);

    boolean doesPreRegisterVideoExists(Long preRegisterVideoId);

}
