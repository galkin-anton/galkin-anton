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
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Locale;

public class Main {
    StreamTokenizer in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new Main().run(new InputStreamReader(System.in));
    }

    Deque<Double> nextInt() throws IOException {
        ArrayDeque<Double> res = new ArrayDeque<>();
        while (in.nextToken() != -1) {
            res.add(in.nval);
        }
        return res;
    }

    public void run(Reader input) throws IOException {
        in = new StreamTokenizer(new BufferedReader(input));
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }

    void solve() throws IOException {
        Deque<Double> a = nextInt();
        Double d;
        while (a.peekLast() != null) {
            d = a.peekLast();
            out.println(String.format(Locale.US, "%.4f", StrictMath.sqrt(d)));
            a.removeLast();
        }
    }
}
