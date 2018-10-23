package org.rhino.rsps.net.io.message.serialize;

import org.rhino.rsps.net.io.message.serialize.DataType;
import org.rhino.rsps.net.io.stream.InputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * FIXME
 */
public class DataTypes {

    /**
     * Collection of readers
     */
    private static final Map<DataType, Reader> readers = new HashMap<>();

    static {
        readers.put(DataType.BYTE, in -> in.readByte());
        readers.put(DataType.SHORT, in -> in.readShort());
        readers.put(DataType.MEDIUM, in -> in.readMedium());
        readers.put(DataType.INTEGER, in -> in.readInteger());
        readers.put(DataType.LONG, in -> in.readLong());
    }

    public static Object read(DataType type, InputStream in) throws IOException {
        return readers.get(type).read(in);
    }

    interface Reader {
        Object read(InputStream in) throws IOException;
    }

}
