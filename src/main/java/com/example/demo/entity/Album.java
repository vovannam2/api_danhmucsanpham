@Entity
@Table(name = "albums")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String coverImageUrl;
    private LocalDate releaseDate;
    
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    
    @OneToMany(mappedBy = "album")
    private List<Song> songs;
    
    @Enumerated(EnumType.STRING)
    private Genre genre;
} 