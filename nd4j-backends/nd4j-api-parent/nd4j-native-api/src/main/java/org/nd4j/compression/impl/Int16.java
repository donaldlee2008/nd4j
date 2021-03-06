package org.nd4j.compression.impl;

import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.compression.CompressionType;
import org.nd4j.linalg.factory.Nd4j;

/**
 * Compressor implementation based on int16/aka short as storage for integral values.
 * So, all data will be stored in -32768..32767 space
 *
 * @author raver119@gmail.com
 */
public class Int16 extends AbstractCompressor {
    /**
     * This method returns compression descriptor. It should be unique for any compressor implementation
     *
     * @return
     */
    @Override
    public String getDescriptor() {
        return "INT16";
    }

    /**
     * This method returns compression type provided by specific NDArrayCompressor implementation
     *
     * @return
     */
    @Override
    public CompressionType getCompressionType() {
        return CompressionType.LOSSY;
    }

    @Override
    public DataBuffer decompress(DataBuffer buffer) {
        DataBuffer result = Nd4j.getNDArrayFactory().convertDataEx(DataBuffer.TypeEx.INT16, buffer, getGlobalTypeEx());

        return result;
    }

    @Override
    public DataBuffer compress(DataBuffer buffer) {
        DataBuffer result = Nd4j.getNDArrayFactory().convertDataEx(getBufferTypeEx(buffer), buffer, DataBuffer.TypeEx.INT16);
        return result;
    }
}
