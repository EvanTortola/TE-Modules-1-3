package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {
    //animal name is null

    @Test
    public void animalname_is_null_expect_unknown() {
        //Arrange
        AnimalGroupName animalGroup = new AnimalGroupName();
        String animalName;
        //String animalName = null;

        //Act
        //animalGroup.getHerd(animalName);
        String actual = animalGroup.getHerd(null);

        //Assert
        Assert.assertEquals("unknown", actual);

    }

    //animal name is not null
    //not null and its not in the map

    @Test
    public void animalname_is_not_in_map() {
        //Arrange
        AnimalGroupName animalGroup = new AnimalGroupName();

        //String animalName = null;

        //Act
        //animalGroup.getHerd(animalName);
        String actual = animalGroup.getHerd("ocelot");

        //Assert
        Assert.assertEquals("unknown", actual);

        //not null and its in the map and matches key
        //not null and its in the map and does not match key casing
    }

    @Test
    public void animalname_is_in_the_map_match_casing() {
        //Arrange
        AnimalGroupName animalGroup = new AnimalGroupName();
        String animalName;
        //String animalName = null;

        //Act
        //animalGroup.getHerd(animalName);
        String actual = animalGroup.getHerd("flamingo");

        //Assert
        Assert.assertEquals("Pat", actual);
    }

    @Test
    public void animalname_is_in_the_map_does_not_match_key_case() {
        //Arrange
        AnimalGroupName animalGroup = new AnimalGroupName();
        String animalName;
        //String animalName = null;

        //Act
        //animalGroup.getHerd(animalName);
        String actual = animalGroup.getHerd("flamingo");

        //Assert
        Assert.assertEquals("Pat", actual);
    }


}