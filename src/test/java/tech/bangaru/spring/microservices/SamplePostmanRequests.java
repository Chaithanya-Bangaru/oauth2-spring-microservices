package tech.bangaru.spring.microservices;

public class SamplePostmanRequests {
	
	// POST Basic Auth clent/secret http://localhost:8080/oauth/token?grant_type=password&username=raaj&password=12345
		// Bearer token 0eb8fe7d-8913-45ee-8db0-72e767da4248 
	
	/*
	 * { "access_token": "0eb8fe7d-8913-45ee-8db0-72e767da4248", "token_type":
	 * "bearer", "expires_in": 43199, "scope": "read" }
	 */
	// Observation :If the access token has pre/trailing spaces, still the token was valid!!
	
	// GET Bearer token 0eb8fe7d-8913-45ee-8db0-72e767da4248 http://localhost:8080/api/v1/todaysDate
	// GET Bearer token 0eb8fe7d-8913-45ee-8db0-72e767da4248 http://localhost:8080/api/v1/getUsers
	// GET Bearer token 0eb8fe7d-8913-45ee-8db0-72e767da424 http://localhost:8080/api/v1/getUsers
		/*
		 * // { // "error": "invalid_token", // "error_description":
		 * "Invalid access token: 0eb8fe7d-8913-45ee-8db0-72e767da424" // }
		 */	
	
	/*
	 * { "error": "invalid_grant", "error_description": "Bad credentials" }
	 */
	
}
