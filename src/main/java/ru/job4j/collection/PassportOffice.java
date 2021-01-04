package ru.job4j.collection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**Сервис должен проверять, что гражданина с таким паспортом еще нет,
 *  а так же возможность получить информацию о гражданине по его паспорту.
 * */
public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
       // String key = citizen.getPassport();

        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            return true;
        }
        return rsl;
    }


    public Citizen get(String passport) {

        return citizens.get(passport);
    }
}
