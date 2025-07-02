package com.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.hello.document.Product;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.internal.bulk.UpdateRequest;


@Service
public class IserviceImpl implements IService {
	@Autowired
	private MongoTemplate mt;
	
	@Override
	public String register(Product p) {

//		return mt.save(p).getId();
		
		mt.insertAll(null);
		
		
		return "";
		
	}
	
	@Override
	public void m() {
		Product p2 = new Product("hp laptop",60_000.);
		Product p3 = new Product("dell laptop",90_000.);
		Product p4 = new Product("I5 processor",1_30_000.);
		Product p5 = new Product("I7 processor",1_90_000.);
		List<Product> li = List.of(p3);
		
//		mt.insertAll(li).forEach(System.out::println);
		
//		Query query = new Query();
//		query.addCriteria(Criteria.where("price").gte(60000.).lte(90000.));
//		mt.find(query, Product.class, "product").forEach(System.out::println);;
	
//		Query query = new Query();
//		query.addCriteria(Criteria.where("price").in(60000,90000));
//		mt.find(query, Product.class, "product").forEach(System.out::println);;
	
		
//		Query query = new Query();
//		query.addCriteria(Criteria.where("pName").regex("^i", "i"));
//		mt.find(query, Product.class).forEach(System.out::println);
	
//		Query query = new Query();
//		query.addCriteria(Criteria.where("pName").is("Hp Laptop"));
//		Update update = new Update();
//		update.set("pName", "Hp Laptop");
//		update.set("price", 68000);
//		System.out.println(mt.findAndModify(query, update, Product.class).getPName());
		
//		
//		Query query = new Query();
//		query.addCriteria(new Criteria().orOperator(Criteria.where("pName").is("Hp Laptop"), Criteria.where("pName").is("dell laptop")));
//		Update update = new Update();
//		update.set("price", 69000);
//		UpdateResult ur = mt.updateMulti(query, update, Product.class);
//		System.out.println(ur.getModifiedCount());
//		
		
		
		
	}
}
