package com.todd.majorChordsServer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/")
public class RootController {

    @Value("${server.version}")
    private String versionString;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getRootPath(){
        Map<String, Object> map = new HashMap<>();
        map.put("status", "running");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping(path = "/v")
    public ResponseEntity<Map<String, Object>> getVersion(){
        Map<String, Object> map = new HashMap<>();
        map.put("version", versionString);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
