package com.hrp.springboot;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hrp.springboot.dao.PropertyPostRepository;
import com.hrp.springboot.dao.RentRequestRepository;
import com.hrp.springboot.entity.PropertyPostBean;
import com.hrp.springboot.entity.RentRequestBean;
import com.hrp.springboot.model.AuthenticationRequest;
import com.hrp.springboot.model.AuthenticationResponse;
//import com.hrp.springboot.service.MyUserDetailsService;

@RestController
@RequestMapping("/house-rent")
public class HouseRentController {
	
	/*@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;*/
	
	@Autowired
	private PropertyPostRepository propertyPostRepository;
	
	@Autowired
	private RentRequestRepository rentRequestRepository;
	
	/*@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Invalida User", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = "JWT token will be generated";
		
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}
*/
	@GetMapping("/fetchPosts")
	public List<PropertyPostBean> getAllPosts() {
		List<PropertyPostBean> postBeanList = null;
		try{
			postBeanList = propertyPostRepository.fetchAllPosts();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return postBeanList;
	}
	
	@PostMapping("/addPost")
	public String savePost(@RequestBody PropertyPostBean postBean) {
		//PropertyPostBean postBean = new PropertyPostBean(1, "Kodampakam", "Chennai", "1-BHK","650", 8500, 101);
		Random rnd = new Random();
	    int number = rnd.nextInt(999999);
		postBean.setPropId(number);
		try{
			return propertyPostRepository.savePost(postBean);
		} catch(Exception e) {
			e.printStackTrace();
			return "Error!";
		}
		
	}
	
	@GetMapping("/rquest-rent/{propId}/{requesterId}")
	public String requestToRentHouse(@PathVariable int propId,@PathVariable int  requesterId) {
		PropertyPostBean postBean = propertyPostRepository.getPropertById(propId);
		Random rnd = new Random();
	    int number = rnd.nextInt(999999);
		RentRequestBean rentBean = new RentRequestBean(number, propId, requesterId, postBean.getOwnerId(), "");
		try{
			return propertyPostRepository.saveRentRequest(rentBean);
		} catch(Exception e) {
			e.printStackTrace();
			return "Error!";
		}
	}
	
	@GetMapping("/rquests-for-owner/{ownerId}")
	public List<RentRequestBean> requestToRentHouse(@PathVariable int  ownerId) {
		try{
			return rentRequestRepository.findAllReqForOwner(ownerId);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@GetMapping("/getAd/{propId}")
	public PropertyPostBean getAd(@PathVariable int propId) {
		PropertyPostBean postBean = propertyPostRepository.getPropertById(propId);
		return postBean;
	}
	
	@GetMapping("/test")
	public String test() {
		
		return "works fine!";
	}
	
	@GetMapping("/fetch-all-req")
	public List<RentRequestBean> getAllRequest() {
		List<RentRequestBean> rentBeanList = null;
		try{
			rentBeanList = propertyPostRepository.fetchAllRequests();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rentBeanList;
	}
}
