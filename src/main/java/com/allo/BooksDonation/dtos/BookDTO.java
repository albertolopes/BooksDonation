package com.allo.BooksDonation.dtos;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long bookId;

    private String selfLink;

    private BookInfoDTO volumeInfo;
}
