package de.kessel.elena.service;

import de.kessel.elena.entity.PostBlog;
import de.kessel.elena.repository.PostBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostBlogService {
    private final PostBlogRepository repository;

    public PostBlogService(final PostBlogRepository repository){
        this.repository = repository;
    }

    public PostBlog savePostBlog(final PostBlog postBlog){
        return repository.save(postBlog);
    }

    public List<PostBlog> savePostBlogs(final List<PostBlog> postBlogs){
        return repository.saveAll(postBlogs);
    }

    public List<PostBlog> findPostBlogs(){
        return repository.findAll();
    }
}
