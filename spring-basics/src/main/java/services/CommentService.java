package services;

import aspects.ToLog;
import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;

import java.util.logging.Logger;

@Service
public class CommentService {
    private final CommentNotificationProxy commentNotificationProxy;
    private final CommentRepository commentRepository;
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @Autowired
    public CommentService(@Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy, CommentRepository commentRepository) {
        this.commentNotificationProxy = commentNotificationProxy;
        this.commentRepository = commentRepository;
    }

    public String publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
        logger.info("Publishing comment: " + comment.getText());
        return "Success";
    }

    @ToLog
    public void deleteComment(Comment comment) {
        logger.info("Deleting comment " + comment.getText());
    }

    public void editComment(Comment comment) {
        logger.info("Editing comment " + comment.getText());
    }
}
