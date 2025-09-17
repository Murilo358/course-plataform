package com.video.courses.controller.video;

import com.video.courses.service.video.VideosService;
import com.video.courses.dto.video.VideoUploadDto;
import com.video.courses.dto.video.PreVideoUploadReturnDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/videos")
public class VideosController {


    private final VideosService videosService;

    public VideosController(VideosService videosService) {
        this.videosService = videosService;
    }

    @GetMapping(value="/upload-url")
    public ResponseEntity<PreVideoUploadReturnDTO> uploadVideo() {
        return ResponseEntity.ok(videosService.getUploadUrl());
    }

    @PostMapping
    public ResponseEntity<Long> createNewVideo(@RequestBody VideoUploadDto videoUploadDto){
        return ResponseEntity.ok(videosService.createNewVideo(videoUploadDto));
    }

}
