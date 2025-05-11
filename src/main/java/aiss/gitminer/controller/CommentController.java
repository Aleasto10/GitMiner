package aiss.gitminer.controller;

import aiss.gitminer.model.Comment;
import aiss.gitminer.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gitminer/comments")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping
    public List<Comment> getComments() {return commentRepository.findAll();}

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable String id) {return commentRepository.findById(id).get();}
}
