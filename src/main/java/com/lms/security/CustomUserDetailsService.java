package com.lms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.lms.entity.Employee;
import com.lms.repository.EmployeeRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private EmployeeRepo employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Employee employee = employeeRepository.findByEmail(email);
		if (employee == null) {
			throw new UsernameNotFoundException("User name Not found");
		}
		return new CustomUser(employee);
	}

}
