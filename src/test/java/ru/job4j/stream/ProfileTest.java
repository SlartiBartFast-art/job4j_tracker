package ru.job4j.stream;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;



public class ProfileTest {
    private List<Profile> profiles = new ArrayList<>();


    private Object List;

    @Before
    public void setUp() {
        profiles.add(new Profile(new Address("NewVasyki", "Surname1", 145, 89)));
    }

    @Test
    public void collect2() {
        List<Address> rsl = Profile.collect(profiles);

        List<Address> expected = new ArrayList<>();
        expected.add(new Address("NewVasyki", "Surname1", 145, 89));

        assertThat(rsl, is(expected));
    }
/*"Address{" + "city=" + Address.class + "street=" + Address.class + "apartment=" + Address.class + "89" + '}'
* */

}