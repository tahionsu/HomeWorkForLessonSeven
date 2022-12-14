package com.org.homework.firsttask.cryptedstream;

import java.io.IOException;
import java.io.InputStream;


public class CryptedInputStream extends InputStream {

    private final InputStream is;
    private final int keyPass;

    public CryptedInputStream(InputStream is, int keyPass) {
        this.is = is;
        this.keyPass = keyPass;
    }

    @Override
    public int read() throws IOException {
        return is.read() ^ keyPass;
    }
}
