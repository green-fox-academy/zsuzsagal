package blog;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BlogPost postOne = new BlogPost("John Doe", "Lorem Ipsum", "Lorem ipsum dolor sit amet.", "2000.05.04");
        BlogPost postTwo = new BlogPost("Tim Urban", "Wait but why", "A popular long-form, stick-figure-illustrated blog about almost everything.", "2010.10.10.");
        BlogPost postThree = new BlogPost("William Turton", "One Engineer Is Trying to Get IBM to Reckon With Trump", "Daniel Hanley, a cybersecurity engineer at IBM.", "2017.03.28.");
        BlogPost postFour = new BlogPost("Tom Brown", "Lorem lorem", "Lorem ipsum dolor sit amet and more lorem ipsum.", "2005.03.16");

        BlogPost anotherBlogPost = new BlogPost("Joshua Bloch", "Effective Java", "This highly anticipated new edition of the classic to cover Java SE 5 and Java SE 6 features introduced since the first edition.", "04-23-2006");

        ArrayList<BlogPost> blogPosts = new ArrayList<>();

        blogPosts.add(postOne);
        blogPosts.add(postTwo);
        blogPosts.add(postThree);
        blogPosts.add(postFour);

        Blog myBlog = new Blog(blogPosts);
        System.out.println(blogPosts);

        System.out.println(" -------------------");
        myBlog.delete(3);
        System.out.println(blogPosts);

        System.out.println(" -------------------");
        myBlog.update(2, anotherBlogPost);
        System.out.println(blogPosts);
    }
}
