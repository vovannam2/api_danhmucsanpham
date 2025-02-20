@Entity
@Table(name = "songs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String duration;
    private String audioUrl;
    private Long playCount;
    
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
    
    @ManyToMany(mappedBy = "songs")
    private Set<Playlist> playlists;
    
    @ManyToMany(mappedBy = "likedSongs")
    private Set<User> likedByUsers;
    
    @Enumerated(EnumType.STRING)
    private Genre genre;
    
    private LocalDateTime createdDate;
    
    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }
} 