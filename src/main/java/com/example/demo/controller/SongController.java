package com.example.demo.controller;

import com.example.demo.dto.response.SongResponse;
import com.example.demo.entity.Genre;
import com.example.demo.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getAllGenres() {
        return ResponseEntity.ok(songService.getAllGenres());
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<SongResponse>> getSongsByGenre(@PathVariable Genre genre) {
        return ResponseEntity.ok(songService.getSongsByGenre(genre));
    }

    @GetMapping("/top-played")
    public ResponseEntity<List<SongResponse>> getTopPlayedSongs() {
        return ResponseEntity.ok(songService.getTopPlayedSongs());
    }

    @GetMapping("/recent")
    public ResponseEntity<List<SongResponse>> getRecentSongs() {
        return ResponseEntity.ok(songService.getRecentSongs());
    }
} 