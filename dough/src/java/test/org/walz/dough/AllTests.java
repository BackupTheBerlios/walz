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

package org.walz.dough;

import junit.framework.TestSuite;
import junit.swingui.TestRunner;

public class AllTests {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite("AllTests");
        suite.addTestSuite(org.walz.dough.domain.DefaultMoneyCreationTest.class);
        return suite;
    }

    public static void main(String[] args) {
        TestRunner.run(AllTests.class);
    }
}
