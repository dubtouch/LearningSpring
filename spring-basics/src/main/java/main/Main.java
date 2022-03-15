package main;


import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import services.CommentService;

import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var comment = new Comment();
        comment.setAuthor("Jim");
        comment.setText("this is my first comment");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
        commentService.deleteComment(comment);
        commentService.editComment(comment);

    }
}
