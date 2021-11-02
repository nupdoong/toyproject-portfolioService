package com.portfolio.sharing.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.portfolio.sharing.model.SubscribeList;

public interface SubscribeRepository extends CrudRepository<SubscribeList, Long>{

	List<SubscribeList> findBySubscriber(String subscriber);
	
	void deleteBySubscriberAndPublisher(String subscriber, String publisher);
}
