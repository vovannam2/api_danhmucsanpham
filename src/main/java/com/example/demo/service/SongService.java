package com.example.demo.service;

import com.example.demo.dto.response.SongResponse;
import com.example.demo.entity.Genre;
import com.example.demo.entity.Song;
import com.example.demo.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    // Lấy tất cả danh mục
    public List<Genre> getAllGenres() {
        return Arrays.asList(Genre.values());
    }

    // Lấy bài hát theo danh mục
    public List<SongResponse> getSongsByGenre(Genre genre) {
        return songRepository.findByGenre(genre)
                .stream()
                .map(this::mapToSongResponse)
                .collect(Collectors.toList());
    }

    // Lấy top 10 bài hát có lượt nghe nhiều nhất
    public List<SongResponse> getTopPlayedSongs() {
        return songRepository.findTopByPlayCount()
                .stream()
                .limit(10)
                .map(this::mapToSongResponse)
                .collect(Collectors.toList());
    }

    // Lấy bài hát được tạo trong 7 ngày gần đây
    public List<SongResponse> getRecentSongs() {
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);
        return songRepository.findRecentSongs(sevenDaysAgo)
                .stream()
                .limit(10)
                .map(this::mapToSongResponse)
                .collect(Collectors.toList());
    }

    // Helper method để convert Song thành SongResponse
    private SongResponse mapToSongResponse(Song song) {
        return SongResponse.builder()
                .id(song.getId())
                .title(song.getTitle())
                .duration(song.getDuration())
                .artistName(song.getArtist().getName())
                .albumName(song.getAlbum().getTitle())
                .playCount(song.getPlayCount())
                .genre(song.getGenre())
                .build();
    }
} 