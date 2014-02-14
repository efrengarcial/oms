package com.touresbalon.oms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.domain.Story;

@Repository
public interface StoryRepository extends CrudRepository<Story, String> {

    public List<Story> findAll();
}