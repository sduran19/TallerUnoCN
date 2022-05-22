package co.edu.polijic.taller.controller;

//import co.edu.polijic.taller.helpers.ErrorMessage;
import co.com.helpers.ErrorMessage;
//import co.edu.polijic.taller.helpers.Response;
import co.com.helpers.Response;
import co.edu.polijic.taller.helpers.ResponseBuild;
import co.edu.polijic.taller.mappers.ProjectMapper;
import co.edu.polijic.taller.model.dto.ProjectDto;
import co.edu.polijic.taller.model.entity.Project;
import co.edu.polijic.taller.service.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ResponseBuild builder;
    private final ProjectMapper projectMapper = Mappers.getMapper(ProjectMapper.class);

    @PostMapping
    public Response save(@Valid @RequestBody ProjectDto projectDto, BindingResult result){
        if (result.hasErrors())
        {
            return builder.failed(formatMessage(result));
        }
        return builder.created(projectService.save(projectMapper.to(projectDto)));
    }

    @GetMapping
    public ResponseEntity<List<Project>> findAll(){
        List<Project> projects = projectService.findAll();
        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
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
