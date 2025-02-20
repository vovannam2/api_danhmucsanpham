package com.example.demo.repository;

import com.example.demo.entity.Genre;
import com.example.demo.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    
    List<Song> findByGenre(Genre genre);
    
    @Query("SELECT s FROM Song s ORDER BY s.playCount DESC")
    List<Song> findTopByPlayCount();
    
    @Query("SELECT s FROM Song s WHERE s.createdDate >= :date")
    List<Song> findRecentSongs(LocalDateTime date);
} 