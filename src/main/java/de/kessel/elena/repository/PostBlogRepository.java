package de.kessel.elena.repository;

import de.kessel.elena.entity.PostBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostBlogRepository extends JpaRepository<PostBlog, Integer> {
}
