package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {

    @Test
    public void successful_cigar_party_on_the_weekend_() {
        //arrange
        CigarParty cigarParty = new CigarParty();

        //Act
        boolean havinAParty = cigarParty.haveParty(40, true);

        //Assert
        Assert.assertTrue(havinAParty);
    }

    @Test
    public void unsuccessful_cigar_party_on_weekend(){
        //Arrange
        CigarParty cigarParty = new CigarParty();

        //Act
        boolean havinAParty = cigarParty.haveParty(30, true);

        //Assert
        Assert.assertFalse(havinAParty);
    }

    @Test
    public void successful_cigar_party_during_week() {
        //arrange
        CigarParty cigarParty = new CigarParty();

        //act
        boolean havinAParty = cigarParty.haveParty(60, false);

        //assert
        Assert.assertTrue(havinAParty);
    }


}
