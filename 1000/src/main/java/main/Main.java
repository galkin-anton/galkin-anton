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

import java.io.*;

/**
 * Project: TimusJudge
 * Author: Galkin
 * Date: 03.04.2020
 * Time: 11:18
 * Descriptions
 */

public class Main {
    StreamTokenizer in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new Main().run(new InputStreamReader(System.in));
    }

    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public void run(Reader input) throws IOException {
        in = new StreamTokenizer(new BufferedReader(input));
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }

    void solve() throws IOException {
        int a = nextInt();
        int b = nextInt();
        out.print(a + b);
    }
}
