package org.galaxy.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.galaxy.model.User;

public class JSONUtil {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        user.setUsername("zht");
        user.setPassword("pwd");
        String userJSON = mapper.writeValueAsString(user);
        System.out.println(userJSON);

        String userStr2 = "{\"username\":\"zht\",\"password\":\"p@ssw0rd\"}";

        User user2 = mapper.readValue(userStr2,User.class);
        System.out.println(user2.getUsername()+"||||"+user2.getPassword());
    }

}
