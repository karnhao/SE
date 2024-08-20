package ku.cs.design_principles;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author 6510451000 Sittipat Tepsutar
 */
public class Main {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final List<String> notAllowDomains = Arrays.asList("dom1.cc", "dom2.cc", "dom3.cc");
    public boolean register(User user) {

        validateUser(user);
        validateEmail(user.getEmail());

        // register ...
        // ...
        
        return true;
    }

    private void validateEmail(String email) {
        Pattern validEmailPattern = Pattern.compile(EMAIL_PATTERN);
        if (!validEmailPattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Email is wrong format");
        }
    }

    private void validateUser(User user) {
        if (user.getName() == null || user.getName().trim().equals("")) {
            throw new IllegalArgumentException("Name should not empty");
        }
        if (user.getEmail() == null || user.getEmail().trim().equals("")) {
            throw new IllegalArgumentException("Email should not empty");
        }
        if (!user.getName().matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name is wrong format");
        }

        if (notAllowDomains.contains(user.getEmail().split("@")[1])) {
            throw new IllegalArgumentException("Domain Email is not allow");
        }
        if (user.getAge() < 20) {
            throw new IllegalArgumentException("Age should more than 20 years");
        }
    }
}
