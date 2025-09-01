package com.video.courses.repositories.videos;

import org.springframework.stereotype.Repository;

@Repository
public interface VideoUploadRepository {

    long createPreVideoRegister(String uploadUrl, String errorMessage);

    boolean doesPreRegisterVideoExists(Long preRegisterVideoId);

}
