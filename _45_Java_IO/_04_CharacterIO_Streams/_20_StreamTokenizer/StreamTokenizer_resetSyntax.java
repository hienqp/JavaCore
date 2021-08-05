package _45_Java_IO._04_CharacterIO_Streams._20_StreamTokenizer;

import java.io.*;

public class StreamTokenizer_resetSyntax {
    private static final String path = "D:\\Learning\\Java\\JavaOOP\\src\\_45_Java_IO\\_04_CharacterIO_Streams\\_20_StreamTokenizer\\test_resetSyntax.txt";

    public static void main(String[] args) throws IOException {
        String text = "Hello. This is a text \n that will be split " + "into tokens. 1 + 1 = 2";

        try {
            // ghi file
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeUTF(text);
            objectOutputStream.flush();

            // đọc file vừa tạo, sử dụng StreamTokenizer để phân giải nội dung file thành các token
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            Reader reader = new BufferedReader(new InputStreamReader(objectInputStream));

            StreamTokenizer streamTokenizer = new StreamTokenizer(reader);

            // biến điều kiện kết thúc quá trình đọc
            boolean eof = false; // end of file

            do {
                int token = streamTokenizer.nextToken();

                switch (token) {
                    case StreamTokenizer.TT_EOF:
                        System.out.println("End of File encountered.");
                        eof = true;
                        break;

                    case StreamTokenizer.TT_EOL:
                        System.out.println("End of Line encountered.");
                        break;

                    case StreamTokenizer.TT_WORD:
                        System.out.println("Word: " + streamTokenizer.sval);
                        break;

                    case StreamTokenizer.TT_NUMBER:
                        // when a number is met, reset syntax
                        streamTokenizer.resetSyntax();
                        System.out.println("Number: " + streamTokenizer.nval);
                        break;

                    default:
                        System.out.println((char) token + " encountered."); // in những token != TT_NUMBER && token != TT_WORD
                        // gặp '!' cũng coi như là end of file
                        if (token == '!') {
                            eof = true;
                        }
                }
            } while (!eof); // eof = true -> while(false) -> kết thúc
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
