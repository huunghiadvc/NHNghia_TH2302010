package utils;

public class ValidateUtils {
    public static boolean nameValid(String name){
        return name.matches(".*[a-zA-Z].*");
    }

    public static boolean emailValid(String email){
        return email.matches("^(.+)@(.+)$");
    }

    public static boolean phoneValid(String phone){
        return phone.matches(".*[0-9].*");
    }

}
