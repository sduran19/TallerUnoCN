package co.edu.polijic.taller.controller;

//import co.edu.polijic.taller.helpers.ErrorMessage;
import co.com.helpers.ErrorMessage;
//import co.edu.polijic.taller.helpers.Response;
import co.com.helpers.Response;
import co.edu.polijic.taller.helpers.ResponseBuild;
import co.edu.polijic.taller.mappers.BacklogMapper;
import co.edu.polijic.taller.model.dto.BacklogDto;
import co.edu.polijic.taller.model.entity.Backlog;
import co.edu.polijic.taller.service.BacklogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/backlogs")
@RequiredArgsConstructor
public class BacklogController {

    private final BacklogService backlogService;
    private final ResponseBuild builder;

    @PostMapping
    public Response save(@Valid @RequestBody BacklogDto backlogDto, BindingResult result){
        if (result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        return builder.created(backlogService.save(backlogDto));
    }

    @GetMapping
    public Response findAll(){
        List<Backlog> backlogs = backlogService.findAll();
        return builder.success(backlogs);
    }

    private String formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .error(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return json;
    }
}
