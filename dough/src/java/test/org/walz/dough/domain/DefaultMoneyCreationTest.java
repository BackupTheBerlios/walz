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
import java.util.Currency;

import junit.framework.TestCase;

public class DefaultMoneyCreationTest extends TestCase {

    private static final Currency EUR = Currency.getInstance("EUR");
    private static final Currency USD = Currency.getInstance("USD");
    
    public void testCreationFromMinLong() {
        DefaultMoney money = new DefaultMoney(Long.MIN_VALUE, EUR);
        assertEquals(new BigDecimal("-9223372036854775808.00"), money.amount());
    }
    
    public void testCreationFromNegativeLong() {
        DefaultMoney money = new DefaultMoney(-42L, EUR);        
        assertEquals(new BigDecimal("-42.00"), money.amount());
    }
    
    public void testCreationFromZeroLong() {
        DefaultMoney money = new DefaultMoney(0L, EUR);        
        assertEquals(new BigDecimal("0.00"), money.amount());
    }
    
    public void testCreationFromPositiveLong() {
        DefaultMoney money = new DefaultMoney(42L, EUR);
        assertEquals(new BigDecimal("42.00"), money.amount());
    }
    
    public void testCreationFromMaxLong() {
        DefaultMoney money = new DefaultMoney(Long.MAX_VALUE, EUR);
        assertEquals(new BigDecimal("9223372036854775807.00"), money.amount());
    }
    
    public void testCreationOfImmutableFromBigDecimal() {
        BigDecimal createFrom = new BigDecimal("42.00");
        DefaultMoney money = new DefaultMoney(createFrom, EUR);
        
        assertNotSame("force immutability!", createFrom, money.amount());
        assertEquals(new BigDecimal("42.00"), money.amount());
    }
    
    public void testEquals() {
        
        DefaultMoney moneyA = new DefaultMoney(+42L, EUR);
        DefaultMoney moneyB = new DefaultMoney(+42L, EUR);
        DefaultMoney moneyC = new DefaultMoney(-42L, EUR);
        DefaultMoney moneyD = new DefaultMoney(+42L, USD);
        
        assertFalse(moneyA.equals(null));
        assertTrue(moneyA.equals(moneyA));
        assertTrue(moneyA.equals(moneyB));
        assertTrue(moneyB.equals(moneyA));       
        assertFalse(moneyA.equals(moneyD));
    }
    
    public void testHashCode() {
        
        DefaultMoney moneyA = new DefaultMoney(+42L, EUR);
        DefaultMoney moneyB = new DefaultMoney(+42L, EUR);
        DefaultMoney moneyC = new DefaultMoney(-42L, EUR);
        DefaultMoney moneyD = new DefaultMoney(+42L, USD);
        
        assertTrue(moneyA.hashCode() == moneyB.hashCode());
        assertTrue(moneyA.hashCode() != moneyC.hashCode());
        assertTrue(moneyA.hashCode() != moneyD.hashCode());
    }
}
