package likelion14.likelion14.controller;

import likelion14.likelion14.dto.DocResponse;
import likelion14.likelion14.global.code.dto.ApiResponse;
import likelion14.likelion14.service.DocService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DocController {

    private final DocService docService;

    @GetMapping("/from-api")
    public ResponseEntity<ApiResponse<DocResponse>> getCultureFromApi(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size) {

        DocResponse response = docService.getDoc(page, size);

        return ResponseEntity.ok(ApiResponse.onSuccess(response));
    }

    @GetMapping("/total-count")
    public ApiResponse<Integer> getTotalCount() {
        DocResponse response = docService.getDoc(1, 1);
        return ApiResponse.onSuccess(response.getBody().getTotalCount());
    }

    @GetMapping("/detail")
    public ApiResponse<DocResponse.DocItem> getHospitalDetail() {
        DocResponse response = docService.getDoc(1, 1);
        return ApiResponse.onSuccess(response.getBody().getItems().getItem().get(0));
    }

}
