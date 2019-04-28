package exp;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 * Hash 工具
 */
public class HashUtils {

    private static final char[] HEXES = {
            '0', '1', '2', '3',
            '4', '5', '6', '7',
            '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f'
    };

    /**
     * 计算文本（byte数据）的 哈希
     *
     * 根据指定的算法加密任意长度的数据, 返回固定长度的十六进制小写哈希值
     *
     * @param data 需要加密的数据
     * @param algorithm 加密算法, 例如: MD5, SHA-1, SHA-256, SHA-512 等
     */
    public static String encrypt(byte[] data, String algorithm) throws Exception {
        // 1. 根据算法名称获实现了算法的加密实例
        MessageDigest digest = MessageDigest.getInstance(algorithm);

        // 2. 加密数据, 计算数据的哈希值
        byte[] cipher = digest.digest(data);

        // 3. 将结果转换为十六进制小写
        return bytes2Hex(cipher);
    }

    /**
     * 计算文件的哈希
     *
     * 根据指定的算法加密文件数据, 返回固定长度的十六进制小写哈希值
     *
     * @param file 需要加密的文件
     * @param algorithm 加密算法, 例如: MD5, SHA-1, SHA-256, SHA-512 等
     */
    public static String encrypt(File file, String algorithm) throws Exception {
        InputStream in = null;

        try {
            // 1. 根据算法名称获实现了算法的加密实例
            MessageDigest digest = MessageDigest.getInstance(algorithm);

            in = new FileInputStream(file);
            byte[] buf = new byte[1024];
            int len = -1;
            while ((len = in.read(buf)) != -1) {
                // 2. 文件数据通常比较大, 使用 update() 方法逐步添加
                digest.update(buf, 0, len);
            }

            // 3. 计算数据的哈希值, 添加完数据后 digest() 方法只能被调用一次
            byte[] cipher = digest.digest();

            // 4. 将结果转换为十六进制小写
            return bytes2Hex(cipher);

        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    // nothing
                }
            }
        }
    }

    /**
     * byte数组转换为 16 进制数据
     */
    private static String bytes2Hex(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        for (byte b : bytes) {
            sb.append(HEXES[(b >> 4) & 0x0F]);
            sb.append(HEXES[b & 0x0F]);
        }

        return sb.toString();
    }
}
