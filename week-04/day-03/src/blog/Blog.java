package blog;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Blog {
    //  Create a Blog class which can
    //  store a list of BlogPosts
    //  add BlogPosts to the list
    //  delete(int) one item at given index
    //  update(int, BlogPost) one item at the given index and update it with another BlogPost

    ArrayList<BlogPost> blogPosts;

    public Blog(ArrayList <BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }

    public void add(BlogPost bp)
    {
        blogPosts.add(bp);
    }

    public void delete(int index)
    {
        blogPosts.remove(blogPosts.get(index));
    }

    public void update(int index, BlogPost bp) {
        blogPosts.get(index).authorName = bp.authorName;
        blogPosts.get(index).title = bp.title;
        blogPosts.get(index).text = bp.text;
        blogPosts.get(index).publicationDate = bp.publicationDate;
    }
}


