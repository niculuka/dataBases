package classes;

import javax.persistence.*;

@Entity
@Table(name = "post_comment")
public class PostComment {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "review")
    private String review;

    @ManyToOne
    private Post post;

    public PostComment(String review) {
        this.review = review;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public PostComment(long id, String review, Post post) {
        this.id = id;
        this.review = review;
        this.post = post;
    }

    public PostComment(String review, Post post) {
        this.review = review;
        this.post = post;
    }
}
