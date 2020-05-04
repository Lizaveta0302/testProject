package com.example.testProject.entity.dto;

import com.example.testProject.entity.FileModel;
import com.example.testProject.entity.Message;
import com.example.testProject.entity.User;
import com.example.testProject.entity.util.MessageHelper;

import java.util.HashSet;
import java.util.Set;

public class MessageDto {
    private Long id;
    private String text;
    private String tag;
    private User author;
    private FileModel file;
    private Long likes;
    private Boolean meLiked;

    public MessageDto(Message message,Long likes, Boolean meLiked) {
        this.id = message.getId();
        this.text = message.getText();
        this.tag = message.getTag();
        this.author = message.getAuthor();
        this.file = message.getFile();
        this.likes = likes;
        this.meLiked = meLiked;
    }

    public String getAuthorName() {
        return MessageHelper.getAuthorName(author);
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    public User getAuthor() {
        return author;
    }

    public FileModel getFile() {
        return file;
    }

    public Long getLikes() {
        return likes;
    }

    public Boolean getMeLiked() {
        return meLiked;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", author=" + author +
                ", likes=" + likes +
                ", meLiked=" + meLiked +
                '}';
    }
}
