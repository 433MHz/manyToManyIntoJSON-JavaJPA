package pl.krystian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {
	
	@Autowired
	BooksRepo booksRepo;
	
	@Autowired
	UserRepo userRepo;

	@PostMapping("/setAll")
	public void setRepos() {
		User user = new User();
		
		Books book = new Books();
		
		user.setName("Krystian Izdebski");
		book.setBookName("Robinson");
		user.setBook(book);
		
		userRepo.save(user);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/getAllBooks")
	public List<Books> getBooks(){
		return booksRepo.findAll();
	}
}
