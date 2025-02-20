package com.example.demo.dto.response;

import com.example.demo.entity.Genre;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class SongResponse {
    private Long id;
    private String title;
    private String duration;
    private String artistName;
    private String albumName;
    private Long playCount;
    private Genre genre;
} 