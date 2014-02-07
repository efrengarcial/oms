package com.wtf.oms.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/ping")
@Controller
public class PingResource {

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> ping() {
    	 ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
         return responseEntity;
    }
}
