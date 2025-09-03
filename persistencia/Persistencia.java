

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import model.CentralDeInformacoes;
import model.Passageiro;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;

public class Persistencia {

    private static final String NOME_ARQUIVO = "central.xml";

   // Salvar objeto CentralDeInformacoes em arquivo XML
    public static void salvarCentral(CentralDeInformacoes central) throws Exception {
        XStream xstream = new XStream(new StaxDriver())
        xstream.allowTypes(new Class[] { CentralDeInformacoes.class, Passageiro.class });

        String xml = xstream.toXML(central);

        FileWriter escritor = new FileWriter(NOME_ARQUIVO);
        escritor.write(xml);
        escritor.close();
    }

    // Recuperar objeto CentralDeInformacoes do arquivo XML
    public static CentralDeInformacoes recuperarCentral() throws Exception {
        File arquivo = new File(NOME_ARQUIVO);

        if (!arquivo.exists()) {
            // Se não existir o arquivo, retorna um novo CentralDeInformacoes
            return new CentralDeInformacoes();
        }

        XStream xstream = new XStream(new StaxDriver());
        xstream.allowTypes(new Class[] { CentralDeInformacoes.class, Passageiro.class });

        FileReader leitor = new FileReader(arquivo);
        CentralDeInformacoes central = (CentralDeInformacoes) xstream.fromXML(leitor);
        leitor.close();

        return central;
    }
}
