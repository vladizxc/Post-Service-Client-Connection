package org.codekitchen.socialnetworkwebapplication.controller;

import org.codekitchen.socialnetworkwebapplication.client.PostClient;
import org.codekitchen.socialnetworkwebapplication.entity.dto.PostDto;
import org.codekitchen.socialnetworkwebapplication.entity.dto.PostsContainerDto;
import org.codekitchen.socialnetworkwebapplication.entity.dto.request.CreatePostRequest;
import org.codekitchen.socialnetworkwebapplication.entity.dto.request.UpdatePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommonController {

    private final PostClient postClient;

    @Autowired
    public CommonController(PostClient postClient) {
        this.postClient = postClient;
    }

    @GetMapping("/")
    public String redirectToMainPage(){
        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String getMainPage(Model model){
        PostsContainerDto posts = postClient.findAll();
        model.addAttribute("posts", posts.getPosts());
        return "main-page";
    }

    @GetMapping("/posts/{id}")
    public String getPostDetailPage(@PathVariable int id, Model model){
        PostDto post = postClient.findById(id);
        model.addAttribute("post", post);
        return "details-page";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(int id){
        postClient.deleteById(id);
        return "redirect:/posts";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam String author,
                             @RequestParam String title){
        CreatePostRequest request = new CreatePostRequest(author, title);
        postClient.save(request);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/update")
    public String updatePost(@PathVariable int id,
                             @RequestParam String author,
                             @RequestParam String title,
                             @RequestParam int numberOfLikes,
                             @RequestParam int numberOfDislikes){
        UpdatePostRequest request = new UpdatePostRequest(author, title, numberOfLikes, numberOfDislikes);
        postClient.update(id, request);
        return "redirect:/posts/" + id;
    }
}
