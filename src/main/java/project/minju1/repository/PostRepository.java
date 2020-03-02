package project.minju1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.minju1.entity.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllPostByMemberId(Long memberId);

    List<Post> findByTitle(String title);

    List<Post> findAllPostByMemberUsername(String username);
}
