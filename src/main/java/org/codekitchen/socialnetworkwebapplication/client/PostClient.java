package org.codekitchen.socialnetworkwebapplication.client;

import org.codekitchen.socialnetworkwebapplication.entity.dto.PostDto;
import org.codekitchen.socialnetworkwebapplication.entity.dto.PostsContainerDto;
import org.codekitchen.socialnetworkwebapplication.entity.dto.request.CreatePostRequest;
import org.codekitchen.socialnetworkwebapplication.entity.dto.request.UpdatePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PostClient {

    @Value("${post.client.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public PostClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PostsContainerDto findAll(){
        return restTemplate.getForObject(baseUrl, PostsContainerDto.class);
    }

    public PostDto findById(int id){
        return restTemplate.getForObject(baseUrl + "/" + id, PostDto.class);
    }

    public void deleteById(int id){
        restTemplate.delete(baseUrl + "/" + id);
    }

    public PostDto save(CreatePostRequest request){
        return restTemplate.postForObject(baseUrl, request, PostDto.class);
    }

    public PostDto update(int id, UpdatePostRequest request){
        //restTemplate.put(baseUrl + "/" + id, request);
        return restTemplate.exchange(
                baseUrl + "/" + id,
                HttpMethod.PUT,
                new HttpEntity<>(request),
                PostDto.class
        ).getBody();
    }
}
