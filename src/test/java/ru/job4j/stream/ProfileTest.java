package ru.job4j.stream;

import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfileTest {
    private List<Profile> profiles = new ArrayList<>();

    @Before
    public void setUp() {
        profiles.add(new Profile(new Address("NewVasyki", "Surname1", 145, 89)));
        profiles.add(new Profile(new Address("Moskow", "Big Vernadskya", 90, 205)));
        profiles.add(new Profile(new Address("Vladivostok", "Vosstaniya", 15, 25)));
        profiles.add(new Profile(new Address("NewVasyki", "Surname1", 145, 89)));
    }

    @Test
            public void collectAddr() {
        Profiles ps = new Profiles();

        List<Address> rsl = ps.collect1(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("NewVasyki", "Surname1", 145, 89));
        expected.add(new Address("Moskow", "Big Vernadskya", 90, 205));
        expected.add(new Address("Vladivostok", "Vosstaniya", 15, 25));
        expected.add(new Address("NewVasyki", "Surname1", 145, 89));
        assertThat(rsl, is(expected));
    }



    @Test
    public void collect2() {
        Profiles ps = new Profiles();


        List<Address> rsl = ps.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moskow", "Big Vernadskya", 90, 205));
        expected.add(new Address("NewVasyki", "Surname1", 145, 89));
        expected.add(new Address("Vladivostok", "Vosstaniya", 15, 25));
        assertThat(rsl, is(expected));
    }
}