package com.qtwitch.backend.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class StreamService {

    private final List<StreamResponse> streams = List.of(
            new StreamResponse(
                    "build-night",
                    "Criando uma engine de chat em tempo real",
                    "DevChannel",
                    "Software e games",
                    18420,
                    true,
                    "linear-gradient(135deg, #7c3aed, #20c997)"
            ),
            new StreamResponse(
                    "ranked-run",
                    "Ranked com a comunidade",
                    "PlayerZero",
                    "Competitivo",
                    12780,
                    true,
                    "linear-gradient(135deg, #ef4444, #f59e0b)"
            ),
            new StreamResponse(
                    "pixel-art",
                    "Arte, sprites e trilha sonora",
                    "StudioLoop",
                    "Arte",
                    8430,
                    true,
                    "linear-gradient(135deg, #06b6d4, #a3e635)"
            ),
            new StreamResponse(
                    "coffee-code",
                    "Manha de codigo: API + frontend",
                    "CafeComDeploy",
                    "Just Chatting",
                    5290,
                    true,
                    "linear-gradient(135deg, #f97316, #14b8a6)"
            )
    );

    public List<StreamResponse> findLiveStreams() {
        return streams.stream()
                .filter(StreamResponse::live)
                .sorted(Comparator.comparingInt(StreamResponse::viewerCount).reversed())
                .toList();
    }

    public Optional<StreamResponse> findById(String id) {
        return streams.stream()
                .filter(stream -> stream.id().equals(id))
                .findFirst();
    }
}
