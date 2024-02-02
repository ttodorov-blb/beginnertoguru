package ttodorov.blubito.spring.beginnertoguru.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ttodorov.blubito.spring.beginnertoguru.domain.Author;
import ttodorov.blubito.spring.beginnertoguru.domain.Book;
import ttodorov.blubito.spring.beginnertoguru.domain.Publisher;
import ttodorov.blubito.spring.beginnertoguru.repositories.AuthorRepository;
import ttodorov.blubito.spring.beginnertoguru.repositories.BookRepository;
import ttodorov.blubito.spring.beginnertoguru.repositories.PublisherRepository;

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
        System.out.println("Started in bootstrap");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Number of books: " + bookRepository.count());

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        Book tg = new Book("trimata glupaci", "1513516");
        bookRepository.save(tg);
        publisher.getBooks().add(tg);
        publisherRepository.save(publisher);

        System.out.println("Publisher's books count: " + publisher.getBooks().size());
        System.out.println("Number of books: " + bookRepository.count());

        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
