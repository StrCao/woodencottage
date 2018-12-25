java NIO由以下几个核心部分组成:
* Channels
* Buffers
* Selectors

Channel和Buffer之间可以双向传递数据

Channel的实现有：
* FileChannel(文件IO)
* DatagramChannel(UDP IO)
* SocketChannel(TCP IO)
* ServerSocketChannel(TCP IO)

Buffer的实现有：
* ByteBuffer
* CharBuffer
* DoubleBuffer
* FloatBuffer
* IntBuffer
* LongBuffer
* ShortBuffer

