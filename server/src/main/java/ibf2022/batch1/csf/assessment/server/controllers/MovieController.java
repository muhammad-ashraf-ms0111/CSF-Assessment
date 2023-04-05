package ibf2022.batch1.csf.assessment.server.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.batch1.csf.assessment.server.models.Review;
import ibf2022.batch1.csf.assessment.server.services.MovieService;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;

@RestController
@RequestMapping(path="/api/reviews") //consumes = MediaType.APPLICATION_JSON_VALUE, 
        //produces = MediaType.APPLICATION_JSON_VALUE)
    
public class MovieController {

	// TODO: Task 3, Task 4, Task 8

	//Task3: Write a request handler in MovieController class

    @Autowired
    private MovieService movieSvc;
    
    @GetMapping
    public ResponseEntity<List<Review>> searchReviews(@RequestParam(value = "query") String title) {
        List<Review> r = movieSvc.searchReviews(title);
        return ResponseEntity.ok(r);
    }
    // public ResponseEntity<String> searchReviews(
    //     @RequestParam(required=true) String query,
				
	// 	JsonArray result = null;
    //     List<Review> or = this.movieSvc.searchReviews(query);
        
    //     JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
    //     for (Review mc : or)
    //         arrBuilder.add(mc.toJSON());
    //     result = arrBuilder.build();
    //     return ResponseEntity
    //         .status(HttpStatus.OK)
    //         .contentType(MediaType.APPLICATION_JSON)
    //         .body(result.toString());
    // }


		
}

