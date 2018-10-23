package org.rhino.rsps.net.io.stream;

import java.io.IOException;

public interface OutputStreamFactory {

    OutputStream create() throws IOException;

    OutputStream create(int size) throws IOException;

    OutputStream create(OutputStream outputStream) throws IOException;

}
