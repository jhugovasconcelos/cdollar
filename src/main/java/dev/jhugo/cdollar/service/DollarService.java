package dev.jhugo.cdollar.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import dev.jhugo.cdollar.repository.DollarRecord;


@Service
public class DollarService {
    
    // TODO: Create Beans for RestTemplate and Date in separate Configurations Class.
    RestTemplate dollarTemplate = new RestTemplate();


    private Date today = new Date();
    private SimpleDateFormat todayFormat = new SimpleDateFormat("MM-dd-yyyy");
    private String todayString = todayFormat.format(today);
    
    
    String url = String.format(
            "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='%s'&$top=1&$format=json&$select=cotacaoVenda", todayString);

    public String getDollarPrice() {
        RestClient restClient = RestClient.create();
        DollarRecord dollarRecord = restClient.get()
        .uri(url)
        .retrieve()
        .body(DollarRecord.class);
                
        // TODO: Solve this - the optional should guarantee the value won't be null.
        Optional<String> dollarPriceOptional = Optional.of(dollarRecord.getValue().toString());
        
    }
}
