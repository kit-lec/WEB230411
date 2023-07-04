package com.lec.spring.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    private Long id;   // 글 id (PK)
    private String subject;
    private String content;
    private LocalDateTime regDate;
    private long viewCnt;

    private User user;    // 글 작성자 (FK)

    @ToString.Exclude
    @Builder.Default
    private List<Attachment> fileList = new ArrayList<>();

}











