package org.rhino.rsps.net.io.message.serialize;

import org.rhino.rsps.net.io.message.serialize.DataType;
import org.rhino.rsps.net.io.stream.InputStream;
import org.rhino.rsps.net.io.stream.OutputStream;

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

    /**
     * Collection of readers
     */
    private static final Map<DataType, Writer> writers = new HashMap<>();

    static {
        readers.put(DataType.BYTE, in -> in.readByte());
        readers.put(DataType.SHORT, in -> in.readShort());
        readers.put(DataType.MEDIUM, in -> in.readMedium());
        readers.put(DataType.INTEGER, in -> in.readInteger());
        readers.put(DataType.LONG, in -> in.readLong());

        writers.put(DataType.BYTE, (value, out) -> out.writeByte(value));
        writers.put(DataType.SHORT, (value, out) -> out.writeShort(value));
        writers.put(DataType.MEDIUM, (value, out) -> out.writeMedium(value));
        writers.put(DataType.INTEGER, (value, out) -> out.writeInteger(value));
        writers.put(DataType.LONG, (value, out) -> out.writeLong(value));
    }

    public static Object read(DataType type, InputStream in) throws IOException {
        return readers.get(type).read(in);
    }

    public static void write(DataType type, int value, OutputStream out) throws IOException {
        writers.get(type).write(value, out);
    }

    interface Reader {
        Object read(InputStream in) throws IOException;
    }

    interface Writer {

        void write(int value, OutputStream out) throws IOException;
    }

}
