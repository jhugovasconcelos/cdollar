package dev.jhugo.cdollar.service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import dev.jhugo.cdollar.repository.DollarRecord;



@Service
public class DollarService {
    
    private final RestClient restClient;

    // Constructor injection for the restClient
    public DollarService(){
        restClient = RestClient.builder()
        .baseUrl("https://olinda.bcb.gov.br")
        .build();
    }
    
    public DollarRecord getDollarPrice() {      
        // Creating Date        
        LocalDateTime today = LocalDateTime.now();

        // Changing the date to the day before, or 2 days before if it's sunday
        if(today.getHour() <= 14){
            today = today.minusDays(1);
        }
        if(today.getDayOfWeek().toString() == "SUNDAY"){
            today = today.minusDays(2);
        }
                
        // Formatting date to fit into the URL
        DateTimeFormatter todayFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy"); 
        String todayString = todayFormatter.format(today);
        String url = String.format(
            "/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='%s'&$top=1&$format=json&$select=cotacaoVenda", todayString);

        
        // Using the Restclient to fetch data from the Bacen API
        return restClient.get()
        .uri(url)
        .retrieve()
        .body(DollarRecord.class);
    }
}
