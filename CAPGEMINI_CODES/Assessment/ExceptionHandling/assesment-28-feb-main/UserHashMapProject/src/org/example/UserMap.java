package src.org.example;

import java.util.HashMap;

public class UserMap extends HashMap<String, String> {

    @Override
    public String put(String key, String value) {

        if (this.containsKey(key)) {
            throw new UsernameExistsException("Username already exists: " + key);
        }

        return super.put(key, value);
    }
}