package ru.job4j.ex;

import java.util.Scanner;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException { // если пользователя не нашли в списке, то кинуть исключение UserNotFoundException.

        for (User pow : users) {

            if (pow.getUsername().equals(login)) {
                return pow;
            }
        }
        throw new UserNotFoundException("user not fund in system");
    }

    public static boolean validate(User user) throws UserInvalidException { //если пользователь не валидный или если имя пользователя состоит из менее трех символов, то кинуть исключение UserInvalidException
        if (user.isValid()) {
            String name = user.getUsername();
            int count = 0; //int nameUser = String.length(name);
            for (int i = 0; i < name.length(); i++) { // как проверить что в имени больше 3-х символа
                count = i;
            }
            if (count > 3) {
                return true;
            }

        }
        throw new UserInvalidException("user is not valid or name user smaller three symbols");

    }

    public static void main(String[] args) {
        User[] users = {new User("Petr Arsentev", true)};

        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ex) {
                ex.printStackTrace();
            } catch (UserNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
