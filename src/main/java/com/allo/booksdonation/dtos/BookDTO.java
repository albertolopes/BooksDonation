package com.allo.booksdonation.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookDTO {

    private Long bookId;

    private String selfLink;

    private BookInfoDTO volumeInfo;
}
