package com.org.homework.firsttask.cryptedstream;

import java.io.IOException;
import java.io.OutputStream;

public class CryptedOutputStream extends OutputStream {

    private final OutputStream os;
    private final int keyPass;

    public CryptedOutputStream(OutputStream stream, int keyPass) {
        this.os = stream;
        this.keyPass = keyPass;
    }

    @Override
    public void write(int b) throws IOException {
        os.write(b ^ keyPass);
    }

}
