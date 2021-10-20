package ru.springapp.blog.repo;

import org.springframework.data.repository.CrudRepository;
import ru.springapp.blog.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
}
