package ren_mor.ticket_assistance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ren_mor.ticket_assistance.entities.User;
import ren_mor.ticket_assistance.exceptions.UnauthorizedException;
import ren_mor.ticket_assistance.payloads.LoginDTO;

@Service
public class AuthService {
    @Autowired
    private UserService userService;

//    @Autowired
//    JWTTools jwtTools;
//
//    @Autowired
//    private PasswordEncoderService bcrypt;

//    public String checkCredentialsAndGenerateToken(LoginDTO body){
//        User found = this.userService.findByEmail(body.username());
//        if (bcrypt.matches(body.password(), found.getPassword())){
//            return jwtTools.createToken(found);
//        } else {
//            throw new UnauthorizedException("Credenziali non valide");
//        }
//    }
}
