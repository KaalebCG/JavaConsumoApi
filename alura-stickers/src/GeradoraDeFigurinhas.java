

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

  public void cria(InputStream inputStream, String nomeArquivo) throws Exception{

    //leitura da imagem
    /* InputStream inputStream = new URL().openStream(); */
    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    //cria nova imagem em memoria com transparencia 
    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    //copiar a imagem original para a nova imagem
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal,0,0, null);

    //Configurar fonte
    var fonte = new Font(Font.SANS_SERIF,Font.BOLD, 64);
    graphics.setColor(Color.YELLOW);
    graphics.setFont(fonte);

    //escrever a frase na imagem
    graphics.drawString("TOP", largura / 2,  novaAltura - 100);

    //escrever a nova imagem em um arquivo 
    ImageIO.write(novaImagem, "png", new File("alura-stickers/saida/" + nomeArquivo + ".png"));
  }
  
}
