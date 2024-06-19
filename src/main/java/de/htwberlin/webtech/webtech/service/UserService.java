package de.htwberlin.webtech.webtech.service;

import de.htwberlin.webtech.webtech.persistence.UserEntity;
import de.htwberlin.webtech.webtech.persistence.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserEntity updateUser(Long id, UserEntity userEntityToUpdate){
        var userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isEmpty()) {
            return null;
        }

        var userEntity = userEntityOptional.get();

        userEntity.setEmail(userEntityToUpdate.getEmail());
        userEntity.setUsername(userEntityToUpdate.getUsername());
        userEntity.setPassword(userEntityToUpdate.getPassword());

        userEntity = userRepository.save(userEntity);

        return userEntity;
    }

    public UserEntity create(UserEntity newUser) {
        return userRepository.save(newUser);
    }

    public boolean deleteById(Long id) {
        if (!userRepository.existsById(id)){
            return false;
        }

        userRepository.deleteById(id);
        return true;
    }
    public UserEntity register(UserEntity newUser) {
        // Überprüfen Sie, ob bereits ein Benutzer mit dieser E-Mail existiert
        UserEntity existingUser = userRepository.findByEmail(newUser.getEmail());
        if (existingUser != null) {
            // Wenn ja, werfen Sie eine Ausnahme oder geben Sie null zurück
            return null;
        }

        // Speichern Sie den neuen Benutzer
        return userRepository.save(newUser);
    }

    public UserEntity login(String email, String password) {
        // Finden Sie den Benutzer anhand der E-Mail
        UserEntity user = userRepository.findByEmail(email);
        if (user != null && password.equals(user.getPassword())) {
            // Wenn der Benutzer existiert und das Passwort übereinstimmt, geben Sie den Benutzer zurück
            return user;
        }
        // Wenn der Benutzer nicht existiert oder das Passwort nicht übereinstimmt, geben Sie null zurück
        return null;
    }
}
