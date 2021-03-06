package com.example.testProject.service;

import com.example.testProject.entity.Hike;
import com.example.testProject.entity.Role;
import com.example.testProject.entity.User;
import com.example.testProject.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private HikeServiceImpl hikeService;

    //@Autowired
    //private MailSender mailSender;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public User getByname(String name) {
        return userRepo.findByUsername(name);
    }

    public Optional<User> getById(Long id) {
        return userRepo.findById(id);
    }

    @Transactional
    public boolean addUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        //user.setActivationCode(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepo.save(user);

        //sendMessage(user);

        return true;
    }

   /* private void sendMessage(User user) {
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to Majorca. Please, visit next link http://localhost:8080/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );
            mailSender.send(user.getEmail(), "Activation code", message);
        }
    }

    public boolean activateUser(String code) {
        User user = userRepo.findByActivationCode(code);
        if (user == null) {
            return false;
        }
        user.setActivationCode(null);
        userRepo.save(user);
        return true;
    }*/

    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Transactional
    public void saveUser(User user, String username, Map<String, String> form) {

        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);
    }


    public void userDelete(Long user) {
        userRepo.deleteById(user);
    }

    @Transactional
    public void updateProfile(/*String email,*/ String password, User user) throws IOException {
        /*boolean isEmailChanged = (email != null);
        if (isEmailChanged) {
            user.setEmail(email);
            if (!StringUtils.isEmpty(email)) {
                user.setActivationCode(UUID.randomUUID().toString());
            }
        }*/
        if (!StringUtils.isEmpty(password)) {
            user.setPassword(passwordEncoder.encode(password));
        }

        userRepo.save(user);
       /* if (isEmailChanged) {
            sendMessage(user);
        }*/
    }

    @Transactional
    public void reserve(Hike hike, User currentUser) {
        currentUser.getReservations().add(hike);
        long seats = hike.getSeats();
        if (seats > 0) {
            seats--;
        } else {
            seats = 0;
        }
        hike.setSeats(seats);
        hikeService.save(hike);
        userRepo.save(currentUser);
    }

    @Transactional
    public void cancel_reserve(Hike hike, User currentUser) {
        for (Hike hk : currentUser.getReservations()) {
            if (hk.getHike_id().equals(hike.getHike_id())) {
                currentUser.getReservations().remove(hk);
                long seats = hike.getSeats();
                seats++;
                hike.setSeats(seats);
                hikeService.save(hike);
                userRepo.save(currentUser);
            }
        }

    }


    public void subscribe(User currentUser, User user) {
        user.getSubscribers().add(currentUser);
        userRepo.save(user);
    }

    public void unsubscribe(User currentUser, User user) {
        user.getSubscribers().remove(currentUser);
        userRepo.save(user);
    }
}
