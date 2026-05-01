package com.huly.backend.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/math")
public class MathController {

    @PostMapping("/sum")
    public ResponseEntity<Map<String, Integer>> sum(@RequestBody Map<String, Integer> body) {
        int a = body.getOrDefault("a", 0);
        int b = body.getOrDefault("b", 0);
        return ResponseEntity.ok(Map.of("result", a + b));
    }
}
