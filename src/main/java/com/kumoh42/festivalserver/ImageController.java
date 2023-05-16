package com.kumoh42.festivalserver;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping(value = "/night-market/{name}/{num}", produces = {MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity<byte[]> getNightMarketImage(@PathVariable String name, @PathVariable String num){
        try {
            return imageService.getNightMarketImage(name, num)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch(IOException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/event", produces = {MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity<byte[]> getEventImage(){
        try {
            return imageService.getEventImage()
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch(IOException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/show-table/{num}", produces = {MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity<byte[]> getShowTableImage(@PathVariable int num){
        try {
            return imageService.getShowTableImage(num)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch(IOException e){
            return ResponseEntity.notFound().build();
        }
    }

}
