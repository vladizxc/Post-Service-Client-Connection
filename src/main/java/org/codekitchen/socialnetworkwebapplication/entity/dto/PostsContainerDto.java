package org.codekitchen.socialnetworkwebapplication.entity.dto;

import org.codekitchen.socialnetworkwebapplication.entity.dto.PostDto;

import java.util.List;

public class PostsContainerDto {
    private List<PostDto> posts;

    public List<PostDto> getPosts(){
        return posts;
    }
}
