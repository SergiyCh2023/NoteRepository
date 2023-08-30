package com.example.Note.feature.note;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Table(name = "notes")
@NoArgsConstructor
@Data@AllArgsConstructor
@Service
@Entity
public class Note {

    public Note(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
    @Id
    private long id;
    private String title;
    private String content;
    @Enumerated(EnumType.STRING)
    @Column (name="access_type")
    private Access access;





}
