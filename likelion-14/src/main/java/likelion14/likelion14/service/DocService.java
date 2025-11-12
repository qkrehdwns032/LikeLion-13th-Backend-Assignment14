package likelion14.likelion14.service;

import likelion14.likelion14.dto.DocResponse;
import likelion14.likelion14.global.code.status.ErrorStatus;
import likelion14.likelion14.global.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.net.URI;


@Slf4j
@RequiredArgsConstructor
@Component
public class DocService {

    private final RestTemplate restTemplate;

    @Value("${api.doc.url}")
    private String baseUrl;

    @Value("${api.doc.key}")
    private String authKey;

    public DocResponse getDoc(int pageNo, int numOfRows){

        String url = String.format(
            "%s/getDoctorRefTcMtInsttSearchList02?serviceKey=%s&pageNo=%d&numOfRows=%d",
            baseUrl, authKey, pageNo, numOfRows
        );
        try{
            return restTemplate.getForObject(new URI(url), DocResponse.class);
        }
        catch(Exception e){
            log.error("Doc API 호출 실패 (String)",e);

            throw new GeneralException(ErrorStatus.DOC_API_ERROR);
        }
    }

}
