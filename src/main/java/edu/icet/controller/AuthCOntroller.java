package edu.icet.controller;

import edu.icet.dto.LoginRequest;
import edu.icet.dto.RegisterRequest;
import edu.icet.entity.User;
import edu.icet.repository.UserRepository;
import edu.icet.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin // Frontend එකෙන් එන requests block වෙන්නේ නැති වෙන්න
public class AuthController {

    // Dependency Injection සඳහා variables ටික declare කරගන්නවා
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // 1. Register: User කෙනෙක්ව Database එකට එකතු කිරීම
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequest request) {
        // Email එක දැනටමත් තියෙනවද බලනවා
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Email already exists!"));
        }

        // අලුත් User කෙනෙක් හදනවා
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())) // Password එක Encrypt කරනවා
                .role("USER") // Default role එක දානවා
                .build();

        userRepository.save(user); // DB එකට save කරනවා
        return ResponseEntity.ok(Map.of("message", "User registered successfully!"));
    }

    // 2. Login: Userව පරීක්ෂා කරලා JWT Token එකක් නිකුත් කිරීම
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        try {
            // Email/Password හරිද කියලා Spring Security එකෙන් බලනවා
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            // User හරි නම් Token එකක් හදනවා
            User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
            String jwtToken = jwtService.generateToken(user);

            // Token එක Frontend එකට යවනවා
            return ResponseEntity.ok(Map.of("token", jwtToken));
        } catch (Exception e) {
            // මොකක් හරි වැරදුනොත් Error එකක් දෙනවා
            return ResponseEntity.status(401).body(Map.of("error", "Invalid email or password"));
        }
    }
}