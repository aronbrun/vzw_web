package com.website.vzw.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Members")
public class MemberController {

    @Autowired
    private MemberService memberService;


    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getById(@PathVariable Long id) {
        Optional<Member> member = memberService.findById(id);

        if (member.isPresent()) {
            return new ResponseEntity<>(member.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/{username}/{password}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Member> checkLogin(@PathVariable("username") String username, @PathVariable("password") String password){
        Optional<Member> member = memberService.findByLogin(username, password);
        if (member.isPresent()) {
            return new ResponseEntity<>(member.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping({ "", "/" })
    public ResponseEntity<List<Member>> getAll() {
        List<Member> members = memberService.findAll();

        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @PostMapping({ "", "/" })
    public ResponseEntity<Member> create(@Valid @RequestBody Member member) {
        memberService.save(member);

        return new ResponseEntity<>(member, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateById(@PathVariable Long id, @Valid @RequestBody Member member) {
        HttpStatus status = ((memberService.update(member, id)) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(member, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        memberService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
