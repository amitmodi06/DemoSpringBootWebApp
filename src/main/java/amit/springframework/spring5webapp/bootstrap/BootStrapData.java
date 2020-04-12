package amit.springframework.spring5webapp.bootstrap;

import amit.springframework.spring5webapp.domain.Author;
import amit.springframework.spring5webapp.domain.Book;
import amit.springframework.spring5webapp.domain.Publisher;
import amit.springframework.spring5webapp.repositories.AuthorRepository;
import amit.springframework.spring5webapp.repositories.BookRepository;
import amit.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * created by KUAM on 4/11/2020
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Author chetan = new Author("Chetan", "Bhagat");
        Book five = new Book("Five Point Someone", "11111");
        Publisher penguin = new Publisher("Penguin", "Trade Tower", "111City", "NewYork", "112233");
        publisherRepository.save(penguin);
        chetan.getBooks().add(five);
        five.getAuthors().add(chetan);

        five.setPublisher(penguin);
        penguin.getBooks().add(five);


        authorRepository.save(chetan);
        bookRepository.save(five);
        publisherRepository.save(penguin);


        Author robin = new Author("Robin", "Sharma");
        Book monk = new Book("The Monk Who Sold His Ferrari", "22222");
        Publisher delta = new Publisher("Delta", "Mangolpuri", "Delhi", "New Delhi", "100001");
        publisherRepository.save(delta);
        robin.getBooks().add(monk);
        monk.getAuthors().add(robin);

        monk.setPublisher(delta);
        delta.getBooks().add(monk);

        authorRepository.save(robin);
        bookRepository.save(monk);
        publisherRepository.save(delta);

        System.out.println("Started in BootStrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("NUmber of Publishers: " +  publisherRepository.count());

        System.out.println("Publisher "+penguin.getName()+ " has books: "+penguin.getBooks().size());
        System.out.println("Publisher "+delta.getName()+" has books: "+delta.getBooks().size() );

    }
}
