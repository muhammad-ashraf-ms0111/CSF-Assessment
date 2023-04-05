package ibf2022.batch1.csf.assessment.server.services;


import java.util.List;

import ibf2022.batch1.csf.assessment.server.models.Review;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {
	
	// @Value("${csf.movie.api.url}")
	// private String movieApiUrl;
	@Autowired
	private RestTemplate restTemplate;

	@Value("${csf.movie.api.key}")
	private String movieApiKey;
	public static final String nytimesUrl = "https://api.nytimes.com/svc/movies/v2/reviews/search.json?";
	
public List<Review> searchReviews(String query) {
	String api_uri = nytimesUrl + query + "&api-key=" + movieApiKey;
	
	try {
		ResponseEntity<Results> forEntity = restTemplate.getForEntity(api_uri, Results.class);
		Results body = forEntity.getBody();
		return body.r();
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}
record Results(List<Review> r) {}
}



// public Optional<List<Review>> searchReviews(String query){
// 	ResponseEntity<String> resp = null;
// 	List<Review> c = null;

//UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(nytimesUrl)
// 			.queryParam("query", query)
// 			.queryParam("api-key", movieApiKey);
	
	
// 	String nytimesApiUrl = builder.toUriString();
// 	System.out.println(nytimesApiUrl);

// 	RestTemplate template = new RestTemplate();
// 	resp = template.getForEntity(nytimesApiUrl,String.class);
// 	System.out.println(resp);
	
// 	c = Review.create(resp.getBody());
	
// 	System.out.println(c);
	
// 	if(c != null)
// 		return Optional.of(c);                        
// 	return Optional.empty();
// }
	// TODO: Task 4
	// DO NOT CHANGE THE METHOD'S SIGNATURE

	// public Optional<List<Review>> searchReviews(String query, Integer limit, Integer offset) {
	// 	return null;
	// }


	
