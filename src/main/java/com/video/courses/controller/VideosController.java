package com.video.courses.controller;

import com.video.courses.VideosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@Slf4j
@RestController("/videos")
public class VideosController {


    private final VideosService videosService;

    public VideosController(VideosService videosService) {
        this.videosService = videosService;
    }

    @PostMapping(name="/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public ResponseEntity<?> uploadVideo(@RequestParam("file") MultipartFile file) {

        return ResponseEntity.ok(videosService.upload(file));
    }
}
