package exp;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 * Hash ����
 */
public class HashUtils {

    private static final char[] HEXES = {
            '0', '1', '2', '3',
            '4', '5', '6', '7',
            '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f'
    };

    /**
     * �����ı���byte���ݣ��� ��ϣ
     *
     * ����ָ�����㷨�������ⳤ�ȵ�����, ���ع̶����ȵ�ʮ������Сд��ϣֵ
     *
     * @param data ��Ҫ���ܵ�����
     * @param algorithm �����㷨, ����: MD5, SHA-1, SHA-256, SHA-512 ��
     */
    public static String encrypt(byte[] data, String algorithm) throws Exception {
        // 1. �����㷨���ƻ�ʵ�����㷨�ļ���ʵ��
        MessageDigest digest = MessageDigest.getInstance(algorithm);

        // 2. ��������, �������ݵĹ�ϣֵ
        byte[] cipher = digest.digest(data);

        // 3. �����ת��Ϊʮ������Сд
        return bytes2Hex(cipher);
    }

    /**
     * �����ļ��Ĺ�ϣ
     *
     * ����ָ�����㷨�����ļ�����, ���ع̶����ȵ�ʮ������Сд��ϣֵ
     *
     * @param file ��Ҫ���ܵ��ļ�
     * @param algorithm �����㷨, ����: MD5, SHA-1, SHA-256, SHA-512 ��
     */
    public static String encrypt(File file, String algorithm) throws Exception {
        InputStream in = null;

        try {
            // 1. �����㷨���ƻ�ʵ�����㷨�ļ���ʵ��
            MessageDigest digest = MessageDigest.getInstance(algorithm);

            in = new FileInputStream(file);
            byte[] buf = new byte[1024];
            int len = -1;
            while ((len = in.read(buf)) != -1) {
                // 2. �ļ�����ͨ���Ƚϴ�, ʹ�� update() ���������
                digest.update(buf, 0, len);
            }

            // 3. �������ݵĹ�ϣֵ, ��������ݺ� digest() ����ֻ�ܱ�����һ��
            byte[] cipher = digest.digest();

            // 4. �����ת��Ϊʮ������Сд
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
     * byte����ת��Ϊ 16 ��������
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
