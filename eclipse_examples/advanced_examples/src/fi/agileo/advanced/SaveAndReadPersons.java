package fi.agileo.advanced;

import java.util.*;
import java.io.*;

class User implements Serializable {
    public String name;
    public int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class SaveAndReadPersons {
    
    static final String output_fn = "users.dat";
    
    public static void main(String args[])
    {
        List<User> users = Arrays.asList( 
            new User("jack", 40),
            new User("john", 32),
            new User("jill", 47),
            new User("mike", 28));
    
    List<User> readUsers=null;
    
    try {
        ObjectOutputStream objWrite = new ObjectOutputStream(
                    new FileOutputStream(output_fn));

        try{
         objWrite.writeObject(users);
         objWrite.flush();
        }
        finally{
         objWrite.close();
        }
                
        
        // Olion tietojen lukeminen
        ObjectInputStream objRead = 
        new ObjectInputStream(new FileInputStream(output_fn));
        
        try {         
         readUsers = (List<User>)objRead.readObject();
        }
        finally {
         objRead.close();
    }
        
    } catch (IOException | ClassNotFoundException ex) {
        System.out.println(ex);
    }
    for (User user: readUsers) {
        System.out.print(user.name + ": ");
        System.out.println(user.age);
    }
    }
}
