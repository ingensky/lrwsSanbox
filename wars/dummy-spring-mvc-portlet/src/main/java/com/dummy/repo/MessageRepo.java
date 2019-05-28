package com.dummy.repo;

import com.dummy.domain.DummyMessage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<DummyMessage, Long> {

//    List<DummyMessage> getAll();
//    int countAll();
}
