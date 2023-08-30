package com.example.Note.feature.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>, JpaSpecificationExecutor<Note> {



    @Modifying
    @Query(nativeQuery = true, value = "UPDATE notes SET title =:title, content= :content WHERE id =:id")
    void updateNotesByIds (@Param("id") Long id, @Param("title") String title, @Param("content") String content);


//    @Query(nativeQuery = true, value = "INSERT INTO notes (id, user_id, title, content, access_type) " +
//            "VALUES (user_id=2, title =:title, content= :content, access_type='isPublic' WHERE id =:id)")
//    void createNotesByIds (@Param("id") Long id, @Param("title") String title, @Param("content") String content);





}
