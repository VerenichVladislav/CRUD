package app.model;

import app.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model instance = new Model();
    private List<User> model;

    public static Model getInstance(){
        return instance;
    }

    private Model(){
        model = new ArrayList<User>();
    }

    public void add(User user) {
        model.add(user);
    }

    public List<String> list(){
        return model.stream().map(User::getName).collect(Collectors.toList());
    }
    public void set(String name, String new_name){
        for(User user : model) if (user.getName().equals(name)) user.setName(new_name);
    }
    public void remove(String name){
        User user = null;
        for (User user1 : model) if (user1.getName().equals(name)) user = user1;
        model.remove(user);

    }
}
