package com.wtf.oms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wtf.oms.domain.Story;

@Repository
public interface StoryRepository extends CrudRepository<Story, String> {

    public List<Story> findAll();
}
