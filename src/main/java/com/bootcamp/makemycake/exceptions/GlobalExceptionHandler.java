package com.bootcamp.makemycake.exceptions;


import com.bootcamp.makemycake.dto.ApiResponse;
import com.bootcamp.makemycake.exceptions.auth.*;
import com.bootcamp.makemycake.exceptions.email.SendingEmailException;
import com.bootcamp.makemycake.exceptions.favorite.FavoriteNotFoundException;
import com.bootcamp.makemycake.exceptions.offre.AddOfferException;
import com.bootcamp.makemycake.exceptions.offre.DeleteOfferException;
import com.bootcamp.makemycake.exceptions.offre.OffreNotFoundException;
import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiResponse> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        ApiResponse response = new ApiResponse("User already exists", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ApiResponse> handleInvalidTokenException(InvalidTokenException ex) {
        ApiResponse response = new ApiResponse("Invalid Token", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ApiResponse> handleInvalidCredentialsException(InvalidCredentialsException ex) {
        ApiResponse response = new ApiResponse("User already exists", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SendingEmailException.class)
    public ResponseEntity<ApiResponse> handleSendingEmailException(InvalidTokenException ex) {
        ApiResponse response = new ApiResponse("Invalid Token", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<ApiResponse> handleEmailNotFoundException(EmailNotFoundException ex) {
        ApiResponse response = new ApiResponse("Error", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<ApiResponse> handleMessagingException(MessagingException ex) {
        ApiResponse response = new ApiResponse("Error", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DeleteOfferException.class)
    public ResponseEntity<ApiResponse> handleDeleteOfferException(DeleteOfferException ex) {
        ApiResponse response = new ApiResponse("Offer Deletion Error", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OffreNotFoundException.class)
    public ResponseEntity<ApiResponse> handleNotFoundOfferException(OffreNotFoundException ex) {
        ApiResponse response = new ApiResponse("Offer Deletion Error", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AddOfferException.class)
    public ResponseEntity<ApiResponse> handleAddOfferException(AddOfferException ex) {
        ApiResponse response = new ApiResponse("Offer Creation Error", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }




    @ExceptionHandler(AccountIsNotEnabledException.class)
    public ResponseEntity<ApiResponse> handleAccountIsNotEnabledException(AccountIsNotEnabledException ex) {
        ApiResponse response = new ApiResponse("Error", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ApiResponse> handleMaxSizeException(MaxUploadSizeExceededException ex) {
        ApiResponse response = new ApiResponse(
            "File size exceeds maximum limit",
            "The uploaded file size exceeds the maximum allowed size of 5MB",
            HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse> handleRuntimeException(RuntimeException ex) {
        ApiResponse response = new ApiResponse(
            "Error",
            ex.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGenericException(Exception e) {
        ApiResponse response = new ApiResponse("Error", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FavoriteNotFoundException.class)
    public ResponseEntity<ApiResponse> handleFavoriteNotFoundException(FavoriteNotFoundException ex) {
        ApiResponse response = new ApiResponse("Favorite Error", ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
