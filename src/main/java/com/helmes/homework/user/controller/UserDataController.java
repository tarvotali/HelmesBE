package com.helmes.homework.user.controller;

import com.helmes.homework.sector.entity.Sector;
import com.helmes.homework.sector.repository.SectorRepository;
import com.helmes.homework.user.entity.User;
import com.helmes.homework.user.entity.UserDataRequest;
import com.helmes.homework.user.entity.UserDataResponse;
import com.helmes.homework.user.repository.UserRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserDataController {

    private static final Logger logger = LoggerFactory.getLogger(UserDataController.class);
    private final UserRepository userRepository;
    private final SectorRepository sectorRepository;


    @Autowired
    public UserDataController(UserRepository userRepository, SectorRepository sectorRepository) {
        this.userRepository = userRepository;
        this.sectorRepository = sectorRepository;
    }

    @PostMapping("/userData/submit")
    public ResponseEntity<Long> submitUserData(@Valid @RequestBody UserDataRequest userDataRequest) {
        try {
            logger.info("Received UserData: {}", userDataRequest);
            List<Sector> userSectors = userDataRequest.getUserSectors().stream()
                    .map(sectorId -> sectorRepository.findById(sectorId).orElseThrow(() -> new IllegalArgumentException("Invalid sector id: " + sectorId)))
                    .collect(Collectors.toList());

            User user = new User();
            user.setName(userDataRequest.getName());
            user.setUserSectors(userSectors);
            user.setAgreeToTerms(userDataRequest.isAgreeToTerms());
            var savedUser = userRepository.save(user);

            return ResponseEntity.ok(savedUser.getUserId());
        } catch (Exception e) {
            logger.error("Error occurred while processing user data: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/userData/{userId}")
    public ResponseEntity<UserDataResponse> getUserData(@PathVariable("userId") Long userId) {
        User user = userRepository.getReferenceById(userId);

        UserDataResponse userDataResponse = new UserDataResponse();
        userDataResponse.setName(user.getName());
        userDataResponse.setUserSectors(user.getUserSectors().stream().map(Sector::getId).collect(Collectors.toList()));
        userDataResponse.setAgreeToTerms(user.isAgreeToTerms());

        return ResponseEntity.ok().body(userDataResponse);
    }
}
