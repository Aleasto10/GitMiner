package aiss.gitminer.controller;

import aiss.gitminer.model.Comment;
import aiss.gitminer.model.Issue;
import aiss.gitminer.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/gitminer/issues")
public class IssueController {

    @Autowired
    IssueRepository issueRepository;

    @GetMapping
    public List<Issue> getIssues() {return issueRepository.findAll();}

    @GetMapping("/{id}")
    public Issue getIssueById(@PathVariable String id) {return issueRepository.findById(id).get();}

    @GetMapping("/{id}/comments")
    public  List<Comment> getCommentsByIssue(@PathVariable String id) {
        return getIssueById(id).getComments();
    }

    @GetMapping("?authorId={id}")
    public List<Issue> getIssuesByAuthorId(@PathVariable String id) {
        List<Issue> issues = new ArrayList<>();
        List<Issue> allIssues = getIssues();
        for (Issue issue : allIssues) {
            if (issue.getAuthor().getId().equals(id)) {
                issues.add(issue);
            }
        }
        return issues;
    }

    @GetMapping("?state={state}")
    public List<Issue> getIssuesByState(@PathVariable String state) {

        List<Issue> issues = getIssues();
        List<Issue> filteredIssues = new ArrayList<>();
        for (Issue issue : issues) {
            if (issue.getState().equals(state)) {
                filteredIssues.add(issue);
            }
        }

        return filteredIssues;
    }
}
