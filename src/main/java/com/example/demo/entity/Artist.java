@Entity
@Table(name = "artists")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String bio;
    private String imageUrl;
    
    @OneToMany(mappedBy = "artist")
    private List<Album> albums;
    
    @OneToMany(mappedBy = "artist")
    private List<Song> songs;
    
    @ManyToMany(mappedBy = "followedArtists")
    private Set<User> followers;
} 