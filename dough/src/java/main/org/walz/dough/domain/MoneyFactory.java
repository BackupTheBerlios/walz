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

public class MoneyFactory {

    private MoneyFactory() {
        // intentionally left blank
    }
    
    public static Money newInstance(long amount, Currency currency) {
        return new DefaultMoney(amount, currency);
    }
    
    public static Money newInstance(BigDecimal amount, Currency currency) {
        return new DefaultMoney(amount, currency);
    }
}
