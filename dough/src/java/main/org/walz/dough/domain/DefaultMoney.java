/* 
 *   This file is part of dough.
 *
 *   dough is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 *
 *   Foobar is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with dough; if not, write to the Free Software
 *   Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.walz.dough.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Currency;

/**
 * Immutable <i>Value Object</i> representing a monetary value.<br>
 * Supports currencies with up to 4 fraction digits.
 */
public class DefaultMoney implements Money {

	/* used to convert main unit into smallest base unit */
	private static final BigInteger[] baseUnitFactors = { 
		BigInteger.valueOf(1L),
		BigInteger.valueOf(10L),
	    BigInteger.valueOf(100L),
		BigInteger.valueOf(1000L),
		BigInteger.valueOf(10000L)};

    private final BigDecimal amount;
    private final Currency currency;
    
    DefaultMoney(long amount, Currency currency) {
        assertValidCurrency(currency);
    
    	this.currency = currency;
        this.amount = new BigDecimal(BigInteger.valueOf(amount).multiply(baseUnitFactor()),
                                     currency.getDefaultFractionDigits());
    }

	DefaultMoney(BigDecimal amount, Currency currency) {
		assert (amount != null): "illegal argument: amount cannot be null";
		assertValidCurrency(currency);

    	this.currency = currency;
    	this.amount = new BigDecimal(amount.unscaledValue(), amount.scale());
	}
  
    public BigDecimal amount() {
        return amount;
    }
    
    public Currency currency() {
        return currency;
    }
    
    public boolean equals(Object o) {
        return (o instanceof Money) && equals((Money) o);
    }
    
    public int hashCode() {
        return amount.hashCode() + currency.hashCode();
    }

    private BigInteger baseUnitFactor() {
        return baseUnitFactors[currency.getDefaultFractionDigits()];
    }

    private void assertValidCurrency(Currency currency) {
        assert (currency != null): "illegal argument, currency was null";
		assert (currency.getDefaultFractionDigits() <= 4): 
               "unsupported currency " + currency + ": " + 
               "number of fraction digits must be < " + 
               baseUnitFactors.length + ", but was " + 
               currency.getDefaultFractionDigits();
    }

    private boolean equals(Money other) {
        return amount().equals(other.amount()) && 
               currency().equals(other.currency());
    }
}
