package arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainArquivo {

  private static final String PATH_ARQUIVO = "assets/arquivo.txt";
  private static final String PATH_DIRETORIO = "assets";

  public static void main(String[] args) {
    File arquivo = new File(PATH_ARQUIVO);

    // Verifica se o arquivo existe
    System.out.println(arquivo.exists());
    // Verifica se o arquivo é um diretório
    System.out.println(arquivo.isDirectory());
    // Verifica se o arquivo é, de fato, um arquivo
    System.out.println(arquivo.isFile());
    // Obtém o caminho completo de um arquivo
    System.out.println(arquivo.getAbsolutePath());
    // Exclui um arquivo existente
    // System.out.println(arquivo.delete());

    // Cria um novo arquivo
    File novoArquivo = new File(PATH_DIRETORIO + "/novoArquivo.txt");
    try {
      novoArquivo.createNewFile();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // Ler um arquivo linha a linha
    try {
      FileReader fr = new FileReader(arquivo);
      BufferedReader br = new BufferedReader(fr);
      StringBuffer sb = new StringBuffer();
      String line;
      while ((line = br.readLine()) != null) {
        sb.append(line);
        sb.append("\n");
      }

      fr.close();
      System.out.println("Conteúdo do arquivo: ");
      System.out.println(sb.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }

    // Lista todos os arquivos de um diretório
    File diretorio = new File(PATH_DIRETORIO);
    for (File arq : diretorio.listFiles()) {
      System.out.println(arq.getAbsolutePath());
    }
  }
}
