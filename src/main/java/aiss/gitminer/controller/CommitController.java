package aiss.gitminer.controller;


import aiss.gitminer.model.Commit;
import aiss.gitminer.repository.CommitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gitminer/commits")
public class CommitController {

    @Autowired
    CommitRepository commitRepository;

    @GetMapping
    public List<Commit> getCommits() {return commitRepository.findAll();}

    @GetMapping("{id}")
    public Commit getCommitById(@RequestParam String id) {return commitRepository.findById(id).get();}
}
