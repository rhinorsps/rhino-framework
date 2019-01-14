package org.rhino.rsps.net;

import org.rhino.rsps.net.stream.InputStream;
import org.rhino.rsps.net.stream.provider.OutputStreamProvider;

import static com.google.common.base.Preconditions.checkNotNull;

public class DelegateSerializable implements Serializable {

    /**
     * The serializable delegate
     */
    private final Serializable delegate;

    public DelegateSerializable(Serializable delegate) {
        this.delegate = checkNotNull(delegate);
    }

    @Override
    public InputStream serialize(OutputStreamProvider<?> provider) throws Exception {
        if (this.delegate == null) {
            throw new NullPointerException("delegate cannot be null");
        }
        return this.delegate.serialize(provider);
    }

}
