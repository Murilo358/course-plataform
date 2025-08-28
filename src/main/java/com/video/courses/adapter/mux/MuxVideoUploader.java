package com.video.courses.adapter.mux;

import com.mux.ApiException;
import com.mux.sdk.DirectUploadsApi;
import com.mux.sdk.models.*;
import com.video.courses.dto.VideoUploaderDTO;
import com.video.courses.ports.upload.VideoUploader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class MuxVideoUploader implements VideoUploader {

    private final DirectUploadsApi directUploadsApi;


    public MuxVideoUploader(DirectUploadsApi directUploadsApi) {
        this.directUploadsApi = directUploadsApi;
    }


    @Override
    public VideoUploaderDTO getUploadUrl() {
        try {

            CreateUploadRequest request = new CreateUploadRequest()
                    .newAssetSettings(
                            new CreateAssetRequest()
                                    .playbackPolicy(List.of(PlaybackPolicy.PUBLIC))
                                    .videoQuality(CreateAssetRequest.VideoQualityEnum.BASIC)
                    ).corsOrigin("*");

            DirectUploadsApi.APIcreateDirectUploadRequest upload = directUploadsApi.createDirectUpload(request);

            UploadResponse execute = upload.execute();
            Optional<Upload> data = Optional.ofNullable(execute.getData());
            if(data.isEmpty()){
                return null;
            }

            Upload uploadData = data.get();
            Upload.StatusEnum status = uploadData.getStatus();

            if(Upload.StatusEnum.WAITING.equals(status)){
                String errorMessage = Optional.ofNullable(uploadData.getError()).map(UploadError::getMessage).orElse(null);
                return new VideoUploaderDTO(uploadData.getId(), uploadData.getUrl(),errorMessage);
            }

            return null;


        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void uploadVideoToExternalApi(MultipartFile file, Optional<String> optUrl) {
        //todo to implement
    }
}
