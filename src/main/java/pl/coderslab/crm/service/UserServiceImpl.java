package pl.coderslab.crm.service;

import org.springframework.stereotype.Service;
import pl.coderslab.crm.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }
}
