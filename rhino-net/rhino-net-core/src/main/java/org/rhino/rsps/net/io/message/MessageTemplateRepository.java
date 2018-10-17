package org.rhino.rsps.net.io.message;

import java.io.IOException;

public interface MessageTemplateRepository {

    /**
     *
     * @param opcode
     * @return
     * @throws IOException
     */
    MessageTemplate getTemplateIncoming(int opcode) throws IOException;

    /**
     * shorter version of getTemplateIncoming(message.getOpcode())
     * @param message
     * @return
     * @throws IOException
     */
    default MessageTemplate getTemplateIncoming(Message message) throws IOException {
        return this.getTemplateIncoming(message.getOpcode());
    }

    /**
     *
     * @param opcode
     * @return
     * @throws IOException
     */
    MessageTemplate getTemplateOutgoing(int opcode) throws IOException;

    /**
     * shorter version of getTemplateOutgoing(message.getOpcode())
     * @param message
     * @return
     * @throws IOException
     */
    default MessageTemplate getTemplateOutgoing(Message message) throws IOException {
        return this.getTemplateOutgoing(message.getOpcode());
    }

}
