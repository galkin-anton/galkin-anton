/*
 * Copyright (c) 2008-2020
 * Sberbank
 * All rights reserved.
 *
 * This product and related documentation are protected by copyright and
 * distributed under licenses restricting its use, copying, distribution, and
 * decompilation. No part of this product or related documentation may be
 * reproduced in any form by any means without prior written authorization of
 * Sberbank and its licensors, if any.
 *
 * $
 */
package main;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * Project: TimusJudge
 * Author: Galkin
 * Date: 03.04.2020
 * Time: 11:59
 * Descriptions
 */

public class MainTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    //@DisplayName("Sum of 1 and 3 shouldbe 4")
    @Test
    public void sum13eq4() throws IOException {
        Main main = new Main();
        StringReader sr = new StringReader(String.format("1%n3"));
        main.run(sr);
        assertEquals("4", systemOutRule.getLog());
    }

    @Test
    public void testConsole() {
        System.out.print("3");
        //System.out.print(0_101);
        assertEquals("3", systemOutRule.getLog());
    }
}
