package blogPost;

public class BlogPost {
    //Create a BlogPost class that has
    //an authorName
    //a title
    //a text
    //a publicationDate

    String authorName;
    String title;
    String text;
    String publicationDate;

    public BlogPost(String authorName, String title, String text, String publicationDate) {
        this.authorName = authorName;
        this.title = title;
        this.text = text;
        this.publicationDate = publicationDate;
    }

    public String toString() {
        return "The author is: " + authorName + ", the title is: " + title + ", the text is: " + text + " publicationDate is: " + publicationDate;
    }
}
