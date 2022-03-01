package com.example.examserver;

import com.example.examserver.model.Role;
import com.example.examserver.model.User;
import com.example.examserver.model.UserRole;
import com.example.examserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting Code");

		User user = new User();

		user.setUsername("abd");
		user.setFistName("Piyush");
		user.setLastName("Joshi");
		user.setPassword("abc");
		user.setEmail("Email@gmail.com");
		user.setProfile("default.png");
		user.setEnabled(true);
		user.setPhone("122222");

		Role role = new Role();
		role.setRollName("ADMIN");
		role.setRoleId(44L);

		Set<UserRole> userRoleSet = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);

		userRoleSet.add(userRole);

		this.userService.createUser(user,userRoleSet);
		/*User user1  = this.userService.createUser(user,userRoleSet);
		System.out.println(user1.getUsername());*/
	}
}
