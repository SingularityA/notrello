package com.epam.notrello.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto {

    private Long id;

    @NotBlank(message = "Note title shouldn't be blank!")
    @Size(max = 50, message = "Note title should be up to 50 characters")
    private String title;

    @Size(max = 800, message = "Note text should be up to 800 characters")
    private String text;

    private LocalDateTime created;

    private LocalDateTime lastUpdated;
}
