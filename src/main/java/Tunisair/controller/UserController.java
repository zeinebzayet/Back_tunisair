package Tunisair.controller;

import Tunisair.entity.User;
import Tunisair.exception.ResourceNotFoundException;
import Tunisair.payload.request.LoginRequest;
import Tunisair.payload.request.SignupRequest;
import Tunisair.payload.response.JwtResponse;
import Tunisair.payload.response.MessageResponse;
import Tunisair.repository.UserRepository;
import Tunisair.security.jwt.JwtUtils;
import Tunisair.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return  this.userRepository.findAll();
    }
    @GetMapping("/user/{cin}")
    public User getUserById(@PathVariable(value = "cin") Long cin) throws ResourceNotFoundException {
        return  this.userRepository.findById(cin).orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + cin));
    }

    @PostMapping("/user")
    public User addUser( @RequestBody User u) {
        return this.userRepository.save(u);
    }

    @PutMapping("/user/{cin}")
    public ResponseEntity<User> updateUser(@PathVariable(value="cin") Long cin, @RequestBody User userDetails) throws ResourceNotFoundException{
        User u = userRepository.findById(cin).orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + cin));
        u.setUsername(userDetails.getUsername());
        u.setEmail(userDetails.getEmail());
        u.setTel(userDetails.getTel());

        u.setPassword(encoder.encode(userDetails.getPassword()));
        u.setRole(u.getRole());

        final User updateUser=userRepository.save(u);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/user/{cin}")
    public void deleteUser(@PathVariable(value = "cin") Long cin)throws ResourceNotFoundException {
        User u = userRepository.findById(cin).orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + cin));
        userRepository.deleteById(cin);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        //create object authentification
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        //update SecurityContext using Authentication object qu'on a crée
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getCin(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getTel(),
                userDetails.getPassword(),
                userDetails.getRole()
                ));
    }



    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new user's account
        User user = new User(signUpRequest.getCin(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getTel(),
                encoder.encode(signUpRequest.getPassword()),signUpRequest.getRole());
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


}

