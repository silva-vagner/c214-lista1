package br.inatel.c214.lista1;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.inatel.c214.lista1.model.Venda;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class App
{
    public static void main(String[] args)
    {
        // CARREGANDO O ARQUIVO DIRETO DA PASTA RESOURCES
        InputStream is = App.class.getClassLoader().getResourceAsStream("data.csv");
        List<Venda> listaVendas = new ArrayList<>();

        // CONVERTENDO INPUTSTREAM PARA READER (NECESSARIO PARA TRABALHAR COM O METODO INPUTSTREAMREADER()
        Reader reader =  new InputStreamReader(is);

        // INSTANCIANDO E CONVERTENDO PARA BEANS DA CLASSE VENDA
        CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                .withType(Venda.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        // ARMAZENANDO OS VALORES NA LISTA DO TIPO VENDA
        listaVendas = csvToBean.parse();

        // ADICIONANDO FILTROS ATRAVES DE FILTER() E ARMAZENANDO EM SUAS RESPECTIVAS LISTAS
        List<Venda> vendasPorPlatform = listaVendas
                .stream()
                .filter(c -> c.getPlatform().equalsIgnoreCase("wii"))
                .collect(Collectors.toList());

        System.out.println("\n\n                ---- FILTRANDO POR PLATFORM ----\n");
        for (Venda venda: vendasPorPlatform)
            System.out.println(venda);

        List<Venda> vendasPorPublisher = listaVendas
                .stream()
                .filter(c -> c.getPublisher().equalsIgnoreCase("ACTIVISION"))
                .collect(Collectors.toList());

        System.out.println("\n\n                ---- FILTRANDO POR PUBLISHER ----\n");
        for (Venda venda: vendasPorPublisher)
            System.out.println(venda);

    }
}