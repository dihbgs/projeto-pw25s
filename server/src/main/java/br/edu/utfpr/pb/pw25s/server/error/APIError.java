package br.edu.utfpr.pb.pw25s.server.error;

import java.util.Date;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class APIError {
    private long timestamp = new Date().getTime();
    private Map<String, String> validationErrors;
    private String errorMessage;
    private int statusCode;
    private String url;

    public APIError(int statusCode, String errorMessage, String url, Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
        this.url = url;
    }

    public APIError(int statusCode, String errorMessage, String url) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
        this.url = url;
    }
    
}
