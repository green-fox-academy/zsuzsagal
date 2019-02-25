package com.reddit.spring;

import com.reddit.spring.model.Post;
import com.reddit.spring.model.User;
import com.reddit.spring.repository.PostRepository;
import com.reddit.spring.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  private PostRepository postRepository;
  private UserRepository userRepository;

  public Application(PostRepository postRepository, UserRepository userRepository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    User Dave = new User("Dave");
    User Emily = new User("Emily");
    User Emma = new User("Emma");
    User Chris = new User("Chris");
    User Pablo = new User("Pablo");
    List<User> users = Arrays.asList(Dave, Emily, Emma, Chris, Dave, Pablo);
    userRepository.saveAll(users);
    postRepository.save(new Post("How the Right Nutrition Can Strengthen Your Kids' Bones", Dave));
    postRepository.save(new Post("A Parent's Guide to Promoting Your Child's Social Well-Being", Dave));
    postRepository.save(new Post("Recipes for Quick & Healthy Dinners", Emma));
    postRepository.save(new Post("15 Brilliant Brands Who Are Killing It on Snapchat", Chris));
    postRepository.save(new Post("15 Inspiring Brands Who Just Get It", Chris));
    postRepository.save(new Post("A Step-By-Step Guide", Pablo));
    postRepository.save(new Post("A Guide To Feeding Toddlers", Pablo));
    postRepository.save(new Post("25 Harry Potter Gadgets Every Fan Should Have", Emma));
    postRepository.save(new Post("Secrets No One Has Told You About", Pablo));
    postRepository.save(new Post("Here Are 10 Realities No One Will Tell You", Chris));
    postRepository.save(new Post("20 Things No One Will Tell You About Mosquitoes", Pablo));
    postRepository.save(new Post("Mistakes And How To Avoid Them", Dave));
    postRepository.save(new Post("7 Tips To Engage And Delight Your Audience", Emma));
    postRepository.save(new Post("How To Easily And Quickly Change Your Tire Alone: 12 Steps.", Chris));
    postRepository.save(new Post("Why Successful People Plan Their Lives 90 Days At A Time", Emma));
    postRepository.save(new Post("10 Jewelry Shops Where You Can Buy An Affordable Diamond", Emily));
    postRepository.save(new Post("Master These 7 Essential Elements For Winning Content ", Dave));
    postRepository.save(new Post("How I Groom My Cat: A Funny Infographic For Cat Lovers", Chris));
  }
}
