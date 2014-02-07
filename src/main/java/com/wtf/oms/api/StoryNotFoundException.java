package com.wtf.oms.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StoryNotFoundException extends RuntimeException {

  
	private static final long serialVersionUID = 1L;

	public StoryNotFoundException(String storyId) {
        super(String.format("Story with id %s not found", storyId));
    }
}
