package model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author Juha Peltomäki
 */
public class User {

    private String name;
    private int age;
    private GregorianCalendar birthday;

    public User() {
    }

    public User(String name, int age, int day, int month, int year) {
        this.name = name;
        this.age = age;
        setBirthday(day, month, year);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the birthday
     */
    public GregorianCalendar getBirthday() {
        return birthday;
    }

    public String getBorndate() {
        return birthday.get(GregorianCalendar.DAY_OF_MONTH) + "."
                + birthday.get(GregorianCalendar.MONTH) + "."
                + birthday.get(GregorianCalendar.YEAR);
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(GregorianCalendar birthday) {
        this.birthday = birthday;
    }

    private void setBirthday(int day, int month, int year) {
        GregorianCalendar c = (GregorianCalendar) Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.YEAR, year);
        setBirthday(c);
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", age=" + age + ", birthday=" + getBorndate() + '}';
    }
}
