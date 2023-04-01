import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexao http e buscar os top 250 filmes 
/*        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json"; */
       String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-28";
        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados
        ExtratorConteudoNasa extrator = new ExtratorConteudoNasa();
       List<Conteudo> conteudos = extrator.extraiConteudos(json);
        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i<5; i++){
            Conteudo conteudo = conteudos.get(i);
            InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();
            String nomeArquivo = conteudo.getTitulo();
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());

        }
    }
}
