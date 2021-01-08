package ru.job4j.ex;

import java.util.Scanner;
/** если пользователя не нашли в списке, то кинуть исключение UserNotFoundException.
 * */
public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {

        for (User pow : users) {

            if (pow.getUsername().equals(login)) {
                return pow;
            }
        }
        throw new UserNotFoundException("user not fund in system");
    }
/**если пользователь не валидный или если имя пользователя
 * состоит из менее трех символов, то кинуть исключение UserInvalidException
 * */

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() && user.getUsername().length() > 3) {
                return true;
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
