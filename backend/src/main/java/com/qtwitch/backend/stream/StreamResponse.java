package com.qtwitch.backend.stream;

public record StreamResponse(
        String id,
        String title,
        String channelName,
        String category,
        int viewerCount,
        boolean live,
        String thumbnailColor
) {
}
