package br.com.drsolutions.wsdlcliente.clients;

import br.com.drsolutions.wsdlcliente.wsdl.GetPaisRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class PaisClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(PaisClient.class);

    public br.com.drsolutions.wsdlcliente.wsdl.GetPaisResponse getPais(String pais) {

        GetPaisRequest request = new GetPaisRequest();
        request.setNome(pais);

        log.info("Obtendo dados sobre: " + pais);

        br.com.drsolutions.wsdlcliente.wsdl.GetPaisResponse response = (br.com.drsolutions.wsdlcliente.wsdl.GetPaisResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/paises", request,
                        new SoapActionCallback(
                                "http://br.com.drsolutions/wsdlservidor/assets/GetPaisRequest"));

        return response;
    }

}
