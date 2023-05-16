package com.kumoh42.festivalserver;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public Optional<byte[]> getNightMarketImage(String name, String num) throws IOException {
        return imageRepository.findNightMarketImage(name, num);
    }

    public Optional<byte[]> getEventImage() throws IOException {
        return imageRepository.findEventImage();
    }

    public Optional<byte[]> getShowTableImage(int num) throws IOException {
        return imageRepository.findShowTableImage(num);
    }

}
