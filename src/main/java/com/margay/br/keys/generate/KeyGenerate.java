/*
 * Desenvolvido por: Margay Sistemas
 * http://margay.com.br
 * contato@margay.com.br
 * (93)99155-3577
 */

package com.margay.br.keys.generate;

import java.io.IOException;
import static java.lang.Long.parseLong;
import static java.lang.String.valueOf;
import static java.lang.System.getProperty;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Files.write;
import java.nio.file.Path;
import static java.nio.file.Paths.get;
import java.security.NoSuchAlgorithmException;
import static java.security.SecureRandom.getInstanceStrong;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;

public class KeyGenerate {

    private KeyGenerate() {
    }

    public static String produtoKey() {
        var alfa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var zeraArquivo = "000001";
        var readData = readData();
        if (charIsEmpty(readData)) {
            readData = readData.concat("A");
        }

        var length = readData.length();
        var letter = readData.substring(length - 1, length);
        var index = alfa.indexOf(letter);
        var charAt = alfa.charAt(index);
        var value = parseLong(readData.replace(letter, "")) + 1L;
        var is = valueOf(value);
        var result = readData.substring(0, length - 1 - is.length());
        result = result.concat(is).concat(valueOf(charAt));
        if (is.equals("100000")) {
            if (readData.contains(valueOf(charAt))) {
                result = zeraArquivo.concat(valueOf(alfa.charAt(index + 1)));
            } else {
                result = zeraArquivo.concat(valueOf(alfa.charAt(index)));
            }
        }

        return writeData(result, "readFile.sys");
    }

    private static Path homePath(String fileNameExtension) {
        return get(getProperty("user.home"), fileNameExtension);
    }

    public static String readData() {
        try {
            return readAllLines(homePath("readFile.sys")).get(0);
        } catch (IOException var1) {
            getLogger(KeyGenerate.class.getName()).log(SEVERE, (String) null, var1);
            throw new ExceptionInInitializerError("Erro ao inicializar leitura do arquivo");
        }
    }

    public static String writeData(String readData, String fileNameExtension) {
        try {
            var path = homePath(fileNameExtension);
            write(path, readData.getBytes());
            return readAllLines(path).get(0);
        } catch (IOException var3) {
            getLogger(KeyGenerate.class.getName()).log(SEVERE, (String) null, var3);
            throw new ExceptionInInitializerError("Erro ao inicializar gravação do arquivo");
        }
    }

    private static boolean charIsEmpty(String readData) {
        return readData.codePoints().filter(Character::isLetter).findFirst().isEmpty();
    }

    public static String keyCode() {
        try {
            var alfa = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
            var length = alfa.length();
            var token = new StringBuilder();
            var random = getInstanceStrong();

            for (var i = 0; i < 7; ++i) {
                var index = random.nextInt(length);
                token.append(alfa.charAt(index));
            }

            return token.toString();
        } catch (NoSuchAlgorithmException var6) {
            getLogger(KeyGenerate.class.getName()).log(SEVERE, (String) null, var6);
            throw new IllegalArgumentException("Erro ao gerar chave");
        }
    }
}
