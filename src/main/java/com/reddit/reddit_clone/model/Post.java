package com.reddit.reddit_clone.model;


import java.time.Instant;

import org.springframework.data.annotation.Id;

import jakarta.persistence.*;
import lombok.*;

@Data //Generate getter and setter at runtime
@Entity //JPA 
@Builder //Builder design pattern
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postId;
    private String postName;
    private String url;
    @Lob
    private String description;
    private Integer voteCount = 0;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
    private Instant createdDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Subreddit subreddit;
}
