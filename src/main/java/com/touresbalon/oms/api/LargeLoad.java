package com.touresbalon.oms.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.touresbalon.oms.domain.oracle.Data;

@RequestMapping("/largeLoad")
@Controller
public class LargeLoad {

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Data>  load() {
    	List<Data> list = new ArrayList<Data>();
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> forEntity = restTemplate.getForEntity(
                "http://angular-ui.github.io/ng-grid/jsonFiles/largeLoad.json", List.class);
        if (forEntity.hasBody()) {
        	for (Object item:  forEntity.getBody()) {
				Map<String,Object> map= (Map<String,Object>)item;
				Data data = new Data();
				data.setName((String)map.get("name"));
				data.setAllowance(map.get("allowance").toString());
				System.out.println(map);
				list.add(data);
			}
        }
        return list;
    }
}
