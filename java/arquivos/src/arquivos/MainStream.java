package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class MainStream {

  private static final String PATH_DIRETORIO = "assets";

  public static void main(String[] args) {
    String conteudoArquivo = "conteúdo para arquivo!";
    gravarArquivo(conteudoArquivo);
    String testeConteudo = recuperarArquivo();
    System.out.println(testeConteudo);
  }

  public static void gravarArquivo(String conteudo) {
    File arquivo = new File(PATH_DIRETORIO + "/novoArquivo.txt");

    // cria o arquivo caso ele não exista
    if (!arquivo.exists()) {
      try {
        arquivo.createNewFile();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    try {
      FileOutputStream fileOutput = new FileOutputStream(arquivo);
      OutputStreamWriter objectOutput = new OutputStreamWriter(fileOutput, StandardCharsets.UTF_8);
      // Escreve o conteúdo no arquivo
      objectOutput.write(conteudo);
      // Confirma a escrita no stream de objeto e de arquivo
      objectOutput.flush();
      fileOutput.flush();
      // Fecha os streams
      objectOutput.close();
      fileOutput.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String recuperarArquivo() {
    File arquivo = new File(PATH_DIRETORIO + "/novoArquivo.txt");

    // retorna null caso o arquivo não exista
    if (!arquivo.exists()) {
      return null;
    }

    try {
      FileInputStream fileInput = new FileInputStream(arquivo);
      InputStreamReader inputStreamReader = new InputStreamReader(fileInput, StandardCharsets.UTF_8);

      // Lê o conteúdo do arquivo
      int data;
      String saida = "";
      while ((data = inputStreamReader.read()) != -1) {
        saida += (char) data;
      }

      fileInput.close();
      inputStreamReader.close();
      // retorna o conteúdo do arquivo
      return saida.toString();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
