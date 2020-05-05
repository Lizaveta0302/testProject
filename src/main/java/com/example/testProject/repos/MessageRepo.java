package com.example.testProject.repos;

import com.example.testProject.entity.FileModel;
import com.example.testProject.entity.Message;
import com.example.testProject.entity.User;
import com.example.testProject.entity.dto.MessageDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {

    @Query("select new com.example.testProject.entity.dto.MessageDto(" +
            "   m, " +
            "   count(ml), " +
            "   sum(case when ml = :user then 1 else 0 end) > 0" +
            ") " +
            "from Message m left join m.likes ml " +
            "group by m order by m.likes.size desc")
    Iterable<MessageDto> findAll(@Param("user") User user);

    @Query("select new com.example.testProject.entity.dto.MessageDto(" +
            "   m, " +
            "   count(ml), " +
            "   sum(case when ml = :user then 1 else 0 end) > 0" +
            ") " +
            "from Message m left join m.likes ml " +
            "where m.tag = :tag " +
            "group by m")
    List<MessageDto> findByTag(@Param("tag") String tag, @Param("user") User user);

    @Query("select new com.example.testProject.entity.dto.MessageDto(" +
            "   m, " +
            "   count(ml), " +
            "   sum(case when ml = :user then 1 else 0 end) > 0" +
            ") " +
            "from Message m left join m.likes ml " +
            "where m.author = :author " +
            "group by m")
    List<MessageDto> findByUser(@Param("author") User author, @Param("user") User user);
}
