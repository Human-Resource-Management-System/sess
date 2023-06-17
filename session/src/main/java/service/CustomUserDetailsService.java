package service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import DAO.UserRepository;
import model.User;

public class CustomUserDetailsService implements UserDetailsService {


	   private UserRepository userRepository;

	   // Inject the necessary dependencies, such as a UserRepository or DataSource
	   public CustomUserDetailsService(UserRepository userRepository) {
	      this.userRepository = userRepository;
	   }
	   
	   @Override
	   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	      // Perform a database query to retrieve the user details based on the username
	      // Map the retrieved data to an instance of UserDetails and return it

	      // Example code:
	      User user = userRepository.findByUsername(username);
	      if (user == null) {
	         throw new UsernameNotFoundException("User not found");
	      }

	      return new org.springframework.security.core.userdetails.User(
	            user.getUsername(),
	            user.getPassword(),
	            user.getAuthorities()
	      );
	   }
	}
