package com.im;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveImage {
	public static void main(String[] args) throws IOException {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Player player=new Player();
		player.setAge(22);
		player.setDoj(new Date());
		player.setGender("Female");
		player.setName("Akash");
		FileInputStream fileInputStream=new FileInputStream("src/main/java/0_3C6CUn1FEC_raM8c.jpeg");
		byte[] data=new byte[fileInputStream.available()];
		fileInputStream.read(data);
		player.setImage(data);
		entityTransaction.begin();
		entityManager.persist(player);
		entityTransaction.commit();
	}
}
