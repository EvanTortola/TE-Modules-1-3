package com.techelevator.change;

import java.math.BigDecimal;

public interface ChangeMaker {
	Change getChangeFor(BigDecimal amount);
}
