package pl.jurys.kanbanbackend.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jurys.kanbanbackend.model.User;
import pl.jurys.kanbanbackend.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Service
public class SessionUtil {

    @Autowired
    private UserRepository userRepository;

    public void startSession(HttpSession session, User user) {
        session.setAttribute("user", user);
        session.setAttribute("id", user.getUserId());
    }

    public void endSession(HttpSession session) {
        session.setAttribute("user", null);
        session.setAttribute("id", null);
    }//TODO: na froncie przekierować do /
}
