package com.henrybooks.henrybooks.repository;

import com.henrybooks.henrybooks.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO book " +
            "VALUES (:bcode, :title, :pcode, :type, :paperback)", nativeQuery = true)
    int createOne(@Param("bcode") String bcode, @Param("title") String title,
                  @Param("pcode") String pcode, @Param("type") String type,
                  @Param("paperback") String paperback);

    @Modifying
    @Transactional
    @Query(value = "UPDATE book " +
            "SET title = :title, publisherCode = :pcode, type = :type, paperback = :paperback " +
            "WHERE bookCode = :bcode", nativeQuery = true)
    int updateOne(@Param("bcode") String bcode, @Param("title") String title,
                   @Param("pcode") String pcode, @Param("type") String type,
                   @Param("paperback") String paperback);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM book " +
            "WHERE book.bookCode = :id", nativeQuery = true)
    void deleteOne(@Param("id") String id);
}
