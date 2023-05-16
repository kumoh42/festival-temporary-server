package com.kumoh42.festivalserver;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Repository
public class ImageRepository {

    private final String NIGHT_MARKET_BASE_PATH = "/images/";
    private final String EVENT_IMAGE_PATH = "/images/event.png";
    private final String SHOW_TABLE_BASE_PATH = "/images/show-table/";

    public Optional<byte[]> findNightMarketImage(String folder, String num) throws IOException {
        InputStream in = getClass().getResourceAsStream(NIGHT_MARKET_BASE_PATH + folder + "/" + num + ".png");
        return Optional.of(IOUtils.toByteArray(in));
    }

    public Optional<byte[]> findEventImage() throws IOException {
        InputStream in = getClass().getResourceAsStream(EVENT_IMAGE_PATH);
        return Optional.of(IOUtils.toByteArray(in));
    }

    public Optional<byte[]> findShowTableImage(int num) throws IOException {
        InputStream in = getClass().getResourceAsStream(SHOW_TABLE_BASE_PATH + num + ".png");
        return Optional.of(IOUtils.toByteArray(in));
    }

}
