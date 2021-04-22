package com.smpark.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Account account = new Account();
		account.setUsername("smpark");
		account.setPassword("jpa");
		
		Study study = new Study();
		study.setName("Spring Data Jpa");
		
		account.getStudies().add(study);
		
		Session session = entityManager.unwrap(Session.class);
		session.save(account);
		session.save(study);
	}
	
}
