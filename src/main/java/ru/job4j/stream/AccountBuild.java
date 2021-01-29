package ru.job4j.stream;

public class AccountBuild {
    public static void main(String[] args) {
        Account account = new Account.Builder().buildName("Petr")
                .buildSurname("Arsentev")
                .buildSAge((byte) 32)
                .buildGender("men")
                .buildPassport(89242500)
                .buildAddress("Bolshaya Syharevska")
                .build();
        System.out.println(account);
    }
}
